package com.ccclubs.influxdb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/31 0031.
 */

@Measurement(name = "INFLUXDB_CAR_CAN_HISTORY")
public class CarCan implements Serializable {

    private static final long serialVersionUID = -1L;

    @Column(name = "cs_number")
    private String cs_number;

    @Column(name = "can_data")
    private String can_data;

    @Column(name = "add_time")
    private Long add_time;

    @Column(name = "time")
    private String current_time;


    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
    }

    public String getCan_data() {
        return can_data;
    }

    public void setCan_data(String can_data) {
        this.can_data = can_data;
    }

    public Long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Long add_time) {
        this.add_time = add_time;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    @Override
    public String toString() {
        return "CarCan{" +
                "cs_number='" + cs_number + '\'' +
                ", can_data='" + can_data + '\'' +
                ", add_time=" + add_time +
                ", current_time=" + current_time +
                '}';
    }

}
