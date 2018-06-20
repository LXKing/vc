package com.ccclubs.gateway.jt808.util;

import com.ccclubs.gateway.jt808.constant.TranslateType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;

import java.util.Optional;

/**
 * @Author: yeanzi
 * @Date: 2018/6/1
 * @Time: 9:28
 * Email:  yeanzhi@ccclubs.com
 * 消息转义工具类
 */
public final class PacTranslateUtil {

    public static void translateUpPac(ByteBuf inboundBuf) {
        inboundBuf.resetReaderIndex();

        ByteBuf translatedBuf = decode(inboundBuf);
        inboundBuf.clear();
        inboundBuf.writeBytes(translatedBuf);

        ReferenceCountUtil.release(translatedBuf);
    }

    public static void translateDownPac(ByteBuf outboundBuf) {
        // 跳过起始符
        outboundBuf.resetReaderIndex();

        ByteBuf translatedBuf = encode(outboundBuf);
        outboundBuf.clear();
        outboundBuf.writeBytes(translatedBuf);

        ReferenceCountUtil.release(translatedBuf);
    }

    /**
     * 若校验码、消息头以及消息体中出现0x7e则要进行转义处理
     *      0x7e->0x7d0x02
     *      0x7d->0x7d0x01
     * @param outboundBuf
     */
    private static ByteBuf encode(ByteBuf outboundBuf) {
        ByteBuf dstBuf = Unpooled.buffer();
        // 先读取起始符
        dstBuf.writeByte(outboundBuf.readByte());

        int readerIndex = outboundBuf.readerIndex();
        Optional<TranslateType> translateTypeOptional = findByte(outboundBuf);
        while(translateTypeOptional.isPresent()) {
            dstBuf.writeBytes(outboundBuf, readerIndex, outboundBuf.readerIndex() - readerIndex);
            // 改为转义的部分
            dstBuf.writeBytes(translateTypeOptional.get().getEscaped());
            // 跳过0x7e字节
            outboundBuf.skipBytes(1);
            readerIndex = outboundBuf.readerIndex();
            translateTypeOptional = findByte(outboundBuf);
        }
        dstBuf.writeBytes(outboundBuf, readerIndex, outboundBuf.readerIndex() - readerIndex);
        return dstBuf;
    }

    /**
     * 转义还原
     *      0x7d0x02->0x7e
     *      0x7d0x01->0x7d
     * @param inboundBuf
     */
    private static ByteBuf decode(ByteBuf inboundBuf) {
        ByteBuf dstBuf = Unpooled.buffer();
        int readerIndex = inboundBuf.readerIndex();
        Optional<TranslateType> translateTypeOptional = findShort(inboundBuf);
        while(translateTypeOptional.isPresent()) {
            dstBuf.writeBytes(inboundBuf, readerIndex, inboundBuf.readerIndex() - readerIndex);
            // 改为转义的部分
            dstBuf.writeByte(translateTypeOptional.get().getGoal());
            // 跳过0x7d02字节
            inboundBuf.skipBytes(translateTypeOptional.get().getEscaped().length);
            readerIndex = inboundBuf.readerIndex();
            translateTypeOptional = findShort(inboundBuf);
        }
        dstBuf.writeBytes(inboundBuf, readerIndex, inboundBuf.readerIndex() - readerIndex);
        return dstBuf;
    }

    private static Optional<TranslateType> findByte(ByteBuf sourceBuf) {
        if (sourceBuf.readableBytes() <= 0) {
            return Optional.empty();
        }
        for (int i = sourceBuf.readerIndex(); i < sourceBuf.writerIndex(); i++) {
            for (TranslateType t :
                    TranslateType.values()) {
                if (sourceBuf.getByte(i) == t.getGoal()) {
                    return Optional.of(t);
                }
            }
            sourceBuf.skipBytes(1);
        }
        return Optional.empty();
    }

    private static Optional<TranslateType> findShort(ByteBuf sourceBuf) {
        if (sourceBuf.readableBytes() <= 0) {
            return Optional.empty();
        }
        for (int i = sourceBuf.readerIndex(); i < sourceBuf.writerIndex(); i++) {
            for (TranslateType t :
                    TranslateType.values()) {
                boolean find = true;
                for (int j = 0; j < t.getEscaped().length; j++) {
                    if (sourceBuf.getByte(i + j) != t.getEscaped()[j]) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    return Optional.of(t);
                }
            }
            sourceBuf.skipBytes(1);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        String source = "7e007d027d";
        ByteBuf sourceBuf = Unpooled.buffer().writeBytes(ByteBufUtil.decodeHexDump(source));
        translateUpPac(sourceBuf);

        System.out.println(ByteBufUtil.hexDump(sourceBuf));
    }
}
