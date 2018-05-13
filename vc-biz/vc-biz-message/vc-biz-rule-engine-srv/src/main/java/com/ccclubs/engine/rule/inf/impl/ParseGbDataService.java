package com.ccclubs.engine.rule.inf.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.rule.inf.IParseGbDataService;
import com.ccclubs.frm.logger.VehicleControlLogger;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.frm.spring.constant.RedisConst;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.gb.GBMessageType;
import com.ccclubs.protocol.dto.gb.GB_02;
import com.ccclubs.protocol.dto.gb.GB_02_01;
import com.ccclubs.protocol.dto.transform.TerminalNotRegister;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagProperty;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.dto.CsMessage;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 处理国标信息 Created by qsxiaogang on 2017/3/7.
 * modify by jhy on 2018.5.9
 */
@Component
public class ParseGbDataService implements IParseGbDataService {

    private static final Logger logger = LoggerFactory.getLogger(ParseGbDataService.class);
    private static final Logger loggerBusiness = VehicleControlLogger.getLogger();

    @Resource(name = "producer")
    private Producer client;

    @Resource
    MessageFactory messageFactory;

    @Value("${" + ConstantUtils.MQ_TOPIC + "}")
    String topic;

    @Value("${" + KafkaConst.KAFKA_TOPIC_GB_MESSAGE + "}")
    String kafkaTopicCsMessage;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Resource
    QueryVehicleService queryVehicleService;

    @Resource
    QueryTerminalService queryTerminalService;

    // 只转发到“15: 终端符合性对接”
    private static final int ACCESS_TO_TRANSFER_ONS = 15;

    // TODO:V10车型，2017年生产的车辆
    private int V10_MODEL = 22;
    private Date V10_MAX_PROD_DATE = new Date(1514736000000L);

    @Override
    public void processRtMessage(GBMessage message) {
        // GB实时状态数据存入redis
        if (message.getMessageType() == GBMessageType.GB_MSG_TYPE_0X02) {
            redisTemplate.opsForHash()
                    .put(RedisConst.REDIS_KEY_RT_STATES_HASH, message.getVin(), message.getPacketDescr());
            redisTemplate.opsForZSet().add(RedisConst.REDIS_KEY_RT_STATES_ZSET, message.getVin(),
                    DateTimeUtil
                            .date2UnixFormat(message.getMessageContents().getTime(), DateTimeUtil.UNIX_FORMAT));
        }
    }

    @Override
    public void processAllMessage(GBMessage message) {
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(message.getVin());

        if (null == csVehicle) {
            loggerBusiness.info(
                    JSON.toJSONString(
                            new TerminalNotRegister(message.getVin(), "GB", "国标协议终端，当前在线，但系统中不存在，请排查原因 ",
                                    message.getPacketDescr())));
            return;
        }
        CsMachine csMachine = queryTerminalService.queryCsMachineByIdFromCache(csVehicle.getCsvMachine());
        // add at 2018-03-06 ，V10车型，2017年生产的车辆，累计里程在充电时，存在跳变，实时数据为0时，平台需要矫正，加入最后一次最新里程，详情见V10车型产品王杰邮件
        message = correctionObdMiles(message, csVehicle);

        // 转发ONS
        transferToMq(message, csVehicle);

        CsMessage csMessage = new CsMessage();
        csMessage.setCsmAccess(csVehicle.getCsvAccess());
        csMessage.setCsmCar(csVehicle.getCsvId().longValue());
        csMessage.setCsmVin(message.getVin());
        // 加入车机号 add by jhy 2018.5.8
        csMessage.setCsmNumber(csMachine == null ? null : csMachine.getCsmNumber());
        csMessage.setTeNo(csMachine == null ? null : csMachine.getCsmTeNo());
        csMessage.setIccid(csMachine == null ? null : csMachine.getCsmIccid());
        csMessage.setMobile(csMachine == null ? null : csMachine.getCsmMobile());
        csMessage.setCsmNumber(csMachine == null ? null : csMachine.getCsmNumber());
        csMessage.setCsmProtocol((short) 0);
        csMessage.setCsmType((short) message.getMessageType());
        csMessage.setCsmVerify(StringUtils.empty(message.getErrorMessage()) ? (short) 1 : 0);
        if (message.getMessageContents() != null) {
            csMessage
                    .setCsmMsgTime(
                            StringUtils.date(message.getMessageContents().getTime(), "yyyy-MM-dd HH:mm:ss")
                                    .getTime());
        }
        csMessage.setCsmAddTime(System.currentTimeMillis());
        csMessage.setCsmData(message.getPacketDescr());
        csMessage.setCsmStatus((short) 1);
        // TODO 车机号不存在，转到kafka异常数据通道
        kafkaTemplate.send(kafkaTopicCsMessage, JSONObject.toJSONString(csMessage));
    }

    /**
     * add at 2018-03-06 ，V10车型，2017年生产的车辆，累计里程在充电时，存在跳变，实时数据为0时，平台需要矫正，加入最后一次最新里程，详情见V10车型产品王杰
     * 2018年3月2日 (周五) 14:11 邮件
     * ad at 2018-03-06 18:57
     *
     * @param message 待转换的国标数据
     */
    private GBMessage correctionObdMiles(final GBMessage message, final CsVehicle csVehicle) {
        GBMessage correctionMessage = message;
        // 仅针对V10
        if (V10_MODEL != csVehicle.getCsvModel()) {
            return correctionMessage;
        }
        // 2017年生产的车辆
        if (null == csVehicle.getCsvProdDate() || csVehicle.getCsvProdDate()
                .after(V10_MAX_PROD_DATE)) {
            return correctionMessage;
        }

        if (null == message.getMessageContents()) {
            return correctionMessage;
        }

        // 开始处理实时数据
        if (GBMessageType.GB_MSG_TYPE_0X02 == message.getMessageType()
                || GBMessageType.GB_MSG_TYPE_0X03 == message.getMessageType()) {
            GB_02 gb_02 = (GB_02) message.getMessageContents();
            GB_02_01 gb_02_01 = (GB_02_01) gb_02
                    .getRealTimeAdditionalItem(GBMessageType.GB_MSG_REAL_TIME_TYPE_0X01);
            if (null == gb_02_01) {
                return correctionMessage;
            }

            if (gb_02_01.getMileage() <= 0) {
                Object obdMileage = redisTemplate.opsForHash()
                        .get(RedisConst.REDIS_KEY_RT_STATES_CORRECTION_HASH, message.getVin());
                if (obdMileage != null) {
                    gb_02_01.setMileage(Integer.parseInt(String.valueOf(obdMileage)));
                    correctionMessage.setPacketDescr(Tools.ToHexString(correctionMessage.WriteToBytes()));
                }
            } else {
                if (GBMessageType.GB_MSG_TYPE_0X02 == message.getMessageType()) {
                    redisTemplate.opsForHash()
                            .put(RedisConst.REDIS_KEY_RT_STATES_CORRECTION_HASH, message.getVin(), gb_02_01.getMileage());
                }
            }
        }

        return correctionMessage;
    }

    /**
     * 只转发到“15: 终端符合性对接”转发到MQ，topic：terminal，tag：terminal_gb_
     */
    private void transferToMq(GBMessage message, CsVehicle csVehicle) {
        if (csVehicle.getCsvAccess() == ACCESS_TO_TRANSFER_ONS) {
            try {
                Message mqMessage = messageFactory
                        .getMessage(topic, MqTagProperty.MQ_TERMINAL_GB, message);
                if (mqMessage != null) {
                    client.send(mqMessage);
                } else {
                    logger.error(message.getVin() + " 未授权给应用");
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

}
