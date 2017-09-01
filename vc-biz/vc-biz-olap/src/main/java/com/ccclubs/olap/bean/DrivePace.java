package com.ccclubs.olap.bean;

public class DrivePace {
    private String cs_number;

    private String pace_start_time;

    private String pace_end_time;

    private double pace_miles;

    private long pace_timemills;

    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
    }

    public String getPace_start_time() {
        return pace_start_time;
    }

    public void setPace_start_time(String pace_start_time) {
        this.pace_start_time = pace_start_time;
    }

    public String getPace_end_time() {
        return pace_end_time;
    }

    public void setPace_end_time(String pace_end_time) {
        this.pace_end_time = pace_end_time;
    }

    public double getPace_miles() {
        return pace_miles;
    }

    public void setPace_miles(double pace_miles) {
        this.pace_miles = pace_miles;
    }

    public long getPace_timemills() {
        return pace_timemills;
    }

    public void setPace_timemills(long pace_timemills) {
        this.pace_timemills = pace_timemills;
    }
}
