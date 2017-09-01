package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;

/**
 * 省电模式切换入参
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class PowerModeInput extends CommonInput implements java.io.Serializable {
    @NotNull(message = "车辆vin码必填")
    private String vin;

    @NotNull(message = "功耗模式必填")
    @InArray(range = {0, 1, 2}, message = "省电模式支持{0:标准模式,1:最佳省电模式,2:极度省电模式}")
    private Byte type;//0:标准模式,1:最佳省电模式,2:极度省电模式

    @NotNull(message = "休眠秒数必填")
    private Short second;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Short getSecond() {
        return second;
    }

    public void setSecond(Short second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "PowerModeInput{" +
                "vin='" + vin + '\'' +
                ", type=" + type +
                ", second=" + second +
                '}';
    }
}
