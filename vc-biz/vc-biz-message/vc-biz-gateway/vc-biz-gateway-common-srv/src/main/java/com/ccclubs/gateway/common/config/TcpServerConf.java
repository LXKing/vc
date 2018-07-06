package com.ccclubs.gateway.common.config;

import com.ccclubs.gateway.common.inf.ChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.ResourceLeakDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * tcp服务组件
 */
@Component
public class TcpServerConf {
    private static final Logger LOG = Logger.getLogger("TcpServer");

    /**
     * 是否打开报文打印开关
     */
    public static boolean GATEWAY_PRINT_LOG;

    @Autowired
    private NettyProperties nettyProperties;

    @Autowired
    private GatewayProperties gatewayProperties;

    @Autowired
    private ChildChannelHandler childChannelHandler;

    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public EventLoopGroup bossGroup() {
        if (nettyProperties.isUseLinuxEpoll() && Epoll.isAvailable()) {
            return new EpollEventLoopGroup(nettyProperties.getBossCount());
        } else {
            return new NioEventLoopGroup(nettyProperties.getBossCount());
        }
    }

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public EventLoopGroup workerGroup() {
        if (nettyProperties.isUseLinuxEpoll() && Epoll.isAvailable()) {
            return new EpollEventLoopGroup(nettyProperties.getWorkerCount());
        } else {
            return new NioEventLoopGroup(nettyProperties.getWorkerCount());
        }
    }

    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap() {

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(), workerGroup());
        if (nettyProperties.isUseLinuxEpoll() && Epoll.isAvailable()) {
            b.channel(EpollServerSocketChannel.class);
        } else {
            b.channel(NioServerSocketChannel.class);
        }
        b.handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(childChannelHandler);

        Map<ChannelOption<?>, Object> tcpChannelOptions = tcpChannelOptions();
        Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();
        // channel参数设置
        for (ChannelOption option : keySet) {
            b.option(option, tcpChannelOptions.get(option));
        }

        if (gatewayProperties.isBufferCheck()) {
            // 追踪字节缓存内存泄露，很耗费性能，debug时打开。
            LOG.warning("缓存检查: 开启");
            ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.PARANOID);
        }
        if (gatewayProperties.isLogPrint()) {
            GATEWAY_PRINT_LOG = true;
            LOG.warning("网关打印输出日志：开启");
        }
        return b;
    }

    @Bean(name = "tcpChannelOptions")
    public Map<ChannelOption<?>, Object> tcpChannelOptions() {
        Map<ChannelOption<?>, Object> options = new HashMap<>();
        options.put(ChannelOption.SO_KEEPALIVE, nettyProperties.isKeepAlive());
        options.put(ChannelOption.SO_BACKLOG, nettyProperties.getBacklog());
        return options;
    }

    @Bean(name = "tcpSocketAddress")
    public InetSocketAddress tcpPort() {
        int tcpPort = nettyProperties.getTcpPort();
        tcpPort = tcpPort==0?26700:tcpPort;
        return new InetSocketAddress(tcpPort);
    }
}
