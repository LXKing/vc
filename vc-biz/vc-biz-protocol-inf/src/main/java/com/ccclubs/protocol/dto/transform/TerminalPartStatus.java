package com.ccclubs.protocol.dto.transform;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 通过远程控制指令获取的部分车辆状态数据 Created by qsxiaogang on 2017/6/3.
 */
public class TerminalPartStatus implements Serializable {

    private static final long serialVersionUID = -6519276463058646695L;
    /**
     * 下位机时间
     */
    private Long cssCurrentTime;

    /**
     * 车辆OBD里程
     */
    private BigDecimal cssObdMile;
    /**
     * 油量
     */
    private BigDecimal cssOil;
    /**
     * 订单状态
     */
    private Integer cssTradeStatus;
    /**
     * 订单里程
     */
    private BigDecimal cssTradeMile;
    /**
     * 订单开始时间
     */
    private Date cssTradeStartTime;
    /**
     * 订单结束时间
     */
    private Date cssTradeEndTime;
    /**
     * 动力电池电量
     */
    private Integer cssEvBattery;
    /**
     * 经度，带6位小数
     */
    private BigDecimal cssLongitude;
    /**
     * 纬度，带6位小数
     */
    private BigDecimal cssLatitude;

    /**
     * 车门状态，高WORD 代表 MASK,低 WORD 代表内容
     */
    private Short cssDoor;

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
    private Short cssLock = 0;

    // ===================================
    /**
     * 基站LAC
     */
    private Integer cssBaseLAC;

    /**
     * 基站CI
     */
    private Integer cssBaseCI;

    /**
     * GPS辅助定位，经度平均值
     */
    private BigDecimal cssLongitudeAvg;
    /**
     * GPS辅助定位，纬度平均值
     */
    private BigDecimal cssLatitudeAvg;
    /**
     * GPS辅助定位，经度最大值
     */
    private BigDecimal cssLongitudeMax;
    /**
     * GPS辅助定位，纬度最大值
     */
    private BigDecimal cssLatitudeMax;
    /**
     * GPS辅助定位，经度最小值
     */
    private BigDecimal cssLongitudeMin;
    /**
     * GPS辅助定位，纬度最小值
     */
    private BigDecimal cssLatitudeMin;
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
    /**
     * 控制状态
     */
    private Integer controlStatus;
    /**
     * 手刹状态
     * */
    private Integer handbrake;
    /**
     * 初始化业务订单RFID号
     */
    String tradeInitCard;
    /**
     * 业务订单RFID号
     */
    String tradeTakeCard;

    public String getTradeInitCard() {
        return tradeInitCard;
    }

    public void setTradeInitCard(String tradeInitCard) {
        this.tradeInitCard = tradeInitCard;
    }

    public String getTradeTakeCard() {
        return tradeTakeCard;
    }

    public void setTradeTakeCard(String tradeTakeCard) {
        this.tradeTakeCard = tradeTakeCard;
    }

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

    public Integer getHandbrake() {
        return handbrake;
    }

    public void setHandbrake(Integer handbrake) {
        this.handbrake = handbrake;
    }

    public Byte getVrtVehicleStart() {
        return vrtVehicleStart;
    }

    public void setVrtVehicleStart(Byte vrtVehicleStart) {
        this.vrtVehicleStart = vrtVehicleStart;
    }

    public BigDecimal getCssOil() {
        return cssOil;
    }

    public void setCssOil(BigDecimal cssOil) {
        this.cssOil = cssOil;
    }

    public Date getCssTradeStartTime() {
        return cssTradeStartTime;
    }

    public void setCssTradeStartTime(Date cssTradeStartTime) {
        this.cssTradeStartTime = cssTradeStartTime;
    }

    public Date getCssTradeEndTime() {
        return cssTradeEndTime;
    }

    public void setCssTradeEndTime(Date cssTradeEndTime) {
        this.cssTradeEndTime = cssTradeEndTime;
    }

    public Integer getCssTradeStatus() {
        return cssTradeStatus;
    }

    public void setCssTradeStatus(Integer cssTradeStatus) {
        this.cssTradeStatus = cssTradeStatus;
    }

    public BigDecimal getCssTradeMile() {
        return cssTradeMile;
    }

    public void setCssTradeMile(BigDecimal cssTradeMile) {
        this.cssTradeMile = cssTradeMile;
    }

    public Integer getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(Integer controlStatus) {
        this.controlStatus = controlStatus;
    }

    public Long getCssCurrentTime() {
        return cssCurrentTime;
    }

    public void setCssCurrentTime(Long cssCurrentTime) {
        this.cssCurrentTime = cssCurrentTime;
    }

    public BigDecimal getCssObdMile() {
        return cssObdMile;
    }

    public void setCssObdMile(BigDecimal cssObdMile) {
        this.cssObdMile = cssObdMile;
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

    public Integer getCssEngine() {
        return cssEngine;
    }

    public void setCssEngine(Integer cssEngine) {
        this.cssEngine = cssEngine;
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

    public BigDecimal getCssLongitudeAvg() {
        return cssLongitudeAvg;
    }

    public void setCssLongitudeAvg(BigDecimal cssLongitudeAvg) {
        this.cssLongitudeAvg = cssLongitudeAvg;
    }

    public BigDecimal getCssLatitudeAvg() {
        return cssLatitudeAvg;
    }

    public void setCssLatitudeAvg(BigDecimal cssLatitudeAvg) {
        this.cssLatitudeAvg = cssLatitudeAvg;
    }

    public BigDecimal getCssLongitudeMax() {
        return cssLongitudeMax;
    }

    public void setCssLongitudeMax(BigDecimal cssLongitudeMax) {
        this.cssLongitudeMax = cssLongitudeMax;
    }

    public BigDecimal getCssLatitudeMax() {
        return cssLatitudeMax;
    }

    public void setCssLatitudeMax(BigDecimal cssLatitudeMax) {
        this.cssLatitudeMax = cssLatitudeMax;
    }

    public BigDecimal getCssLongitudeMin() {
        return cssLongitudeMin;
    }

    public void setCssLongitudeMin(BigDecimal cssLongitudeMin) {
        this.cssLongitudeMin = cssLongitudeMin;
    }

    public BigDecimal getCssLatitudeMin() {
        return cssLatitudeMin;
    }

    public void setCssLatitudeMin(BigDecimal cssLatitudeMin) {
        this.cssLatitudeMin = cssLatitudeMin;
    }
}
