package com.ccclubs.phoenix.orm.dto;

import java.io.Serializable;

/**
 * @Author: GFA
 * @Project: vc
 * @Package: com.ccclubs.phoenix.orm.dto
 * @Date: 2018/08/20  10:57
 * @Description:
 */
public class TBoxLogDto implements Serializable {

    private static final long serialVersionUID = 16179638222298528L;

    //编号
    private Long orderNo;
    //车机号
    private String teNumber;
    //Vin
    private String vin;
    //Log Info
    private String logInfo;
    //Add Time
    private Long addTime;
    //Source Hex
    private String sourceHex;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
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
