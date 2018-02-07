package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 车门落锁-带控制参数
 *
 * @author jianghaiyang
 * @create 2018-01-26
 **/
public class LockDoorInput extends CommonInput implements Serializable{
    /**
     * 车辆Vin码
     */
    @NotNull(message = "车辆Vin码必填")
    private String vin;
    /**
     * 控制参数
     */
    @NotNull(message = "控制参数必填")
    private String code;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
