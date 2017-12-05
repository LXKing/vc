package com.ccclubs.phoenix.orm.model;

public class SocPace {
    private String cs_number;

    private int pace_start_soc;

    private int pace_end_soc;

    private int pace_changed_soc;

    private String pace_start_time;

    private String pace_end_time;

    private String pace_soc;

    private long pace_timemills;

    public int getPace_changed_soc() {
        return pace_changed_soc;
    }

    public void setPace_changed_soc(int pace_changed_soc) {
        this.pace_changed_soc = pace_changed_soc;
    }

    public int getPace_start_soc() {
        return pace_start_soc;
    }

    public void setPace_start_soc(int pace_start_soc) {
        this.pace_start_soc = pace_start_soc;
    }

    public int getPace_end_soc() {
        return pace_end_soc;
    }

    public void setPace_end_soc(int pace_end_soc) {
        this.pace_end_soc = pace_end_soc;
    }

    public String getCs_number() {
        return cs_number;
    }

    public long getPace_timemills() {
        return pace_timemills;
    }

    public void setPace_timemills(long pace_timemills) {
        this.pace_timemills = pace_timemills;
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

    public String getPace_soc() {
        return pace_soc;
    }

    public void setPace_soc(String pace_soc) {
        this.pace_soc = pace_soc;
    }
}
