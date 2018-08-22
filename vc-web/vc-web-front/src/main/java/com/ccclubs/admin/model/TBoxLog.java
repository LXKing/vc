package com.ccclubs.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author: GFA
 * @Project: vc
 * @Package: com.ccclubs.admin.model
 * @Date: 2018/08/20  14:23
 * @Description: 车机网络日志
 */
public class TBoxLog implements Serializable {

    private static final long serialVersionUID = 7962306117101554793L;

    //车机号
    private String teNumber;
    //车架号vin码
    private String vin;
    //订单号
    private Long orderNo;
    //日志信息
    private String logInfo;
    //原始数据
    private String sourceHex;
    //添加时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date addTime;

    /*********************Getter Setter*********************/
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
