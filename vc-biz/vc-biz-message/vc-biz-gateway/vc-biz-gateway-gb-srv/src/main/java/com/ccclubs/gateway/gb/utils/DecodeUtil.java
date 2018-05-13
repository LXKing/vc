package com.ccclubs.gateway.gb.utils;

import io.netty.buffer.ByteBuf;
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

    public static void main(String[] args) {
        ByteBuf source = Unpooled.wrappedBuffer("fhhsdkjfsd".getBytes());
        byte[] b5 = new byte[5];
        source.readBytes(b5);
        source.readByte();
        source.readByte();
    }
}
