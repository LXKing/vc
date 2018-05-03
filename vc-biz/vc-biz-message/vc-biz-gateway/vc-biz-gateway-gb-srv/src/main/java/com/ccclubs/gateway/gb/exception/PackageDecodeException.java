package com.ccclubs.gateway.gb.exception;

import com.ccclubs.gateway.gb.enums.PackagePart;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
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

    public PackageDecodeException() {
        super(EXCEPTION_DECRIPTION_PRIFIX);
    }


    public PackageDecodeException(String message) {
        super(message);
    }

    public PackageDecodeException(PackagePart pacPart, String exceptionVal) {
        super(new StringBuilder(EXCEPTION_DECRIPTION_PRIFIX)
                        .append("位置[").append(pacPart.getDes()).append("]")
                        .append("异常值[").append(exceptionVal).append("]").toString());
    }

    public PackageDecodeException(String message, Throwable cause) {
        super(new StringBuilder(EXCEPTION_DECRIPTION_PRIFIX)
                        .append("[msg=").append(message).append("]")
                        .append("[errormsg=").append(cause.getMessage()).append("]").toString(),
                cause);
    }

    public PackageDecodeException(ByteBuf message, Throwable cause) {
        super(new StringBuilder(EXCEPTION_DECRIPTION_PRIFIX)
                        .append("[msg=").append(ByteBufUtil.hexDump(message)).append("]")
                        .append("[errormsg=").append(cause.getMessage()).append("]").toString(),
                cause);
    }

    public PackageDecodeException(ByteBuf message) {
        super(EXCEPTION_DECRIPTION_PRIFIX + "[msg=]" + ByteBufUtil.hexDump(message));
    }

    public PackageDecodeException(Throwable cause) {
        super(cause);
    }
}
