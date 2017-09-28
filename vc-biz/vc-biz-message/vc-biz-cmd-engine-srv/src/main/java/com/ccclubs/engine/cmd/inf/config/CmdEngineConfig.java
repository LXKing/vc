package com.ccclubs.engine.cmd.inf.config;

import com.aliyun.openservices.ons.api.*;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import com.ccclubs.engine.cmd.inf.IMqAckService;
import com.ccclubs.engine.cmd.inf.MqManager;
import com.ccclubs.engine.cmd.inf.impl.MqAckService;
import com.ccclubs.engine.cmd.inf.impl.MqMessageListener;
import com.ccclubs.engine.cmd.inf.impl.OperationMessageProcessService;
import com.ccclubs.engine.cmd.inf.impl.ParseOperationService;
import com.ccclubs.frm.mqtt.MqttAliyunProperties;
import com.ccclubs.frm.mqtt.MqttOwnProperties;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.inf.impl.MqMqttClient;
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
import org.springframework.context.annotation.Primary;

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
    private MqttAliyunProperties mqttAliyunProperties;
    @Autowired
    private MqttOwnProperties mqttOwnProperties;
    @Autowired
    private OnsProperties onsProperties;

    /**
     * 主要是用于JT808远程控制
     *
     * @return
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

    /**
     * 主要是用于自有MQTT远程控制
     *
     * @return
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
        return ownMqClient;
    }

    @Bean(name = "ackService")
    public IMqAckService ackService() {
        MqAckService ackService = new MqAckService();
        return ackService;
    }

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
        mqMessageProcessService.setMqAckService(ackService());
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

    @Bean(name = "consumer", initMethod = "start", destroyMethod = "shutdown")
    @Qualifier(value = "messageListener")
    public Consumer consumer(MessageListener messageListener) {
        logger.info("init consumer...");
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

    @Bean(name = "mqManager", initMethod = "startServer", destroyMethod = "stopServer")
    @Qualifier(value = "ackService")
    public MqManager mqManager(IMqAckService ackService) {
        MqManager mqManager = new MqManager();
        mqManager.setMqClient(mqClient());
        mqManager.setMqClient(mqttClient());
        mqManager.setMqAckService(ackService);

        return mqManager;
    }
}
