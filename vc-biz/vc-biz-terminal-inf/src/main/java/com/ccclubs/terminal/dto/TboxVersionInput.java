package com.ccclubs.terminal.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 终端版本信息
 *
 * @author jianghaiyang
 * @create 2018-07-24
 **/
public class TboxVersionInput implements Serializable {

    private String appId;

    @NotNull(message = "车辆vin码必填")
    private String vin;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
