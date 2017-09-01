package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DVD版本
 * @author jianghaiyang
 * @create 2017-08-01
 **/
public class DvdVersionIntput extends CommonInput implements Serializable{

    @NotNull(message = "车辆vin码必填")
    private String vin;

    @NotNull(message = "最新版本号必填")
    private Integer latestVersion;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(Integer latestVersion) {
        this.latestVersion = latestVersion;
    }
}
