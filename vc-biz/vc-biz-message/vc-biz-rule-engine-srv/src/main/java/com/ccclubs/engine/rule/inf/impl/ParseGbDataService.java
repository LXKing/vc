package com.ccclubs.engine.rule.inf.impl;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.engine.core.util.MachineMapping;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.core.util.RedisHelper;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.rule.inf.IParseGbDataService;
import com.ccclubs.mongo.orm.dao.CsMessageDao;
import com.ccclubs.mongo.orm.model.CsMessage;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagProperty;
import com.ccclubs.protocol.util.StringUtils;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
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
  @Resource
  RedisHelper redisHelper;
  @Resource
  private CsMessageDao csMessageDao;

  @Override
  public void processMessage(GBMessage message, byte[] srcByteArray) {
    HashOperations ops = redisTemplate.opsForHash();
    MachineMapping mapping = (MachineMapping) ops
        .get(RuleEngineConstant.REDIS_KEY_VIN, message.getVin());
    if (mapping == null) {
      redisHelper.setNotExist(message.getVin(), true);
      return;
    }
    if (mapping.getCar() == null || mapping.getAccess() == null) {
      return;
    }

    transferToMq(message);

    CsMessage csMessage = new CsMessage();
    csMessage.setCsmAccess(mapping.getAccess());
    csMessage.setCsmCar(mapping.getCar());
    csMessage.setCsmVin(message.getVin());
    csMessage.setCsmProtocol((short) 0);
    csMessage.setCsmType((short) message.getMessageType());
    csMessage.setCsmVerify(StringUtils.empty(message.getErrorMessage()) ? (short) 1 : 0);
    if (message.getMessageContents() != null) {
      csMessage
          .setCsmMsgTime(
              StringUtils.date(message.getMessageContents().getTime(), "yyyy-MM-dd HH:mm:ss"));
    }
    csMessage.setCsmAddTime(new Date());
    csMessage.setCsmData(message.getPacketDescr());
    csMessage.setCsmStatus((short) 1);

    csMessageDao.save(csMessage);
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
