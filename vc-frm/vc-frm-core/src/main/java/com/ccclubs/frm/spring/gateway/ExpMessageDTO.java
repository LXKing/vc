package com.ccclubs.frm.spring.gateway;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 网关异常消息DTO
 * @author jianghaiyang
 * @create 2018-05-15
 **/
public class ExpMessageDTO implements Serializable {

    // 错误类型
    private String code;

    // 车架号
    private String vin;

    // 原始报文
    private String sourceHex;

    // 错误位置
    private Integer index;

    // 错误原因
    private String reason;

    public String toJson() {
        return JSON.toJSONString(this);
    }
    // -----------------------------------------------------------
    public String getCode() {
        return code;
    }

    public ExpMessageDTO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public ExpMessageDTO setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getSourceHex() {
        return sourceHex;
    }

    public ExpMessageDTO setSourceHex(String sourceHex) {
        this.sourceHex = sourceHex;
        return this;
    }

    public Integer getIndex() {
        return index;
    }

    public ExpMessageDTO setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public ExpMessageDTO setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
