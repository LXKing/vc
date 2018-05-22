package com.ccclubs.engine.rule.inf.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_RULE_GB_ERROR;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_GATEWAY_GB_ERROR;

/**
 * GB错误报文监听处理
 *
 * @author jianghaiyang
 * @create 2018-05-17
 **/
@Component
public class GbErrorMessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GbErrorMessageConsumer.class);

    @Resource
    QueryTerminalService queryTerminalService;

    @Resource
    QueryVehicleService queryVehicleService;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GB_ERROR + "}")
    String topicGBError;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_RULE_GB_ERROR + "}", topics = "${" + KAFKA_TOPIC_GATEWAY_GB_ERROR + "}")
    public void process(String record) {
        ExpMessageDTO dto = JSONObject.parseObject(record, ExpMessageDTO.class);
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(dto.getVin());
        if (Objects.nonNull(csVehicle) && Objects.nonNull(csVehicle.getCsvMachine()) && csVehicle.getCsvMachine() != 0) {
            CsMachine csMachine = queryTerminalService.queryCsMachineByIdFromCache(csVehicle.getCsvMachine());
            dto.setAccess(csVehicle.getCsvAccess());
            dto.setTeNo(csMachine.getCsmTeNo());
            dto.setTeNumber(csMachine.getCsmNumber());
            dto.setIccid(csMachine.getCsmIccid());
            dto.setMobile(csMachine.getCsmMobile());
            dto.setTeType(csMachine.getCsmTeType());
            kafkaTemplate.send(topicGBError, dto.getVin(), dto.toJson());
        } else {
            LOGGER.error("没有绑定车机,vin={}", dto.getVin());
        }
    }
}
