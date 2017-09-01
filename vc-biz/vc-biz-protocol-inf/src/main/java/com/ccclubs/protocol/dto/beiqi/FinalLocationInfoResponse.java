package com.ccclubs.protocol.dto.beiqi;

import java.io.Serializable;

/**
 * 北汽新能源平台返回结果 获取设备位置和车辆状态信息 消息返回
 * Created by qsxiaogang on 2017/3/16.
 */
public class FinalLocationInfoResponse implements Serializable {

  private static final long serialVersionUID = 2637317472481888523L;

  /**
   * accStatus : 0
   * altitude :
   * centralLockStatus : 1
   * chargeStatus : 0
   * defendStatus : 1
   * devID : 100016880000010
   * doorStatus : 10000
   * electricity : 30
   * fillGunStatus : 0
   * gpsTime : 2017-03-16 13:31:51
   * gsmvalue : 17
   * isLoc : 0
   * isTwoMinutesDatas : 1
   * latitude : 39.87234700
   * lightStatus : 0000
   * longitude : 116.45542300
   * mileage : 29
   * oilPercent : 0
   * oilStatus : 0
   * powerPercent : 30
   * rfid : 0
   * satellitecount : 0
   * sign :
   * sirection : 0
   * speed : 0.00
   * stars : 0
   * status : 25;32;23;60
   * totalDistance : 7832
   * voltage : 653
   * windowStatus : 0
   */

  /**
   * ACC 状态 0 ACC 关 1 ACC 开
   */
  private String accStatus;
  /**
   * 海拔
   */
  private String altitude;
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
   * 设备 id（每台 T-box 硬件的 ID）
   */
  private String devID;
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
  private String gpsTime;
  /**
   * GSM 信号强度
   */
  private String gsmvalue;
  private String isLoc;
  private String isTwoMinutesDatas;
  /**
   * 纬度 115.4442730000，单位：度
   */
  private String latitude;
  /**
   * 车灯状态 第一个字节为小灯，第二个字节为大
   * 灯， 第三个字节为后雾灯， 第四个字节为前雾灯 0
   * 灭 1 亮
   */
  private String lightStatus;
  /**
   * 经度 28.1972100000，单位：度
   */
  private String longitude;
  /**
   * 续航里程（km）
   */
  private String mileage;
  /**
   * 油量百分比 形如：92，为百分比
   */
  private String oilPercent;
  /**
   * 油路状态 0 闭合 1 断开
   */
  private String oilStatus;
  /**
   * 电量百分比 形如：90，为百分比
   */
  private String powerPercent;
  /**
   * 会员卡卡号
   */
  private String rfid;
  /**
   * 预定结果，0 预定成功，1 预定失败
   */
  private String result;
  /**
   * 卫星数
   */
  private String satellitecount;
  private String sign;
  /**
   * 方向 0-360，单位：度
   */
  private String sirection;
  /**
   * 速度
   */
  private String speed;
  /**
   * 卫星数量
   */
  private String stars;
  /**
   * 状态串 形如：23,33,36
   * 字段值 代表含义 备注
   * 3 电瓶欠压
   * 4 车台主电被切断
   * 5 紧急报警
   * 23 车辆熄火
   * 33 车辆发动
   */
  private String status;
  /**
   * 行驶总里程 93971500，单位：m
   */
  private String totalDistance;
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

  public String getAltitude() {
    return altitude;
  }

  public void setAltitude(String altitude) {
    this.altitude = altitude;
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

  public String getDevID() {
    return devID;
  }

  public void setDevID(String devID) {
    this.devID = devID;
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

  public String getGpsTime() {
    return gpsTime;
  }

  public void setGpsTime(String gpsTime) {
    this.gpsTime = gpsTime;
  }

  public String getGsmvalue() {
    return gsmvalue;
  }

  public void setGsmvalue(String gsmvalue) {
    this.gsmvalue = gsmvalue;
  }

  public String getIsLoc() {
    return isLoc;
  }

  public void setIsLoc(String isLoc) {
    this.isLoc = isLoc;
  }

  public String getIsTwoMinutesDatas() {
    return isTwoMinutesDatas;
  }

  public void setIsTwoMinutesDatas(String isTwoMinutesDatas) {
    this.isTwoMinutesDatas = isTwoMinutesDatas;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLightStatus() {
    return lightStatus;
  }

  public void setLightStatus(String lightStatus) {
    this.lightStatus = lightStatus;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getMileage() {
    return mileage;
  }

  public void setMileage(String mileage) {
    this.mileage = mileage;
  }

  public String getOilPercent() {
    return oilPercent;
  }

  public void setOilPercent(String oilPercent) {
    this.oilPercent = oilPercent;
  }

  public String getOilStatus() {
    return oilStatus;
  }

  public void setOilStatus(String oilStatus) {
    this.oilStatus = oilStatus;
  }

  public String getPowerPercent() {
    return powerPercent;
  }

  public void setPowerPercent(String powerPercent) {
    this.powerPercent = powerPercent;
  }

  public String getRfid() {
    return rfid;
  }

  public void setRfid(String rfid) {
    this.rfid = rfid;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getSatellitecount() {
    return satellitecount;
  }

  public void setSatellitecount(String satellitecount) {
    this.satellitecount = satellitecount;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getSirection() {
    return sirection;
  }

  public void setSirection(String sirection) {
    this.sirection = sirection;
  }

  public String getSpeed() {
    return speed;
  }

  public void setSpeed(String speed) {
    this.speed = speed;
  }

  public String getStars() {
    return stars;
  }

  public void setStars(String stars) {
    this.stars = stars;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTotalDistance() {
    return totalDistance;
  }

  public void setTotalDistance(String totalDistance) {
    this.totalDistance = totalDistance;
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
    sb.append(",\"altitude\":\"")
        .append(altitude).append('\"');
    sb.append(",\"centralLockStatus\":\"")
        .append(centralLockStatus).append('\"');
    sb.append(",\"chargeStatus\":\"")
        .append(chargeStatus).append('\"');
    sb.append(",\"defendStatus\":\"")
        .append(defendStatus).append('\"');
    sb.append(",\"devID\":\"")
        .append(devID).append('\"');
    sb.append(",\"doorStatus\":\"")
        .append(doorStatus).append('\"');
    sb.append(",\"electricity\":\"")
        .append(electricity).append('\"');
    sb.append(",\"fillGunStatus\":\"")
        .append(fillGunStatus).append('\"');
    sb.append(",\"gpsTime\":\"")
        .append(gpsTime).append('\"');
    sb.append(",\"gsmvalue\":\"")
        .append(gsmvalue).append('\"');
    sb.append(",\"isLoc\":\"")
        .append(isLoc).append('\"');
    sb.append(",\"isTwoMinutesDatas\":\"")
        .append(isTwoMinutesDatas).append('\"');
    sb.append(",\"latitude\":\"")
        .append(latitude).append('\"');
    sb.append(",\"lightStatus\":\"")
        .append(lightStatus).append('\"');
    sb.append(",\"longitude\":\"")
        .append(longitude).append('\"');
    sb.append(",\"mileage\":\"")
        .append(mileage).append('\"');
    sb.append(",\"oilPercent\":\"")
        .append(oilPercent).append('\"');
    sb.append(",\"oilStatus\":\"")
        .append(oilStatus).append('\"');
    sb.append(",\"powerPercent\":\"")
        .append(powerPercent).append('\"');
    sb.append(",\"rfid\":\"")
        .append(rfid).append('\"');
    sb.append(",\"result\":\"")
        .append(result).append('\"');
    sb.append(",\"satellitecount\":\"")
        .append(satellitecount).append('\"');
    sb.append(",\"sign\":\"")
        .append(sign).append('\"');
    sb.append(",\"sirection\":\"")
        .append(sirection).append('\"');
    sb.append(",\"speed\":\"")
        .append(speed).append('\"');
    sb.append(",\"stars\":\"")
        .append(stars).append('\"');
    sb.append(",\"status\":\"")
        .append(status).append('\"');
    sb.append(",\"totalDistance\":\"")
        .append(totalDistance).append('\"');
    sb.append(",\"voltage\":\"")
        .append(voltage).append('\"');
    sb.append(",\"windowStatus\":\"")
        .append(windowStatus).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
