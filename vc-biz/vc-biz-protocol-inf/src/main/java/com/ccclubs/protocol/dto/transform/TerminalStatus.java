package com.ccclubs.protocol.dto.transform;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 终端上传的状态数据
 * Created by qsxiaogang on 2017/6/3.
 */
public class TerminalStatus implements Serializable {

    private static final long serialVersionUID = 1999426779084374974L;
    /**
     * 终端序列号
     */
    private String cssNumber;
    /**
     * 车辆VIN吗
     */
    private String cssVin;
    /**
     * 订单号
     */
    private Long cssOrder;

    /**
     * 下位机时间
     */
    private Long cssCurrentTime;
    /**
     * 车辆租赁状态 ,0x00 初始状态，0x01 收到订单，
     */
    private Integer cssRented;
    /**
     * 车辆OBD里程
     */
    private Integer cssObdMile;
    /**
     * 发动机温度
     */
    private Integer cssEngineT;
    /**
     * 车速
     */
    private Integer cssSpeed;
    /**
     * 转速
     */
    private Integer cssMotor;

    /**
     * 燃油量
     */
    private Integer cssOil = 0;

    /**
     * 蓄电池电量
     */
    private Integer cssPower;

    /**
     * 动力电池电量
     */
    private Integer cssEvBattery;

    /**
     * 是否在充电(0：未充电或无效，1：慢充，2：快充)
     */
    private Integer cssCharging;

    /**
     * 续航里程
     */
    private Integer cssEndurance;
    /**
     * 车内温度
     */
    private Integer cssTemperature;
    /**
     * 信号强度
     */
    private Integer cssCsq;
    /**
     * 经度，带6位小数
     */
    private BigDecimal cssLongitude;
    /**
     * 纬度，带6位小数
     */
    private BigDecimal cssLatitude;

    /**
     * 航向角
     */
    private Integer cssDir;

    /**
     * 空调状态 mAirConditionerStaus，bit0 循环模式，（0:内循环 1:外循环）
     */
    private Integer cssCircular;

    /**
     * 空调状态 mAirConditionerStaus，bit1 PTC启停，（0:OFF 1:ON）
     */
    private Integer cssPtc;
    /**
     * 空调状态 mAirConditionerStaus，bit2 压缩机，（0:OFF 1:ON）
     */
    private Integer cssCompres;
    /**
     * 空调状态 mAirConditionerStaus，bit3-bit5 档风量，（0:OFF 1:1档 2:2档 3:3档 4:4档）
     */
    private Integer cssFan;

    /**
     * 车机的功耗的工作状态
     */
    private Integer cssSaving;

    /**
     * 车门状态，高WORD 代表 MASK,低 WORD 代表内容
     */
    private Integer cssDoor;

    // ===================================
    /**
     * CN值
     */
    private Integer cssCn;
    /**
     * 可视卫星数量
     */
    private Integer cssSatelliteCount;
    /**
     * 卫星有效数位
     */
    private Integer cssSatelliteEffective;

    /**
     * GPS有效性
     */
    private Integer cssGPSValid;
    /**
     * GPS CN值
     */
    private Integer cssGpsCn;
    /**
     * GPS 当前卫星数量
     */
    private Integer cssGpsCount;

    /**
     * 车辆状态
     */
    private Integer cssVehicleStatus;

    /**
     * 车机的休眠时间
     */
    private Integer cssVehicleSleepTime;

    /**
     * 车辆启动状态
     */
    private Integer cssVehicleStaus;

    /**
     * 网络类型,0-GSM，1-3G/4G,2-CDMA
     */
    private Integer cssNetType;

    /**
     * 基站LAC
     */
    private Integer cssBaseLAC;

    /**
     * 基站CI
     */
    private Integer cssBaseCI;

    /**
     * 挡位信息
     */
    private Integer cssGear;

    public String getCssNumber() {
        return cssNumber;
    }

    public void setCssNumber(String cssNumber) {
        this.cssNumber = cssNumber;
    }

    public Long getCssOrder() {
        return cssOrder;
    }

    public void setCssOrder(Long cssOrder) {
        this.cssOrder = cssOrder;
    }

    public Long getCssCurrentTime() {
        return cssCurrentTime;
    }

    public void setCssCurrentTime(Long cssCurrentTime) {
        this.cssCurrentTime = cssCurrentTime;
    }

    public Integer getCssRented() {
        return cssRented;
    }

    public void setCssRented(Integer cssRented) {
        this.cssRented = cssRented;
    }

    public Integer getCssObdMile() {
        return cssObdMile;
    }

    public void setCssObdMile(Integer cssObdMile) {
        this.cssObdMile = cssObdMile;
    }

    public Integer getCssEngineT() {
        return cssEngineT;
    }

    public void setCssEngineT(Integer cssEngineT) {
        this.cssEngineT = cssEngineT;
    }

    public Integer getCssSpeed() {
        return cssSpeed;
    }

    public void setCssSpeed(Integer cssSpeed) {
        this.cssSpeed = cssSpeed;
    }

    public Integer getCssMotor() {
        return cssMotor;
    }

    public void setCssMotor(Integer cssMotor) {
        this.cssMotor = cssMotor;
    }

    public Integer getCssOil() {
        return cssOil;
    }

    public void setCssOil(Integer cssOil) {
        this.cssOil = cssOil;
    }

    public Integer getCssPower() {
        return cssPower;
    }

    public void setCssPower(Integer cssPower) {
        this.cssPower = cssPower;
    }

    public Integer getCssEvBattery() {
        return cssEvBattery;
    }

    public void setCssEvBattery(Integer cssEvBattery) {
        this.cssEvBattery = cssEvBattery;
    }

    public Integer getCssCharging() {
        return cssCharging;
    }

    public void setCssCharging(Integer cssCharging) {
        this.cssCharging = cssCharging;
    }

    public Integer getCssEndurance() {
        return cssEndurance;
    }

    public void setCssEndurance(Integer cssEndurance) {
        this.cssEndurance = cssEndurance;
    }

    public Integer getCssTemperature() {
        return cssTemperature;
    }

    public void setCssTemperature(Integer cssTemperature) {
        this.cssTemperature = cssTemperature;
    }

    public Integer getCssCsq() {
        return cssCsq;
    }

    public void setCssCsq(Integer cssCsq) {
        this.cssCsq = cssCsq;
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

    public Integer getCssDir() {
        return cssDir;
    }

    public void setCssDir(Integer cssDir) {
        this.cssDir = cssDir;
    }

    public Integer getCssCircular() {
        return cssCircular;
    }

    public void setCssCircular(Integer cssCircular) {
        this.cssCircular = cssCircular;
    }

    public Integer getCssPtc() {
        return cssPtc;
    }

    public void setCssPtc(Integer cssPtc) {
        this.cssPtc = cssPtc;
    }

    public Integer getCssCompres() {
        return cssCompres;
    }

    public void setCssCompres(Integer cssCompres) {
        this.cssCompres = cssCompres;
    }

    public Integer getCssFan() {
        return cssFan;
    }

    public void setCssFan(Integer cssFan) {
        this.cssFan = cssFan;
    }

    public Integer getCssSaving() {
        return cssSaving;
    }

    public void setCssSaving(Integer cssSaving) {
        this.cssSaving = cssSaving;
    }

    public Integer getCssDoor() {
        return cssDoor;
    }

    public void setCssDoor(Integer cssDoor) {
        this.cssDoor = cssDoor;
    }

    public Integer getCssCn() {
        return cssCn;
    }

    public void setCssCn(Integer cssCn) {
        this.cssCn = cssCn;
    }

    public Integer getCssSatelliteCount() {
        return cssSatelliteCount;
    }

    public void setCssSatelliteCount(Integer cssSatelliteCount) {
        this.cssSatelliteCount = cssSatelliteCount;
    }

    public Integer getCssSatelliteEffective() {
        return cssSatelliteEffective;
    }

    public void setCssSatelliteEffective(Integer cssSatelliteEffective) {
        this.cssSatelliteEffective = cssSatelliteEffective;
    }

    public Integer getCssGpsCn() {
        return cssGpsCn;
    }

    public void setCssGpsCn(Integer cssGpsCn) {
        this.cssGpsCn = cssGpsCn;
    }

    public Integer getCssGpsCount() {
        return cssGpsCount;
    }

    public void setCssGpsCount(Integer cssGpsCount) {
        this.cssGpsCount = cssGpsCount;
    }

    public Integer getCssGPSValid() {
        return cssGPSValid;
    }

    public void setCssGPSValid(Integer cssGPSValid) {
        this.cssGPSValid = cssGPSValid;
    }

    public Integer getCssVehicleStatus() {
        return cssVehicleStatus;
    }

    public void setCssVehicleStatus(Integer cssVehicleStatus) {
        this.cssVehicleStatus = cssVehicleStatus;
    }

    public Integer getCssVehicleSleepTime() {
        return cssVehicleSleepTime;
    }

    public void setCssVehicleSleepTime(Integer cssVehicleSleepTime) {
        this.cssVehicleSleepTime = cssVehicleSleepTime;
    }

    public Integer getCssVehicleStaus() {
        return cssVehicleStaus;
    }

    public void setCssVehicleStaus(Integer cssVehicleStaus) {
        this.cssVehicleStaus = cssVehicleStaus;
    }

    public Integer getCssNetType() {
        return cssNetType;
    }

    public void setCssNetType(Integer cssNetType) {
        this.cssNetType = cssNetType;
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
