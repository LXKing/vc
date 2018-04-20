package com.ccclubs.storage.tasks.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.pub.orm.model.CsCan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @KafkaListener(id = "${kafka.consumer.group.storage}", topics = "${kafka.topic.cscan}")
    public void processCanStorage(List<String> messageList){
        List<CsCan> csCanList=new ArrayList<>();
        for (String message:messageList){
            CsCan csCan=JSONObject.parseObject(message,CsCan.class);
            if (csCan==null){continue;}
            csCanList.add(csCan);
        }


    }

}
