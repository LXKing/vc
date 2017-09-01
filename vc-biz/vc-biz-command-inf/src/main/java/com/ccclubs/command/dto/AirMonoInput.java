package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;

/**
 * 空调单个控制指令入参
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class AirMonoInput extends CommonInput implements java.io.Serializable {

    @NotNull(message = "车辆Vin码必填")
    private String vin;

    @NotNull(message = "控制项必填")
    @InArray(range = {1, 2, 3, 4}, message = "控制项必须为: 1内外循环模式 2PTC启停 3压缩机启停 4风量")
    private Integer item;

    @NotNull(message = "控制项值必填")
    private Integer value;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
