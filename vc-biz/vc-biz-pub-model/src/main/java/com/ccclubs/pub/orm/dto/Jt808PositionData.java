package com.ccclubs.pub.orm.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 808位置数据
 *
 * @author jianghaiyang
 * @create 2018-05-09
 **/
public class Jt808PositionData implements Serializable {
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
    BigDecimal altitude;
    // 方向
    BigDecimal course;
    // 速度
    BigDecimal speed;
    // 纬度
    BigDecimal latitude;
    // 经度
    BigDecimal longitude;
    // 下位机时间
    Long currentTime;
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

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public BigDecimal getCourse() {
        return course;
    }

    public void setCourse(BigDecimal course) {
        this.course = course;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
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
