package com.ccclubs.olap.bean;

import java.io.Serializable;

public class SocMiles implements Serializable {
    private String cs_vin;

    private String cs_number;

    private int row_no;

    private int start_soc;

    private int end_soc;

    private int changed_soc;

    private float changed_miles;

    private float start_miles;

    private float end_miles;

    private String start_time;

    private String end_time;

    private long pace_timemills;

    public float getChanged_miles() {
        return changed_miles;
    }

    public void setChanged_miles(float changed_miles) {
        this.changed_miles = changed_miles;
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

    public int getRow_no() {
        return row_no;
    }

    public void setRow_no(int row_no) {
        this.row_no = row_no;
    }

    public int getStart_soc() {
        return start_soc;
    }

    public void setStart_soc(int start_soc) {
        this.start_soc = start_soc;
    }

    public int getEnd_soc() {
        return end_soc;
    }

    public void setEnd_soc(int end_soc) {
        this.end_soc = end_soc;
    }

    public int getChanged_soc() {
        return changed_soc;
    }

    public void setChanged_soc(int changed_soc) {
        this.changed_soc = changed_soc;
    }

    public float getStart_miles() {
        return start_miles;
    }

    public void setStart_miles(float start_miles) {
        this.start_miles = start_miles;
    }

    public float getEnd_miles() {
        return end_miles;
    }

    public void setEnd_miles(float end_miles) {
        this.end_miles = end_miles;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public long getPace_timemills() {
        return pace_timemills;
    }

    public void setPace_timemills(long pace_timemills) {
        this.pace_timemills = pace_timemills;
    }
}
