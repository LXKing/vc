package com.ccclubs.gateway.gb.utils;

import io.netty.buffer.ByteBuf;

/**
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 17:11
 * Email:  yeanzhi@ccclubs.com
 */
public class ValidUtil {

    public static final Integer MAX_DEFAULT = 65531;

    /**
     * 校验消息中数值是否在对应允许的范围内
     * @param item  被校验数据值
     * @param min   允许的最小值
     * @param max   允许的最大值
     * @return
     */
    public static boolean rangeValid(int item, int min, int max) {
        boolean is = !(item < min || item > max);
        return is;
    }

    /**
     * 异或校验包完整
     *      从命令单元（第三个字节）开始，一次与后一个字节异或，直至倒数第二个字节。
     *      将异或的结果与报文中最后一个字节比较。
     *      -相等：报文完整
     *      -不相等：报文不完整
     * @param msg
     * @return
     */
    public static boolean validePac(ByteBuf msg) {
        return getValdByteInMsg(msg) == caculateValidByteFromBuff(msg);
    }

    /**
     * 从当前数据包计算校验码
     * @param msg
     * @return
     */
    public static byte caculateValidByteFromBuff(ByteBuf msg) {
        msg.resetReaderIndex();
        // 跳过两个字节
        msg.skipBytes(2);
        // 命令单元的第一个字节
        byte currValidByte = msg.readByte();
        // 异或至倒数第二个字节
        while (msg.readableBytes() > 1) {
            currValidByte ^= msg.readByte();
        }
        // 重置读指针
        msg.resetReaderIndex();
        return currValidByte;
    }

    /**
     * 获取当前数据包中的校验码(最后一位字节)
     * @param msg
     * @return
     */
    public static byte getValdByteInMsg(ByteBuf msg) {
        msg.resetReaderIndex();
        byte validByteInMsg = msg.readerIndex(msg.readableBytes() - 1).readByte();
        msg.resetReaderIndex();
        return validByteInMsg;
    }

    /**
     *  命令的主动发起方应答标志为0xFE，标识此包为命令包；当应答标志不是0xFE时，被动接收方应不应答。
     *  当命令的被动接收方应答标志不是0xFE，此包为应答包
     * @param ackType
     * @return
     */
    public static boolean isNeedAck(int ackType) {
        if(0xFE == ackType) {
            return true;
        }
        return false;
    }

}
