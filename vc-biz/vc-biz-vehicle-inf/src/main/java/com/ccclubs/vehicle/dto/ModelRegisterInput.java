package com.ccclubs.vehicle.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 车型注册入参
 *
 * @author jianghaiyang
 * @create 2017-07-10
 **/
public class ModelRegisterInput  implements Serializable {
    @NotNull(message = "车型销售名称必填")
    private String csmName;

    @NotNull(message = "车型备案型号必填")
    private String csmFlag;

    @NotNull(message = "车辆类型（动力）必填")
    @InArray(range = {0, 1, 2, 3}, message = "动力类型:0:汽油车,1:纯电动汽车,2:插电式混合动力汽车,3:燃料电池汽车")
    private Byte csmType;//动力类型:0:汽油车,1:纯电动汽车,2:插电式混合动力汽车,3:燃料电池汽车;

    @NotNull(message = "变速箱类型必填")
    @InArray(message = "变速箱类型范围:0:自动档,1:手动档")
    private Byte csmFile;//变速箱类型:0:自动档,1:手动档;

    @NotNull(message = "车辆种类必填")
    @InArray(range = {0, 1, 2},message = "车辆种类范围:0:乘用车：小型轿车,1:客车：大客、中客、小客、公交,2:专用车：物流、环卫、其他")
    private Byte csmCatagory;//车辆种类:0:乘用车：小型轿车,1:客车：大客、中客、小客、公交,2:专用车：物流、环卫、其他;

    //@NotNull(message = "油箱容量(L)必填")
    private BigDecimal csmTankCapacity;//油箱容量(L)

    //@NotNull(message = "电池容量(KW.H)必填")
    private BigDecimal csmBatteryCapacity;//电池容量(KW.H)

    public String getCsmName() {
        return csmName;
    }

    public void setCsmName(String csmName) {
        this.csmName = csmName;
    }

    public String getCsmFlag() {
        return csmFlag;
    }

    public void setCsmFlag(String csmFlag) {
        this.csmFlag = csmFlag;
    }

    public Byte getCsmType() {
        return csmType;
    }

    public void setCsmType(Byte csmType) {
        this.csmType = csmType;
    }

    public Byte getCsmFile() {
        return csmFile;
    }

    public void setCsmFile(Byte csmFile) {
        this.csmFile = csmFile;
    }

    public Byte getCsmCatagory() {
        return csmCatagory;
    }

    public void setCsmCatagory(Byte csmCatagory) {
        this.csmCatagory = csmCatagory;
    }

    public BigDecimal getCsmTankCapacity() {
        return csmTankCapacity;
    }

    public void setCsmTankCapacity(BigDecimal csmTankCapacity) {
        this.csmTankCapacity = csmTankCapacity;
    }

    public BigDecimal getCsmBatteryCapacity() {
        return csmBatteryCapacity;
    }

    public void setCsmBatteryCapacity(BigDecimal csmBatteryCapacity) {
        this.csmBatteryCapacity = csmBatteryCapacity;
    }

    public ModelRegisterInput() {
    }

    public ModelRegisterInput(String csmName, String csmFlag, Byte csmType, Byte csmFile, Byte csmCatagory, BigDecimal csmTankCapacity, BigDecimal csmBatteryCapacity) {
        this.csmName = csmName;
        this.csmFlag = csmFlag;
        this.csmType = csmType;
        this.csmFile = csmFile;
        this.csmCatagory = csmCatagory;
        this.csmTankCapacity = csmTankCapacity;
        this.csmBatteryCapacity = csmBatteryCapacity;
    }
}
