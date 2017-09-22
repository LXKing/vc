package com.ccclubs.olap.orm.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/22 0022.
 */
public class ZhiFABean implements Serializable{

    /**
     * 车机号
     */
    private String cs_number;

    private String csc_car_no;

    private String csc_model;

    private String csc_code;

    private int usecount;//使用次数

    private int chargecount;//使用次数

    private float changed_miles;

    private String start_time;//开始时间

    private String flag;//1:波谷  2：波峰

    private static final long serialVersionUID =1L;


    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
    }

    public String getCsc_car_no() {
        return csc_car_no;
    }

    public void setCsc_car_no(String csc_car_no) {
        this.csc_car_no = csc_car_no;
    }

    public String getCsc_model() {
        return csc_model;
    }

    public void setCsc_model(String csc_model) {
        this.csc_model = csc_model;
    }

    public String getCsc_code() {
        return csc_code;
    }

    public void setCsc_code(String csc_code) {
        this.csc_code = csc_code;
    }

    public float getChanged_miles() {
        return changed_miles;
    }

    public void setChanged_miles(float changed_miles) {
        this.changed_miles = changed_miles;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public int getUsecount() {
        return usecount;
    }

    public void setUsecount(int usecount) {
        this.usecount = usecount;
    }

    public int getChargecount() {
        return chargecount;
    }

    public void setChargecount(int chargecount) {
        this.chargecount = chargecount;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}