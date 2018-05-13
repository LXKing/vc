package com.ccclubs.gateway;

import com.ccclubs.gateway.gb.TcpServerStarter;
import com.ccclubs.gateway.gb.utils.KafkaProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 国标网关
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
@Import({KafkaProperties.class})
public class GatewayGBSrvApp extends SpringBootServletInitializer {

  private static final Logger logger = LoggerFactory.getLogger(GatewayGBSrvApp.class);
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GatewayGBSrvApp.class);
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(GatewayGBSrvApp.class);
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