package com.ccclubs.frm.spring.gateway;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 网关异常消息DTO
 * @author jianghaiyang
 * @create 2018-05-15
 **/
public class ExpMessageDTO implements Serializable {
    //网关类型
    private String gatewayType;

    // 错误类型
    private String code;

    // 车架号
    private String vin;

    // 授权系统
    private Integer access;

    // 手机号
    private String mobile;

    // 车机终端序列号
    private String teNo;

    // 终端类型 0:车厘子,1:中导,2:慧翰,3:通领
    private Byte teType;

    // 车机号
    private String teNumber;

    // ICCID
    private String iccid;

    // 原始报文
    private String sourceHex;

    // 错误位置
    private Integer index;

    // 错误原因
    private String reason;

    // 错误报文时间
    private Long msgTime;

    public String getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Long getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Long msgTime) {
        this.msgTime = msgTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }

    public Byte getTeType() {
        return teType;
    }

    public void setTeType(Byte teType) {
        this.teType = teType;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

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
