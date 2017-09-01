package com.ccclubs.vehicle.inf.base.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * 车辆属性对照
 *
 * @author jianghaiyang
 * @create 2017-07-03
 **/
@ConfigurationProperties(prefix = "vehicle")
public class VehicleProp {
    private Map<String, String> colorMap;

    public Map<String, String> getColorMap() {
        return colorMap;
    }

    public void setColorMap(Map<String, String> colorMap) {
        this.colorMap = colorMap;
    }
}
