package com.ccclubs.vehicle.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/25
 * @Time: 11:08
 * @Description: 车辆与车机绑定历史周期的输出类！
 */

public class CarLifeOutput implements Serializable {

    private static final long serialVersionUID = 7858618935130919137L;

    /**
     * 车机号
     */
    private String csNumber;
    /**
     * 车架号
     */
    private String csVin;
    /**
     * [cstb_start_time]开始时间
     */
    private Date csStartTime;
    /**
     * [cstb_end_time]结束时间
     */
    private Date csEndTime;
    /**
     * [cstb_status]状态 1:正常 0:无效
     */
    private Short csStatus;

    public String getCsNumber() {
        return csNumber;
    }

    public void setCsNumber(String csNumber) {
        this.csNumber = csNumber;
    }

    public String getCsVin() {
        return csVin;
    }

    public void setCsVin(String csVin) {
        this.csVin = csVin;
    }

    public Date getCsStartTime() {
        return csStartTime;
    }

    public void setCsStartTime(Date csStartTime) {
        this.csStartTime = csStartTime;
    }

    public Date getCsEndTime() {
        return csEndTime;
    }

    public void setCsEndTime(Date csEndTime) {
        this.csEndTime = csEndTime;
    }

    public Short getCsStatus() {
        return csStatus;
    }

    public void setCsStatus(Short csStatus) {
        this.csStatus = csStatus;
    }


}
