package com.ccclubs.gateway;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.ccclubs.frm.mqtt.MqttAliyunProperties;
import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.inf.impl.MqMqttClient;
import com.ccclubs.frm.ons.OnsProperties;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import com.ccclubs.gateway.common.config.GatewayProperties;
import com.ccclubs.gateway.common.config.KafkaProperties;
import com.ccclubs.gateway.common.config.NettyProperties;
import com.ccclubs.gateway.common.connection.ClientSocketCollection;
import com.ccclubs.gateway.jt808.TcpServerStarter;
import com.ccclubs.gateway.jt808.service.MqttMessageProcessService;
import com.ccclubs.gateway.jt808.service.RedisConnService;
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

import java.io.IOException;
import java.util.Properties;

/**
 * 808网关
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
@ImportAutoConfiguration({RedisAutoConfiguration.class, OnsProperties.class, MqttAliyunProperties.class,KafkaProperties.class, NettyProperties.class, GatewayProperties.class})
public class Gateway808CASrvApp extends SpringBootServletInitializer {

  private static final Logger logger = LoggerFactory.getLogger(Gateway808CASrvApp.class);

  @Autowired
  private MqttAliyunProperties mqttAliyunProperties;
  @Autowired
  private OnsProperties onsProperties;

  @Autowired
  private ClientSocketCollection clientSocketCollection;

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Gateway808CASrvApp.class);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    ConfigurableApplicationContext ctx = SpringApplication.run(Gateway808CASrvApp.class, args);
    String[] profiles = ctx.getEnvironment().getActiveProfiles();
    for (String p : profiles) {
      logger.info("Env profile:{}", p);
    }

    ctx.getBean(TcpServerStarter.class).start();
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
    mqClient.setMqMessageProcessService(getRemoteMessageProcessService());
    return mqClient;
  }

  @Bean(name = "jt808RemoteProcessService")
  public IMessageProcessService getRemoteMessageProcessService() {
    return new MqttMessageProcessService(clientSocketCollection);
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

  //yaz----------------------------------------
  /**
   * 启动Tcp服务器
   * @return
   */
  @Bean(name = "tcpServerStarter", destroyMethod = "stop")
  public TcpServerStarter getTcpServerStarter() {

    return new TcpServerStarter();
  }

}