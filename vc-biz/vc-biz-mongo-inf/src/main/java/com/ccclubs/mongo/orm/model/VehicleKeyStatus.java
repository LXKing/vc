package com.ccclubs.mongo.orm.model;

import java.io.Serializable;
import org.joda.time.DateTime;

/**
 * @author qsxiaogang
 * @create 2017-09-20
 **/
public class VehicleKeyStatus implements Serializable {

  // 钥匙状态
  private Integer vehicleKeyStatus;
  //平台收到的开始时间
  private DateTime platformStartTime;
  //开始时间
  private DateTime startTime;
  //平台收到的结束时间
  private DateTime platformEndTime;
  //结束时间
  private DateTime endTime;
  //持续时长
  private Integer durTime;

  public Integer getVehicleKeyStatus() {
    return vehicleKeyStatus;
  }

  public void setVehicleKeyStatus(Integer vehicleKeyStatus) {
    this.vehicleKeyStatus = vehicleKeyStatus;
  }

  public DateTime getPlatformStartTime() {
    return platformStartTime;
  }

  public void setPlatformStartTime(DateTime platformStartTime) {
    this.platformStartTime = platformStartTime;
  }

  public DateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(DateTime startTime) {
    this.startTime = startTime;
  }

  public DateTime getPlatformEndTime() {
    return platformEndTime;
  }

  public void setPlatformEndTime(DateTime platformEndTime) {
    this.platformEndTime = platformEndTime;
  }

  public DateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(DateTime endTime) {
    this.endTime = endTime;
  }

  public Integer getDurTime() {
    return durTime;
  }

  public void setDurTime(Integer durTime) {
    this.durTime = durTime;
  }
}
