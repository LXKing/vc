package com.ccclubs.phoenix.orm.model;


import java.io.Serializable;

/**
 *
 * @author taosm
 * @date 2017/9/5 0005
 */
public class CarCan implements Serializable{

    private static final long serialVersionUID = -7959982051545616367L;
    //车机号
    private String cs_number;

    //车辆can数据
    private String can_data;

    //添加时间
    private Long add_time;
    //下位机时间
    private Long current_time;

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

    public Long getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(Long current_time) {
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
