package com.ccclubs.engine.rule.inf.impl;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.rule.inf.IParseGbDataService;
import com.ccclubs.mongo.orm.model.CsMessage;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagProperty;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsVehicle;
import java.util.Date;
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


  @Override
  public void processMessage(GBMessage message, byte[] srcByteArray) {

    CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(message.getVin());

    if (null == csVehicle) {
      logger.info("国标协议终端：{} 当前在线，但系统中不存在，请排查原因 ", message.getVin());
      return;
    }

    transferToMq(message);

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
              StringUtils.date(message.getMessageContents().getTime(), "yyyy-MM-dd HH:mm:ss").getTime());
    }
    csMessage.setCsmAddTime(System.currentTimeMillis());
    csMessage.setCsmData(message.getPacketDescr());
    csMessage.setCsmStatus((short) 1);

    //将 csMessage 放如 redis 队列
    /**
     * 等待消费
     */
    ListOperations ops = redisTemplate.opsForList();
    ops.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE, csMessage);
  }

  /**
   * 转发到MQ，topic：terminal，tag：terminal_gb_
   */
  private void transferToMq(GBMessage message) {
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
      e.printStackTrace();
    }
  }

}
