package com.ccclubs.admin.task.jobs;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.model.CsState;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.query.CsVehicleQuery;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.service.ICsStateService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.protocol.dto.online.OnlineConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ccclubs.frm.spring.constant.RedisConst.*;

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

    //车辆之前的状态
    private static final Integer PRE_STATUS_OFFLINE = 0;
    private static final Integer PRE_STATUS_ONLINE = 1;

    @Autowired
    ICsVehicleService vehicleService;

    @Autowired
    ICsMachineService machineService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GATEWAY_CONN + "}")
    String connStatusTopic;

    @Override
    public void run() {
        CsVehicleQuery query = new CsVehicleQuery();
        query.setCsvAccessEquals(ACCESS);
        List<CsVehicle> list = vehicleService.getAllByParam(query.getCrieria());
        LOGGER.info("开始处理(ACCESS={}),CS_Vehicle车辆数据 {} 条", ACCESS, list.size());
        for (CsVehicle vehicle : list) {
            if (vehicle.getCsvMachine() != null) {
                CsMachine machine = machineService.selectByPrimaryKey(vehicle.getCsvMachine());
                String mobile = machine.getCsmMobile();
                boolean isOnline = (null != redisTemplate.opsForValue()
                        .get(REDIS_KEY_ONLINE + mobile));
                OnlineConnection onlineConnection = (OnlineConnection) redisTemplate.opsForValue().get(REDIS_KEY_ONLINE + mobile);
                if (vehicle != null) {
                    //之前的状态(默认online)
                    int preStatus = PRE_STATUS_ONLINE;
                    if (redisTemplate.opsForHash().hasKey(REDIS_KEY_TCP_OFFLINE, vehicle.getCsvVin())) {
                        preStatus = PRE_STATUS_OFFLINE;
                    }
                    if (redisTemplate.opsForHash().hasKey(REDIS_KEY_TCP_ONLINE, vehicle.getCsvVin())) {
                        preStatus = PRE_STATUS_ONLINE;
                    }
                    //当前是离线
                    if (!isOnline) {
                        switch (preStatus) {
                            //之前离线
                            case 0:
                                break;
                            //之前在线
                            case 1:
                                sendOffLineEvent(onlineConnection.getMsgLastTime(), vehicle);
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
                                sendOnLineEvent(onlineConnection.getMsgLastTime(), vehicle);
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


        }
    }

    //上线
    private void sendOnLineEvent(Long lastTime, CsVehicle vehicle) {
        ConnOnlineStatusEvent event = new ConnOnlineStatusEvent();
        event.setVin(vehicle.getCsvVin());
        event.setOnline(true);
        event.setTimestamp(lastTime);
        event.setGatewayType("808");
        // 发送到kafka
        kafkaTemplate.send(connStatusTopic, JSONObject.toJSONString(event));
        LOGGER.info("TCP:ONLINE:808" + event.toJson());
    }

    //离线
    private void sendOffLineEvent(Long lastTime, CsVehicle vehicle) {
        ConnOnlineStatusEvent event = new ConnOnlineStatusEvent();
        event.setVin(vehicle.getCsvVin());
        event.setOnline(false);
        event.setTimestamp(lastTime);
        event.setGatewayType("808");
        // 发送到kafka
        kafkaTemplate.send(connStatusTopic, JSONObject.toJSONString(event));
        LOGGER.info("TCP:OFFLINE:808" + event.toJson());
    }
}
