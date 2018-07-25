package com.ccclubs.command.dto;

/**
 * @Author: yeanzi
 * @Date: 2018/7/25
 * @Time: 10:36
 * Email:  yeanzhi@ccclubs.com
 * 二合一版本升级条件
 */
public class MixedUpgradeInput {
    /**
     * 权限
     */
    private String appId;

    /**
     * 车机VIN码
     */
    private String vin;
    /**
     * 终端类型
     */
    private Byte terType;
    /**
     * 终端型号
     */
    private String terModel;

    /**
     * 二合一版本升级包id
     */
    private Integer mixedUpVersionId;

    public String getVin() {
        return vin;
    }

    public MixedUpgradeInput setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public Byte getTerType() {
        return terType;
    }

    public MixedUpgradeInput setTerType(Byte terType) {
        this.terType = terType;
        return this;
    }

    public String getTerModel() {
        return terModel;
    }

    public MixedUpgradeInput setTerModel(String terModel) {
        this.terModel = terModel;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public MixedUpgradeInput setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public Integer getMixedUpVersionId() {
        return mixedUpVersionId;
    }

    public void setMixedUpVersionId(Integer mixedUpVersionId) {
        this.mixedUpVersionId = mixedUpVersionId;
    }
}
