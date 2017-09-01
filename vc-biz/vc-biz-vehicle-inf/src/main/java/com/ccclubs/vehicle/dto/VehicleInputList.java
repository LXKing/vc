package com.ccclubs.vehicle.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * list 一组车辆
 *
 * @author jianghaiyang
 * @create 2017-07-12
 **/
public class VehicleInputList implements Serializable {

    @Valid
    @NotEmpty(message = "输入信息不能为空")
    private List<VehicleRegisterInput> inputs;

    public List<VehicleRegisterInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<VehicleRegisterInput> inputs) {
        this.inputs = inputs;
    }
}
