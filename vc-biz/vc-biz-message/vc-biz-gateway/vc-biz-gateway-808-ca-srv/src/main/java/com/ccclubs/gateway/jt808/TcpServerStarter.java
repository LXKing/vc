package com.ccclubs.gateway.jt808;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @Author: yeanzi
 * @Date: 2018/4/4
 * @Time: 12:24
 * Email:  yeanzhi@ccclubs.com
 */
@Component
public class TcpServerStarter {
    private static final Logger LOG = LoggerFactory.getLogger(TcpServerStarter.class);

    // 是否开启缓存检查（debug时用）
    private boolean checkBufferLeaker;

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private Channel serverChannel;


    public void start() {

        LOG.info("808-TCP服务器启动");
        try {
            this.serverChannel =
                    serverBootstrap
                            .bind(tcpPort).sync()
                            .channel().closeFuture().sync()
                            .channel();
        } catch (Exception e) {
            LOG.error("808-TCP服务启动异常：{}", e.getMessage());
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void stop() throws Exception {
        serverChannel.close();
        serverChannel.parent().close();
    }

    public InetSocketAddress getTcpPort() {
        return tcpPort;
    }

    public TcpServerStarter setTcpPort(InetSocketAddress tcpPort) {
        this.tcpPort = tcpPort;
        return this;
    }

    public Channel getServerChannel() {
        return serverChannel;
    }

    public TcpServerStarter setServerChannel(Channel serverChannel) {
        this.serverChannel = serverChannel;
        return this;
    }

    public boolean isCheckBufferLeaker() {
        return checkBufferLeaker;
    }

    public TcpServerStarter setCheckBufferLeaker(boolean checkBufferLeaker) {
        this.checkBufferLeaker = checkBufferLeaker;
        return this;
    }
}
