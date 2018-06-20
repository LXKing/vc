package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.storage.impl.GbErrorMessageStorageImpl;
import com.ccclubs.storage.util.StorageThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_STORAGE_GB_ERROR;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_GB_ERROR;

/**
 * Gb错误报文消费
 *
 * @author jianghaiyang
 * @create 2018-05-22
 **/
@Component
public class GbErrorMessageConsumer{
    private static final Logger LOGGER = LoggerFactory.getLogger(GbErrorMessageConsumer.class);

    @Autowired
    GbErrorMessageStorageImpl gbErrorMessageStorage;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_GB_ERROR + "}", topics = "${" + KAFKA_TOPIC_GB_ERROR + "}", containerFactory = "batchFactory")
    public void processNor(List<String> messageList) {

        GbErrorMessageRunner gbErrorMessageRunner =
                new GbErrorMessageRunner(messageList);
        StorageThreadPool.getThreadPool().execute(gbErrorMessageRunner);

    }

    class GbErrorMessageRunner implements Runnable{

        private List<String> messageList;

        public GbErrorMessageRunner(List<String> messageList) {
            this.messageList = messageList;
        }

        @Override
        public void run() {
            List<ExpMessageDTO> expMessageDTOList = new ArrayList<>();
            for (String message : messageList) {
                ExpMessageDTO expMessageDTO = JSONObject.parseObject(message, ExpMessageDTO.class);
                if (expMessageDTO == null) {
                    continue;
                }
                expMessageDTOList.add(expMessageDTO);
            }
            try {
                gbErrorMessageStorage.saveOrUpdate(expMessageDTOList);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
            LOGGER.debug("Save nor gbMessage data done:" + messageList.size());
        }
    }

}
