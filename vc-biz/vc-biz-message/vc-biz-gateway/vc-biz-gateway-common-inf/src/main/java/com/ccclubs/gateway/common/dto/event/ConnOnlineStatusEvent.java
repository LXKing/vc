package com.ccclubs.gateway.common.dto.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
    private String vin;

    /**
     * 车机号
     */
    private String teNumber;

    /**
     * 车辆sim卡号
     */
    private String simNo;

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
     * 下线原因
     *
     */
    private Integer offlineType;

    /**
     * 发送该通知的时间戳
     */
    private Long timestamp;

    /**
     * 网关类型：固定为国标
     */
    private GatewayType gatewayType;

    public String toJson() {
        JSONObject json = (JSONObject) JSON.toJSON(this);
        json.put("gatewayType", gatewayType.getDes());
        return json.toJSONString();
    }

    /**
     * 根据网关类型不同，设置不同的唯一字段
     * @param uniqueNo
     * @param gatewayType
     * @return
     */
    public ConnOnlineStatusEvent addUniqueNoByGatewayType(String uniqueNo, GatewayType gatewayType) {
        switch (gatewayType) {
            case GB:
                this.setVin(uniqueNo);
                break;
            case MQTT:
                this.setTeNumber(uniqueNo);
                break;
            case GATEWAY_808:
                this.setSimNo(uniqueNo);
                break;
            default:
                break;
        }
        return this;
    }


    // ---------------------------------------------------------------------------

    public String getSimNo() {
        return simNo;
    }

    public ConnOnlineStatusEvent setSimNo(String simNo) {
        this.simNo = simNo;
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

    public String getVin() {
        return vin;
    }

    public ConnOnlineStatusEvent setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public ConnOnlineStatusEvent setTeNumber(String teNumber) {
        this.teNumber = teNumber;
        return this;
    }

    public Integer getOfflineType() {
        return offlineType;
    }

    public ConnOnlineStatusEvent setOfflineType(Integer offlineType) {
        this.offlineType = offlineType;
        return this;
    }
}