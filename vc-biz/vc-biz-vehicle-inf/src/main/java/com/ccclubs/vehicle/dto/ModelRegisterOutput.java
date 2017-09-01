package com.ccclubs.vehicle.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 车型注册返回
 *
 * @author jianghaiyang
 * @create 2017-07-10
 **/
public class ModelRegisterOutput implements Serializable{
    //车型标识
    private String csmFlag;

    public String getCsmFlag() {
        return csmFlag;
    }

    public void setCsmFlag(String csmFlag) {
        this.csmFlag = csmFlag;
    }

    @Override
    public String toString() {
        return "ModelRegisterOutput{" +
                "csmFlag='" + csmFlag + '\'' +
                '}';
    }
}
