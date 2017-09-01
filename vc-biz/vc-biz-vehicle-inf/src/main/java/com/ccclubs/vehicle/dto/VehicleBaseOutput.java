package com.ccclubs.vehicle.dto;

/**
 * 车辆基本信息
 *
 * @author jianghaiyang
 * @create 2017-06-28
 **/
public class VehicleBaseOutput implements java.io.Serializable {
    //出厂日期
    private String prodDate;
    //爱车颜色
    private String color;

    public String getProdDate() {
        return prodDate;
    }

    public void setProdDate(String prodDate) {
        this.prodDate = prodDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "VehicleBaseOutput{" +
                "prodDate='" + prodDate + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
