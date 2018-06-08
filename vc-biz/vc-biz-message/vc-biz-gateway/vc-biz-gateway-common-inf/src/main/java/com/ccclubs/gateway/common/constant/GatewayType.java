package com.ccclubs.gateway.common.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/6/7
 * @Time: 14:10
 * Email:  yeanzhi@ccclubs.com
 * 网关类型
 */
public enum GatewayType {
    /**
     * 国标网关
     */
    GATEWAY_GB("GB"),
    /**
     * 808网关
     */
    GATEWAY_808("808"),
    /**
     * MQTT网关
     */
    GATEWAY_MQTT("MQTT");

    private String des;
    GatewayType(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }
}
