package com.ccclubs.gateway.jt808.inf.impl;


import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.frm.ons.OnsMessageFactory;
import com.ccclubs.gateway.jt808.inf.IGpsDataService;
import com.ccclubs.protocol.dto.jt808.JT_0301;
import com.ccclubs.protocol.dto.jt808.JT_0302;
import com.ccclubs.protocol.dto.jt808.JT_0303;
import com.ccclubs.protocol.dto.jt808.JT_0701;
import com.ccclubs.protocol.dto.jt808.JT_0702;
import com.ccclubs.protocol.dto.jt808.JT_0900;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagUtils;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * 终端上行数据处理实现类
 */
public class GpsDataService implements IGpsDataService {

  private static final Logger logger = LoggerFactory.getLogger(GpsDataService.class);

  @Value("${" + ConstantUtils.MQ_TOPIC + "}")
  String topic;
  @Resource(name = "onsPublishClient")
  private Producer client;

  // 获取实时数据
  // 保存终端参数
  // 处理GPS数据
  @Override
  public final void processMessage(T808Message message) {
    // 消息类型
    int headerType = message.getHeader().getMessageType();
    if (headerType == 0x0001 // 终端应答 -
        || headerType == 0x0000 || headerType == 0x0100 // 注册
        || headerType == 0x0003 // 终端注销
        || headerType == 0x0102) // 鉴权 - -
    {
      // logger.error("收到来自 " + simNo + " 消息，消息头：" + headerType);
      // 非数据包，不进行处理
      return;
    }

    if (headerType == 0x0002 ||headerType == 0x0200 || headerType == 0x0201) {
      transferToMQ(message, MqTagUtils.getTag(MqTagUtils.PROTOCOL_JT808, message.getMessageType()));
    } else {
      processData(message);
    }
  }

  /**
   * 将jt808协议数据转发到消息中间件MQ，topic：ser，tag：jt808
   */
  private void transferToMQ(T808Message message, String messageTag) {
    if (null == message || null == message.getHeader()|| !StringUtils.empty(message.getErrorMessage()))
    {
      return;
    }
    // 转发数据，数据流转topic：ser
    Message mqMessage = OnsMessageFactory
        .getProtocolMessage(topic, messageTag,
            Tools.HexString2Bytes(message.getPacketDescr()));
    if (mqMessage != null) {
      client.sendOneway(mqMessage);
    } else {
      logger.error(ConstantUtils.MQ_TOPIC + " 或  " + ConstantUtils.MQ_TOPIC + " 未配置");
    }
  }

  /**
   * 将jt808协议数据转发到消息中间件MQ，topic：ser，tag：jt808
   */
  private void transferToMQ(MqMessage message, String messageTag) {
    // 转发数据，数据流转topic：ser
    Message mqMessage = OnsMessageFactory
        .getProtocolMessage(topic, messageTag,
            message.WriteToBytes());
    if (mqMessage != null) {
      client.sendOneway(mqMessage);
    } else {
      logger.error(ConstantUtils.MQ_TOPIC + " 或  " + ConstantUtils.MQ_TOPIC + " 未配置");
    }
  }

  /**
   * 收到808消息后，根据消息的不同，进行不同的处理
   */
  private void processData(T808Message message) {
    int headerType = message.getHeader().getMessageType();
    String simNo = message.getSimNo();
    if (headerType == 0x0104) {
      // 查询参数返回的应答参数数据存入数据库中
      // SaveTerminalParam(message);
      return;
    } else if (headerType == 0x0801) {
      // 媒体上传数据
      // SaveMedia(message);
      // 交给媒体上传服务处理
      // mediaService.processMediaMsg(message);
    } else if (headerType == 0x0800) {
      // 媒体信息上传数据
      // SaveMediaInfo(message);
    } else if (headerType == 0x0802) {
      // 媒体检索数据
      // this.SaveMediaSearchItem(message);
    } else if (headerType == 0x0700) {
      // 行车记录仪数据
      // vehicleRecorderService.processMediaMsg(message);
      // SaveVehicleRecorder(message);
    } else if (headerType == 0x0704) {
      // 定位补报，需要将补报的定位信息批量入库
      transferToMQ(message, MqTagUtils.getTag(MqTagUtils.PROTOCOL_JT808, message.getMessageType()));
    } else if (headerType == 0x0701) {
      // 电子运单数据
      // saveEWayBill(message);
      // 添加电子运单命令
      JT_0701 rd = (JT_0701) message.getMessageContents();
    } else if (headerType == 0x0702) {
      // 驾驶员主动上报信息
      // this.saveDriver(message);
      JT_0702 rd = (JT_0702) message.getMessageContents();
      if (rd == null) {
        return;
      }
    } else if (headerType == 0x0705) {
      // 驾驶员主动上报信息
      // this.saveDriver(message);
      JT_0702 rd = (JT_0702) message.getMessageContents();
      if (rd == null) {
        return;
      }
    } else if (headerType == 0x0302) {
      // 终端对提问下发指令的应答
      JT_0302 ack = (JT_0302) message.getMessageContents();
      int responseNo = ack.getResponseMessageSerialNo();
      int answerId = ack.getAnswerId();
      String answer = "";
    } else if (headerType == 0x0303) {
      // 信息点播/取消
      JT_0303 ack = (JT_0303) message.getMessageContents();
      int inforType = ack.getMessageType(); // 点播的信息类型
      int req = ack.getPointResult();// 0：取消；1：点播
    } else if (headerType == 0x0301) {
      // 终端事件上报
      JT_0301 ack = (JT_0301) message.getMessageContents();
      int eventId = ack.getEventId();
    } else if (headerType == 0x0900) {
      // 终端对平台的上行透传
      JT_0900 jt0900 = (JT_0900) message.getMessageContents();
      if (jt0900 == null) {
        return;
      }

      byte msgType = jt0900.getMessageType();
      if (0x01 == msgType || 0xFD == (msgType & 0xFF)) {
        transferToMQ(message,
            MqTagUtils.getTag(MqTagUtils.PROTOCOL_JT808, message.getMessageType(), msgType));
      } else if ((msgType & 0xFF) == 0xF1) {
        // 分时租赁协议透传
        if (jt0900.getMessageContent().length >= MqMessage.MESSAGE_MIN_LENGTH) {
          MqMessage mqMessage = new MqMessage();
          mqMessage.ReadFromBytes(jt0900.getMessageContent());
          transferToMQ(mqMessage,
              MqTagUtils.getTag(MqTagUtils.PROTOCOL_MQTT, mqMessage.getFucCode()));
        }
      }
    } else {
      logger.error("未知的处理类型:" + Integer.toHexString(headerType));
    }
  }
}