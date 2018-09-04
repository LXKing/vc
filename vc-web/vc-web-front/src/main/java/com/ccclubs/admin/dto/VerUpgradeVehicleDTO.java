package com.ccclubs.admin.dto;

/**
 * @Author: yeanzi
 * @Date: 2018/4/20
 * @Time: 15:03
 * Email:  yeanzhi@ccclubs.com
 * 车辆升级版本dto
 */
public class VerUpgradeVehicleDTO {

    /**
     * 车辆ID
     */
    private Integer vehicleId;

    /**
     * 车辆vin码
     */
    private String csVehicelVin;

    /**
     * 车辆车型ID
     */
    private Integer csModelId;

    /**
     * 车辆当前升级版本
     */
    private String verCurr;

    /**
     * 车辆当前升级版本ID
     */
    private Integer verCurrId;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCsVehicelVin() {
        return csVehicelVin;
    }

    public void setCsVehicelVin(String csVehicelVin) {
        this.csVehicelVin = csVehicelVin;
    }

    public Integer getCsModelId() {
        return csModelId;
    }

    public void setCsModelId(Integer csModelId) {
        this.csModelId = csModelId;
    }

    public String getVerCurr() {
        return verCurr;
    }

    public void setVerCurr(String verCurr) {
        this.verCurr = verCurr;
    }

    public Integer getVerCurrId() {
        return verCurrId;
    }

    public void setVerCurrId(Integer verCurrId) {
        this.verCurrId = verCurrId;
    }
}
