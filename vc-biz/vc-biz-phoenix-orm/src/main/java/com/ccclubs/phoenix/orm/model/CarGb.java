package com.ccclubs.phoenix.orm.model;

public class CarGb {

    //车辆vin码
    private String cs_vin;

    //添加时间
    private Long add_time;

    //报文上传时间
    private Long current_time;

    //报文内容
    private String gb_data;

    //授权系统
    private Integer cs_access;

    //协议类型
    private Integer cs_protocol;

    //报文类型
    private Integer gb_type;

    //校验结果
    private Integer cs_verify;

    public String getCs_vin() {
        return cs_vin;
    }

    public void setCs_vin(String cs_vin) {
        this.cs_vin = cs_vin;
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

    public String getGb_data() {
        return gb_data;
    }

    public void setGb_data(String gb_data) {
        this.gb_data = gb_data;
    }

    public Integer getCs_access() {
        return cs_access;
    }

    public void setCs_access(Integer cs_access) {
        this.cs_access = cs_access;
    }

    public Integer getCs_protocol() {
        return cs_protocol;
    }

    public void setCs_protocol(Integer cs_protocol) {
        this.cs_protocol = cs_protocol;
    }

    public Integer getGb_type() {
        return gb_type;
    }

    public void setGb_type(Integer gb_type) {
        this.gb_type = gb_type;
    }

    public Integer getCs_verify() {
        return cs_verify;
    }

    public void setCs_verify(Integer cs_verify) {
        this.cs_verify = cs_verify;
    }

    @Override
    public String toString() {
        return "CarGb{" +
                "cs_vin='" + cs_vin + '\'' +
                ", add_time=" + add_time +
                ", current_time=" + current_time +
                ", gb_data='" + gb_data + '\'' +
                ", cs_access=" + cs_access +
                ", cs_protocol=" + cs_protocol +
                ", gb_type=" + gb_type +
                ", cs_verify=" + cs_verify +
                '}';
    }
}
