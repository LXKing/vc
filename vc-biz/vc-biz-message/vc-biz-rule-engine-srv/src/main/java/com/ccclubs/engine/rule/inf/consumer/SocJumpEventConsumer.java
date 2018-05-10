package com.ccclubs.engine.rule.inf.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.rule.inf.dto.stream.SocJumpEvent;
import com.ccclubs.frm.spring.constant.OnsConst;
import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.SrvHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_RULE_STREAM_JUMP_SOC;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_STREAM_JUMP_SOC;


/**
 * 电池跳变Event消费者
 *
 * @author jianghaiyang
 * @create 2018-05-08
 **/
@Component
public class SocJumpEventConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocJumpEventConsumer.class);
    @Resource
    MessageFactory messageFactory;

    @Resource
    QueryAppInfoService queryHostInfoService;

    @Resource
    EnvironmentUtils environmentUtils;

    @Resource(name = "producer")
    private Producer client;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_RULE_STREAM_JUMP_SOC + "}",
            topics = "${" + KAFKA_TOPIC_STREAM_JUMP_SOC + "}", containerFactory = "batchFactory")
    public void process(List<String> records) {
        for (String event : records) {
            SocJumpEvent jumpEventObject = JSONObject.parseObject(event, SocJumpEvent.class);
            SrvHost srvHost = queryHostInfoService.queryHostByIdFromCache(jumpEventObject.getAccess());
            Message mqMessage = messageFactory
                    .getMessage(srvHost.getShTopic().trim(),
                            OnsConst.ONS_TAG_PREFIX_SOC_JUMP + jumpEventObject.getAccess(),
                            event.getBytes());
            if (mqMessage != null) {
                mqMessage
                        .setKey(
                                jumpEventObject.getVin() + "_" + StringUtils
                                        .date(new Date(), ConstantUtils.TIME_FORMAT));
                if (environmentUtils.isProdEnvironment()) {
                    client.sendOneway(mqMessage);
                } else {
                    LOGGER.debug(JSON.toJSONString(event));
                }
            } else {
                LOGGER.error(jumpEventObject.getVin() + " 未授权给应用");
            }
        }
    }
}
