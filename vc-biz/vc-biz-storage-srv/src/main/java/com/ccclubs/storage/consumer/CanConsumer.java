package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.storage.impl.CanStorageImpl;
import com.ccclubs.storage.util.StorageThreadPool;
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
 * @Date: 2018/4/20
 * @Time: 13:54
 * @Description: 读取can报文数据通过Phoenix存储到HBASE！
 */
@Component
public class CanConsumer{

    private static final Logger logger = LoggerFactory.getLogger(CanConsumer.class);

    @Autowired
    CanStorageImpl canStorage;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_CAN + "}", topics = "${" + KAFKA_TOPIC_CAN + "}", containerFactory = "batchFactory")
    public void processNor(List<String> messageList) {
        CanRunner canRunner=new CanRunner(messageList);
        StorageThreadPool.getThreadPool().execute(canRunner);
    }

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_CAN_EXP + "}", topics = "${" + KAFKA_TOPIC_CAN_EXP + "}", containerFactory = "batchFactory")
    public void processExp(List<String> messageList) {
        this.processNor(messageList);
        logger.debug("Save exp can data done:" + messageList.size());
    }



    class CanRunner implements Runnable{
        private List<String> messageList;

        public CanRunner(List<String> messageList) {
            this.messageList = messageList;
        }

        @Override
        public void run() {
            List<CsCan> csCanList = new ArrayList<>();
            for (String message : messageList) {
                CsCan csCan = JSONObject.parseObject(message, CsCan.class);
                if (csCan == null) {
                    continue;
                }
                csCanList.add(csCan);
            }
            try {
                canStorage.saveOrUpdate(csCanList);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            logger.debug("Save nor can data done:" + csCanList.size());
        }
    }

}
