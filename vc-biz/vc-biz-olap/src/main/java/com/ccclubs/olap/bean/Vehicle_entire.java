package com.ccclubs.olap.bean;

import java.io.Serializable;

public class Vehicle_entire implements Serializable {
    //车辆vin码
    private String cs_vin;
    //车机号
    private String cs_number;
    //车辆状态
    private Integer cs_car_status;
    //充电状态
    private Integer batt_status=-1;
    //can电池状态
    private int can_batt_status=-1;
    //省电状态
    private Integer saving_status;
    //速度
    private float speed;
    //总里程
    private float total_miles;
    //电量
    private Integer soc;
    //档位
    private String gear;
    //总电压
    private float total_volt;
    //总电流
    private float total_elect;
    //添加时间
    private String addTime;

    //终结标识(0:未终结  1:终结)
    private int terminate_flg = 0;

    public int getTerminate_flg() {
        return terminate_flg;
    }

    public void setTerminate_flg(int terminate_flg) {
        this.terminate_flg = terminate_flg;
    }

    public String getCs_vin() {
        return cs_vin;
    }

    public void setCs_vin(String cs_vin) {
        this.cs_vin = cs_vin;
    }

    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
    }

    public Integer getCs_car_status() {
        return cs_car_status;
    }

    public void setCs_car_status(Integer cs_car_status) {
        this.cs_car_status = cs_car_status;
    }

    public Integer getBatt_status() {
        return batt_status;
    }

    public void setBatt_status(Integer batt_status) {
        this.batt_status = batt_status;
    }

    public Integer getSaving_status() {
        return saving_status;
    }

    public void setSaving_status(Integer saving_status) {
        this.saving_status = saving_status;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getTotal_miles() {
        return total_miles;
    }

    public void setTotal_miles(float total_miles) {
        this.total_miles = total_miles;
    }

    public Integer getSoc() {
        return soc;
    }

    public void setSoc(Integer soc) {
        this.soc = soc;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public float getTotal_volt() {
        return total_volt;
    }

    public void setTotal_volt(float total_volt) {
        this.total_volt = total_volt;
    }

    public float getTotal_elect() {
        return total_elect;
    }

    public void setTotal_elect(float total_elect) {
        this.total_elect = total_elect;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public int getCan_batt_status() {
        return can_batt_status;
    }

    public void setCan_batt_status(int can_batt_status) {
        this.can_batt_status = can_batt_status;
    }
}
