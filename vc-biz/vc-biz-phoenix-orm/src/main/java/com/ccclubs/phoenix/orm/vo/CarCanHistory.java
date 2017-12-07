package com.ccclubs.phoenix.orm.vo;



/**
 * Created by taosm on 2017/9/12 0012.
 */
//FIXME 这个类应该被撤下来，应该换上旁边model包的CarCan
public class CarCanHistory {
    //起始时间
    private String begin_time;
    //结束时间
    private String end_time;
    //车架号
    private String cs_vin;
    //车机号
    private String cs_number;
    //车辆can数据（原始报文）
    private String can_data;
    //添加时间(显示)
    private Long add_time;
    //下位机时间(显示)
    private Long current_time;

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
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
}
