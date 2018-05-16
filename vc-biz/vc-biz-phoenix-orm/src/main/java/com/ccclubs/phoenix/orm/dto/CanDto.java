package com.ccclubs.phoenix.orm.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/14
 * @Time: 10:20
 * @Description: 车辆CAN总线数据！
 */

public class CanDto implements Serializable{
    private static final long serialVersionUID = 1291016524134493696L;

    private String teNumber;
    private Long currentTime;
    private String vin;
    private String teNo;
    private String iccid;
    private String mobile;
    private String sourceHex;
    private Long addTime;

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public String getSourceHex() {
        return sourceHex;
    }

    public void setSourceHex(String sourceHex) {
        this.sourceHex = sourceHex;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }
}
