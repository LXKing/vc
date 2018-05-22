package com.ccclubs.gateway.gb;

import com.ccclubs.gateway.gb.config.GatewayProperties;
import com.ccclubs.gateway.gb.config.NettyProperties;
import com.ccclubs.gateway.gb.handler.process.ChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.ResourceLeakDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    private NettyProperties nettyProperties;

    @Autowired
    private GatewayProperties gatewayProperties;

    @Autowired
    @Qualifier("childChannelHandler")
    private ChildChannelHandler childChannelHandler;

    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup();
    }

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup();
    }

    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap() {
        ChildChannelHandler.printPacLog = gatewayProperties.isLogPrint();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(), workerGroup())
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(childChannelHandler);

        Map<ChannelOption<?>, Object> tcpChannelOptions = tcpChannelOptions();
        Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();
        // channel参数设置
        for (ChannelOption option : keySet) {
            b.option(option, tcpChannelOptions.get(option));
        }

        if (gatewayProperties.isBufferCheck()) {
            // 追踪字节缓存内存泄露，很耗费性能，debug时打开。
            LOG.warning("启动缓存检查");
            ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.PARANOID);
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
        return new InetSocketAddress(nettyProperties.getTcpPort());
    }
}
