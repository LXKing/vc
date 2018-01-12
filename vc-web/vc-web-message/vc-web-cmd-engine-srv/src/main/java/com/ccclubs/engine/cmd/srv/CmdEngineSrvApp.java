package com.ccclubs.engine.cmd.srv;

import com.ccclubs.engine.cmd.inf.config.CmdEngineConfig;
import com.ccclubs.frm.mongo.config.MultipleMongoConfig;
import com.ccclubs.frm.mqtt.MqttAliyunProperties;
import com.ccclubs.frm.mqtt.MqttOwnProperties;
import com.ccclubs.frm.mybatis.MybatisConfig;
import com.ccclubs.frm.ons.OnsProperties;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import java.io.IOException;
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

/**
 * cmd engine start class
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
@Import({MybatisConfig.class})
@ImportAutoConfiguration({RedisAutoConfiguration.class, OnsProperties.class, CmdEngineConfig.class,
    MultipleMongoConfig.class, MqttAliyunProperties.class, MqttOwnProperties.class})
@EnableScheduling
public class CmdEngineSrvApp extends SpringBootServletInitializer {

  private static final Logger logger = LoggerFactory.getLogger(CmdEngineSrvApp.class);

  /**
   * war打包用，相当于web.xml配置
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(CmdEngineSrvApp.class);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    ConfigurableApplicationContext ctx = SpringApplication.run(CmdEngineSrvApp.class, args);
    String[] profiles = ctx.getEnvironment().getActiveProfiles();
    for (String p : profiles) {
      logger.info("Env profile:{}", p);
    }
  }
}