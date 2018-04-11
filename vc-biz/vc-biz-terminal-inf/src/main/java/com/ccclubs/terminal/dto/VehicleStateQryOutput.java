package com.ccclubs.terminal.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 车辆状态数据
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public class VehicleStateQryOutput implements java.io.Serializable{

    //TODO Vin码

    private String cssTeNo;//终端序列号

    private Date cssCurrentTime;//下位机时间

    private String cssRented;//租赁状态

    private Integer cssObdMile;//OBD里程，单位0.1km todo BigDecimal

    private Integer cssEngineT;//发动机温度，单位℃

    private Short cssSpeed;//车速，单位km/h

    private Integer cssMotor;//转速，单位r/min

    private String cssOil;//燃油量，单位L

    private Integer cssPower;//蓄电量，单位10mV

    private Byte cssEvBattery;//动力电池电，单位1%

    private Byte cssCharging;//在充电(0：未充电或无效，1：慢充，2：快充)

    private String cssEndurance;//续航里程，单位km

    private Short cssTemperature;//车内温度【仅供参考】，单位℃

    private Short cssCsq;//信号强度

    private BigDecimal cssLongitude;//经度【小数6位】

    private BigDecimal cssLatitude;//纬度【小数6位】

    //TODO cssGpsValid GPS有效位
    //TODO cssGpsCn GPS CN值
    //TODO cssGpsCount GPS可视卫星数量

    private String cssDir;//方向角度

    private Byte cssCircular;//循环模式，（0:内循环 1:外循环）

    private Byte cssPtc;//PTC启停，（0:OFF 1:ON）

    private Byte cssCompres;//压缩机，（0:OFF 1:ON）

    private Byte cssFan;//档风量，（0:OFF 1:1档 2:2档 3:3档 4:4档）

    //TODO cssBaseLAC 基站信号 LAC 值
    //TODO cssBaseCI  基站信号 CI值

    private Byte cssSaving;//省电模式，（0:标准模式 1:最佳省电 2:极度省电）

    private Byte cssEngine;//车门状态共两个字节，高字节代表车门MASK，详见表A，低字节代表车门开关状态

    private String cssDoor;//车门状态共两个字节，高字节代表车门MASK，详见表A，低字节代表车门开关状态

    private Integer cssLight;//灯状态，共四个字节，高双字节代表灯MASK，详见表C，低双字节代表灯开关状态

    private Integer cssLock;//门锁状态，共两个字节，高字节代表车门MASK，详见表E，低字节代表车门开关状态

    private Byte cssGear;//0：空挡；1：1挡；2：2挡；3：3挡；...13：倒挡；14：自动D挡；15：停车P挡

    //TODO 手刹
    //TODO 自动驾驶状态

    public String getCssTeNo() {
        return cssTeNo;
    }

    public void setCssTeNo(String cssTeNo) {
        this.cssTeNo = cssTeNo;
    }

    public Date getCssCurrentTime() {
        return cssCurrentTime;
    }

    public void setCssCurrentTime(Date cssCurrentTime) {
        this.cssCurrentTime = cssCurrentTime;
    }

    public String getCssRented() {
        return cssRented;
    }

    public void setCssRented(String cssRented) {
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

    public Short getCssSpeed() {
        return cssSpeed;
    }

    public void setCssSpeed(Short cssSpeed) {
        this.cssSpeed = cssSpeed;
    }

    public Integer getCssMotor() {
        return cssMotor;
    }

    public void setCssMotor(Integer cssMotor) {
        this.cssMotor = cssMotor;
    }

    public String getCssOil() {
        return cssOil;
    }

    public void setCssOil(String cssOil) {
        this.cssOil = cssOil;
    }

    public Integer getCssPower() {
        return cssPower;
    }

    public void setCssPower(Integer cssPower) {
        this.cssPower = cssPower;
    }

    public Byte getCssEvBattery() {
        return cssEvBattery;
    }

    public void setCssEvBattery(Byte cssEvBattery) {
        this.cssEvBattery = cssEvBattery;
    }

    public Byte getCssCharging() {
        return cssCharging;
    }

    public void setCssCharging(Byte cssCharging) {
        this.cssCharging = cssCharging;
    }

    public String getCssEndurance() {
        return cssEndurance;
    }

    public void setCssEndurance(String cssEndurance) {
        this.cssEndurance = cssEndurance;
    }

    public Short getCssTemperature() {
        return cssTemperature;
    }

    public void setCssTemperature(Short cssTemperature) {
        this.cssTemperature = cssTemperature;
    }

    public Short getCssCsq() {
        return cssCsq;
    }

    public void setCssCsq(Short cssCsq) {
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

    public String getCssDir() {
        return cssDir;
    }

    public void setCssDir(String cssDir) {
        this.cssDir = cssDir;
    }

    public Byte getCssCircular() {
        return cssCircular;
    }

    public void setCssCircular(Byte cssCircular) {
        this.cssCircular = cssCircular;
    }

    public Byte getCssPtc() {
        return cssPtc;
    }

    public void setCssPtc(Byte cssPtc) {
        this.cssPtc = cssPtc;
    }

    public Byte getCssCompres() {
        return cssCompres;
    }

    public void setCssCompres(Byte cssCompres) {
        this.cssCompres = cssCompres;
    }

    public Byte getCssFan() {
        return cssFan;
    }

    public void setCssFan(Byte cssFan) {
        this.cssFan = cssFan;
    }

    public Byte getCssSaving() {
        return cssSaving;
    }

    public void setCssSaving(Byte cssSaving) {
        this.cssSaving = cssSaving;
    }

    public Byte getCssEngine() {
        return cssEngine;
    }

    public void setCssEngine(Byte cssEngine) {
        this.cssEngine = cssEngine;
    }

    public String getCssDoor() {
        return cssDoor;
    }

    public void setCssDoor(String cssDoor) {
        this.cssDoor = cssDoor;
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

    public Byte getCssGear() {
        return cssGear;
    }

    public void setCssGear(Byte cssGear) {
        this.cssGear = cssGear;
    }
}
