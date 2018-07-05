package com.ccclubs.gateway.jt808.exception;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 21:29
 * Email:  yeanzhi@ccclubs.com
 * 包装解析异常信息
 */
public class OfflineException extends RuntimeException {

    public OfflineException(String msg) {
        super(msg);
    }

    public OfflineException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
