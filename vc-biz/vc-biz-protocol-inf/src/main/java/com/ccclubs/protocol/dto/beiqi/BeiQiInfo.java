package com.ccclubs.protocol.dto.beiqi;

import java.io.Serializable;

/**
 * 北汽新能源平台返回结果 消息头
 * Created by qsxiaogang on 2017/3/16.
 */
public class BeiQiInfo implements Serializable {

  private static final long serialVersionUID = 3008496971828906681L;

  /**
   * accStatus : 1
   * centralLockStatus : 0
   * chargeStatus : 0
   * defendStatus : 0
   * doorStatus : 00000
   * electricity : 13
   * fillGunStatus : 0
   * gsmvalue : 23
   * lightStatus : 0000
   * mileage : 24
   * oilStatus : 0
   * rfid : 0
   * satellitecount : 10
   * voltage : 14
   * windowStatus : 0
   */
  /**
   * ACC 状态 0 ACC 关 1 ACC 开
   */
  private String accStatus;
  /**
   * 中控锁状态 0 未锁 1 锁上
   */
  private String centralLockStatus;
  /**
   * 充电状态（0：未充电，1：充电中，2：充电完成，
   * 3：充电故障）
   */
  private String chargeStatus;
  /**
   * 防盗状态 0 撤防 1 设防
   */
  private String defendStatus;
  /**
   * 车门状态，第一个字节为驾驶员门，第二个字节为
   * 副驾驶员门，第三个字节为驾驶员后门，第四个字节为副驾驶员后门，第五个为后备箱门 0 未关 1
   * 关
   */
  private String doorStatus;
  /**
   * 电量百分比(百分之一)
   */
  private String electricity;
  /**
   * 充枪连接状态 0 半连接 1 未连接 2 已连接
   */
  private String fillGunStatus;
  /**
   * 定位时间 形如：2014-10-30 21:58:09
   */
  private String gsmvalue;
  /**
   * 车灯状态 第一个字节为小灯，第二个字节为大
   灯， 第三个字节为后雾灯， 第四个字节为前雾灯 0
   灭 1 亮
   */
  private String lightStatus;
  /**
   * 续航里程（km）
   */
  private String mileage;
  /**
   * 油量百分比 形如：92，为百分比
   */
  private String oilStatus;
  /**
   * 会员卡卡号
   */
  private String rfid;
  /**
   * 卫星数
   */
  private String satellitecount;
  /**
   * 电池电压值（单位：0.1V）
   */
  private String voltage;
  /**
   * 车窗状态 0 全关好 1 未关好
   */
  private String windowStatus;

  public String getAccStatus() {
    return accStatus;
  }

  public void setAccStatus(String accStatus) {
    this.accStatus = accStatus;
  }

  public String getCentralLockStatus() {
    return centralLockStatus;
  }

  public void setCentralLockStatus(String centralLockStatus) {
    this.centralLockStatus = centralLockStatus;
  }

  public String getChargeStatus() {
    return chargeStatus;
  }

  public void setChargeStatus(String chargeStatus) {
    this.chargeStatus = chargeStatus;
  }

  public String getDefendStatus() {
    return defendStatus;
  }

  public void setDefendStatus(String defendStatus) {
    this.defendStatus = defendStatus;
  }

  public String getDoorStatus() {
    return doorStatus;
  }

  public void setDoorStatus(String doorStatus) {
    this.doorStatus = doorStatus;
  }

  public String getElectricity() {
    return electricity;
  }

  public void setElectricity(String electricity) {
    this.electricity = electricity;
  }

  public String getFillGunStatus() {
    return fillGunStatus;
  }

  public void setFillGunStatus(String fillGunStatus) {
    this.fillGunStatus = fillGunStatus;
  }

  public String getGsmvalue() {
    return gsmvalue;
  }

  public void setGsmvalue(String gsmvalue) {
    this.gsmvalue = gsmvalue;
  }

  public String getLightStatus() {
    return lightStatus;
  }

  public void setLightStatus(String lightStatus) {
    this.lightStatus = lightStatus;
  }

  public String getMileage() {
    return mileage;
  }

  public void setMileage(String mileage) {
    this.mileage = mileage;
  }

  public String getOilStatus() {
    return oilStatus;
  }

  public void setOilStatus(String oilStatus) {
    this.oilStatus = oilStatus;
  }

  public String getRfid() {
    return rfid;
  }

  public void setRfid(String rfid) {
    this.rfid = rfid;
  }

  public String getSatellitecount() {
    return satellitecount;
  }

  public void setSatellitecount(String satellitecount) {
    this.satellitecount = satellitecount;
  }

  public String getVoltage() {
    return voltage;
  }

  public void setVoltage(String voltage) {
    this.voltage = voltage;
  }

  public String getWindowStatus() {
    return windowStatus;
  }

  public void setWindowStatus(String windowStatus) {
    this.windowStatus = windowStatus;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"accStatus\":\"")
        .append(accStatus).append('\"');
    sb.append(",\"centralLockStatus\":\"")
        .append(centralLockStatus).append('\"');
    sb.append(",\"chargeStatus\":\"")
        .append(chargeStatus).append('\"');
    sb.append(",\"defendStatus\":\"")
        .append(defendStatus).append('\"');
    sb.append(",\"doorStatus\":\"")
        .append(doorStatus).append('\"');
    sb.append(",\"electricity\":\"")
        .append(electricity).append('\"');
    sb.append(",\"fillGunStatus\":\"")
        .append(fillGunStatus).append('\"');
    sb.append(",\"gsmvalue\":\"")
        .append(gsmvalue).append('\"');
    sb.append(",\"lightStatus\":\"")
        .append(lightStatus).append('\"');
    sb.append(",\"mileage\":\"")
        .append(mileage).append('\"');
    sb.append(",\"oilStatus\":\"")
        .append(oilStatus).append('\"');
    sb.append(",\"rfid\":\"")
        .append(rfid).append('\"');
    sb.append(",\"satellitecount\":\"")
        .append(satellitecount).append('\"');
    sb.append(",\"voltage\":\"")
        .append(voltage).append('\"');
    sb.append(",\"windowStatus\":\"")
        .append(windowStatus).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
