package com.ccclubs.phoenix.orm.dto;

import java.io.Serializable;

/**
 * 2018/9/17
 * CarStateDto
 *
 * @author machuanpeng
 */
public class CanStateDto implements Serializable {
    private static final long serialVersionUID = -4920229013098094437L;
    /**
     * 车机号
     */
    private String teNumber;
    private String vin;
    /**
     * 授权系统
     */
    private Integer access;
    /**
     * 添加时间
     */
    private Long addTime;
    /**
     * 下位机时间
     */
    private Long currentTime;
    /**
     * 租赁状态
     */
    private Integer rentFlg;
    /**
     * 报警代码
     */
    private String warnCode;
    /**
     * RFID卡号
     */
    private String rfid;
    /**
     * 用户RFID
     */
    private String userRfid;
    /**
     * OBD里程
     */
    private Float obdMiles;
    /**
     * 发动机温度
     */
    private Float engineTeempe;
    /**
     * 总里程
     */
    private Float totalMiles;
    /**
     * 车速
     */
    private Float speed;
    /**
     * 转速
     */
    private Float motorSpeed;
    /**
     * 燃油量
     */
    private Float oilCost;
    /**
     * 蓄电量
     */
    private Float powerReserve;
    /**
     * 动力电池电量
     */
    private Float evBattery;
    /**
     * 充电状态
     */
    private Integer chargingStatus;
    /**
     * 油里程
     */
    private Float fuelMiles;
    /**
     * 电量程
     */
    private Float elecMiles;
    /**
     * 续航里程
     */
    private Float endurMiles;
    /**
     * 温度
     */
    private Float tempe;
    /**
     * 卫星数量
     */
    private Integer gpsNum;
    /**
     * 卫星信号强度
     */
    private Integer gpsStrength;
    /**
     * gps有效性
     */
    private Integer gpsValid;
    /**
     * 网络信号强度
     */
    private Integer netStrength;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 方向角度
     */
    private Float directionAngle;
    /**
     * 循环模式
     */
    private Integer circularMode;
    /**
     * PTC启停
     */
    private Integer ptcStatus;
    /**
     * 压缩机状态
     */
    private Integer compreStatus;
    /**
     * 档风量
     */
    private Integer fanMode;
    /**
     * 省电模式
     */
    private Integer savingMode;
    /**
     * 省电模式 format
     */
    private String savingModeStr;
    /**
     * 车门状态
     */
    private Integer doorStatus;
    /**
     * 发动机
     */
    private Integer engineStatus;
    /**
     * 钥匙状态
     */
    private Integer keyStatus;
    /**
     * 灯状态
     */
    private Integer lightStatus;
    /**
     * 锁状态
     */
    private Integer lockStatus;
    /**
     * 网络类型
     */
    private String netType;
    /**
     * 基站LAC
     */
    private String baseLac;
    /**
     * 基站CI
     */
    private String baseCi;
    /**
     * 当前订单
     */
    private String curOrder;
    /**
     * 档位
     */
    private Integer gear;
    /**
     * 自动驾驶状态
     */
    private Integer autopilotStatus;
    /**
     * 手刹状态
     */
    private Integer handbrakeStatus;

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
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

    public Float getEngineTeempe() {
        return engineTeempe;
    }

    public void setEngineTeempe(Float engineTeempe) {
        this.engineTeempe = engineTeempe;
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

    public String getSavingModeStr() {
        return savingModeStr;
    }

    public void setSavingModeStr(String savingModeStr) {
        this.savingModeStr = savingModeStr;
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

    public Integer getAutopilotStatus() {
        return autopilotStatus;
    }

    public void setAutopilotStatus(Integer autopilotStatus) {
        this.autopilotStatus = autopilotStatus;
    }

    public Integer getHandbrakeStatus() {
        return handbrakeStatus;
    }

    public void setHandbrakeStatus(Integer handbrakeStatus) {
        this.handbrakeStatus = handbrakeStatus;
    }
}


