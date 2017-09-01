package com.ccclubs.upgrade.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 升级服务输入参数
 *
 * @author jianghaiyang
 * @create 2017-08-14
 **/
public class UpgradeInput implements Serializable{
    @NotNull(message = "车辆vin码必填")
    String vin;

    String filename;

    String appId;

    Long reqInTime;

    Long reqOutTime;

    Long procInTime;

    Long procOutTime;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Long getReqInTime() {
        return reqInTime;
    }

    public void setReqInTime(Long reqInTime) {
        this.reqInTime = reqInTime;
    }

    public Long getReqOutTime() {
        return reqOutTime;
    }

    public void setReqOutTime(Long reqOutTime) {
        this.reqOutTime = reqOutTime;
    }

    public Long getProcInTime() {
        return procInTime;
    }

    public void setProcInTime(Long procInTime) {
        this.procInTime = procInTime;
    }

    public Long getProcOutTime() {
        return procOutTime;
    }

    public void setProcOutTime(Long procOutTime) {
        this.procOutTime = procOutTime;
    }
}
