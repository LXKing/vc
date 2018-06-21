package com.ccclubs.pub.orm.dto;

import java.io.Serializable;

/**
 * 车机网络日志
 *
 * @author jianghaiyang
 * @create 2018-06-21
 **/
public class TboxLog implements Serializable {
    //车架号
    private String vin;
    //车机号
    private String teNumber;
    //订单号
    private Long orderNo;
    //日志信息
    private String logInfo;
    //原始数据
    private String sourceHex;
    //添加时间
    private Long addTime;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
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
