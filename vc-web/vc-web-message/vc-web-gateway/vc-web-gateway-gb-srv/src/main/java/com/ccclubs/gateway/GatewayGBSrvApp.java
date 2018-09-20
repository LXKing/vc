package com.ccclubs.gateway;

import com.ccclubs.gateway.common.config.GatewayProperties;
import com.ccclubs.gateway.common.config.KafkaProperties;
import com.ccclubs.gateway.common.config.NettyProperties;
import com.ccclubs.gateway.gb.TcpServerStarter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 国标网关
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
@EnableConfigurationProperties({KafkaProperties.class, NettyProperties.class, GatewayProperties.class})
public class GatewayGBSrvApp extends SpringBootServletInitializer {

  private static final Logger LOG = LoggerFactory.getLogger(GatewayGBSrvApp.class);
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GatewayGBSrvApp.class);
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(GatewayGBSrvApp.class);
        // 启动netty服务
        ctx.getBean(TcpServerStarter.class).start();
    }

    /**
     * 启动Tcp服务器
     * @return
     */
    @Bean(name = "tcpServerStarter", destroyMethod = "stop")
    public TcpServerStarter getTcpServerStarter() {
        return new TcpServerStarter();
    }

}