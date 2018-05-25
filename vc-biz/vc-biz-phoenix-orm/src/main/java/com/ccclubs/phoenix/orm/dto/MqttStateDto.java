package com.ccclubs.phoenix.orm.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/14
 * @Time: 10:21
 * @Description: 分时租赁协议状态数据！
 */

public class MqttStateDto implements Serializable {

    private static final long serialVersionUID = 739230200604069204L;

    private String vin;

    private Long currentTime;

    private String teNumber;

    private String teNo;

    private String iccid;

    private String mobile;

    private Integer access;

    private Long addTime;

    private Integer rentFlg;

    private String warnCode;

    private String rfid;

    private String userRfid;

    private Float obdMiles;

    private Float engineTempe;

    private Float totalMiles;

    private Float speed;

    private Float motorSpeed;

    private Float oilCost;

    private Float powerReserve;

    private Float evBattery;

    private Integer chargingStatus;

    private Float fuelMiles;

    private Float elecMiles;

    private Float endurMiles;

    private Float tempe;

    private Integer gpsNum;

    private Integer gpsStrength;

    private Integer gpsValid;

    private Integer netStrength;

    private Double longitude;

    private Double latitude;

    private Float directionAngle;

    private Integer circularMode;

    private Integer ptcStatus;

    private Integer compreStatus;

    private Integer fanMode;

    private Integer savingMode;

    private Integer doorStatus;

    private Integer engineStatus;

    private Integer keyStatus;

    private Integer lightStatus;

    private Integer lockStatus;

    private String netType;

    private String baseLac;

    private String baseCi;

    private String curOrder;

    private Integer gear;

    private Long autopilotStatus;

    private Integer handbrakeStatus;

    private String sourceHex;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
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

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Integer getRentFlg() {
        return rentFlg;
    }

    public void setRentFlg(Integer rentFlg) {
        this.rentFlg = rentFlg;
    }

    public String getWarnCode() {
        return warnCode;
    }

    public void setWarnCode(String warnCode) {
        this.warnCode = warnCode;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getUserRfid() {
        return userRfid;
    }

    public void setUserRfid(String userRfid) {
        this.userRfid = userRfid;
    }

    public Float getObdMiles() {
        return obdMiles;
    }

    public void setObdMiles(Float obdMiles) {
        this.obdMiles = obdMiles;
    }

    public Float getEngineTempe() {
        return engineTempe;
    }

    public void setEngineTempe(Float engineTempe) {
        this.engineTempe = engineTempe;
    }

    public Float getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(Float totalMiles) {
        this.totalMiles = totalMiles;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getMotorSpeed() {
        return motorSpeed;
    }

    public void setMotorSpeed(Float motorSpeed) {
        this.motorSpeed = motorSpeed;
    }

    public Float getOilCost() {
        return oilCost;
    }

    public void setOilCost(Float oilCost) {
        this.oilCost = oilCost;
    }

    public Float getPowerReserve() {
        return powerReserve;
    }

    public void setPowerReserve(Float powerReserve) {
        this.powerReserve = powerReserve;
    }

    public Float getEvBattery() {
        return evBattery;
    }

    public void setEvBattery(Float evBattery) {
        this.evBattery = evBattery;
    }

    public Integer getChargingStatus() {
        return chargingStatus;
    }

    public void setChargingStatus(Integer chargingStatus) {
        this.chargingStatus = chargingStatus;
    }

    public Float getFuelMiles() {
        return fuelMiles;
    }

    public void setFuelMiles(Float fuelMiles) {
        this.fuelMiles = fuelMiles;
    }

    public Float getElecMiles() {
        return elecMiles;
    }

    public void setElecMiles(Float elecMiles) {
        this.elecMiles = elecMiles;
    }

    public Float getEndurMiles() {
        return endurMiles;
    }

    public void setEndurMiles(Float endurMiles) {
        this.endurMiles = endurMiles;
    }

    public Float getTempe() {
        return tempe;
    }

    public void setTempe(Float tempe) {
        this.tempe = tempe;
    }

    public Integer getGpsNum() {
        return gpsNum;
    }

    public void setGpsNum(Integer gpsNum) {
        this.gpsNum = gpsNum;
    }

    public Integer getGpsStrength() {
        return gpsStrength;
    }

    public void setGpsStrength(Integer gpsStrength) {
        this.gpsStrength = gpsStrength;
    }

    public Integer getGpsValid() {
        return gpsValid;
    }

    public void setGpsValid(Integer gpsValid) {
        this.gpsValid = gpsValid;
    }

    public Integer getNetStrength() {
        return netStrength;
    }

    public void setNetStrength(Integer netStrength) {
        this.netStrength = netStrength;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Float getDirectionAngle() {
        return directionAngle;
    }

    public void setDirectionAngle(Float directionAngle) {
        this.directionAngle = directionAngle;
    }

    public Integer getCircularMode() {
        return circularMode;
    }

    public void setCircularMode(Integer circularMode) {
        this.circularMode = circularMode;
    }

    public Integer getPtcStatus() {
        return ptcStatus;
    }

    public void setPtcStatus(Integer ptcStatus) {
        this.ptcStatus = ptcStatus;
    }

    public Integer getCompreStatus() {
        return compreStatus;
    }

    public void setCompreStatus(Integer compreStatus) {
        this.compreStatus = compreStatus;
    }

    public Integer getFanMode() {
        return fanMode;
    }

    public void setFanMode(Integer fanMode) {
        this.fanMode = fanMode;
    }

    public Integer getSavingMode() {
        return savingMode;
    }

    public void setSavingMode(Integer savingMode) {
        this.savingMode = savingMode;
    }

    public Integer getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(Integer doorStatus) {
        this.doorStatus = doorStatus;
    }

    public Integer getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(Integer engineStatus) {
        this.engineStatus = engineStatus;
    }

    public Integer getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(Integer keyStatus) {
        this.keyStatus = keyStatus;
    }

    public Integer getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(Integer lightStatus) {
        this.lightStatus = lightStatus;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getBaseLac() {
        return baseLac;
    }

    public void setBaseLac(String baseLac) {
        this.baseLac = baseLac;
    }

    public String getBaseCi() {
        return baseCi;
    }

    public void setBaseCi(String baseCi) {
        this.baseCi = baseCi;
    }

    public String getCurOrder() {
        return curOrder;
    }

    public void setCurOrder(String curOrder) {
        this.curOrder = curOrder;
    }

    public Integer getGear() {
        return gear;
    }

    public void setGear(Integer gear) {
        this.gear = gear;
    }

    public Long getAutopilotStatus() {
        return autopilotStatus;
    }

    public void setAutopilotStatus(Long autopilotStatus) {
        this.autopilotStatus = autopilotStatus;
    }

    public Integer getHandbrakeStatus() {
        return handbrakeStatus;
    }

    public void setHandbrakeStatus(Integer handbrakeStatus) {
        this.handbrakeStatus = handbrakeStatus;
    }

    public String getSourceHex() {
        return sourceHex;
    }

    public void setSourceHex(String sourceHex) {
        this.sourceHex = sourceHex;
    }


}
