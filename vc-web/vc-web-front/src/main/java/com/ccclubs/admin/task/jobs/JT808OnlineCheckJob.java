package com.ccclubs.admin.task.jobs;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.admin.model.CsState;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.query.CsStateQuery;
import com.ccclubs.admin.service.ICsStateService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

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
    RedisTemplate redisTemplate;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GATEWAY_CONN + "}")
    String connStatusTopic;

    @Override
    public void run() {
        CsStateQuery query = new CsStateQuery();
        query.setCssAccessEquals(ACCESS.shortValue());
        List<CsState> list = stateService.getAllByParam(query.getCrieria());
        LOGGER.info("开始处理(ACCESS={}),CS_STATE状态数据 {} 条", ACCESS, list.size());
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

    //上线
    private void sendOnLineEvent(CsState state) {
        CsVehicle vehicle = vehicleService.selectByPrimaryKey(state.getCssCar());
        ConnOnlineStatusEvent event = new ConnOnlineStatusEvent();
        event.setVin(vehicle.getCsvVin());
        event.setOnline(true);
        event.setTimestamp(state.getCssCurrentTime().getTime());
        event.setGatewayType("808");
        // 发送到kafka
        kafkaTemplate.send(connStatusTopic, JSONObject.toJSONString(event));
    }

    //离线
    private void sendOffLineEvent(CsState state) {
        CsVehicle vehicle = vehicleService.selectByPrimaryKey(state.getCssCar());
        ConnOnlineStatusEvent event = new ConnOnlineStatusEvent();
        event.setVin(vehicle.getCsvVin());
        event.setOnline(false);
        event.setTimestamp(state.getCssCurrentTime().getTime());
        event.setGatewayType("808");
        // 发送到kafka
        kafkaTemplate.send(connStatusTopic, JSONObject.toJSONString(event));
    }
}
