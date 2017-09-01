package com.ccclubs.terminal.dto;

import javax.validation.constraints.NotNull;

/**
 * 终端版本查询参数
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public class VersionQryInput implements java.io.Serializable{

    //车辆vin码
    @NotNull(message = "车辆vin码必填")
    private String vin;

    private String appId;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
