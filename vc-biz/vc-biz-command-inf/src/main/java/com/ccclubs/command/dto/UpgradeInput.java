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
}
