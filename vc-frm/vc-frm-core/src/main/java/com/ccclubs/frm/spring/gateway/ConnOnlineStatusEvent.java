package com.ccclubs.frm.spring.gateway;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 22:57
 * Email:  yeanzhi@ccclubs.com
 * 车辆上线下线状态通知
 */
public class ConnOnlineStatusEvent implements Serializable {

    /**
     * 车辆vin码
     */
    private String vin;

    /**
     * SIM 卡号
     */
    private String simNo;

    /**
     * 车机号
     */
    private String teNumber;

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
     * 车辆下线类型
     * 1: 服务端主动断开（网关检测到错误）
     * 2: 超时断开（终端在某时间段内没有和网关交互）
     * 3: 客户端主动断开（网关检测到客户端主动断开事件）
     */
    private Integer offlineType;

    /**
     * 发送该通知的时间戳
     */
    private Long timestamp;

    /**
     * 网关类型：808,GB,MQTT
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

    public Integer getOfflineType() {
        return offlineType;
    }

    public void setOfflineType(Integer offlineType) {
        this.offlineType = offlineType;
    }

    public String getSimNo() {
        return simNo;
    }

    public ConnOnlineStatusEvent setSimNo(String simNo) {
        this.simNo = simNo;
        return this;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public ConnOnlineStatusEvent setTeNumber(String teNumber) {
        this.teNumber = teNumber;
        return this;
    }
}
