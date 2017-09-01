package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 设置-还车（充电）检查
 * @author jianghaiyang
 * @create 2017-08-01
 **/
public class ReturnCheckInput extends CommonInput implements Serializable{

    @NotNull(message = "车辆vin码必填")
    private String vin;

    @NotNull(message = "充电检查配置项值必填")
    @InArray(message = "数值范围不正确 {0:还车时，终端不校验车辆充电; 1:还车时，终端需要校验车辆充电，不充电不允许还车}")
    private Integer value;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
