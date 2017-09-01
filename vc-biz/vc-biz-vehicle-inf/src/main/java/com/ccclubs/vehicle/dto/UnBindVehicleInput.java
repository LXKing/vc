package com.ccclubs.vehicle.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 解绑输入
 *
 * @author jianghaiyang
 * @create 2017-07-05
 **/
public class UnBindVehicleInput implements Serializable {
    //车辆vin码
    @NotNull(message="车辆vin码必填")
    private String vin;

    //终端序列号
    @NotNull(message="终端序列号必填")
    private String teNo;

    private String appId;

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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
