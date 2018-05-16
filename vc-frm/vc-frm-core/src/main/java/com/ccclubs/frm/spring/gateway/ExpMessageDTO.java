package com.ccclubs.frm.spring.gateway;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
