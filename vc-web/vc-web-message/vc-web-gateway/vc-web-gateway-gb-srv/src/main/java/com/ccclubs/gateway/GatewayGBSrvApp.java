package com.ccclubs.gateway;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.ccclubs.frm.mqtt.MqttAliyunProperties;
import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.inf.impl.MqMqttClient;
import com.ccclubs.gateway.gb.inf.IAckService;
import com.ccclubs.gateway.gb.inf.IGbMessageProcessService;
import com.ccclubs.gateway.gb.inf.IGbServer;
import com.ccclubs.gateway.gb.inf.IGpsDataService;
import com.ccclubs.gateway.gb.inf.IGbManager;
import com.ccclubs.gateway.gb.inf.impl.GBManager;
import com.ccclubs.gateway.gb.inf.impl.MessageProcessService;
import com.ccclubs.gateway.gb.inf.impl.AckService;
import com.ccclubs.gateway.gb.inf.impl.GpsDataService;
import com.ccclubs.gateway.gb.inf.impl.MqttMessageProcessService;
import com.ccclubs.gateway.gb.mina.GbServerHandler;
import com.ccclubs.gateway.gb.mina.GbTcpServer;
import com.ccclubs.frm.ons.OnsProperties;
import java.io.IOException;
import java.util.Properties;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 国标网关
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
@ImportAutoConfiguration({MqttAliyunProperties.class, OnsProperties.class})
public class GatewayGBSrvApp extends SpringBootServletInitializer {

  private static final Logger logger = LoggerFactory.getLogger(GatewayGBSrvApp.class);
  @Autowired
  private MqttAliyunProperties mqttAliyunProperties;
  @Autowired
  private OnsProperties onsProperties;
  @Value("${gbServer.maxOfflineTime}")
  private Integer maxOfflineTime;
  @Value("${gbServer.port}")
  private Integer port;


  /**
   * war打包用，相当于web.xml配置
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(GatewayGBSrvApp.class);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    ConfigurableApplicationContext ctx = SpringApplication.run(GatewayGBSrvApp.class, args);
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

  @Bean(name = "gbTcpServer")
  public IGbServer getGbServer() {
    GbTcpServer gbTcpServer = new GbTcpServer();
    gbTcpServer.setMaxOfflineTime(maxOfflineTime);
    gbTcpServer.setPort(port);
    return gbTcpServer;
  }

  @Bean(name = "gbHandler")
  public IoHandlerAdapter getGbHandler() {
    return new GbServerHandler();
  }

  @Bean(name = "gbRemoteProcessService")
  public IMessageProcessService getMessageProcessService() {
    return new MqttMessageProcessService();
  }

  @Bean(name = "gbAckService", initMethod = "start")
  public IAckService getAckService() {
    AckService ackService = new AckService();
    ackService.setThreadPool(50);
    return ackService;
  }

  @Bean(name = "gbManager", initMethod = "startServer", destroyMethod = "stopServer")
  public IGbManager getGbManager() {
    return new GBManager();
  }

  @Bean(name = "gbMessageProcessService")
  public IGbMessageProcessService getGbMessageProcessService() {
    return new MessageProcessService();
  }

  @Bean(name = "gbGpsDataService")
  public IGpsDataService getGpsDataService() {
    return new GpsDataService();
  }

}