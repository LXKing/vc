package com.ccclubs.gateway.jt808;

import com.ccclubs.gateway.jt808.service.TerminalConnService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.Objects;

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

    @Autowired
    private TerminalConnService terminalConnService;

    public void start() {
        ChannelFuture bindFuture = serverBootstrap.bind(tcpPort);

        this.serverChannel = bindFuture.channel();

        bindFuture.addListener((future -> {
            if (future.isCancelled()) {
                LOG.error("808-TCP server cancelled: ", future.cause());
            } else if (!future.isSuccess()) {
                LOG.error("808-TCP bind failed cause：{}", future.cause());
            } else {
                LOG.info("808-TCP server start success: port={}", tcpPort);
            }
        }));
        this.serverChannel.closeFuture().addListener((f)-> {
            if (!f.isSuccess()) {
                LOG.error("server channel closing failed, cause: {}", f.cause());
            } else {
                LOG.info("server channel closed success");
            }
        });
    }

    @PreDestroy
    public void stop() throws Exception {
        LOG.info("tcp server is closing, all client will offline");
        terminalConnService.offlineOfAll();

        serverChannel.close();
        if (Objects.nonNull(serverChannel.parent())) {
            serverChannel.parent().close();
        }
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
