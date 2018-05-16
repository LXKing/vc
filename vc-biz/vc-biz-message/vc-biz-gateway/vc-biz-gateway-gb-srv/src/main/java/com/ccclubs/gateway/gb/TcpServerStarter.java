package com.ccclubs.gateway.gb;

import com.ccclubs.gateway.gb.handler.process.ChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.Set;

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


    public void start() throws Exception {
        // TODO 稳定后删除的代码----------------------
        Set<String> vins = ChildChannelHandler.vins;
        // 添加受监视的车机
        vins.add("LJ8E3A5MXGB001117");
        vins.add("LJ8E3C1M5GB008817");
        vins.add("LJ8E3C1M5GB010065");
        vins.add("LJ8E3C1M8GB011016");
        vins.add("LJ8E3C1M1GB008152");
        vins.add("LJ8E3C1M9GB010635");
        vins.add("LJ8E3A1M1FB001074");
        vins.add("LJ8E3C1M8GB008116");
        vins.add("LJ8E3C1MXGB003628");
        vins.add("LJ8E3C1MXGB009476");
        vins.add("LJ8E3C1M4GB008842");
        vins.add("LJ8E3C1M3HD314565");
        vins.add("LJ8E3C1M0HD310845");
        vins.add("LJ8M3A5M5GB002302");
        vins.add("LJ8E3C1M6HD003401");
        // -------------------------------------------

        LOG.info("TCP服务器启动");
        new Thread(() -> {
            try {
                this.serverChannel =
                        serverBootstrap
                                .bind(tcpPort).sync()
                                .channel().closeFuture().sync()
                                .channel();
            } catch (Exception e) {
                LOG.error("TCP服务器启动异常：{}", e.getMessage());
                e.printStackTrace();
            }

        }).start();
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
