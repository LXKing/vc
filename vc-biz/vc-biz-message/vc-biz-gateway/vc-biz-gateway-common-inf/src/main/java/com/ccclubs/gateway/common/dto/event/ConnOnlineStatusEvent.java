package com.ccclubs.gateway.common.dto.event;

import com.alibaba.fastjson.JSON;
import com.ccclubs.gateway.common.constant.GatewayType;

import java.io.Serializable;

/**
 * @Author: yeanzi
 * @Date: 2018/6/7
 * @Time: 14:13
 * Email:  yeanzhi@ccclubs.com
 * 终端上线下状态通知
 */
public class ConnOnlineStatusEvent implements Serializable {

    /**
     * 车辆vin码
     */
    private String uniqueNo;

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
    private GatewayType gatewayType;

    public String toJson() {
        return JSON.toJSONString(this);
    }

    // ---------------------------------------------------------------------------

    public String getUniqueNo() {
        return uniqueNo;
    }

    public ConnOnlineStatusEvent setUniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo;
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

    public GatewayType getGatewayType() {
        return gatewayType;
    }

    public ConnOnlineStatusEvent setGatewayType(GatewayType gatewayType) {
        this.gatewayType = gatewayType;
        return this;
    }
}