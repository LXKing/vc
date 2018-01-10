package com.ccclubs.vtsearch.srv;

import com.ccclubs.frm.mybatis.MybatisConfig;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import com.ccclubs.terminal.inf.state.impl.TerminalProp;
import com.ccclubs.vehicle.inf.base.impl.VehicleProp;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MybatisConfig.class})
@EnableConfigurationProperties({TerminalProp.class, VehicleProp.class})
@ImportAutoConfiguration({RedisAutoConfiguration.class})
public class VtsearchSrvApp extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(VtsearchSrvApp.class);

    /**
     * war打包用，相当于web.xml配置
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VtsearchSrvApp.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(VtsearchSrvApp.class, args);
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for (String p : profiles) {
            logger.info("Env profile:{}", p);
        }

        //Thread.sleep(100000000000000000L);
    }

}