package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.pub.orm.dto.Jt808PositionData;
import com.ccclubs.storage.impl.Jt808StorageImpl;
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
 * @Date: 2018/5/10
 * @Time: 16:15
 * @Description: 读取Jt808报文数据通过Phoenix存储到HBASE！
 */
@Component
public class Jt808Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Jt808Consumer.class);

    @Autowired
    Jt808StorageImpl jt808Storage;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_JT_POSITION + "}", topics = "${" + KAFKA_TOPIC_JT_POSITION + "}", containerFactory = "batchFactory")
    public void processNor(List<String> messageList) {
        List<Jt808PositionData> jt808PositionDataList = new ArrayList<>();
        for (String message : messageList) {
            Jt808PositionData jt808PositionData = JSONObject.parseObject(message, Jt808PositionData.class);
            if (jt808PositionData == null) {
                continue;
            }
            jt808PositionDataList.add(jt808PositionData);
        }
        try {
            jt808Storage.saveOrUpdate(jt808PositionDataList);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Save nor jt808 data done:"+messageList.size());
    }

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_JT_POSITION_EXP + "}", topics = "${" + KAFKA_TOPIC_JT_POSITION_EXP + "}", containerFactory = "batchFactory")
    public void processExp(List<String> messageList) {
        this.processNor(messageList);
        logger.debug("Save exp jt808 data done:"+messageList.size());
    }

}
