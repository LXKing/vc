package com.ccclubs.engine.rule;

import com.ccclubs.common.BatchProperties;
import com.ccclubs.engine.rule.inf.config.RuleEngineConfig;
import com.ccclubs.frm.mongodb.config.MongoConfig;
import com.ccclubs.frm.mqtt.MqttAliyunProperties;
import com.ccclubs.frm.mqtt.MqttOwnProperties;
import com.ccclubs.frm.mybatis.MybatisConfig;
import com.ccclubs.frm.ons.OnsProperties;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

/**
 * cmd engine start class
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
@Import({MybatisConfig.class})
@ImportAutoConfiguration({RedisAutoConfiguration.class,OnsProperties.class,
        MqttAliyunProperties.class, MqttOwnProperties.class, RuleEngineConfig.class,MongoConfig.class,
    BatchProperties.class})
@EnableScheduling
public class RuleEngineSrvApp extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(RuleEngineSrvApp.class);

    /**
     * war打包用，相当于web.xml配置
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RuleEngineSrvApp.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(RuleEngineSrvApp.class, args);
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for (String p : profiles) {
            logger.info("Env profile:{}", p);
        }
    }
}