package com.ccclubs.gateway.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author: yeanzi
 * @Date: 2018/4/4
 * @Time: 10:13
 * Email:  yeanzhi@ccclubs.com
 */
@SpringBootApplication
public class GBApigatewayApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GBApigatewayApp.class);
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(GBApigatewayApp.class);
    }

    /**
     * 启动Tcp服务器
     * @return
     */
    @Bean(name = "tcpServerStarter", initMethod = "start", destroyMethod = "stop")
    public TcpServerStarter getTcpServerStarter() {
        return new TcpServerStarter();
    }




}
