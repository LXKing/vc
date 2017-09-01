package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;

/**
 * 空调全部控制指令入参
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class AirAllInput extends CommonInput implements java.io.Serializable {

    @NotNull(message = "车辆Vin码必填")
    private String vin;

    @NotNull(message = "内外循环模式必填")
    @InArray(message = "0:内循环,1:外循环")
    private Integer circular;//0:内循环,1:外循环

    @NotNull(message = "PTC启停必填")
    @InArray(message = "0:OFF,1:ON")
    private Integer ptc;//0:OFF,1:ON

    @NotNull(message = "压缩机启停必填")
    @InArray(message = "0:OFF,1:ON")
    private Integer compress;//0:OFF,1:ON

    @NotNull(message = "风量必填")
    @InArray(range = {0, 1, 2, 3, 4}, message = "0:OFF,1:1档,2:2档,3:3档,4:4档")
    private Integer fan;//0:OFF,1:1档,2:2档,3:3档,4:4档

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getCircular() {
        return circular;
    }

    public void setCircular(Integer circular) {
        this.circular = circular;
    }

    public Integer getPtc() {
        return ptc;
    }

    public void setPtc(Integer ptc) {
        this.ptc = ptc;
    }

    public Integer getCompress() {
        return compress;
    }

    public void setCompress(Integer compress) {
        this.compress = compress;
    }

    public Integer getFan() {
        return fan;
    }

    public void setFan(Integer fan) {
        this.fan = fan;
    }

}
