package com.ccclubs.phoenix.orm.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/14
 * @Time: 10:20
 * @Description: Jt808协议状态数据！
 */

public class Jt808Dto implements Serializable {

    private static final long serialVersionUID = -4733980799108297967L;
    // 车架号
    String vin;
    // 车机号
    String teNumber;
    // 终端序列号
    String teNo;
    // ICCID
    String iccid;
    // 手机号
    String mobile;
    // 海拔高度
    Double altitude;
    // 方向
    Float course;
    // 速度
    Float gpsSpeed;
    // 纬度
    Double latitude;
    // 经度
    Double longitude;
    // 下位机时间
    Long currentTime;
    // 平台处理时间
    Long addTime;
    // 报警标志
    Integer alarmFlag;
    // 状态
    Integer status;
    // 网络信号强度
    Short netStrength;
    // GPS有效位
    Integer gpsValid;
    // 原始报文
    String sourceHex;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Float getCourse() {
        return course;
    }

    public void setCourse(Float course) {
        this.course = course;
    }

    public Float getGpsSpeed() {
        return gpsSpeed;
    }

    public void setGpsSpeed(Float gpsSpeed) {
        this.gpsSpeed = gpsSpeed;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Integer getAlarmFlag() {
        return alarmFlag;
    }

    public void setAlarmFlag(Integer alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Short getNetStrength() {
        return netStrength;
    }

    public void setNetStrength(Short netStrength) {
        this.netStrength = netStrength;
    }

    public Integer getGpsValid() {
        return gpsValid;
    }

    public void setGpsValid(Integer gpsValid) {
        this.gpsValid = gpsValid;
    }

    public String getSourceHex() {
        return sourceHex;
    }

    public void setSourceHex(String sourceHex) {
        this.sourceHex = sourceHex;
    }
}
