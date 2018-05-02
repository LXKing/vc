package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.storage.tasks.processor.HistoryCanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_STORAGE_CAN;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_CS_CAN;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/20
 * @Time: 13:54
 * @Description: 读取can报文数据通过Phoenix存储到HBASE！
 */
@Component
public class CanConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CanConsumer.class);

    @Autowired
    HistoryCanUtils historyCanUtils;

    //@KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_CAN + "}", topics = "${" + KAFKA_TOPIC_CS_CAN + "}", containerFactory = "batchFactory")
    public void processCanStorage(List<String> messageList){
        List<CsCan> csCanList=new ArrayList<>();
        for (String message:messageList){
            CsCan csCan=JSONObject.parseObject(message,CsCan.class);
            if (csCan==null){continue;}
            csCanList.add(csCan);
        }

        try {
            historyCanUtils.saveHistoryDataToHbase(csCanList);
        }catch (Exception e){
            logger.error(e.getMessage());
        }


    }

}
