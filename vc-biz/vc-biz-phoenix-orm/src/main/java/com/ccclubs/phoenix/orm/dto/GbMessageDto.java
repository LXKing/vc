package com.ccclubs.phoenix.orm.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/14
 * @Time: 10:20
 * @Description: 国标协议状态数据！
 */

public class GbMessageDto implements Serializable {
    private static final long serialVersionUID = -5109328013141665042L;

    //授权系统
    private Integer access;
    //@caption("车机号")
    private String teNumber;
    private String teNo;
    private String iccid;
    private String mobile;
    private String vin;
    private Integer messageType;
    private Long currentTime;
    //@note(" 0:国标 1:地标  ")
    private Integer protocol;
    //@note(" 1:成功 0:失败  ")
    private Integer verify;

    private Long addTime;
    private String sourceHex;

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public Integer getProtocol() {
        return protocol;
    }

    public void setProtocol(Integer protocol) {
        this.protocol = protocol;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getSourceHex() {
        return sourceHex;
    }

    public void setSourceHex(String sourceHex) {
        this.sourceHex = sourceHex;
    }
}
