package com.ccclubs.phoenix.orm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pace implements Serializable {
    private String cs_vin;
    private String cs_number;
    private Integer row_no;
    //起始时间(日期格式)
    private String pace_start_datetime;
    private long pace_start_timemills;
    //结束时间(日期格式)
    private String pace_end_datetime;
    private long pace_end_timemills;
    //阶段总共时间
    private long pace_timemills;
    //起始里程数
    private double pace_start_obd_miles;
    //结束里程数
    private double pace_end_obd_miles;
    //变化里程数
    private float pace_changed_miles;
    //起始电量
    private float pace_start_ev_battery;
    //结束电量
    private float pace_end_ev_battery;
    //该数据块内记录列表
    private List<CarState> recordList=new ArrayList<>();
    //数据块变化电量
    private float pace_changed_ev_battery;

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

    public Integer getRow_no() {
        return row_no;
    }

    public void setRow_no(Integer row_no) {
        this.row_no = row_no;
    }

    public String getPace_start_datetime() {
        return pace_start_datetime;
    }

    public void setPace_start_datetime(String pace_start_datetime) {
        this.pace_start_datetime = pace_start_datetime;
    }

    public long getPace_start_timemills() {
        return pace_start_timemills;
    }

    public void setPace_start_timemills(long pace_start_timemills) {
        this.pace_start_timemills = pace_start_timemills;
    }

    public String getPace_end_datetime() {
        return pace_end_datetime;
    }

    public void setPace_end_datetime(String pace_end_datetime) {
        this.pace_end_datetime = pace_end_datetime;
    }

    public long getPace_end_timemills() {
        return pace_end_timemills;
    }

    public void setPace_end_timemills(long pace_end_timemills) {
        this.pace_end_timemills = pace_end_timemills;
    }

    public double getPace_start_obd_miles() {
        return pace_start_obd_miles;
    }

    public void setPace_start_obd_miles(double pace_start_obd_miles) {
        this.pace_start_obd_miles = pace_start_obd_miles;
    }

    public double getPace_end_obd_miles() {
        return pace_end_obd_miles;
    }

    public void setPace_end_obd_miles(double pace_end_obd_miles) {
        this.pace_end_obd_miles = pace_end_obd_miles;
    }

    public float getPace_changed_miles() {
        return pace_changed_miles;
    }

    public void setPace_changed_miles(float pace_changed_miles) {
        this.pace_changed_miles = pace_changed_miles;
    }

    public float getPace_start_ev_battery() {
        return pace_start_ev_battery;
    }

    public void setPace_start_ev_battery(float pace_start_ev_battery) {
        this.pace_start_ev_battery = pace_start_ev_battery;
    }

    public float getPace_end_ev_battery() {
        return pace_end_ev_battery;
    }

    public void setPace_end_ev_battery(float pace_end_ev_battery) {
        this.pace_end_ev_battery = pace_end_ev_battery;
    }

    public List<CarState> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<CarState> recordList) {
        this.recordList = recordList;
    }

    public float getPace_changed_ev_battery() {
        return pace_changed_ev_battery;
    }

    public void setPace_changed_ev_battery(float pace_changed_ev_battery) {
        this.pace_changed_ev_battery = pace_changed_ev_battery;
    }

    public long getPace_timemills() {
        return pace_timemills;
    }

    public void setPace_timemills(long pace_timemills) {
        this.pace_timemills = pace_timemills;
    }

}
