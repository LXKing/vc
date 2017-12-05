package com.ccclubs.phoenix.orm.model;

import java.util.ArrayList;
import java.util.List;

public class PaceBlock {
    private String cs_vin;
    private String cs_number;
    //起始时间(日期格式)
    private String block_start_datetime;
    private long block_start_timemills;
    //结束时间(日期格式)
    private String block_end_datetime;
    private long block_end_timemills;
    //起始里程数
    private Float block_start_obd_miles;
    //结束里程数
    private Float block_end_obd_miles;
    //变化里程数
    private float block_changed_miles;
    //起始电量
    private Float block_start_ev_battery;
    //结束电量
    private Float block_end_ev_battery;
    //平均速度
    private float block_avg_speed;
    //该数据块内记录列表
    private List<CarState> recordList=new ArrayList<>();
    //数据块状态(1:充电  2:驾驶  3:其它)
    private int block_status;
    //数据块变化电量
    private float block_changed_ev_battery;
    //终结标识
    private boolean terminal_flg=false;

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

    public String getBlock_start_datetime() {
        return block_start_datetime;
    }

    public void setBlock_start_datetime(String block_start_datetime) {
        this.block_start_datetime = block_start_datetime;
    }

    public long getBlock_start_timemills() {
        return block_start_timemills;
    }

    public void setBlock_start_timemills(long block_start_timemills) {
        this.block_start_timemills = block_start_timemills;
    }

    public String getBlock_end_datetime() {
        return block_end_datetime;
    }

    public void setBlock_end_datetime(String block_end_datetime) {
        this.block_end_datetime = block_end_datetime;
    }

    public long getBlock_end_timemills() {
        return block_end_timemills;
    }

    public void setBlock_end_timemills(long block_end_timemills) {
        this.block_end_timemills = block_end_timemills;
    }

    public Float getBlock_start_obd_miles() {
        return block_start_obd_miles;
    }

    public void setBlock_start_obd_miles(Float block_start_obd_miles) {
        this.block_start_obd_miles = block_start_obd_miles;
    }

    public Float getBlock_end_obd_miles() {
        return block_end_obd_miles;
    }

    public void setBlock_end_obd_miles(Float block_end_obd_miles) {
        this.block_end_obd_miles = block_end_obd_miles;
    }

    public float getBlock_changed_miles() {
        return block_changed_miles;
    }

    public void setBlock_changed_miles(float block_changed_miles) {
        this.block_changed_miles = block_changed_miles;
    }

    public Float getBlock_start_ev_battery() {
        return block_start_ev_battery;
    }

    public void setBlock_start_ev_battery(Float block_start_ev_battery) {
        this.block_start_ev_battery = block_start_ev_battery;
    }

    public Float getBlock_end_ev_battery() {
        return block_end_ev_battery;
    }

    public void setBlock_end_ev_battery(Float block_end_ev_battery) {
        this.block_end_ev_battery = block_end_ev_battery;
    }

    public float getBlock_avg_speed() {
        return block_avg_speed;
    }

    public void setBlock_avg_speed(float block_avg_speed) {
        this.block_avg_speed = block_avg_speed;
    }

    public List<CarState> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<CarState> recordList) {
        this.recordList = recordList;
    }

    public int getBlock_status() {
        return block_status;
    }

    public void setBlock_status(int block_status) {
        this.block_status = block_status;
    }

    public float getBlock_changed_ev_battery() {
        return block_changed_ev_battery;
    }

    public void setBlock_changed_ev_battery(float block_changed_ev_battery) {
        this.block_changed_ev_battery = block_changed_ev_battery;
    }

    public boolean isTerminal_flg() {
        return terminal_flg;
    }

    public void setTerminal_flg(boolean terminal_flg) {
        this.terminal_flg = terminal_flg;
    }
}
