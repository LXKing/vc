package com.ccclubs.vehicle.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * list 一组车型
 *
 * @author jianghaiyang
 * @create 2017-07-12
 **/
public class ModelInputList implements Serializable {

    @Valid
    @NotEmpty(message = "输入信息不能为空")
    private List<ModelRegisterInput> inputs;

    public List<ModelRegisterInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<ModelRegisterInput> inputs) {
        this.inputs = inputs;
    }
}
