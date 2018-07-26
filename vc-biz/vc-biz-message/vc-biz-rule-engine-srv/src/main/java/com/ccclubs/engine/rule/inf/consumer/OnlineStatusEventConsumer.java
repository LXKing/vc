package com.ccclubs.engine.rule.inf.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.frm.ons.OnsMessageFactory;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.frm.spring.constant.OnsConst;
import com.ccclubs.frm.spring.constant.TboxType;
import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.frm.spring.gateway.GatewayType;
import com.ccclubs.frm.spring.util.BeanMapper;
import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.pub.orm.dto.OnlineStateEventDTO;
import com.ccclubs.pub.orm.dto.StateDTO;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

import static com.ccclubs.engine.core.util.RuleEngineConstant.*;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_RULE_CONN;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_GATEWAY_CONN;
import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_RECENT_STATES;

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
    QueryTerminalService queryTerminalService;

    @Resource
    EnvironmentUtils environmentUtils;

    @Resource
    TerminalUtils terminalUtils;

    @Value("${" + KafkaConst.KAFKA_TOPIC_CONN_EVENT + "}")
    String topicOnlineEvent;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_RULE_CONN + "}",
            topics = "${" + KAFKA_TOPIC_GATEWAY_CONN + "}", containerFactory = "batchFactory")
    public void process(List<String> records) {
        for (String record : records) {
            ConnOnlineStatusEvent event = JSONObject.parseObject(record, ConnOnlineStatusEvent.class);
            // 更新缓存-当前车辆在线情况
            String eventKey;
            switch (event.getGatewayType()) {
                case GatewayType.GATEWAY_GB:
                    eventKey = event.getVin();
                    final MachineMapping mappingGb = terminalUtils.getMapping(eventKey, MACHINEMAPPING_VIN);
                    if (mappingGb != null) {
                        event.setSimNo(StringUtils.isEmpty(mappingGb.getMobile()) ? null : mappingGb.getMobile());
                        event.setTeNumber(StringUtils.isEmpty(mappingGb.getNumber()) ? null : mappingGb.getNumber());
                    }
                    break;
                case GatewayType.GATEWAY_808:
                    eventKey = event.getSimNo();
                    final MachineMapping mapping808 = terminalUtils.getMapping(eventKey, MACHINEMAPPING_SIMNO);
                    Integer carModel = 0;
                    if (mapping808 != null) {
                        event.setVin(StringUtils.isEmpty(mapping808.getVin()) ? null : mapping808.getVin());
                        event.setTeNumber(StringUtils.isEmpty(mapping808.getNumber()) ? null : mapping808.getNumber());
                        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(mapping808.getVin());
                        carModel = csVehicle.getCsvModel();
                    }
                    OnlineStateEventDTO dto = BeanMapper.map(event, OnlineStateEventDTO.class);
                    dto.setCarModel(carModel);
                    CsMachine csMachine = queryTerminalService.queryCsMachineBySimNo(eventKey);
                    //暂时只统计长安的
                    if (csMachine != null && (csMachine.getCsmAccess() == 3 || csMachine.getCsmAccess() == 4 || csMachine.getCsmAccess() == 5)) {
                        dto.setAccess(csMachine.getCsmAccess().shortValue());
                        dto.setIccid(csMachine.getCsmIccid());
                        dto.setTeModelNo(csMachine.getCsmTeModel());
                        dto.setTeNo(csMachine.getCsmTeNo());
                        dto.setTeType(csMachine.getCsmTeType());
                        if (csMachine.getCsmTeType() == TboxType.TL.getValue()) {
                            if (StringUtils.isNotEmpty(csMachine.getCsmTeNo())) {
                                String batchNo = "201" + csMachine.getCsmTeNo().charAt(1) + "-" + csMachine.getCsmTeNo().charAt(2);
                                dto.setBatchNo(batchNo);
                            }
                        }

                        //前30条状态数据,从redis获取
                        List<StateDTO> states = redisTemplate.opsForList()
                                .range(REDIS_KEY_RECENT_STATES + csMachine.getCsmNumber(), 0, -1);
                        dto.setStates(states);
                        //转发kafka
                        kafkaTemplate.send(topicOnlineEvent, dto.getTeNumber(), JSON.toJSONString(dto));
                    }
                    break;
                case GatewayType.GATEWAY_MQTT:
                    eventKey = event.getTeNumber();
                    final MachineMapping mappingMqtt = terminalUtils.getMapping(eventKey, MACHINEMAPPING_CARNUMBER);
                    if (mappingMqtt != null) {
                        event.setVin(StringUtils.isEmpty(mappingMqtt.getVin()) ? null : mappingMqtt.getVin());
                        event.setSimNo(StringUtils.isEmpty(mappingMqtt.getMobile()) ? null : mappingMqtt.getMobile());
                    }
                    break;
                default:
                    break;
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
        CsVehicle csVehicle = null;
        switch (event.getGatewayType()) {
            case GatewayType.GATEWAY_GB:
                csVehicle = queryVehicleService.queryVehicleByVinFromCache(event.getVin());
                break;
            case GatewayType.GATEWAY_808:
                // 根据手机号查询终端信息
                CsMachine csMachine = queryTerminalService.queryCsMachineBySimNo(event.getSimNo());
                if (Objects.nonNull(csMachine)) {
                    csVehicle = queryVehicleService.queryVehicleByMachineFromCache(csMachine.getCsmId());
                }
                break;
            case GatewayType.GATEWAY_MQTT:
                CsMachine csMachineMqtt = queryTerminalService.queryCsMachineByTeNo(event.getTeNumber());
                if (Objects.nonNull(csMachineMqtt)) {
                    csVehicle = queryVehicleService.queryVehicleByMachineFromCache(csMachineMqtt.getCsmId());
                }
                break;
            default:
                break;
        }
        if (csVehicle != null && (csVehicle.getCsvAccess() == 3 || csVehicle.getCsvAccess() == 4 || csVehicle.getCsvAccess() == 5)) {

            SrvHost srvHost = queryHostService.queryHostByIdFromCache(csVehicle.getCsvAccess());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("vin", event.getVin());
            jsonObject.put("timestamp", event.getTimestamp());
            jsonObject.put("online", event.isOnline());

            /*// 记录终端在线情况
            redisTemplate.opsForValue().set(ConstantUtils.ONLINE_REDIS_PRE + event.getSimNo(),
                    new OnlineConnection(event.getSimNo(), event.getClientIp(), event.getServerIp(),
                            System.currentTimeMillis()),
                    ConstantUtils.ONLINE_IDE_TIME, TimeUnit.MILLISECONDS);*/
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
