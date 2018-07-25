package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yeanzi
 * @Date: 2018/7/25
 * @Time: 10:36
 * Email:  yeanzhi@ccclubs.com
 * 二合一版本升级条件
 */
public class VerUpgradeInput implements Serializable {
    /**
     * 身份验证
     */
    private String appId;

    /**
     * 车机VIN码
     */
    @NotNull(message = "车辆vin码必填")
    private String vin;

    /**
     * 目标升级版本ID
     */
    @NotNull(message = "目标升级包ID必填")
    private Integer upgradeVerId;

    public String getVin() {
        return vin;
    }

    public VerUpgradeInput setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public Integer getUpgradeVerId() {
        return upgradeVerId;
    }

    public VerUpgradeInput setUpgradeVerId(Integer upgradeVerId) {
        this.upgradeVerId = upgradeVerId;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public VerUpgradeInput setAppId(String appId) {
        this.appId = appId;
        return this;
    }
}
