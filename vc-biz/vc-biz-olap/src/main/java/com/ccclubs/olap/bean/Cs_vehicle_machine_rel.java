package com.ccclubs.olap.bean;

import java.io.Serializable;

public class Cs_vehicle_machine_rel implements Serializable {
    //车辆VIN码
    private String cs_vin;
    //车机号
    private String cs_number;
    //车牌号
    private String cs_car_no;
    //终端号
    private String cs_te_no;
    //厂商
    private String cs_vender;
    //车辆类型(1:电动车  2:汽油车)
    private int car_type;

    public String getCs_vender() {
        return cs_vender;
    }

    public void setCs_vender(String cs_vender) {
        this.cs_vender = cs_vender;
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

    public String getCs_car_no() {
        return cs_car_no;
    }

    public void setCs_car_no(String cs_car_no) {
        this.cs_car_no = cs_car_no;
    }

    public String getCs_te_no() {
        return cs_te_no;
    }

    public void setCs_te_no(String cs_te_no) {
        this.cs_te_no = cs_te_no;
    }

    public int getCar_type() {
        return car_type;
    }

    public void setCar_type(int car_type) {
        this.car_type = car_type;
    }
}
