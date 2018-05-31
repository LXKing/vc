package com.ccclubs.gateway.jt808.util;

import com.ccclubs.gateway.jt808.constant.EncryptType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 18:14
 * Email:  yeanzhi@ccclubs.com
 * 包工具
 */
public final class PacUtil {

    public static Integer getContentLen(Short contentAttr) {
        return contentAttr & 0x03FF;
    }

    /**
     * 判断加密方式：
     *  目前只判断是否加密了
     * @param contentAttr
     * @return
     */
    public static boolean isEncrypted(Short contentAttr) {

        // 获取第10、11、12位的bit位
        int encryptPart = (contentAttr >>> 10);
        Boolean b10 = checkLastBit(encryptPart);
        encryptPart = encryptPart >>> 1;
        Boolean b11 = checkLastBit(encryptPart);
        encryptPart = encryptPart >>> 1;
        Boolean b12 = checkLastBit(encryptPart);

        if (!b10 && !b11 && !b12) {
            return false;
        } else if (b10) {
            return true;
        }
        // 其他为其他加密方式
        return true;
    }

    /**
     * 从消息体属性字段中解析出该消息是否为分包数据
     * @param contentAttr
     * @return
     */
    public static boolean isMultiPac(Short contentAttr) {
        int attr = contentAttr >>> 13;
        return (attr & 0x0001) == 1;
    }

    public static ByteBuf mobile2Buf(String mobile) {
        StringBuilder mobileSb = new StringBuilder(mobile);
        while (mobileSb.length() < 12) {
            // 大陆首位加0；港澳台根据区号补充
            mobileSb.insert(0, "0");
        }
        return Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump(mobileSb.toString()));
    }

    /**
     * 检查数值的最后一字节位是否为1
     *  true:  1
     *  false: 0
     * @param number
     * @return
     */
    private static boolean checkLastBit(int number) {
        return (number & 0x0001) == 1;
    }

    public static void main(String[] args) {
        Short contentAttr = 0x1803;
        int contentLen = getContentLen(contentAttr);
        boolean isEncrypt = isEncrypted(contentAttr);
        boolean isMultiPac = isMultiPac(contentAttr);
        System.out.println(new StringBuilder()
                .append("contentLen: ").append(contentLen).append("\n")
                .append("isEncrypt: ").append(isEncrypt).append("\n")
                .append("isMultiPac: ").append(isMultiPac).append("\n")
        .toString());

        System.out.println(new String(ByteBufUtil.decodeHexDump("201d"), Charset.forName("utf-8")));

        System.out.println(ByteBufUtil.hexDump("”".getBytes()));
    }

}
