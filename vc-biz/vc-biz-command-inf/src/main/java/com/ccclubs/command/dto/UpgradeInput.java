package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;

/**
 * 升级请求参数
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class UpgradeInput extends CommonInput implements java.io.Serializable{

    @NotNull(message = "车辆vin码必填")
    private String vin;

    /**
     * 目标升级版本ID
     */
    @NotNull(message = "目标升级包ID必填")
    private Integer upgradeVerId;

    /**
     * 文件名称
     */
    private String filename;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getUpgradeVerId() {
        return upgradeVerId;
    }

    public void setUpgradeVerId(Integer upgradeVerId) {
        this.upgradeVerId = upgradeVerId;
    }
}
