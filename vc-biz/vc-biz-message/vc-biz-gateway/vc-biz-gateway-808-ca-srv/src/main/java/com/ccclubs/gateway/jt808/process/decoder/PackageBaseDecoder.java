package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.attr.DefaultChannelHealthyAttr;
import com.ccclubs.gateway.common.bean.attr.PackageTraceAttr;
import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.common.util.DateUtil;
import com.ccclubs.gateway.jt808.constant.PackagePart;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.exception.DecodeExceptionDTO;
import com.ccclubs.gateway.jt808.exception.PackageDecodeException;
import com.ccclubs.gateway.jt808.message.pac.PacContentAttr;
import com.ccclubs.gateway.jt808.message.pac.PacSealInfo;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.util.BufReleaseUtil;
import com.ccclubs.gateway.jt808.util.PacTranslateUtil;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 16:42
 * Email:  yeanzhi@ccclubs.com
 * 808消息不定长分隔符解码器
 */
public class PackageBaseDecoder extends DelimiterBasedFrameDecoder {
    public static final Logger LOG = LoggerFactory.getLogger(PackageBaseDecoder.class);

    /**
     * 最小报文长度(13)
     *      包头：12
     *      校验码：1
     */
    private final Integer minFrameLength;

    public PackageBaseDecoder(int minFrameLength, int maxFrameLength, ByteBuf delimiter) {
        super(maxFrameLength, delimiter);
        this.minFrameLength = minFrameLength;
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("sourceHex={}", ByteBufUtil.hexDump(buffer));
        }

        ByteBuf frame = (ByteBuf) super.decode(ctx, buffer);
        if (LOG.isDebugEnabled()) {
            LOG.debug("after decode: frame={}", frame==null?"null":ByteBufUtil.hexDump(frame));
        }
        // 处理空贞
        if (Objects.isNull(frame) || frame.readableBytes() == 0) {
            dealEmptyPackage(frame);
            return null;
        }
        // 加了7E的原始报文
        String unTranslatedPacHex = PacUtil.packWithPacSymbol(ByteBufUtil.hexDump(frame));
        if (TcpServerConf.GATEWAY_PRINT_LOG) {
            LOG.info("-------------------------------------------------------> new package came: start handling X)");
        }

        final SocketChannel channel = (SocketChannel) ctx.channel();
        Package808 pac = beginHandle(channel, frame, unTranslatedPacHex);
        if (LOG.isDebugEnabled()) {
            LOG.debug("pac:{}", pac.printLog());
        }
        return pac;
    }

    private void skipBytesWhenLessThenMinFrameLength(ByteBuf buff) {
        Objects.requireNonNull(buff);

    }

    private Package808 beginHandle(SocketChannel channel, ByteBuf frame, String unTranslatedPacHex) {
        assert Objects.nonNull(frame);
        assert channel.isActive();

        /**
         * 为新消息更新消息轨迹
         */
        PackageTraceAttr packageTraceAttr = ChannelAttributeUtil.getTrace(channel);
        packageTraceAttr
                // 清除上一个消息的轨迹信息
                .refreshForNew()
                // 标记为当前处理步骤
                .next()
                .setPacBuf(frame)
                .setSourceHex(unTranslatedPacHex);

        /**
         * 更新健康数据
         */
        DefaultChannelHealthyAttr channelHealthyAttr = ChannelAttributeUtil.getHealthy(channel);
        channelHealthyAttr.setLastPackageTime(DateUtil.getNowStr())
                .setLastPackageHex(unTranslatedPacHex);
        // 消息组装
        Package808 pac = composePac(unTranslatedPacHex, frame, packageTraceAttr);
        // 设置健康数据中的消息描述
        channelHealthyAttr.setLastPackageDes(PacUtil.getUpPacTypeDesById(pac.getHeader().getPacId()));
        return pac;
    }

    /**
     * 消息组装
     * @param frame
     * @return
     */
    private Package808 composePac(String sourceHexStr, ByteBuf frame, PackageTraceAttr packageTraceAttr) {
        DecodeExceptionDTO decodeExceptionInfo = new DecodeExceptionDTO(sourceHexStr);
        // 消息转义: 还原消息
        try {
            PacTranslateUtil.translateUpPac(frame);
        } catch (Exception e) {
            decodeExceptionInfo.fail()
                    .setReason("消息转义还原时出现异常")
                    .setExpectedVal(e.getMessage());
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }

        /**
         * 只有当消息转义正常才能继续执行
         */
        Package808 pac = Package808.ofNew()
                .setSourceBuff(frame).setSourceHexStr(sourceHexStr);

        // 最小包校验
        int currPacLen = frame.readableBytes();
        if (currPacLen < this.minFrameLength) {
            decodeExceptionInfo.fail()
                    .setReason("整包长度小于最小包长")
                    .setExpectedVal(">=" + this.minFrameLength)
                    .setExceptionVal("" + currPacLen);
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }

        // 读取终端手机号
        int mobileByteIndex = PackagePart.PAC_ID.getLen() + PackagePart.PAC_SERIAL_NO.getLen();
        if (frame.readableBytes() < mobileByteIndex) {
            decodeExceptionInfo.fail()
                    .setReason("sim号码字段不满12个字符")
                    .setExpectedVal("非空的12个字符");
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        } else {
            frame.readerIndex(mobileByteIndex);
            ByteBuf mobileBuf = frame.readSlice(PackagePart.TER_MOBILE.getLen());
            String mobile = ByteBufUtil.hexDump(mobileBuf);

            String trimdMobile = PacUtil.trim0InMobile(mobile);
            /**
             * 与原有手机号对比
             */
            if (Objects.nonNull(packageTraceAttr.getUniqueNo()) && !trimdMobile.equals(packageTraceAttr.getUniqueNo())) {
                decodeExceptionInfo.fail()
                        .setExceptionVal(trimdMobile)
                        .setReason("报文中的手机号码与首次消息中的手机号码不相同")
                        .setExpectedVal(packageTraceAttr.getUniqueNo());
                throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
            }
            pac.getHeader().setTerMobile(trimdMobile);
            decodeExceptionInfo.setUniqueNo(trimdMobile).next();

            packageTraceAttr.setUniqueNo(trimdMobile);
            // 初始化异常信息
            packageTraceAttr.getExpMessageDTO().setMobile(trimdMobile);
            packageTraceAttr.getExpMessageDTO()
                    .setVin(trimdMobile)
                    .setSourceHex(packageTraceAttr.getSourceHex())
                    .setMsgTime(System.currentTimeMillis());
            frame.resetReaderIndex();
        }

        // 读取消息ID
        int pacId = frame.readUnsignedShort();
        UpPacType upPacType = UpPacType.getByCode(pacId);
        if (Objects.isNull(upPacType)) {
            decodeExceptionInfo.fail()
                    .setReason("不支持的消息ID")
                    .setExceptionVal(Integer.toHexString(pacId))
                    .setExpectedVal(UpPacType.expectedVals());
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        } else {
            decodeExceptionInfo.next();
            pac.getHeader().setPacId(pacId);
        }

        // 读取消息体属性
        PacContentAttr pacAttr = new PacContentAttr();
        Short contentAttr = frame.readShort();
        pacAttr.setContentLen(PacUtil.getContentLen(contentAttr))
                .setEncrypted(PacUtil.isEncrypted(contentAttr))
                .setMultiPac(PacUtil.isMultiPac(contentAttr));

        pac.getHeader().setPacContentAttr(pacAttr);
        decodeExceptionInfo.next();

        // 跳过终端手机号
        frame.skipBytes(PackagePart.TER_MOBILE.getLen());

        // 读取消息流水号
        int pacSerialNo = frame.readUnsignedShort();
        pac.getHeader().setPacSerialNo(pacSerialNo);
        decodeExceptionInfo.next();

        /*
         * 读取消息包封顶项
         *     如果为分包则 消息包封装项有值否则没有值
         */
        if (pac.getHeader().getPacContentAttr().isMultiPac()) {
            // 读取消息总包数
            Integer totalPac = frame.readUnsignedShort();
            Integer pacNo = frame.readUnsignedShort();
            PacSealInfo pacSealInfo = new PacSealInfo().setPacNo(pacNo).setTotalPacCount(totalPac);
            pac.getHeader().setPacSealInfo(pacSealInfo);
        } else {}
        decodeExceptionInfo.next();

        // 读取包体部分
        int contentLen = pac.getHeader().getPacContentAttr().getContentLen();
        if (contentLen > frame.readableBytes()) {
            decodeExceptionInfo.fail()
                    .setReason("消息体的长度大于实际可读字节数")
                    .setExceptionVal(String.valueOf(contentLen))
                    .setExpectedVal("小于" + frame.readableBytes());
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        } else {
            ByteBuf bodyBuf = frame.readSlice(pac.getHeader().getPacContentAttr().getContentLen());
            pac.getBody().setContent(bodyBuf);
            decodeExceptionInfo.next();
        }

        // 读取校验码
        byte validCode = frame.readByte();
        pac.setValidCode(validCode);
        decodeExceptionInfo.next();

        frame.resetReaderIndex();
        return pac;
    }

    /**
     * 针对808网关处理空包的释放
     * @param frame
     */
    private void dealEmptyPackage(ByteBuf frame) {
        // 释放空的Direct Buffer（空包）
        BufReleaseUtil.releaseOnce(frame);
    }

    private void throwWhenDecodeError(DecodeExceptionDTO decodeExceptionInfo, PackageTraceAttr packageTraceAttr) {
        /**
         * 释放引用
         */
        BufReleaseUtil.releaseByLoop(packageTraceAttr.getPacBuf());
        // 设置消息异常轨迹信息
        packageTraceAttr.setErrorOccured(true)
                // 装载异常信息
                .getExpMessageDTO()
                .setSourceHex(decodeExceptionInfo.getSource())
                .setGatewayType(GatewayType.GATEWAY_808.getDes())
                .setVin(decodeExceptionInfo.getUniqueNo())
                .setIndex(decodeExceptionInfo.getDecodeMarkIndex())
                .setReason(decodeExceptionInfo.toLogString())
                .setCode(String.valueOf(packageTraceAttr.getStep()))
                .setMsgTime(System.currentTimeMillis());
        packageTraceAttr.getExpMessageDTO()
                .setMobile(decodeExceptionInfo.getUniqueNo());

        throw new PackageDecodeException(decodeExceptionInfo.toLogString());
    }
}
