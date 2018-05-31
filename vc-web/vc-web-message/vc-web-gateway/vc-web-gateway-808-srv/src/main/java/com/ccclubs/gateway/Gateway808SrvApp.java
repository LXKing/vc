package com.ccclubs.gateway;

import com.ccclubs.gateway.common.config.GatewayProperties;
import com.ccclubs.gateway.common.config.KafkaProperties;
import com.ccclubs.gateway.common.config.NettyProperties;
import com.ccclubs.gateway.jt808.TcpServerStarter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

/**
 * 808网关
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
//@Import({MybatisConfig.class})
//@ImportAutoConfiguration({OnsProperties.class,MqttAliyunProperties.class, RedisAutoConfiguration.class, KafkaProperties.class, NettyProperties.class, GatewayProperties.class})
@ImportAutoConfiguration({KafkaProperties.class, NettyProperties.class, GatewayProperties.class})
public class Gateway808SrvApp extends SpringBootServletInitializer {

  private static final Logger logger = LoggerFactory.getLogger(Gateway808SrvApp.class);

//  @Autowired
//  private MqttAliyunProperties mqttAliyunProperties;
//  @Autowired
//  private OnsProperties onsProperties;
//
//  @Value("${jt808Server.maxOfflineTime}")
//  private Integer maxOfflineTime;
//
//  @Value("${jt808Server.port}")
//  private Integer port;


  /**
   * war打包用，相当于web.xml配置
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Gateway808SrvApp.class);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    ConfigurableApplicationContext ctx = SpringApplication.run(Gateway808SrvApp.class, args);
    String[] profiles = ctx.getEnvironment().getActiveProfiles();
    for (String p : profiles) {
      logger.info("Env profile:{}", p);
    }

    ctx.getBean(TcpServerStarter.class).start();
  }

//  @Bean(name = "aliyunMqttClient", initMethod = "start", destroyMethod = "stop")
//  @Primary
//  IMqClient getAliyunMqttClient() {
//    MqMqttClient mqClient = new MqMqttClient();
//    mqClient.setHost(mqttAliyunProperties.getHost());
//    mqClient.setListenPort(mqttAliyunProperties.getPort());
//    mqClient.setClientIdPre(mqttAliyunProperties.getPreId());
//    mqClient.setUserName(mqttAliyunProperties.getUserName());
//    mqClient.setPwd(mqttAliyunProperties.getPwd());
//    mqClient.setLogUpDown(mqttAliyunProperties.isLogUpDown());
//    mqClient.setSubTopic(mqttAliyunProperties.getSubTopic());
//    mqClient.setMqMessageProcessService(getRemoteMessageProcessService());
//    return mqClient;
//  }
//
//  @Bean(name = "jt808RemoteProcessService")
//  public IMessageProcessService getRemoteMessageProcessService() {
//    return new MqttMessageProcessService();
//  }
//
//
//  @Bean(name = "onsPublishClient", initMethod = "start", destroyMethod = "shutdown")
//  public Producer getProducer() {
//    Properties properties = new Properties();
//    // 您在控制台创建的 Producer ID
//    properties.put(PropertyKeyConst.ProducerId, onsProperties.getProducerId());
//    // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
//    properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
//    // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
//    properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());
//
//    return ONSFactory.createProducer(properties);
//  }
//
//  @Bean(name = "jt808TcpServer")
//  public IJT808Server getJT808Server() {
//    JT808TcpServer jt808TcpServer = new JT808TcpServer();
//    jt808TcpServer.setMaxOfflineTime(maxOfflineTime);
//    jt808TcpServer.setPort(port);
//    return jt808TcpServer;
//  }
//
//  @Bean(name = "jt808ServerHandler")
//  public IoHandlerAdapter getJT808Handler() {
//    return new JT808ServerHandler();
//  }
//
//  @Bean(name = "jt808MessageProcessService")
//  public I808MessageProcessService getMessageProcessService() {
//    return new MessageProcessService();
//  }
//
//  @Bean(name = "jt808GpsDataService")
//  public IGpsDataService getGpsDataService() {
//    return new GpsDataService();
//  }
//
//
//  @Bean(name = "jt808AckService", initMethod = "start")
//  public IAckService getAckService() {
//    AckService ackService = new AckService();
//    ackService.setThreadPool(50);
//    ackService.setCheckRegister(true);
//    ackService.setAck0200PacketDisabled(false);
//    return ackService;
//  }
//
//
//  @Bean(name = "jt808Manager", initMethod = "startServer", destroyMethod = "stopServer")
//  public IT808Manager getJT808Manager() {
//    return new T808Manager();
//  }


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