package com.ccclubs.upgrade.dto;

/**
 * @Author: yeanzi
 * @Date: 2018/5/29
 * @Time: 11:49
 * Email:  yeanzhi@ccclubs.com
 * 终端版本信息
 */
public class TerminalVersionDTO {
    /**
     * 车辆vin码
     */
    private String vin;

    /**
     * 插件版本
     */
    private Integer pluginVer;

    /**
     * 主版本
      */
    private Integer majorVer;

    public String getVin() {
        return vin;
    }

    public TerminalVersionDTO setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public Integer getPluginVer() {
        return pluginVer;
    }

    public TerminalVersionDTO setPluginVer(Integer pluginVer) {
        this.pluginVer = pluginVer;
        return this;
    }

    public Integer getMajorVer() {
        return majorVer;
    }

    public TerminalVersionDTO setMajorVer(Integer majorVer) {
        this.majorVer = majorVer;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TerminalVersionDTO{");
        sb.append("vin='").append(vin).append('\'');
        sb.append(", pluginVer=").append(pluginVer);
        sb.append(", majorVer=").append(majorVer);
        sb.append('}');
        return sb.toString();
    }
}
