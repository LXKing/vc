package com.ccclubs.quota.service;

import java.util.ArrayList;
import java.util.List;

public class PaceBlock {
    private String cs_number;
    //起始时间
    private String block_start_time;

    private long block_start_timemills;

    //结束时间
    private String block_end_time;

    private long block_end_timemills;
    //起始经度
    private double block_start_longitude;
    //起始纬度
    private double block_start_latitude;
    //结束经度
    private double block_end_longitude;
    //结束纬度
    private double block_end_latitude;
    //起始电量
    private int block_start_soc;
    //结束电量
    private int block_end_soc;
    //平均速度
    private float block_avg_speed;
    //该数据块内记录列表
    private List<Vehicle_zhifa> recordList=new ArrayList<>();
    //数据块状态(1:充电  2:驾驶  3:其它)
    private int block_status;
    //数据块变化距离(米)
    private double block_distance;
    //数据块变化电量
    private int block_changed_soc;

    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
    }

    public int getBlock_status() {
        return block_status;
    }

    public void setBlock_status(int block_status) {
        this.block_status = block_status;
    }

    public double getBlock_distance() {
        return block_distance;
    }

    public void setBlock_distance(double block_distance) {
        this.block_distance = block_distance;
    }

    public String getBlock_start_time() {
        return block_start_time;
    }

    public void setBlock_start_time(String block_start_time) {
        this.block_start_time = block_start_time;
    }

    public String getBlock_end_time() {
        return block_end_time;
    }

    public void setBlock_end_time(String block_end_time) {
        this.block_end_time = block_end_time;
    }

    public double getBlock_start_longitude() {
        return block_start_longitude;
    }

    public void setBlock_start_longitude(double block_start_longitude) {
        this.block_start_longitude = block_start_longitude;
    }

    public double getBlock_start_latitude() {
        return block_start_latitude;
    }

    public void setBlock_start_latitude(double block_start_latitude) {
        this.block_start_latitude = block_start_latitude;
    }

    public double getBlock_end_longitude() {
        return block_end_longitude;
    }

    public void setBlock_end_longitude(double block_end_longitude) {
        this.block_end_longitude = block_end_longitude;
    }

    public double getBlock_end_latitude() {
        return block_end_latitude;
    }

    public void setBlock_end_latitude(double block_end_latitude) {
        this.block_end_latitude = block_end_latitude;
    }

    public int getBlock_start_soc() {
        return block_start_soc;
    }

    public void setBlock_start_soc(int block_start_soc) {
        this.block_start_soc = block_start_soc;
    }

    public int getBlock_end_soc() {
        return block_end_soc;
    }

    public void setBlock_end_soc(int block_end_soc) {
        this.block_end_soc = block_end_soc;
    }

    public float getBlock_avg_speed() {
        return block_avg_speed;
    }

    public void setBlock_avg_speed(float block_avg_speed) {
        this.block_avg_speed = block_avg_speed;
    }

    public long getBlock_start_timemills() {
        return block_start_timemills;
    }

    public void setBlock_start_timemills(long block_start_timemills) {
        this.block_start_timemills = block_start_timemills;
    }

    public long getBlock_end_timemills() {
        return block_end_timemills;
    }

    public void setBlock_end_timemills(long block_end_timemills) {
        this.block_end_timemills = block_end_timemills;
    }

    public List<Vehicle_zhifa> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Vehicle_zhifa> recordList) {
        this.recordList = recordList;
    }

    public int getBlock_changed_soc() {
        return block_changed_soc;
    }

    public void setBlock_changed_soc(int block_changed_soc) {
        this.block_changed_soc = block_changed_soc;
    }
}
