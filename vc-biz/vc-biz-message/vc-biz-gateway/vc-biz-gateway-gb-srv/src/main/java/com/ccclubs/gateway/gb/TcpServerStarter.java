package com.ccclubs.gateway.gb;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.util.ResourceLeakDetector;
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

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private Channel serverChannel;


    public void start() throws Exception {
        LOG.info("TCP服务器启动");

        // 追踪字节缓存内存泄露，很耗费性能，debug时打开。
//        ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.PARANOID);
        this.serverChannel =
                serverBootstrap
                        .bind(tcpPort).sync()
                        .channel().closeFuture().sync()
                        .channel();
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
}
