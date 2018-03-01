package com.ccclubs.influxdb.input;

import java.io.Serializable;

public class CarGbHistoryParam extends Page implements Serializable{


    private static final long serialVersionUID = -6596177061016048194L;

    private String cs_vin;

    private String start_time;

    private String end_time;

    private String order="desc";

    public String getCs_vin() {
        return cs_vin;
    }

    public void setCs_vin(String cs_vin) {
        this.cs_vin = cs_vin;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "CarGbHistoryParam{" +
                "cs_vin='" + cs_vin + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
