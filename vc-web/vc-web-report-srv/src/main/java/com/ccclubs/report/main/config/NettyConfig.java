package com.ccclubs.report.main.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ccclubs.report.constant.ReportProps;
import com.ccclubs.report.netty.client.NettyClient;
import com.ccclubs.report.netty.handler.NettyPoolHandlerInitializer;
import com.ccclubs.report.service.ReportInf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

@Configuration
@EnableConfigurationProperties(ReportProps.class)
public class NettyConfig {

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup nioEventLoopGroup() {
        NioEventLoopGroup nelg = new NioEventLoopGroup();
        return nelg;
    }

    @Bean
    public Bootstrap bootstrap() {
        Bootstrap b = new Bootstrap();
        b.group(nioEventLoopGroup());
        b.channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new NettyPoolHandlerInitializer());
        return b;
    }

    @Autowired
    private List<ReportInf> list;
    @Autowired
    private Bootstrap bootstrap;

    @Bean
    public NettyClient nettyClient() {
        NettyClient nc = new NettyClient(list, bootstrap);
        return nc;
    }
    
}
