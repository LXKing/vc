package com.ccclubs.command;

import com.ccclubs.command.util.CommandProp;
import com.ccclubs.frm.mongo.config.MultipleMongoConfig;
import com.ccclubs.frm.mqtt.MqttAliyunProperties;
import com.ccclubs.frm.mqtt.MqttOwnProperties;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.inf.impl.MqMqttClient;
import com.ccclubs.frm.mybatis.MybatisConfig;
import com.ccclubs.frm.redis.RedisAutoConfiguration;

import java.io.IOException;
import java.util.concurrent.*;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Import({MybatisConfig.class})
@EnableConfigurationProperties({CommandProp.class, MqttAliyunProperties.class,
        MqttOwnProperties.class})
@ImportAutoConfiguration({RedisAutoConfiguration.class, MultipleMongoConfig.class})
public class CommandSrvApp extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(CommandSrvApp.class);

    @Autowired
    private MqttAliyunProperties mqttAliyunProperties;
    @Autowired
    private MqttOwnProperties mqttOwnProperties;

    /**
     * war打包用，相当于web.xml配置
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CommandSrvApp.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(CommandSrvApp.class, args);
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for (String p : profiles) {
            logger.info("Env profile:{}", p);
        }
    }

    @Bean(name = "aliyunMqttClient", initMethod = "start", destroyMethod = "stop")
    @Primary
    IMqClient getAliyunMqttClient() {
        MqMqttClient mqClient = new MqMqttClient();
        mqClient.setHost(mqttAliyunProperties.getHost());
        mqClient.setListenPort(mqttAliyunProperties.getPort());
        mqClient.setClientIdPre(mqttAliyunProperties.getPreId());
        mqClient.setUserName(mqttAliyunProperties.getUserName());
        mqClient.setPwd(mqttAliyunProperties.getPwd());
        mqClient.setLogUpDown(mqttAliyunProperties.isLogUpDown());
        mqClient.setSubTopic(mqttAliyunProperties.getSubTopic());
        return mqClient;
    }

    @Bean(name = "ownMqttClient", initMethod = "start", destroyMethod = "stop")
    IMqClient getOwnMqttClient() {
        MqMqttClient ownMqClient = new MqMqttClient();
        ownMqClient.setHost(mqttOwnProperties.getHost());
        ownMqClient.setListenPort(mqttOwnProperties.getPort());
        ownMqClient.setClientIdPre(mqttOwnProperties.getPreId());
        ownMqClient.setUserName(mqttOwnProperties.getUserName());
        ownMqClient.setPwd(mqttOwnProperties.getPwd());
        ownMqClient.setLogUpDown(mqttOwnProperties.isLogUpDown());
        ownMqClient.setSubTopic(mqttOwnProperties.getSubTopic());
        return ownMqClient;
    }

    @Value("${ThreadPool.nameFormat}")
    String nameFormat;

    @Value("${ThreadPool.corePoolSize}")
    int corePoolSize;

    @Value("${ThreadPool.maximumPoolSize}")
    int maximumPoolSize;

    @Value("${ThreadPool.keepAliveTime}")
    long keepAliveTime;

    @Value("${ThreadPool.dequeCapacity}")
    int dequeCapacity;

    @Bean("vcThreadPool")
    public ExecutorService getThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat(nameFormat).build();
        ExecutorService pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS
                , new LinkedBlockingDeque<>(dequeCapacity), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        return pool;
    }

}