package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    @Pattern(regexp = "^(([1-9]\\d?)|(1[0-7]\\d))(\\.\\d{1,6})|180|0(\\.\\d{1,6})?$", message = "经度输入不合法")
    private String log;

    @Pattern(regexp = "^(([1-8]\\d?)|([1-8]\\d))(\\.\\d{1,6})|90|0(\\.\\d{1,6})?$", message = "纬度输入不合法")
    private String lat;

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

    public String getLog() {
        return log;
    }

    public GpsAutoDriveInput setLog(String log) {
        this.log = log;
        return this;
    }

    public String getLat() {
        return lat;
    }

    public GpsAutoDriveInput setLat(String lat) {
        this.lat = lat;
        return this;
    }
}
