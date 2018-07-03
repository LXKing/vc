package com.ccclubs.gateway.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yeanzi
 * @Date: 2018/5/22
 * @Time: 13:01
 * Email:  yeanzhi@ccclubs.com
 * 网关配置
 */
@ConfigurationProperties(prefix = "gateway.server")
public class GatewayProperties {

    /**
     * 是否开启消息日志打印
     */
    private boolean logPrint;

    /**
     * 是否打开buffer缓存检查（测试时开启）
     */
    private boolean bufferCheck;

    /**
     * socket读空闲断开时长（秒）
     */
    private int idleSeconds;

    public boolean isLogPrint() {
        return logPrint;
    }

    public GatewayProperties setLogPrint(boolean logPrint) {
        this.logPrint = logPrint;
        return this;
    }

    public boolean isBufferCheck() {
        return bufferCheck;
    }

    public GatewayProperties setBufferCheck(boolean bufferCheck) {
        this.bufferCheck = bufferCheck;
        return this;
    }

    public int getIdleSeconds() {
        return idleSeconds;
    }

    public GatewayProperties setIdleSeconds(int idleSeconds) {
        this.idleSeconds = idleSeconds;
        return this;
    }
}
