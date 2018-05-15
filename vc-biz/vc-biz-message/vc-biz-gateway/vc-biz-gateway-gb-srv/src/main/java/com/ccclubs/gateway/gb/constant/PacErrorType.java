package com.ccclubs.gateway.gb.constant;

import com.ccclubs.gateway.gb.inf.ICodedStatus;

/**
 * @Author: yeanzi
 * @Date: 2018/5/14
 * @Time: 13:45
 * Email:  yeanzhi@ccclubs.com
 * 包异常类型
 */
public enum PacErrorType implements ICodedStatus {

    /**
     * 解析异常
     */
    PAC_VALID_ERROR(0x01, "报文解析异常"),

    /**
     * 报文长度验证异常
     */
    PAC_LENGTH_ERROR(0x02, "报文长度验证异常");


    private int code;   // 编码
    private String des; // 描述

    PacErrorType(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public static PacErrorType getByCode(int code) {
        for (PacErrorType c :
                PacErrorType.values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        return null;
    }
}
