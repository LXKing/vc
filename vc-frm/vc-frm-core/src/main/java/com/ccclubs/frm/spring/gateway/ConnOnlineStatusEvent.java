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

    /**
     * 根据网关类型不同，设置不同的唯一字段
     * @param uniqueNo
     * @param gatewayType
     * @return
     */
    public ConnOnlineStatusEvent addUniqueNoByGatewayType(String uniqueNo, String gatewayType) {
        if (GatewayType.GATEWAY_GB.equals(gatewayType)) {
            this.setVin(uniqueNo);
        } else if (GatewayType.GATEWAY_MQTT.equals(gatewayType)) {
            this.setTeNumber(uniqueNo);
        } else if (GatewayType.GATEWAY_808.equals(gatewayType)) {
            this.setSimNo(uniqueNo);
        } else {
            throw new IllegalArgumentException("illegal param gatewayType: " + gatewayType);
        }
        return this;
    }

    /**
     * 根据不同网关类型获取对应的唯一标识
     * @return
     */
    public String uniqueNoByGatewayType() {
        if (GatewayType.GATEWAY_GB.equals(this.gatewayType)) {
            return this.vin;
        } else if (GatewayType.GATEWAY_MQTT.equals(this.gatewayType)) {
            return this.teNumber;
        } else if (GatewayType.GATEWAY_808.equals(this.gatewayType)) {
            return this.simNo;
        } else {
            throw new IllegalArgumentException("illegal param gatewayType: " + gatewayType);
        }
    }

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
