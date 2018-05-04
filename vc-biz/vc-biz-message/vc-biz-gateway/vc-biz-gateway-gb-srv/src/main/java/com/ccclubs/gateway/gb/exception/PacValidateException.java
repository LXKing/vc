package com.ccclubs.gateway.gb.exception;

import com.ccclubs.gateway.gb.constant.PackProcessExceptionCode;
import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;

/**
 * @Author: yeanzi
 * @Date: 2018/4/28
 * @Time: 1:29
 * Email:  yeanzhi@ccclubs.com
 * 消息校验处理异常
 */
public class PacValidateException extends RuntimeException {

    private PackProcessExceptionDTO packProcessExceptionDTO;

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

    public PackProcessExceptionDTO getPackProcessExceptionDTO() {
        return packProcessExceptionDTO;
    }

    public PacValidateException setPackProcessExceptionDTO(PackProcessExceptionDTO packProcessExceptionDTO) {
        this.packProcessExceptionDTO = packProcessExceptionDTO;
        return this;
    }
}
