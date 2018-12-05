package com.ccclubs.command.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 简单指令出参
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class SimpleCmdOutput extends CommonOutput implements java.io.Serializable{
    /**
     * 当前时间
     */
    private Long cssCurrentTime;
    private BigDecimal cssObdMile;
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
    private Integer controlStatus;
    /**
     * 手刹状态
     * */
    private Integer handbrake;
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
     * 初始化业务订单RFID号
     */
    private String tradeInitCard;
    /**
     * 业务订单RFID号
     */
    private String tradeTakeCard;
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

    public Integer getHandbrake() {
        return handbrake;
    }

    public void setHandbrake(Integer handbrake) {
        this.handbrake = handbrake;
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

    public Byte getVrtVehicleStart() {
        return vrtVehicleStart;
    }

    public void setVrtVehicleStart(Byte vrtVehicleStart) {
        this.vrtVehicleStart = vrtVehicleStart;
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
