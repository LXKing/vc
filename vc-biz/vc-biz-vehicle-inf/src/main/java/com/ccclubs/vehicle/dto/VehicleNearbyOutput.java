package com.ccclubs.vehicle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 附近的车辆
 *
 * @author jianghaiyang
 * @create 2018-09-27
 **/
public class VehicleNearbyOutput implements Serializable {

    private String vin;
    private BigDecimal longitude;//经度【小数6位】
    private BigDecimal latitude;//纬度【小数6位】
    private BigDecimal direction;//方向角度

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getDirection() {
        return direction;
    }

    public void setDirection(BigDecimal direction) {
        this.direction = direction;
    }
}
