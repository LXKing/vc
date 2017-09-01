package com.ccclubs.command.dto;

import java.math.BigDecimal;

/**
 * 简单指令出参
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class SimpleCmdOutput extends CommonOutput implements java.io.Serializable{
    private Long cssCurrentTime;
    private Integer cssObdMile;
    private Integer cssEvBattery;
    private BigDecimal cssLongitude;
    private BigDecimal cssLatitude;
    private Short cssDoor;
    private Integer cssEngine;
    private Integer cssCharging;
    private Integer cssLight;
    private Short cssLock;
    private Integer cssBaseLAC;
    private Integer cssBaseCI;

    public Long getCssCurrentTime() {
        return cssCurrentTime;
    }

    public void setCssCurrentTime(Long cssCurrentTime) {
        this.cssCurrentTime = cssCurrentTime;
    }

    public Integer getCssObdMile() {
        return cssObdMile;
    }

    public void setCssObdMile(Integer cssObdMile) {
        this.cssObdMile = cssObdMile;
    }

    public Integer getCssEvBattery() {
        return cssEvBattery;
    }

    public void setCssEvBattery(Integer cssEvBattery) {
        this.cssEvBattery = cssEvBattery;
    }

    public BigDecimal getCssLongitude() {
        return cssLongitude;
    }

    public void setCssLongitude(BigDecimal cssLongitude) {
        this.cssLongitude = cssLongitude;
    }

    public BigDecimal getCssLatitude() {
        return cssLatitude;
    }

    public void setCssLatitude(BigDecimal cssLatitude) {
        this.cssLatitude = cssLatitude;
    }

    public Short getCssDoor() {
        return cssDoor;
    }

    public void setCssDoor(Short cssDoor) {
        this.cssDoor = cssDoor;
    }

    public Integer getCssEngine() {
        return cssEngine;
    }

    public void setCssEngine(Integer cssEngine) {
        this.cssEngine = cssEngine;
    }

    public Integer getCssCharging() {
        return cssCharging;
    }

    public void setCssCharging(Integer cssCharging) {
        this.cssCharging = cssCharging;
    }

    public Integer getCssLight() {
        return cssLight;
    }

    public void setCssLight(Integer cssLight) {
        this.cssLight = cssLight;
    }

    public Short getCssLock() {
        return cssLock;
    }

    public void setCssLock(Short cssLock) {
        this.cssLock = cssLock;
    }

    public Integer getCssBaseLAC() {
        return cssBaseLAC;
    }

    public void setCssBaseLAC(Integer cssBaseLAC) {
        this.cssBaseLAC = cssBaseLAC;
    }

    public Integer getCssBaseCI() {
        return cssBaseCI;
    }

    public void setCssBaseCI(Integer cssBaseCI) {
        this.cssBaseCI = cssBaseCI;
    }
}
