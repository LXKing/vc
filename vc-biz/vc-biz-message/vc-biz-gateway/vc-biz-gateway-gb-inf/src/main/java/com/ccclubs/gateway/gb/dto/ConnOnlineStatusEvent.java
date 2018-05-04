package com.ccclubs.gateway.gb.dto;

import com.alibaba.fastjson.JSON;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 22:57
 * Email:  yeanzhi@ccclubs.com
 * 车辆上线下线状态通知
 */
public class ConnOnlineStatusEvent {

    /**
     * 车辆vin码
     */
    private String vin;

    /**
     * 服务端IP
     */
    private String serverIp;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 车辆在线状态通知
     * true:    在线
     * false:   下线
     */
    private boolean online;

    /**
     * 发送该通知的时间戳
     */
    private Long timestamp;

    /**
     * 网关类型：固定为国标
     */
    private String gatewayType = "GB";

    public String toJson() {
        return JSON.toJSONString(this);
    }

    public String getVin() {
        return vin;
    }

    public ConnOnlineStatusEvent setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getServerIp() {
        return serverIp;
    }

    public ConnOnlineStatusEvent setServerIp(String serverIp) {
        this.serverIp = serverIp;
        return this;
    }

    public String getClientIp() {
        return clientIp;
    }

    public ConnOnlineStatusEvent setClientIp(String clientIp) {
        this.clientIp = clientIp;
        return this;
    }

    public boolean isOnline() {
        return online;
    }

    public ConnOnlineStatusEvent setOnline(boolean online) {
        this.online = online;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public ConnOnlineStatusEvent setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public ConnOnlineStatusEvent setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
        return this;
    }
}
