package com.ccclubs.olap.bean;

public class WeekBean {
    //年
    private int year;
    //月
    private int month;
    //起始时间(周一)
    private String monday_datetime;
    //结束时间(周日)
    private String sunday_datetime;

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

    public String getMonday_datetime() {
        return monday_datetime;
    }

    public void setMonday_datetime(String monday_datetime) {
        this.monday_datetime = monday_datetime;
    }

    public String getSunday_datetime() {
        return sunday_datetime;
    }

    public void setSunday_datetime(String sunday_datetime) {
        this.sunday_datetime = sunday_datetime;
    }
}
