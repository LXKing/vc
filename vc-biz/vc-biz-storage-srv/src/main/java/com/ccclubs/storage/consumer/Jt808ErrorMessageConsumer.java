package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.storage.impl.Jt808ErrorMessageStorageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_STORAGE_808_ERROR;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_808_ERROR;

/**
 * Gb错误报文消费
 *
 * @author jianghaiyang
 * @create 2018-05-22
 **/
@Component
public class Jt808ErrorMessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Jt808ErrorMessageConsumer.class);

    @Autowired
    Jt808ErrorMessageStorageImpl jt808ErrorMessageStorage;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_808_ERROR + "}", topics = "${" + KAFKA_TOPIC_808_ERROR + "}")
    public void processNor(String message) {
        List<ExpMessageDTO> expMessageDTOList = new ArrayList<>();
        ExpMessageDTO expMessageDTO = JSONObject.parseObject(message, ExpMessageDTO.class);
        if (expMessageDTO == null) {
            return;
        }
        expMessageDTOList.add(expMessageDTO);
        try {
            jt808ErrorMessageStorage.saveOrUpdate(expMessageDTOList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
