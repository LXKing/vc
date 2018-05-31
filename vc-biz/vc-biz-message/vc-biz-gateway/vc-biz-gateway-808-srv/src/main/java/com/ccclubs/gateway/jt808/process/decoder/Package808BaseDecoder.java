package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.jt808.constant.PackagePart;
import com.ccclubs.gateway.jt808.message.pac.PacContentAttr;
import com.ccclubs.gateway.jt808.message.pac.PacSealInfo;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
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
public class Package808BaseDecoder extends DelimiterBasedFrameDecoder {
    public static final Logger LOG = LoggerFactory.getLogger(Package808BaseDecoder.class);

    /**
     * 最小报文长度
     */
    private final Integer minFrameLength;

    private Package808 pac;

    public Package808BaseDecoder(int minFrameLength, int maxFrameLength, ByteBuf delimiter) {
        super(maxFrameLength, delimiter);
        this.minFrameLength = minFrameLength;
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        String sourceHex = ByteBufUtil.hexDump(buffer);
        LOG.info("sourceHex={}", sourceHex);
        // TODO 校验最小字节数

        ByteBuf frame = (ByteBuf) super.decode(ctx, buffer);
        LOG.info("after decode: frame={}", frame==null?"null":ByteBufUtil.hexDump(frame));

        if (Objects.isNull(frame) || frame.readableBytes() == 0) {
            return null;
        }

        this.pac = composePac(frame);
        return this.pac;
    }

    public void skipBytesWhenLessThenMinFrameLength(ByteBuf buff) {
        Objects.requireNonNull(buff);


    }

    /**
     * 消息组装
     * @param frame
     * @return
     */
    public Package808 composePac(ByteBuf frame) {
        Package808 pac = Package808.ofNew()
                .setSourceBuff(frame).setSourceHexStr(ByteBufUtil.hexDump(frame));

        // 读取终端手机号
        frame.readerIndex(PackagePart.PAC_ID.getLen() + PackagePart.PAC_SERIAL_NO.getLen());
        ByteBuf mobileBuf = frame.readSlice(PackagePart.TER_MOBILE.getLen());
        pac.getHeader().setTerMobile(ByteBufUtil.hexDump(mobileBuf));
        frame.resetReaderIndex();

        // 读取消息ID
        int pacId = frame.readUnsignedShort();
        pac.getHeader().setPacId(pacId);

        // 读取消息体属性
        PacContentAttr pacAttr = new PacContentAttr();
        Short contentAttr = frame.readShort();
        pacAttr.setContentLen(PacUtil.getContentLen(contentAttr))
                .setEncrypted(PacUtil.isEncrypted(contentAttr))
                .setMultiPac(PacUtil.isMultiPac(contentAttr));
        pac.getHeader().setPacContentAttr(pacAttr);

        // 跳过终端手机号
        frame.skipBytes(PackagePart.TER_MOBILE.getLen());

        // 读取消息流水号
        int pacSerialNo = frame.readUnsignedShort();
        pac.getHeader().setPacSerialNo(pacSerialNo);

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

        // 读取包体部分
        ByteBuf bodyBuf = frame.readSlice(pac.getHeader().getPacContentAttr().getContentLen());
        pac.getBody().setContent(bodyBuf);

        // 读取校验码
        byte validCode = frame.readByte();
        pac.setValidCode(validCode);
        return pac;
    }
}
