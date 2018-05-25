package com.ccclubs.frm.spring.gateway;

import java.io.Serializable;

/**
 * 网关正常上行消息DTO
 *
 * @author jianghaiyang
 * @create 2018-05-14
 **/
public class MessageDTO implements Serializable {
    // 消息类型
    private Integer code;
    // 消息类型
    private String vin;
    // 原始报文
    private String sourceHex;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getSourceHex() {
        return sourceHex;
    }

    public void setSourceHex(String sourceHex) {
        this.sourceHex = sourceHex;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
