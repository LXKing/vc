package com.ccclubs.olap.bean;

public class Vehicle_zhifa {
    //车机号
    private String cs_number;
    //车牌号
    private String cs_car_no;
    //车速
    private float speed;
    //电量
    private int soc;
    //经度
    private double longitude;
    //纬度
    private double latitude;
    //发生时间
    private String add_time;

    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        this.soc = soc;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getCs_car_no() {
        return cs_car_no;
    }

    public void setCs_car_no(String cs_car_no) {
        this.cs_car_no = cs_car_no;
    }
}
