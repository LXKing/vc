package com.ccclubs.gateway.common.bean.event;

import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.util.DateUtil;
import io.netty.channel.socket.SocketChannel;

import java.io.Serializable;

/**
 * @Author: yeanzi
 * @Date: 2018/7/4
 * @Time: 16:41
 * Email:  yeanzhi@ccclubs.com
 * 用于日志，不用于统计
 */
public class ConnLiveEvent implements Serializable {

    /**
     * 唯一标识
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
    private String time;

    /**
     * 网关类型：固定为国标
     */
    private String gatewayType;

    /**
     * 异常的原始报文
     *      如果非异常该值为空
     */
    private String exceptionHex;

    public ConnLiveEvent channel(SocketChannel channel) {
        this.clientIp = channel.remoteAddress().getHostString();
        this.serverIp = channel.localAddress().getHostString();
        return this;
    }

    public ConnLiveEvent gatewayType(GatewayType gatewayType) {
        this.gatewayType = gatewayType.getDes();
        return this;
    }

    public ConnLiveEvent online(boolean online) {
        this.online = online;
        return this;
    }

    public ConnLiveEvent exceptionHex(String exceptionHex) {
        this.exceptionHex = exceptionHex;
        return this;
    }

    public ConnLiveEvent uniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo;
        return this;
    }

    public ConnLiveEvent build() {
        // TODO 对之前的参数校验
        this.time = DateUtil.getNowStr();
        return this;
    }

    public String getUniqueNo() {
        return uniqueNo;
    }

    public String getServerIp() {
        return serverIp;
    }

    public String getClientIp() {
        return clientIp;
    }

    public boolean isOnline() {
        return online;
    }

    public String getTime() {
        return time;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public String getExceptionHex() {
        return exceptionHex;
    }
}
