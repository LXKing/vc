package com.ccclubs.pub.orm.vo;

/**
 * 车辆信息view object
 *
 * @author jianghaiyang
 * @create 2017-07-05
 **/
public class VehicleVo {
    //车辆vin码
    private String vin;

    //终端序列号
    private String teNo;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }
}
