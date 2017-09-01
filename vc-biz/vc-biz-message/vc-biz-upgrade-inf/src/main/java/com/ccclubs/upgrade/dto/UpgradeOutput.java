package com.ccclubs.upgrade.dto;

import java.io.Serializable;

/**
 * 升级服务返回参数
 *
 * @author jianghaiyang
 * @create 2017-08-14
 **/
public class UpgradeOutput implements Serializable {
    private String vin;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
