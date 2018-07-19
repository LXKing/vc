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
    @Autowired
    private OnsProperties onsProperties;

    /**
     * ons消息生产者配置
     *
     * @return
     */
    @Bean(name = "producer", initMethod = "start", destroyMethod = "shutdown")
    public Producer producer() {
        Properties properties = new Properties();
        //生产者ID
        properties.put(PropertyKeyConst.ProducerId, onsProperties.getProducerId());
        //AccessKey
        properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
        //SecretKey
        properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());
        return ONSFactory.createProducer(properties);
    }

    /**
     * 处理数据服务
     *
     * @return
     */
    @Bean(name = "terminalParseService")
    @Qualifier(value = "producer")
    public IParseDataService parseDataService(Producer producer) {
        ParseOperationService terminalParseService = new ParseOperationService();
        //设置生产者
        terminalParseService.setClient(producer);
        return terminalParseService;
    }

    @Bean(name = "terminalProcessService")
    @Qualifier(value = "terminalParseService")
    public IMqMessageProcessService mqMessageProcessService(IParseDataService terminalParseService) {
        OperationMessageProcessService mqMessageProcessService = new OperationMessageProcessService();
        //注入消息解析服务
        mqMessageProcessService.setParseDataService(terminalParseService);
        return mqMessageProcessService;
    }

    //ons消息消费者消息处理服务
    @Bean(name = "messageListener")
    @Qualifier(value = "terminalProcessService")
    public MessageListener messageListener(IMqMessageProcessService terminalProcessService) {
        MqMessageListener messageListener = new MqMessageListener();
        //注入消息处理服务
        messageListener.setMqMessageProcessService(terminalProcessService);
        return messageListener;
    }

    @Bean(name = "subscription")
    public Subscription subscription() {
        Subscription subscription = new Subscription();
        //订阅的topic
        subscription.setTopic(onsProperties.getTopic());
        //订阅的tag
        subscription.setExpression(onsProperties.getExpression());
        return subscription;
    }

    @Bean(name = "concumer", initMethod = "start", destroyMethod = "shutdown")
    @Qualifier(value = "messageListener")
    public Consumer concumer(MessageListener messageListener) {
        Properties properties = new Properties();
        //消费者ID
        properties.put(PropertyKeyConst.ConsumerId, onsProperties.getConsumerId());
        //AccessKey
        properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
        //SecretKey
        properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());
        //消费者线程数
        properties.put(PropertyKeyConst.ConsumeThreadNums, onsProperties.getConsumeThreadNums());
        Map<Subscription, MessageListener> map = new HashMap<>();
        map.put(subscription(), messageListener);
        ConsumerBean consumer = new ConsumerBean();
        consumer.setProperties(properties);
        consumer.setSubscriptionTable(map);
        return consumer;
    }

}
