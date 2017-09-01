package com.ccclubs.terminal.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 终端信息查询
 *
 * @author jianghaiyang
 * @create 2017-07-27
 **/
public class TerminalQryInput implements Serializable {
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
