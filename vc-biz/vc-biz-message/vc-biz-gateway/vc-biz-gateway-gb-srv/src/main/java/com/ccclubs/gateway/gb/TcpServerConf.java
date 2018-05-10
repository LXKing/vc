package com.ccclubs.gateway.gb;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 */
@Component
public class TcpServerConf {
    private static final Logger LOG = Logger.getLogger("TcpServer");

    /**
     * 是否打印上行/下行消息 debug日志
     */
    @Value("${pac.log.debug}")
    private boolean printPacLog;

    @Value("${pac.buffer.check}")
    private boolean enableBufferCheck;

    @Autowired
    @Qualifier("childChannelHandler")
    private ChildChannelHandler childChannelHandler;

    @Value("${tcp.port}")
    private int tcpPort;

    @Value("${boss.thread.count}")
    private int bossCount;

    @Value("${worker.thread.count}")
    private int workerCount;

    @Value("${so.keepalive}")
    private boolean keepAlive;

    @Value("${so.backlog}")
    private int backlog;

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
        ChildChannelHandler.printPacLog = printPacLog;
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

        if (enableBufferCheck) {
            // 追踪字节缓存内存泄露，很耗费性能，debug时打开。
            LOG.warning("启动缓存检查");
            ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.PARANOID);
        }
        return b;
    }

    @Bean(name = "tcpChannelOptions")
    public Map<ChannelOption<?>, Object> tcpChannelOptions() {
        Map<ChannelOption<?>, Object> options = new HashMap<>();
        options.put(ChannelOption.SO_KEEPALIVE, keepAlive);
        options.put(ChannelOption.SO_BACKLOG, backlog);
        return options;
    }

    @Bean(name = "tcpSocketAddress")
    public InetSocketAddress tcpPort() {
        return new InetSocketAddress(tcpPort);
    }
}
