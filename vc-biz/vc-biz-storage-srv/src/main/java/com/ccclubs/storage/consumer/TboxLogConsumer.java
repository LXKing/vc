package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.pub.orm.dto.TboxLog;
import com.ccclubs.storage.impl.Jt808ErrorMessageStorageImpl;
import com.ccclubs.storage.impl.TboxLogStorageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.*;

/**
 * Gb错误报文消费
 *
 * @author jianghaiyang
 * @create 2018-05-22
 **/
@Component
public class TboxLogConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(TboxLogConsumer.class);

    @Autowired
    TboxLogStorageImpl tboxLogStorage;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_TBOX_LOG + "}", topics = "${" + KAFKA_TOPIC_TBOX_LOG + "}", containerFactory = "batchFactory")
    public void processNor(List<String> messageList) {
        List<TboxLog> list = new ArrayList<>();
        for (String message : messageList) {
            TboxLog expMessageDTO = JSONObject.parseObject(message, TboxLog.class);
            if (expMessageDTO == null) {
                continue;
            }
            list.add(expMessageDTO);
        }
        try {
            tboxLogStorage.saveOrUpdate(list);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        LOGGER.debug("Save nor tbox data done:" + messageList.size());
    }

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_TBOX_LOG_EXP + "}", topics = "${" + KAFKA_TOPIC_TBOX_LOG_EXP + "}", containerFactory = "batchFactory")
    public void processExp(List<String> messageList) {
        this.processNor(messageList);
        LOGGER.debug("Save exp tbox data done:"+messageList.size());
    }
}
