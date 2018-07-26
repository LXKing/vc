package com.ccclubs.engine.rule.inf.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.engine.rule.inf.consumer.handle.SocJumpEventHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.*;


/**
 * 实时计算Event消费者
 *
 * @author jianghaiyang
 * @create 2018-05-08
 **/
@Component
public class StreamEventConsumer {

    @Resource
    SocJumpEventHandler socJumpEventHandler;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_RULE_STREAM_ENERGY_JUMP + "}",
            topics = "${" + KAFKA_TOPIC_STREAM_ENERGY_JUMP + "}", containerFactory = "batchFactory")
    public void process(List<String> records) {
        for (String event : records) {
            JSONObject streamEvent = JSON.parseObject(event);
            String dataType = streamEvent.getString("dataType");
            switch (dataType) {
                case "SocJump":
                    socJumpEventHandler.handleSocJumpEvent(event);
                    break;
                case "LaunchPace":
                    break;
                case "DrivePace":
                    break;
                case "ChargePace":
                    break;
            }

        }
    }
}
