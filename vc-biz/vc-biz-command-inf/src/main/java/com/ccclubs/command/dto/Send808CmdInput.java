package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 808指令
 *
 * @author jianghaiyang
 * @create 2018-01-24
 **/
public class Send808CmdInput extends CommonInput implements Serializable{
    @NotNull(message = "vin码必填")
    private String vin;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
