package com.ccclubs.vehicle.dto;

import java.io.Serializable;

/**
 * 车辆注册返回
 *
 * @author jianghaiyang
 * @create 2017-07-10
 **/
public class VehicleRegisterOutput  implements Serializable {

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
