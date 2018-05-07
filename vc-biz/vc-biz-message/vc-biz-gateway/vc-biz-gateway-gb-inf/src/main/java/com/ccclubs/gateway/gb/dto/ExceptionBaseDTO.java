package com.ccclubs.gateway.gb.dto;

/**
 * @Author: yeanzi
 * @Date: 2018/5/5
 * @Time: 21:16
 * Email:  yeanzhi@ccclubs.com
 * 异常信息封装dto基类
 */
public class ExceptionBaseDTO {

    /**
     * vin码
     */
    private String vin;

    /**
     * 原始报文的16进制字符串
     */
    private String sourceHexStr;

    public String getVin() {
        return vin;
    }

    public ExceptionBaseDTO setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getSourceHexStr() {
        return sourceHexStr;
    }

    public ExceptionBaseDTO setSourceHexStr(String sourceHexStr) {
        this.sourceHexStr = sourceHexStr;
        return this;
    }
}
