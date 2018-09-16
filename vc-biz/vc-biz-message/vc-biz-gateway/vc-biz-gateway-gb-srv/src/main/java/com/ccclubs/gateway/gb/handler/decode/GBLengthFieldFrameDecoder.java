package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.common.bean.attr.DefaultChannelHealthyAttr;
import com.ccclubs.gateway.common.bean.attr.PackageTraceAttr;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.common.util.DateUtil;
import com.ccclubs.gateway.gb.beans.DecodeExceptionDTO;
import com.ccclubs.gateway.gb.constant.*;
import com.ccclubs.gateway.gb.exception.PackageDecodeException;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.PacHeader;
import com.ccclubs.gateway.gb.utils.DecodeUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/3/25
 * @Time: 22:05
 * Email:  yeanzhi@ccclubs.com
 */
public class GBLengthFieldFrameDecoder extends LengthFieldBasedFrameDecoder {
    private static Logger LOG = LoggerFactory.getLogger(GBLengthFieldFrameDecoder.class);

    /**
     * 记录当前渠道粘包处理状态
     */
    private boolean isComplete = false;

    public GBLengthFieldFrameDecoder(Integer maxFrameLength) {
        this(maxFrameLength, 22, 2);
    }

    public GBLengthFieldFrameDecoder(
            int maxFrameLength,
            int lengthFieldOffset, int lengthFieldLength) {
        //   2K                  22                 2                       1
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, 1, 0);
    }

    private boolean reorganizedPac(ChannelHandlerContext ctx, ByteBuf in) {
        // 超长报文处理：防止超长报文导致的内存爆炸
//        int frameLength = in.readableBytes();
//        if (frameLength > specifiedMaxFrameLength) {
//            // TODO 单次发送长度超长则直接丢弃
//            in.skipBytes(frameLength);throw new TooLongFrameException("Frame too big!");
//        }
        int startMarkIndex = DecodeUtil.indexOfStartMark(in);
        if (-1 == startMarkIndex) {
            return false;
        }
        if (0 == startMarkIndex) {
            isComplete = true;
        } else {
            if (isComplete) {

            } else {
                in.readerIndex(startMarkIndex);
                in.discardReadBytes();
                isComplete = true;
            }
        }

        if (isComplete) {

        } else {
            in.discardReadBytes();
            return false;
        }
        return true;
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        boolean reorganized = reorganizedPac(ctx, in);
        if (!reorganized) {
            return null;
        }
        // 过滤报文段[232307fe010000f8]
        DecodeUtil.filterEmptyVinMsgPart(in);

        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        // 过滤半包
        if (null == frame) {
            isComplete = true;
            return null;
        } else {
            isComplete = false;
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("received: [{}]", ByteBufUtil.hexDump(frame));
        }
        GBPackage pac = beginHandle((SocketChannel) ctx.channel(), frame);
        return pac;
    }

    private GBPackage beginHandle(SocketChannel channel, ByteBuf frame) {
        assert Objects.nonNull(frame);
        assert channel.isActive();

        // 生成和初始化消息包装类
        GBPackage pac = GBPackage.valueOfEmpty();
        pac.setSourceBuff(frame);

        /**
         * 处理链处理新消息
         */
        PackageTraceAttr packageTraceAttr = ChannelAttributeUtil.getTrace(channel);
        packageTraceAttr
                // 清除上一个消息的轨迹信息
                .refreshForNew()
                // 标记为当前处理步骤
                .next()
                .setPacBuf(frame)
                .setSourceHex(pac.getSourceHexStr());

        /**
         * 更新健康数据
         */
        DefaultChannelHealthyAttr channelHealthyAttr = ChannelAttributeUtil.getHealthy(channel);
        channelHealthyAttr.setLastPackageTime(DateUtil.getNowStr())
                .setLastPackageHex(pac.getSourceHexStr());

        // 消息组装
        composeMsgPac(pac, packageTraceAttr);
        // 设置健康数据中的消息类型描述
        channelHealthyAttr.setLastPackageDes(pac.getHeader().getCommandMark().getDes());
        return pac;
    }

    /**
     * 将ByteBuf包装进GBPackage
     * @param pac
     */
    private GBPackage composeMsgPac(GBPackage pac, PackageTraceAttr packageTraceAttr) {

        ByteBuf frame = pac.getSourceBuff();
        // 初始化解析异常dto，记录异常详细信息
        DecodeExceptionDTO decodeExceptionInfo = new DecodeExceptionDTO(pac.getSourceHexStr());
        PacHeader pacHeader = pac.getHeader();

        /**
         * 分别拼装消息的各个部分，最细粒度地定位错误报文异常位置
         */
        // 先获取vin码
        //   跳过前几个字节到vin码字节上
        frame.readerIndex(PackagePart.UNIQUENO.getStartIndex());
        String vinNo = validateAndGetVin(frame);
        if (StringUtils.isNotEmpty(vinNo)) {
            /**
             * 与原有vin对比
             */
            if (Objects.nonNull(packageTraceAttr.getUniqueNo()) && !vinNo.equals(packageTraceAttr.getUniqueNo())) {
                decodeExceptionInfo.fail()
                        .setExceptionVal(vinNo)
                        .setReason("报文中的vin码与首次消息中的vin码不相同")
                        .setExpectedVal(packageTraceAttr.getUniqueNo());
                throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
            }
            decodeExceptionInfo.setVin(vinNo).next();
            pacHeader.setUniqueNo(vinNo);

            packageTraceAttr.setUniqueNo(vinNo);
            // 初始化异常信息
            packageTraceAttr.getExpMessageDTO()
                    .setVin(vinNo)
                    .setSourceHex(packageTraceAttr.getSourceHex())
                    .setMsgTime(System.currentTimeMillis());
            // 重置读指针到报文开始位置
            frame.resetReaderIndex();
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(vinNo)
                    .setReason("vin码字段读取失败")
                    .setExpectedVal("非空的17个字符");
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }

        // 起始符
        String startSymbol = DecodeUtil.byte2Str(frame, PackagePart.START_SYMBOL.getLen());
        if (PackageCons.PAC_START_SYMBOL.equals(startSymbol)) {
            decodeExceptionInfo.next();
            pacHeader.setStartSymbol(startSymbol);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(startSymbol)
                    .setReason("起始符异常")
                    .setExpectedVal(PackageCons.PAC_START_SYMBOL);
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }

        // 命令标识
        Short commandVal = frame.readUnsignedByte();
        CommandType commandType = CommandType.getByCode(commandVal);
        if (null != commandType) {
            decodeExceptionInfo.next();
            pacHeader.setCommandMark(commandType);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(String.valueOf(commandVal)).setReason("命令标识异常")
                    .setExpectedVal(CommandType.expectedVals());
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }

        // 应答标志
        Short ackVal = frame.readUnsignedByte();
        AckType ackType = AckType.getByCode(ackVal);
        if (null != ackType) {
            decodeExceptionInfo.next();
            pacHeader.setAckMark(ackType);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(String.valueOf(ackVal)).setReason("应答标识异常")
                    .setExpectedVal(AckType.expectedVals());
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }

        // vin码在第一部分已经读取了，这里只需要跳过vin码部分
        frame.readerIndex(frame.readerIndex() + PackagePart.UNIQUENO.getLen());

        // 加密方式
        Short encryVal = frame.readUnsignedByte();
        EncryType encryType = EncryType.getByCode(encryVal);
        if (null != encryType) {
            decodeExceptionInfo.next();
            pacHeader.setEncryptType(encryType);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(String.valueOf(encryVal)).setReason("加密方式异常")
                    .setExpectedVal(EncryType.expectedVals());
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }

        // 包体长度
        int contentLength = frame.readUnsignedShort();
        if (contentLength >= 0) {
            decodeExceptionInfo.next();
            pacHeader.setContentLength(contentLength);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(String.valueOf(contentLength)).setReason("包长度字段异常")
                    .setExpectedVal("大于或者等于0");
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }

        // 包体
        if (frame.readableBytes() < contentLength) {
            decodeExceptionInfo.fail()
                    .setExceptionVal(String.valueOf(contentLength)).setReason("包体长度异常")
                    .setExpectedVal("消息体中可读字节少于包头定义值");
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        } else {
            ByteBuf body = frame.readSlice(pac.getHeader().getContentLength());
            decodeExceptionInfo.next();
            pac.getBody().setContent(body);
        }

        // 校验码
        if(frame.readableBytes() == 1) {
            pac.setValidCode(frame.readByte());
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(String.valueOf(frame.readableBytes())).setReason("校验码后的字节长度超长")
                    .setExpectedVal("校验码字节长度等于1");
            throwWhenDecodeError(decodeExceptionInfo, packageTraceAttr);
        }
        return pac;
    }

    /**
     * 校验并返回vin码
     * @param frame
     * @return
     */
    private String validateAndGetVin(ByteBuf frame) {
        String vinNo = null;
        if (frame.readableBytes() >= PackagePart.UNIQUENO.getLen()) {
            vinNo = DecodeUtil.byte2Str(frame, PackagePart.UNIQUENO.getLen());
            if (StringUtils.isNotEmpty(vinNo) &&
                    vinNo.length() == PackagePart.UNIQUENO.getLen())  {
                return vinNo;
            }
        }
        return vinNo;
    }

    /**
     * 当主动的校验异常时，正常逻辑进行不下去，抛出异常，处理该异常
     * @param decodeExceptionInfo
     * @param packageTraceAttr
     */
    private void throwWhenDecodeError(DecodeExceptionDTO decodeExceptionInfo, PackageTraceAttr packageTraceAttr) {
        packageTraceAttr.setErrorOccured(true)
                // 装载异常信息
                .getExpMessageDTO()
                .setGatewayType(GatewayType.GB.getDes())
                .setSourceHex(decodeExceptionInfo.getSource())
                .setVin(decodeExceptionInfo.getVin())
                .setIndex(decodeExceptionInfo.getDecodeMarkIndex())
                .setReason(decodeExceptionInfo.toLogString())
                .setCode(String.valueOf(packageTraceAttr.getStep()))
                .setMsgTime(System.currentTimeMillis());

        throw new PackageDecodeException(decodeExceptionInfo.toLogString());
    }
}
