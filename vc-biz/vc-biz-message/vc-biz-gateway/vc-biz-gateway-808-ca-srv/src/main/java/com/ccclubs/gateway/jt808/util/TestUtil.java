package com.ccclubs.gateway.jt808.util;

import io.netty.buffer.ByteBufUtil;

import java.io.IOException;

/**
 * @Author: yeanzi
 * @Date: 2018/7/3
 * @Time: 10:55
 * Email:  yeanzhi@ccclubs.com
 * 测试工具类
 */
public class TestUtil {

    public static void nullPointer() {
        String S = "5436374232333836";
        System.out.println(new String(ByteBufUtil.decodeHexDump(S)));
    }

    public static void ioException() throws IOException{
        throw new IOException("测试ioException");
    }

    public static void main(String[] args) throws Exception{
        ioException();
    }

}
