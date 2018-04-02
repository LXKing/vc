package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;

/**
 * 简单指令入参
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class SimpleCmdInput extends CommonInput implements java.io.Serializable {

    @NotNull(message = "车辆Vin码必填")
    private String vin;

    @NotNull(message = "指令类型必填")
    @InArray(range = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, message = "输入的指令类型不支持")
    private Integer cmd;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getCmd() {
        return cmd;
    }

    public void setCmd(Integer cmd) {
        this.cmd = cmd;
    }

}
