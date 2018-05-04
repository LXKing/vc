package com.ccclubs.gateway.gb.exception;

import com.ccclubs.gateway.gb.dto.ConnStatisticsExceptionDTO;
import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;

/**
 * @Author: yeanzi
 * @Date: 2018/4/28
 * @Time: 1:29
 * Email:  yeanzhi@ccclubs.com
 * 连接数据统计处理异常
 */
public class ConnStatisticsException extends RuntimeException {

    private PackProcessExceptionDTO packProcessExceptionDTO;

    public ConnStatisticsException() {
        super();
    }

    public ConnStatisticsException(String message) {
        super(message);
    }

    public ConnStatisticsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnStatisticsException(Throwable cause) {
        super(cause);
    }

    protected ConnStatisticsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PackProcessExceptionDTO getPackProcessExceptionDTO() {
        return packProcessExceptionDTO;
    }

    public ConnStatisticsException setPackProcessExceptionDTO(PackProcessExceptionDTO packProcessExceptionDTO) {
        this.packProcessExceptionDTO = packProcessExceptionDTO;
        return this;
    }
}
