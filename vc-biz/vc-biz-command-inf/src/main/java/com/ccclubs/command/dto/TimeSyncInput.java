package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 时间同步入参
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class TimeSyncInput extends CommonInput implements java.io.Serializable{

    @NotNull(message = "车辆Vin码必填")
    private String vin;

    @NotNull(message = "校对时间必填")
    @Pattern(regexp = "^(\\d{4})-([0-1]\\d)-([0-3]\\d)\\s([0-5]\\d):([0-5]\\d):([0-5]\\d)$",message = "日期格式匹配不正确(yyyy-MM-dd HH:mm:ss)")
    private String time;//yyyy-MM-dd HH:mm:ss

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
