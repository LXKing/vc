package com.ccclubs.admin.dto;

import java.io.Serializable;

/**
 * 2018/9/18
 * 车辆统计
 *
 * @author machuanpeng
 */
public class CarStatisticsDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 车辆总数
     */
    private Integer allCar;
    /**
     * 在线车辆
     */
    private Integer onlineCar;
    /**
     * 离线车辆
     */
    private Integer offLine;

    public CarStatisticsDto() {

    }

    public CarStatisticsDto(Integer allCar, Integer onlineCar, Integer offLine) {
        this.allCar = allCar;
        this.onlineCar = onlineCar;
        this.offLine = offLine;
    }

    public Integer getAllCar() {
        return allCar;
    }

    public void setAllCar(Integer allCar) {
        this.allCar = allCar;
    }

    public Integer getOnlineCar() {
        return onlineCar;
    }

    public void setOnlineCar(Integer onlineCar) {
        this.onlineCar = onlineCar;
    }

    public Integer getOffLine() {
        return offLine;
    }

    public void setOffLine(Integer offLine) {
        this.offLine = offLine;
    }
}
