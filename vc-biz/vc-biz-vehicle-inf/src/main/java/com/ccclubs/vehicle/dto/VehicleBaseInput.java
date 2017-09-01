package com.ccclubs.vehicle.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 车辆查询参数
 *
 * @author jianghaiyang
 * @create 2017-06-28
 **/
public class VehicleBaseInput implements Serializable {

    @NotNull(message="车辆VIN码必填")
    private String vin;//车辆VIN码

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "VehicleBaseInput{" +
                "vin='" + vin + '\'' +
                '}';
    }
}
