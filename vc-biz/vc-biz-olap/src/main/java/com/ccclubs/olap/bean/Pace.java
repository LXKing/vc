package com.ccclubs.olap.bean;

import java.io.Serializable;

public class Pace implements Serializable {
    private String cs_vin;

    private String cs_number;

    private Integer row_no;

    private String status;

    private Integer start_soc;

    private Integer end_soc;

    private Integer changed_soc;

    private float start_miles;

    private float end_miles;

    private float changed_miles;

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

    public long getPace_timemills() {
        return pace_timemills;
    }

    public void setPace_timemills(long pace_timemills) {
        this.pace_timemills = pace_timemills;
    }

    public Integer getChanged_soc() {
        return changed_soc;
    }

    public void setChanged_soc(Integer changed_soc) {
        this.changed_soc = changed_soc;
    }

    public Integer getRow_no() {
        return row_no;
    }

    public void setRow_no(Integer row_no) {
        this.row_no = row_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStart_soc() {
        return start_soc;
    }

    public void setStart_soc(Integer start_soc) {
        this.start_soc = start_soc;
    }

    public Integer getEnd_soc() {
        return end_soc;
    }

    public void setEnd_soc(Integer end_soc) {
        this.end_soc = end_soc;
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
}
