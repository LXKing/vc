package com.ccclubs.gateway.gb.exception;

import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;

/**
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 13:32
 * Email:  yeanzhi@ccclubs.com
 */
public class MsgDecodeException extends RuntimeException {

    private PackProcessExceptionDTO packProcessExceptionDTO;

    public MsgDecodeException(String message) {
        super(message);
    }

    public PackProcessExceptionDTO getPackProcessExceptionDTO() {
        return packProcessExceptionDTO;
    }

    public MsgDecodeException setPackProcessExceptionDTO(PackProcessExceptionDTO packProcessExceptionDTO) {
        this.packProcessExceptionDTO = packProcessExceptionDTO;
        return this;
    }
}
