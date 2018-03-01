package com.ccclubs.influxdb.input;

import java.io.Serializable;
public class CarCanHistoryParam extends Page  implements Serializable{


    private static final long serialVersionUID = 3738734732712400375L;

    private String cs_number;

    private String start_time;

    private String end_time;

    private String order="desc";


    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
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
}
