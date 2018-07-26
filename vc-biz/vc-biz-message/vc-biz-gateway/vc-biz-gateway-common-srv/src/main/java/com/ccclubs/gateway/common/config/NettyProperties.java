package com.ccclubs.gateway.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yeanzi
 * @Date: 2018/5/22
 * @Time: 12:58
 * Email:  yeanzhi@ccclubs.com
 * netty相关配置文件
 */
@ConfigurationProperties(prefix = "netty")
public class NettyProperties {

    private int tcpPort;

    private int bossCount;

    private int workerCount;

    private boolean keepAlive;

    private int backlog;

    /**
     * 如果服务器是linux环境：使用EpollEventLoopGroup
     */
    private boolean useLinuxEpoll;

    public int getTcpPort() {
        return tcpPort;
    }

    public NettyProperties setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
        return this;
    }

    public int getBossCount() {
        return bossCount;
    }

    public NettyProperties setBossCount(int bossCount) {
        this.bossCount = bossCount;
        return this;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public NettyProperties setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
        return this;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public NettyProperties setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
        return this;
    }

    public int getBacklog() {
        return backlog;
    }

    public NettyProperties setBacklog(int backlog) {
        this.backlog = backlog;
        return this;
    }

    public boolean isUseLinuxEpoll() {
        return useLinuxEpoll;
    }

    public NettyProperties setUseLinuxEpoll(boolean useLinuxEpoll) {
        this.useLinuxEpoll = useLinuxEpoll;
        return this;
    }
}
