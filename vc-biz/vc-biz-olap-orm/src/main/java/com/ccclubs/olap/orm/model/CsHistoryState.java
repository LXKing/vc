package com.ccclubs.olap.orm.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
public class CsHistoryState implements Serializable {

    private  String csHsNumber;

    private  Float csHsSpeed;

    private  Integer csHsEvBattery;

    private Double csHsLongitude;

    private Double csHsLatitude;

    private  String csHsAddTime;

    private static final long serialVersionUID =1L;

    public String getCsHsNumber() {
        return csHsNumber;
    }

    public void setCsHsNumber(String csHsNumber) {
        this.csHsNumber = csHsNumber;
    }

    public Float getCsHsSpeed() {
        return csHsSpeed;
    }

    public void setCsHsSpeed(Float csHsSpeed) {
        this.csHsSpeed = csHsSpeed;
    }

    public Integer getCsHsEvBattery() {
        return csHsEvBattery;
    }

    public void setCsHsEvBattery(Integer csHsEvBattery) {
        this.csHsEvBattery = csHsEvBattery;
    }

    public Double getCsHsLongitude() {
        return csHsLongitude;
    }

    public void setCsHsLongitude(Double csHsLongitude) {
        this.csHsLongitude = csHsLongitude;
    }

    public Double getCsHsLatitude() {
        return csHsLatitude;
    }

    public void setCsHsLatitude(Double csHsLatitude) {
        this.csHsLatitude = csHsLatitude;
    }

    public String getCsHsAddTime() {
        return csHsAddTime;
    }

    public void setCsHsAddTime(String csHsAddTime) {
        this.csHsAddTime = csHsAddTime;
    }
}
