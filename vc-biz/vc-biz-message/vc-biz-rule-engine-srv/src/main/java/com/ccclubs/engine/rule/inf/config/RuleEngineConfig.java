package com.ccclubs.engine.rule.inf.config;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import com.ccclubs.engine.rule.inf.IMqAckService;
import com.ccclubs.engine.rule.inf.IParseGbDataService;
import com.ccclubs.engine.rule.inf.MqManager;
import com.ccclubs.engine.rule.inf.MqMessageListener;
import com.ccclubs.engine.rule.inf.impl.MqAckService;
import com.ccclubs.engine.rule.inf.impl.MqMessageProcessService;
import com.ccclubs.engine.rule.inf.impl.MqttMessageProcessService;
import com.ccclubs.engine.rule.inf.impl.ParseDataService;
import com.ccclubs.engine.rule.inf.impl.ParseGbDataService;
import com.ccclubs.frm.mqtt.MqttAliyunProperties;
import com.ccclubs.frm.mqtt.MqttOwnProperties;
import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.inf.impl.MqMqttClient;
import com.ccclubs.frm.ons.OnsProperties;
import com.ccclubs.protocol.inf.IMqMessageProcessService;
import com.ccclubs.protocol.inf.IParseDataService;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 规则引擎配置
 *
 * @author jianghaiyang
 * @create 2017-08-10
 **/
@Configuration
public class RuleEngineConfig {

  @Autowired
  private MqttAliyunProperties mqttAliyunProperties;

  @Autowired
  private MqttOwnProperties mqttOwnProperties;

  @Autowired
  private OnsProperties onsProperties;

  /**
   * 主要是用于JT808远程控制
   */
  @Bean(name = "mqClient", initMethod = "start", destroyMethod = "stop")
  @Primary
  public IMqClient mqClient() {
    MqMqttClient mqClient = new MqMqttClient();
    mqClient.setHost(mqttAliyunProperties.getHost());
    mqClient.setListenPort(mqttAliyunProperties.getPort());
    mqClient.setClientIdPre(mqttAliyunProperties.getPreId());
    mqClient.setUserName(mqttAliyunProperties.getUserName());
    mqClient.setPwd(mqttAliyunProperties.getPwd());
    mqClient.setLogUpDown(mqttAliyunProperties.isLogUpDown());
    return mqClient;
  }

//  @Bean(name = "mqttProcess")
//  public IMessageProcessService getMessageProcessService() {
//    return new MqttMessageProcessService();
//  }

  /**
   * 主要是用于自有MQTT远程控制
   */
  @Bean(name = "mqttClient", initMethod = "start", destroyMethod = "stop")
  public IMqClient mqttClient() {
    MqMqttClient ownMqClient = new MqMqttClient();
    ownMqClient.setHost(mqttOwnProperties.getHost());
    ownMqClient.setListenPort(mqttOwnProperties.getPort());
    ownMqClient.setClientIdPre(mqttOwnProperties.getPreId());
    ownMqClient.setUserName(mqttOwnProperties.getUserName());
    ownMqClient.setPwd(mqttOwnProperties.getPwd());
    ownMqClient.setLogUpDown(mqttOwnProperties.isLogUpDown());

//    ownMqClient.setSubTopic(mqttOwnProperties.getSubTopic());
//    ownMqClient.setMqMessageProcessService(getMessageProcessService());

    return ownMqClient;
  }

  @Bean(name = "ackService")
  public IMqAckService ackService() {
    MqAckService ackService = new MqAckService();
    return ackService;
  }

  @Bean(name = "parseDataService")
  public IParseDataService parseDataService() {
    ParseDataService parseDataService = new ParseDataService();
    return parseDataService;
  }

  @Bean(name = "parseGbDataService")
  public IParseGbDataService parseGbDataService() {
    ParseGbDataService parseGbDataService = new ParseGbDataService();
    return parseGbDataService;
  }

  @Bean(name = "mqMessageProcessService")
  public IMqMessageProcessService mqMessageProcessService() {
    MqMessageProcessService mqMessageProcessService = new MqMessageProcessService();
    mqMessageProcessService.setClient(producer());
    mqMessageProcessService.setMqAckService(ackService());
    mqMessageProcessService.setParseDataService(parseDataService());
    mqMessageProcessService.setParseGbDataService(parseGbDataService());
    return mqMessageProcessService;
  }

  @Bean(name = "messageListener")
  @Qualifier(value = "mqMessageProcessService")
  public MessageListener messageListener(IMqMessageProcessService mqMessageProcessService) {
    MqMessageListener messageListener = new MqMessageListener();
    messageListener.setMqMessageProcessService(mqMessageProcessService);
    return messageListener;
  }

  @Bean(name = "subscription")
  public Subscription subscription() {
    Subscription subscription = new Subscription();
    subscription.setTopic(onsProperties.getTopic());
    subscription.setExpression(onsProperties.getExpression());
    return subscription;
  }

  @Bean(name = "producer", initMethod = "start", destroyMethod = "shutdown")
  public Producer producer() {
    Properties properties = new Properties();
    // 您在控制台创建的 Producer ID
    properties.put(PropertyKeyConst.ProducerId, onsProperties.getProducerId());
    // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
    properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
    // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
    properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());

    return ONSFactory.createProducer(properties);
  }

  @Bean(name = "concumer", initMethod = "start", destroyMethod = "shutdown")
  @Qualifier(value = "messageListener")
  public Consumer concumer(MessageListener messageListener) {
    Properties properties = new Properties();
    // 您在控制台创建的 Producer ID
    properties.put(PropertyKeyConst.ConsumerId, onsProperties.getConsumerId());
    // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
    properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
    // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
    properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());
    properties.put(PropertyKeyConst.ConsumeThreadNums, onsProperties.getConsumeThreadNums());

    Map<Subscription, MessageListener> map = new HashMap<>();
    map.put(subscription(), messageListener);
    ConsumerBean consumer = new ConsumerBean();
    consumer.setProperties(properties);
    consumer.setSubscriptionTable(map);
    return consumer;
  }

  @Bean(name = "mqManager", initMethod = "startServer", destroyMethod = "stopServer")
  @Qualifier(value = "ackService")
  public MqManager mqManager(IMqAckService ackService) {
    MqManager mqManager = new MqManager();
    mqManager.setMqClient(mqClient());
    mqManager.setMqttClient(mqttClient());
    mqManager.setMqAckService(ackService);

    return mqManager;
  }
}
