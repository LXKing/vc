package com.ccclubs.engine.rule.inf.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.ons.OnsMessageFactory;
import com.ccclubs.frm.spring.constant.OnsConst;
import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_RULE_CONN;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_GATEWAY_CONN;
import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_TCP_OFFLINE;
import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_TCP_ONLINE;

/**
 * 车辆上下线监听
 * 数据来自Gateway
 *
 * @author jianghaiyang
 * @create 2018-05-10
 **/
@Component
public class OnlineStatusEventConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnlineStatusEventConsumer.class);

    //长安
    private static final Integer ACCESS = 3;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name = "producer")
    private Producer client;

    @Resource
    QueryAppInfoService queryHostService;

    @Resource
    QueryVehicleService queryVehicleService;

    @Resource
    EnvironmentUtils environmentUtils;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_RULE_CONN + "}",
            topics = "${" + KAFKA_TOPIC_GATEWAY_CONN + "}", containerFactory = "batchFactory")
    public void process(List<String> records) {
        for (String record : records) {
            ConnOnlineStatusEvent event = JSONObject.parseObject(record, ConnOnlineStatusEvent.class);
            // 更新缓存-当前车辆在线情况
            if (event.isOnline()) {
                redisTemplate.opsForHash().delete(REDIS_KEY_TCP_OFFLINE + ":" + event.getGatewayType(), event.getVin());
                redisTemplate.opsForHash().put(REDIS_KEY_TCP_ONLINE + ":" + event.getGatewayType(), event.getVin(), event);
            } else {
                redisTemplate.opsForHash().delete(REDIS_KEY_TCP_ONLINE + ":" + event.getGatewayType(), event.getVin());
                redisTemplate.opsForHash().put(REDIS_KEY_TCP_OFFLINE + ":" + event.getGatewayType(), event.getVin(), event);
            }
            //转发上下线事件到业务平台
            transferToOns(event);
        }
    }

    /**
     * 当前只转发到长安业务ONS
     *
     * @param event
     */
    private void transferToOns(ConnOnlineStatusEvent event) {
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(event.getVin());
        if (csVehicle.getCsvAccess() == ACCESS) {
            SrvHost srvHost = queryHostService.queryHostByIdFromCache(csVehicle.getCsvAccess());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("vin", event.getVin());
            jsonObject.put("timestamp", event.getTimestamp());
            jsonObject.put("online", event.isOnline());
            // 发送到ONS（长安业务组平台）
            try {
                Message onsMessage = OnsMessageFactory.getProtocolMessage(srvHost.getShTopic().trim(),
                        OnsConst.ONS_TAG_PREFIX_CONN_STATE + csVehicle.getCsvAccess(),
                        JSON.toJSONBytes(jsonObject));
                if (environmentUtils.isProdEnvironment()) {
                    client.sendOneway(onsMessage);
                } else {
                    LOGGER.debug(jsonObject.toJSONString());
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
}
