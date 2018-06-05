package com.ccclubs.gateway.jt808.constant;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 16:34
 * Email:  yeanzhi@ccclubs.com
 * 消息内的常量定义
 */
public class PackageCons {

    /**
     * 消息的开始和结束的标识符对应的字节
     */
    public static final Integer PAC_START_SYMBOL_BYTE = 0x7e;

    /**
     * 消息解码时分割用的字节
     */
    public static final ByteBuf PAC_DECODE_DELIMITER = Unpooled.wrappedBuffer(new byte[]{0x7e});

    /**
     * 用于与消息ID相与，转换成下行消息类型
     */
    public static final Integer ACK_PRIFIX_HIGH = 0x8000;

    /**
     * 终端上行应答前缀
     */
    public static final String UP_PAC_ACK_PRIFIX = "ACK";
}
