package com.ccclubs.engine.rule.inf.impl;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.rule.inf.IParseGbDataService;
import com.ccclubs.frm.logger.VehicleControlLogger;
import com.ccclubs.frm.spring.constant.RedisConst;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.pub.orm.dto.CsMessage;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.gb.GBMessageType;
import com.ccclubs.protocol.dto.gb.GB_02;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagProperty;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsVehicle;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 处理国标信息 Created by qsxiaogang on 2017/3/7.
 */
public class ParseGbDataService implements IParseGbDataService {

    private static Logger logger = LoggerFactory.getLogger(ParseGbDataService.class);

    @Resource(name = "producer")
    private Producer client;

    @Resource
    MessageFactory messageFactory;

    @Value("${" + ConstantUtils.MQ_TOPIC + "}")
    String topic;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    QueryVehicleService queryVehicleService;

    private static final Logger loggerBusiness = VehicleControlLogger.getLogger();

    // TODO:目前仅国标对接测试车辆才转发给天津数据中心
    private int TRANSFER_ACCESS = 10;

    @Override
    public void processMessage(GBMessage message, byte[] srcByteArray) {

        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(message.getVin());

        if (null == csVehicle) {
            return;
        }

        transferToMq(message, csVehicle);

        // GB实时状态数据存入redis
        if (message.getMessageType() == GBMessageType.GB_MSG_TYPE_0X02) {
            redisTemplate.opsForHash().put(RedisConst.REDIS_KEY_RT_STATES_HASH, message.getVin(), message.getPacketDescr());
            redisTemplate.opsForZSet().add(RedisConst.REDIS_KEY_RT_STATES_ZSET, message.getVin(),
                    DateTimeUtil.date2UnixFormat(message.getMessageContents().getTime(), DateTimeUtil.UNIX_FORMAT));
        }

        CsMessage csMessage = new CsMessage();
        csMessage.setCsmAccess(csVehicle.getCsvAccess());
        csMessage.setCsmCar(csVehicle.getCsvId().longValue());
        csMessage.setCsmVin(message.getVin());
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

        //将 csMessage 放如 redis 队列
        /**
         * 等待消费
         */
        ListOperations ops = redisTemplate.opsForList();
        //分别写进Mongo和Hbase的队列。
//    ops.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_MONGO_QUEUE, csMessage);
        ops.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_HBASE_QUEUE, csMessage);
    }

    /**
     * 转发到MQ，topic：terminal，tag：terminal_gb_
     */
    private void transferToMq(GBMessage message, CsVehicle csVehicle) {
        try {
            if (TRANSFER_ACCESS != csVehicle.getCsvAccess()) {
                return;
            }

            Message mqMessage = messageFactory
                    .getMessage(topic, MqTagProperty.MQ_TERMINAL_GB, message);
            if (mqMessage != null) {
                client.send(mqMessage);
            } else {
                logger.error(message.getVin() + " 未授权给应用");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

}
