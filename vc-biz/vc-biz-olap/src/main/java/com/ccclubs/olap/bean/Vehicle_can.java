package com.ccclubs.olap.bean;

import java.io.Serializable;

public class Vehicle_can implements Serializable {
    //车辆VIN码
    private String cs_vin;
    //车机号
    private String cs_number;
    //车辆状态
    private int cs_car_status;
    //can电池状态
    private int can_batt_status;
    //总电流
    private float total_elect;
    //总电压
    private float total_volt;
    //档位
    private String gear;
    //添加时间
    private String add_time;
    //添加年
    private int year;
    //添加月
    private int month;

    public int getCan_batt_status() {
        return can_batt_status;
    }

    public void setCan_batt_status(int can_batt_status) {
        this.can_batt_status = can_batt_status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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

    public int getCs_car_status() {
        return cs_car_status;
    }

    public void setCs_car_status(int cs_car_status) {
        this.cs_car_status = cs_car_status;
    }

    public float getTotal_elect() {
        return total_elect;
    }

    public void setTotal_elect(float total_elect) {
        this.total_elect = total_elect;
    }

    public float getTotal_volt() {
        return total_volt;
    }

    public void setTotal_volt(float total_volt) {
        this.total_volt = total_volt;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}
