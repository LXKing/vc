package com.ccclubs.gateway.common.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 19:36
 * Email:  yeanzhi@ccclubs.com
 * 消息处理异常码
 */
public enum PackProcessExceptionCode {

    /*校验码校验失败*/
    INVALID_FAIL("2-1"),
    /*长度校验失败*/
    LACK_LENGTH_FAIL("2-2");

    private String code;

    PackProcessExceptionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
