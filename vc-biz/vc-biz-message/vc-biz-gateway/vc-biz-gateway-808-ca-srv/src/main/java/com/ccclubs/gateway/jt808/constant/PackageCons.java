package com.ccclubs.gateway.jt808.constant;

import com.ccclubs.gateway.jt808.util.PacSerialNo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 16:34
 * Email:  yeanzhi@ccclubs.com
 * 消息内的常量定义
 */
public class PackageCons {

    /**
     * 序列号
     */
    public static AtomicReference<PacSerialNo> ACK_SERINALNO = new AtomicReference<>(new PacSerialNo((short)0));

    /**
     * 消息的开始和结束的标识符对应的字节
     */
    public static final Integer PAC_START_SYMBOL_BYTE = 0x7e;

    /**
     * 消息的开始和结束的标识符对应的字节16进制表示
     */
    public static final String PAC_START_SYMBOL_HEX = "7E";

    /**
     * 消息解码时分割用的字节
     */
    public static final ByteBuf PAC_DECODE_DELIMITER = Unpooled.wrappedBuffer(new byte[]{0x7e});

    /**
     * 消息转义时7e对应转义后的字节数组
     */
    public static final byte[] PAC_TRANSLATE_TYPE_HEX_7E = new byte[]{(byte) 0x7d, (byte) 0x02};

    /**
     * 消息转义时7d对应转义后的字节数组
     */
    public static final byte[] PAC_TRANSLATE_TYPE_HEX_7D = new byte[]{(byte) 0x7d, (byte) 0x01};

    /**
     * 用于与消息ID相与，转换成下行消息类型
     */
    public static final Integer ACK_PRIFIX_HIGH = 0x8000;

    /**
     * 终端上行应答前缀
     */
    public static final String UP_PAC_ACK_PRIFIX = "ACK";
    
    public static final String GLOBAL_AUTH_CODE = "1234567890A";
}
