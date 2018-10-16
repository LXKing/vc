package com.ccclubs.protocol.dto.transform;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 终端上传的触发数据 Created by qsxiaogang on 2017/6/3.
 */
public class TerminalTriggerStatus implements Serializable {

    private static final long serialVersionUID = 1139180285816041606L;
    /**
     * 终端序列号
     */
    private String cssNumber;
    /**
     * 车辆VIN吗
     */
    private String cssVin;
    /**
     * 下位机时间
     */
    private Long cssCurrentTime = 0L;
    /**
     * 发动机状态，1未熄火，2已熄火，0无效
     */
    private Integer cssEngine = 0;
    /**
     * 在充电(0：未充电或无效，1：慢充，2：快充)
     */
    private Integer cssCharging = 0;
    /**
     * 灯状态，（1未关，2全关，0无效）
     */
    private Integer cssLight = 0;
    /**
     * 门锁状态，1未关，2全关，0无效
     */
    private Integer cssLock = 0;
    /**
     * 车门状态，高WORD 代表 MASK,低 WORD 代表内容
     */
    private Integer cssDoor = 0;
    /**
     * 挡位信息
     */
    private Integer cssGear;

    /**
     * 控制状态
     */
    private short controlStatusWithMask;
    /**
     * 车辆自身经度
     */
    private BigDecimal acuLongitude;

    /**
     * 车辆自身纬度
     */
    private BigDecimal acuLatitude;

    /**
     * 车辆状态-自动行驶当前状态
     */
    private Byte acuVehicleAdState;

    /**
     * 车辆启动控制方式-自动行驶当前车机指令状态
     */
    private Byte vrtVehicleStart;

    public BigDecimal getAcuLongitude() {
        return acuLongitude;
    }

    public void setAcuLongitude(BigDecimal acuLongitude) {
        this.acuLongitude = acuLongitude;
    }

    public BigDecimal getAcuLatitude() {
        return acuLatitude;
    }

    public void setAcuLatitude(BigDecimal acuLatitude) {
        this.acuLatitude = acuLatitude;
    }

    public Byte getAcuVehicleAdState() {
        return acuVehicleAdState;
    }

    public void setAcuVehicleAdState(Byte acuVehicleAdState) {
        this.acuVehicleAdState = acuVehicleAdState;
    }

    public Byte getVrtVehicleStart() {
        return vrtVehicleStart;
    }

    public void setVrtVehicleStart(Byte vrtVehicleStart) {
        this.vrtVehicleStart = vrtVehicleStart;
    }

    public short getControlStatusWithMask() {
        return controlStatusWithMask;
    }

    public void setControlStatusWithMask(short controlStatusWithMask) {
        this.controlStatusWithMask = controlStatusWithMask;
    }

    public String getCssNumber() {
        return cssNumber;
    }

    public void setCssNumber(String cssNumber) {
        this.cssNumber = cssNumber;
    }

    public Long getCssCurrentTime() {
        return cssCurrentTime;
    }

    public void setCssCurrentTime(Long cssCurrentTime) {
        this.cssCurrentTime = cssCurrentTime;
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

    public Integer getCssLock() {
        return cssLock;
    }

    public void setCssLock(Integer cssLock) {
        this.cssLock = cssLock;
    }

    public Integer getCssDoor() {
        return cssDoor;
    }

    public void setCssDoor(Integer cssDoor) {
        this.cssDoor = cssDoor;
    }

    public Integer getCssGear() {
        return cssGear;
    }

    public void setCssGear(Integer cssGear) {
        this.cssGear = cssGear;
    }

    public String getCssVin() {
        return cssVin;
    }

    public void setCssVin(String cssVin) {
        this.cssVin = cssVin;
    }
}
