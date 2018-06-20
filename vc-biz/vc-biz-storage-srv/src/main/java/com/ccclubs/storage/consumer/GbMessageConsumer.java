package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.pub.orm.dto.CsMessage;
import com.ccclubs.storage.impl.GbMessageStorageImpl;
import com.ccclubs.storage.util.StorageThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_STORAGE_GB_MESSAGE;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_GB_MESSAGE;

/**
 * GB实时报文存入HBase
 *
 * @author jianghaiyang
 * @create 2018-04-20
 **/
@Component
public class GbMessageConsumer{

    private static final Logger logger = LoggerFactory.getLogger(GbMessageConsumer.class);

    @Autowired
    GbMessageStorageImpl gbMessageStorage;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_GB_MESSAGE + "}", topics = "${" + KAFKA_TOPIC_GB_MESSAGE + "}", containerFactory = "batchFactory")
    public void processNor(List<String> messageList) {
        GbMessageRunner gbMessageRunner=new GbMessageRunner(messageList);
        StorageThreadPool.getThreadPool().execute(gbMessageRunner);
    }



    class GbMessageRunner implements Runnable{
        private List<String> messageList;

        public GbMessageRunner(List<String> messageList) {
            this.messageList = messageList;
        }

        @Override
        public void run() {
            List<CsMessage> csMessageList = new ArrayList<>();
            for (String message : messageList) {
                CsMessage csMessage = JSONObject.parseObject(message, CsMessage.class);
                if (csMessage == null) {
                    continue;
                }
                csMessageList.add(csMessage);
            }
            try {
                gbMessageStorage.saveOrUpdate(csMessageList);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            logger.debug("Save nor gbMessage data done:" + messageList.size());
        }
    }

}
