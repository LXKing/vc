package com.ccclubs.engine.cmd.inf.config;

import com.aliyun.openservices.ons.api.*;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import com.ccclubs.engine.cmd.inf.impl.MqMessageListener;
import com.ccclubs.engine.cmd.inf.impl.OperationMessageProcessService;
import com.ccclubs.engine.cmd.inf.impl.ParseOperationService;
import com.ccclubs.frm.ons.OnsProperties;
import com.ccclubs.protocol.inf.IMqMessageProcessService;
import com.ccclubs.protocol.inf.IParseDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 指令解析配置
 *
 * @author jianghaiyang
 * @create 2017-08-28
 **/
@Configuration
public class CmdEngineConfig {

  private static Logger logger = LoggerFactory.getLogger(CmdEngineConfig.class);

  @Autowired
  private OnsProperties onsProperties;

  @Bean(name = "producer", initMethod = "start", destroyMethod = "shutdown")
  public Producer producer() {
    logger.info("init producer...");
    Properties properties = new Properties();
    properties.put(PropertyKeyConst.ProducerId, onsProperties.getProducerId());
    properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
    properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());
    return ONSFactory.createProducer(properties);
  }

  @Bean(name = "terminalParseService")
  @Qualifier(value = "producer")
  public IParseDataService parseDataService(Producer producer) {
    ParseOperationService terminalParseService = new ParseOperationService();
    terminalParseService.setClient(producer);
    return terminalParseService;
  }

  @Bean(name = "terminalProcessService")
  @Qualifier(value = "terminalParseService")
  public IMqMessageProcessService mqMessageProcessService(IParseDataService terminalParseService) {
    OperationMessageProcessService mqMessageProcessService = new OperationMessageProcessService();
    mqMessageProcessService.setParseDataService(terminalParseService);
    return mqMessageProcessService;
  }

  @Bean(name = "messageListener")
  @Qualifier(value = "terminalProcessService")
  public MessageListener messageListener(IMqMessageProcessService terminalProcessService) {
    MqMessageListener messageListener = new MqMessageListener();
    messageListener.setMqMessageProcessService(terminalProcessService);
    return messageListener;
  }

  @Bean(name = "subscription")
  public Subscription subscription() {
    Subscription subscription = new Subscription();
    subscription.setTopic(onsProperties.getTopic());
    subscription.setExpression(onsProperties.getExpression());
    return subscription;
  }

  @Bean(name = "concumer", initMethod = "start", destroyMethod = "shutdown")
  @Qualifier(value = "messageListener")
  public Consumer concumer(MessageListener messageListener) {
    logger.info("init concumer...");
    Properties properties = new Properties();
    properties.put(PropertyKeyConst.ConsumerId, onsProperties.getConsumerId());
    properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
    properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());
    properties.put(PropertyKeyConst.ConsumeThreadNums, onsProperties.getConsumeThreadNums());

    Map<Subscription, MessageListener> map = new HashMap<>();
    map.put(subscription(), messageListener);
    ConsumerBean consumer = new ConsumerBean();
    consumer.setProperties(properties);
    consumer.setSubscriptionTable(map);
    return consumer;
  }

}
