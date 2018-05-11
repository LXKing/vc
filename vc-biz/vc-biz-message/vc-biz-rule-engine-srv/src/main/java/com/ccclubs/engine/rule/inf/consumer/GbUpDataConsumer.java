package com.ccclubs.engine.rule.inf.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.engine.rule.inf.IParseGbDataService;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.gb.GBMessageType;
import com.ccclubs.protocol.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_RULE_GB_SUCCESS;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_GATEWAY_GB_SUCCESS;

/**
 * 消费所有Gb网关上报的数据（正常数据）
 *
 * @author jianghaiyang
 * @create 2018-05-09
 **/
@Component
public class GbUpDataConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(GbUpDataConsumer.class);

    @Value("${" + KafkaConst.KAFKA_TOPIC_GB_LOGIN + "}")
    String topicGBLogin;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GB_REAL + "}")
    String topicGBReal;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GB_REISSUE + "}")
    String topicGBReissue;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GB_LOGOUT + "}")
    String topicGBLogout;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GB_HEART + "}")
    String topicGBHeart;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GB_TIME + "}")
    String topicGBTime;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Resource
    IParseGbDataService parseGbDataService;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_RULE_GB_SUCCESS + "}",
            topics = "${" + KAFKA_TOPIC_GATEWAY_GB_SUCCESS + "}", containerFactory = "batchFactory")
    public void process(List<String> records) {
        for (String record : records) {
            JSONObject gbMessage = JSONObject.parseObject(record);
            Integer dataType = (Integer) gbMessage.get("code");
            String vin = (String) gbMessage.get("vin");
            switch (dataType) {
                case GBMessageType.GB_MSG_TYPE_0X01:
                    break;
                case GBMessageType.GB_MSG_TYPE_0X02:
                    kafkaTemplate.send(topicGBReal, vin, record);
                    // write redis
                    processGbRtMsg(gbMessage.get("sourceHex").toString());
                    break;
                case GBMessageType.GB_MSG_TYPE_0X03:
                    break;
                case GBMessageType.GB_MSG_TYPE_0X04:
                    break;
                case GBMessageType.GB_MSG_TYPE_0X07:
                    break;
                case GBMessageType.GB_MSG_TYPE_0X08:
                    break;
            }
            processGbAllMsg(gbMessage.get("sourceHex").toString());
        }
    }

    private void processGbRtMsg(String sourceHex) {
        GBMessage gbMessage = new GBMessage();
        gbMessage.ReadFromBytes(Tools.HexString2Bytes(sourceHex));
        parseGbDataService.processRtMessage(gbMessage);
    }

    private void processGbAllMsg(String sourceHex) {
        GBMessage gbMessage = new GBMessage();
        gbMessage.ReadFromBytes(Tools.HexString2Bytes(sourceHex));
        parseGbDataService.processAllMessage(gbMessage);
    }
}
