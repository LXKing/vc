package com.ccclubs.gateway.gb.exception;

/**
 * @Author: yeanzi
 * @Date: 2018/4/28
 * @Time: 1:29
 * Email:  yeanzhi@ccclubs.com
 * 消息校验处理异常
 */
public class PacValidateException extends RuntimeException {

    public PacValidateException() {
        super();
    }

    public PacValidateException(String message) {
        super(message);
    }

    public PacValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public PacValidateException(Throwable cause) {
        super(cause);
    }

    protected PacValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
