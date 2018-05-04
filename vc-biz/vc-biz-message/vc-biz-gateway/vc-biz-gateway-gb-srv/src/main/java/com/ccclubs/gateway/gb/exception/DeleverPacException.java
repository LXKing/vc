package com.ccclubs.gateway.gb.exception;

import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;

/**
 * @Author: yeanzi
 * @Date: 2018/4/28
 * @Time: 1:37
 * Email:  yeanzhi@ccclubs.com
 * 消息业务处理器异常
 */
public class DeleverPacException extends RuntimeException {

    private PackProcessExceptionDTO packProcessExceptionDTO;

    public DeleverPacException() {
        super();
    }

    public DeleverPacException(String message) {
        super(message);
    }

    public DeleverPacException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleverPacException(Throwable cause) {
        super(cause);
    }

    protected DeleverPacException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PackProcessExceptionDTO getPackProcessExceptionDTO() {
        return packProcessExceptionDTO;
    }

    public DeleverPacException setPackProcessExceptionDTO(PackProcessExceptionDTO packProcessExceptionDTO) {
        this.packProcessExceptionDTO = packProcessExceptionDTO;
        return this;
    }
}
