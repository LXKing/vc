package com.ccclubs.gateway;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.ccclubs.frm.mqtt.MqttOwnProperties;
import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.inf.impl.MqMqttClient;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import com.ccclubs.gateway.mqtt.MqttMessageProcessService;
import com.ccclubs.frm.ons.OnsProperties;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * MQTT网关
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
@ImportAutoConfiguration({MqttOwnProperties.class, OnsProperties.class, RedisAutoConfiguration.class})
public class GatewayMQTTSrvApp extends SpringBootServletInitializer {

  private static final Logger logger = LoggerFactory.getLogger(GatewayMQTTSrvApp.class);
  @Autowired
  private MqttOwnProperties mqttOwnProperties;
  @Autowired
  private OnsProperties onsProperties;

  /**
   * war打包用，相当于web.xml配置
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(GatewayMQTTSrvApp.class);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    ConfigurableApplicationContext ctx = SpringApplication.run(GatewayMQTTSrvApp.class, args);
    String[] profiles = ctx.getEnvironment().getActiveProfiles();
    for (String p : profiles) {
      logger.info("Env profile:{}", p);
    }
  }

  @Bean(name = "ownMqttClient", initMethod = "start", destroyMethod = "stop")
  @Primary
  IMqClient getAliyunMqttClient() {
    MqMqttClient mqClient = new MqMqttClient();
    mqClient.setHost(mqttOwnProperties.getHost());
    mqClient.setListenPort(mqttOwnProperties.getPort());
    mqClient.setClientIdPre(mqttOwnProperties.getPreId());
    mqClient.setUserName(mqttOwnProperties.getUserName());
    mqClient.setPwd(mqttOwnProperties.getPwd());
    mqClient.setLogUpDown(mqttOwnProperties.isLogUpDown());
    mqClient.setSubTopic(mqttOwnProperties.getSubTopic());
    mqClient.setMqMessageProcessService(getMessageProcessService());
    return mqClient;
  }

  @Bean(name = "onsPublishClient", initMethod = "start", destroyMethod = "shutdown")
  public Producer getProducer() {
    Properties properties = new Properties();
    // 您在控制台创建的 Producer ID
    properties.put(PropertyKeyConst.ProducerId, onsProperties.getProducerId());
    // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
    properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
    // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
    properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());

    return ONSFactory.createProducer(properties);
  }

  @Bean
  public IMessageProcessService getMessageProcessService() {
    return new MqttMessageProcessService();
  }
}