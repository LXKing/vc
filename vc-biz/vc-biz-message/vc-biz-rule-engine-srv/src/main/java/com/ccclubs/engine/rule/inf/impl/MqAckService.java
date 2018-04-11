package com.ccclubs.engine.rule.inf.impl;


import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.engine.rule.inf.IMqAckService;
import com.ccclubs.engine.rule.inf.IMqMessageSender;
import com.ccclubs.protocol.dto.mqtt.FurtherCarReply;
import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MQTT_68_03;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.mqtt.TakeCarReply;
import com.ccclubs.protocol.dto.mqtt.TimeSynchronization;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接收上行信息进行相应处理；
 * 包括时间同步，取车应答，还车应答
 */
public class MqAckService implements IMqAckService {

  private static Logger logger = LoggerFactory.getLogger(MqAckService.class);

  private IMqMessageSender messageSender;

  @Resource
  EnvironmentUtils environmentUtils;

  @Override
  public void beginAck(MqMessage msg) {
    if (getMessageSender() == null) {
      return;
    }

    byte headerType = msg.getFucCode();

    switch (headerType) {
      case 0x41:
      case 0x66:
      case 0x68:
        // 同步时间
        sendGeneralAck(msg);
        break;
      case 0x45:
        // 取车应答
        ackTakeCar(msg);
        break;
      case 0x42:
      case 0x64:
        // 还车应答
        ackFurtherCar(msg);
        break;
      default:
        break;
    }
  }

  private void sendGeneralAck(MqMessage msgFromTerminal) {
//    byte[] byteMsg = msgFromTerminal.WriteToBytes();
    try {
      if (msgFromTerminal.getFucCode() == 0x66) {
        MQTT_66 mqtt_66 = new MQTT_66();
        mqtt_66.ReadFromBytes(msgFromTerminal.getMsgBody());
        synchronizeCarTime(msgFromTerminal, mqtt_66.getTime());
      } else if (msgFromTerminal.getFucCode() == 0x68 && msgFromTerminal.getMsgBody().length > 0) {
        byte subCode = msgFromTerminal.getMsgBody()[0];
        if (subCode == 0x03) {
          MQTT_68_03 mqtt_68_03 = new MQTT_68_03();
          mqtt_68_03.ReadFromBytes(msgFromTerminal.getMsgBody());
          synchronizeCarTime(msgFromTerminal, mqtt_68_03.getTime());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void synchronizeCarTime(MqMessage msg, long terminalTime) {
    try {
      if (StringUtils.empty(msg.getCarNumber())) {
        return;
      }
      long now = System.currentTimeMillis();
      // 如果时间相差大于设置的阈值，则进行时间校正，发送时间同步
      if (Math.abs(now - terminalTime)
          > ConstantUtils.TimeSynchronizationDur) {
        TimeSynchronization timeSynchronization = new TimeSynchronization(
            msg.getCarNumber(), 0l,
            ProtocolTools.transformToTerminalTime(System.currentTimeMillis()),
            (short) 0xC000,
            (short) 0x0002);
        // 设置获取数据时间
        MqMessage mqMessage = new MqMessage();
        mqMessage.ReadFromBytes(timeSynchronization.getBytes());
        getMessageSender().sendMqMessage(mqMessage);
        logger.debug("给 " + msg.getCarNumber() + "发送同步时间");
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void ackTakeCar(MqMessage msg) {
    try {
      TakeCarReply replay = new TakeCarReply(msg.getCarNumber(), msg.getTransId());

      MqMessage mqMessage = new MqMessage();
      mqMessage.ReadFromBytes(replay.getBytes());
      if (environmentUtils.isProdEnvironment()) {
        getMessageSender().sendMqMessage(mqMessage);
      }
//      logger.info("收到来自 车牌号：" + replay.mCarNum + "，订单号：" + replay.mOrderId + " 取车回复，发送取车确认");
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void ackFurtherCar(MqMessage msg) {
    try {
      FurtherCarReply replay = new FurtherCarReply(msg.getCarNumber(), msg.getTransId(),
          msg.getFucCode());

      MqMessage mqMessage = new MqMessage();
      mqMessage.ReadFromBytes(replay.getBytes());
      if (environmentUtils.isProdEnvironment()) {
        getMessageSender().sendMqMessage(mqMessage);
      }
//      logger.info("收到来自 车牌号：" + replay.mCarNum + "，订单号：" + replay.mOrderId + " 还车回复，发送还车确认");
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void setMessageSender(IMqMessageSender handler) {
    this.messageSender = handler;
  }

  public IMqMessageSender getMessageSender() {
    return messageSender;
  }

}
