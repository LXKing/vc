package com.ccclubs.gateway.jt808.exception;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 11:10
 * Email:  yeanzhi@ccclubs.com
 * 包解析异常
 */
public class PackageDecodeException extends DecoderException {

    private static final String EXCEPTION_DECRIPTION_PRIFIX= "解析数据包时出现异常: ";

    /**
     * 异常出现时，附带需要销毁的buf对象
     */
    private ByteBuf buf;

    public PackageDecodeException() {
        super(EXCEPTION_DECRIPTION_PRIFIX);
    }

    public PackageDecodeException(String message) {
        super(message);
    }

    public ByteBuf getBuf() {
        return buf;
    }

    public PackageDecodeException setBuf(ByteBuf buf) {
        this.buf = buf;
        return this;
    }
}
