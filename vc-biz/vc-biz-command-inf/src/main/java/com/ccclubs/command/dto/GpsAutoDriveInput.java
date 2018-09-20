package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;

/**
 * @Author: yeanzi
 * @Date: 2018/9/20
 * @Time: 10:05
 * Email:  yeanzhi@ccclubs.com
 * GPS自动驾驶控制指令入参
 */
public class GpsAutoDriveInput extends CommonInput implements java.io.Serializable {

    @NotNull(message = "车辆vin码必填")
    private String vin;

    @NotNull(message = "行驶指令必填")
    @InArray(range = {1, 2, 3}, message = "行驶指令必须为：1-按经纬度行驶 2-循环行驶 3-暂停")
    private Integer driveCmd;

    @NotNull(message = "经度必填")
    private Integer log;

    @NotNull(message = "纬度必填")
    private Integer lat;

    public String getVin() {
        return vin;
    }

    public GpsAutoDriveInput setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public Integer getDriveCmd() {
        return driveCmd;
    }

    public GpsAutoDriveInput setDriveCmd(Integer driveCmd) {
        this.driveCmd = driveCmd;
        return this;
    }

    public Integer getLog() {
        return log;
    }

    public GpsAutoDriveInput setLog(Integer log) {
        this.log = log;
        return this;
    }

    public Integer getLat() {
        return lat;
    }

    public GpsAutoDriveInput setLat(Integer lat) {
        this.lat = lat;
        return this;
    }
}
