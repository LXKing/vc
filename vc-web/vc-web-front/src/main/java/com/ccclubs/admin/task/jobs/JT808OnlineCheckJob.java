package com.ccclubs.admin.task.jobs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.admin.model.CsState;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.SrvHost;
import com.ccclubs.admin.query.CsStateQuery;
import com.ccclubs.admin.service.ICsStateService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.service.ISrvHostService;
import com.ccclubs.frm.ons.OnsMessageFactory;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.frm.spring.constant.OnsConst;
import com.ccclubs.frm.spring.util.EnvironmentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_TCP_OFFLINE;
import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_TCP_ONLINE;

/**
 * 808车辆在线情况定时检查
 *
 * @author jianghaiyang
 * @create 2018-05-05
 **/
@Service
public class JT808OnlineCheckJob implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(JT808OnlineCheckJob.class);

    //长安
    private static final Integer ACCESS = 3;
    private static final Long OFFLINE_MILLIS_THRESHOLD = 6 * 60 * 1000L;
    //车辆之前的状态
    private static final Integer PRE_STATUS_OFFLINE = 0;
    private static final Integer PRE_STATUS_ONLINE = 1;

    @Autowired
    ICsStateService stateService;

    @Autowired
    ICsVehicleService vehicleService;

    @Autowired
    ISrvHostService hostService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GATEWAY_CONN + "}")
    String connStatusTopic;

    @Resource(name = "onsPublishClient")
    private Producer client;

    @Autowired
    EnvironmentUtils environmentUtils;

    @Override
    public void run() {
        CsStateQuery query = new CsStateQuery();
        query.setCssAccessEquals(ACCESS.shortValue());
        List<CsState> list = stateService.getAllByParam(query.getCrieria());
        for (CsState state : list) {
            long between = System.currentTimeMillis() - state.getCssCurrentTime().getTime();
            //之前的状态(默认online)
            int preStatus = PRE_STATUS_ONLINE;
            if (redisTemplate.opsForHash().hasKey(REDIS_KEY_TCP_OFFLINE, state.getCssCar().toString())) {
                preStatus = PRE_STATUS_OFFLINE;
            }
            if (redisTemplate.opsForHash().hasKey(REDIS_KEY_TCP_ONLINE, state.getCssCar().toString())) {
                preStatus = PRE_STATUS_ONLINE;
            }
            //当前是离线
            if (between >= OFFLINE_MILLIS_THRESHOLD) {
                switch (preStatus) {
                    //之前离线
                    case 0:
                        break;
                    //之前在线
                    case 1:
                        redisTemplate.opsForHash().delete(REDIS_KEY_TCP_ONLINE, state.getCssCar().toString(), state.getCssCurrentTime());
                        redisTemplate.opsForHash().put(REDIS_KEY_TCP_OFFLINE, state.getCssCar().toString(), state.getCssCurrentTime());
                        sendOffLineEvent(state);
                        break;
                    default:
                        break;
                }
            }
            //当前是在线
            else {
                switch (preStatus) {
                    //之前离线
                    case 0:
                        redisTemplate.opsForHash().delete(REDIS_KEY_TCP_OFFLINE, state.getCssCar().toString(), state.getCssCurrentTime());
                        redisTemplate.opsForHash().put(REDIS_KEY_TCP_ONLINE, state.getCssCar().toString(), state.getCssCurrentTime());
                        sendOnLineEvent(state);
                        break;
                    //之前在线
                    case 1:
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void sendOnLineEvent(CsState state) {
        SrvHost srvHost = hostService.selectByPrimaryKey(ACCESS);
        CsVehicle vehicle = vehicleService.selectByPrimaryKey(state.getCssCar());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("vin", vehicle.getCsvVin());
        jsonObject.put("timestamp", state.getCssCurrentTime());
        jsonObject.put("online", true);
        // 发送到kafka
        //kafkaTemplate.send(connStatusTopic, jsonObject.toJSONString());
        // 发送到ONS（长安业务组平台）
        Message onsMessage = OnsMessageFactory.getProtocolMessage(srvHost.getShTopic().trim(),
                OnsConst.ONS_TAG_PREFIX_CONN_STATE + ACCESS,
                JSON.toJSONBytes(jsonObject));
        if (environmentUtils.isProdEnvironment()) {
            client.sendOneway(onsMessage);
        } else {
            LOGGER.debug(jsonObject.toJSONString());
        }
    }

    private void sendOffLineEvent(CsState state) {
        SrvHost srvHost = hostService.selectByPrimaryKey(ACCESS);
        CsVehicle vehicle = vehicleService.selectByPrimaryKey(state.getCssCar());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("vin", vehicle.getCsvVin());
        jsonObject.put("timestamp", state.getCssCurrentTime());
        jsonObject.put("online", false);
        // 发送到kafka
        //kafkaTemplate.send(connStatusTopic, jsonObject.toJSONString());
        // 发送到ONS（长安业务组平台）
        Message onsMessage = OnsMessageFactory.getProtocolMessage(srvHost.getShTopic().trim(),
                OnsConst.ONS_TAG_PREFIX_CONN_STATE + ACCESS,
                JSON.toJSONBytes(jsonObject));
        if (environmentUtils.isProdEnvironment()) {
            client.sendOneway(onsMessage);
        } else {
            LOGGER.debug(jsonObject.toJSONString());
        }
    }
}
