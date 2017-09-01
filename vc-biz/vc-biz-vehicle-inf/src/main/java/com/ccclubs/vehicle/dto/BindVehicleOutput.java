package com.ccclubs.vehicle.dto;

import java.io.Serializable;

/**
 * 绑定操作返回
 *
 * @author jianghaiyang
 * @create 2017-07-03
 **/
public class BindVehicleOutput implements Serializable {
    //终端序列号
    private String teNo;

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }
}
