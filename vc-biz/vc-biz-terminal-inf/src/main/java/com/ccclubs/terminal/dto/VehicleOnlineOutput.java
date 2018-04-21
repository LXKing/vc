package com.ccclubs.terminal.dto;

import java.io.Serializable;

/**
 * 车辆在线状态
 *
 * @author jianghaiyang
 * @create 2018-04-20
 **/
public class VehicleOnlineOutput implements Serializable {
    private Boolean online;

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
