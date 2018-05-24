package com.ccclubs.protocol.dto.transform;

import java.io.Serializable;
import java.math.BigDecimal;

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
  private Integer cssObdMile;

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
