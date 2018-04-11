package com.ccclubs.terminal.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/8
 * @Time: 10:21
 * @Description: 此input类是批量查询车辆信息的输入类。
 */

public class VehicleStatesQryInput implements Serializable {
    private static final long serialVersionUID = 6601797193559187769L;
    //车辆vin码
    @NotNull(message = "车辆vin码必填")
    private String[] vins;

    private String appId;

    public String[] getVins() {
        return vins;
    }

    public void setVins(String[] vins) {
        this.vins = vins;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
