package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.storage.tasks.processor.HistoryStateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_STORAGE_STATE;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_CS_STATE;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/21
 * @Time: 15:05
 * @Description: 请填写描述！
 */
@Component
public class CsStateConsumer {
    private static final Logger logger = LoggerFactory.getLogger(CsStateConsumer.class);

    @Autowired
    HistoryStateUtils historyStateUtils;
    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_STATE + "}", topics = "${" + KAFKA_TOPIC_CS_STATE + "}", containerFactory = "batchFactory")
    public void processCanStorage(List<String> messageList){
        List<CsState> csStateList=new ArrayList<>();
        for (String message:messageList){
            CsState csState= JSONObject.parseObject(message,CsState.class);
            if (csState==null){continue;}
            csStateList.add(csState);
        }

        historyStateUtils.saveHistoryDataToHbase(csStateList);

    }



}
