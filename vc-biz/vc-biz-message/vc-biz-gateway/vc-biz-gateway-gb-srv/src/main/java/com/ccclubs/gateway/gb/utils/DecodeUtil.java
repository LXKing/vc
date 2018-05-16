package com.ccclubs.gateway.gb.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 15:21
 * Email:  yeanzhi@ccclubs.com
 */
public final class DecodeUtil {
    private static Charset CHARSET_GBK = Charset.forName("GBK");

    private DecodeUtil() {
        throw new AssertionError();
    }

    /**
     * 字节转化字符串
     *  TODO 方法前参数校验未做
     * @param buf
     * @param len
     * @return
     */
    public static String byte2Str(ByteBuf buf, int len) {
        byte[] bytes = new byte[len];
        buf.readBytes(bytes);
        return new String(bytes, CHARSET_GBK);
    }

    public static int indexOfStartMark(ByteBuf inputBuffer) {
        int length = inputBuffer.writerIndex();
        // 报文长度至少大于2
        if (length < 2) {
            return -1;
        }
        int rederIndex = inputBuffer.readerIndex();
        for(int i = rederIndex; i < length - 1; i ++) {
            byte b1 = inputBuffer.getByte(i);
            // "#" = b1
            if (0x23 == b1) {
                // "#" = b2
                if (i + 1 <= length && 0x23 == inputBuffer.getByte(i + 1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static String getVinFromByteBuf(ByteBuf sourceBuffer) {
        int readerIndex = sourceBuffer.readerIndex();
        sourceBuffer.resetReaderIndex();

        int startMark = indexOfStartMark(sourceBuffer);
        ByteBuf vinBuf = sourceBuffer.slice(startMark + 4, 17);
        String vin = vinBuf.toString(CHARSET_GBK);

        sourceBuffer.readerIndex(readerIndex);
        return vin;
    }

    public static void main(String[] args) {
        ByteBuf source = Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump("232301fe4c4a38453343314d36484430303334303101002b110512120d2f00193839383630324235303931363330303439343134010d32303136303932303030313939f9"));
        System.out.println(getVinFromByteBuf(source));
    }
}