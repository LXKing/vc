package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.storage.impl.MqttStateStorageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.*;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/21
 * @Time: 15:05
 * @Description: 读取MqttState报文数据通过Phoenix存储到HBASE！
 */
@Component
public class MqttStateConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MqttStateConsumer.class);

    @Autowired
    MqttStateStorageImpl mqttStateStorage;


    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_MQTT_STATE + "}", topics = "${" + KAFKA_TOPIC_MQTT_STATE + "}", containerFactory = "batchFactory")
    public void processNor(List<String> messageList) {
        List<CsState> csStateList = new ArrayList<>();
        for (String message : messageList) {
            CsState csState = JSONObject.parseObject(message, CsState.class);
            if (csState == null) {
                continue;
            }
            csStateList.add(csState);
        }
        try {
            mqttStateStorage.saveOrUpdate(csStateList);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Save nor mqtt data done:" + messageList.size());
    }

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_MQTT_STATE_EXP + "}", topics = "${" + KAFKA_TOPIC_MQTT_STATE_EXP + "}", containerFactory = "batchFactory")
    public void processExp(List<String> messageList) {
        this.processNor(messageList);
        logger.debug("Save exp mqtt data done:" + messageList.size());
    }

}
