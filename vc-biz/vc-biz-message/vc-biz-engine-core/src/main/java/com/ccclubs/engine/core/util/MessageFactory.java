package com.ccclubs.engine.core.util;

import com.aliyun.openservices.ons.api.Message;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageFactory {

  private final static String COMMOND_DOWN_STREAM_TEMPLATE = "car/ser/{0}/rt_0/{1}/pri_3";

  @Resource
  QueryAppInfoService queryHostInfoService;

  @Resource
  QueryTerminalService queryTerminalService;

  @Resource
  QueryVehicleService queryVehicleService;

  @Value("${" + ConstantUtils.MQ_CAR + "}")
  String car;

  @Value("${" + ConstantUtils.MQ_PROTOCOL + "}")
  String protocol;

  /**
   * 获取MQ消息 Message
   *
   * @param topic 应用自身topic
   * @param tags 完整的消息类型tag
   * @param srcByteArray 需要发送的内容
   */
  public Message getMessage(String topic, String tags, byte[] srcByteArray) {
    if (StringUtils.empty(topic)) {
      throw new RuntimeException(" transform topic should not be null !");
    }
    if (StringUtils.empty(tags)) {
      throw new RuntimeException(" transform tags should not be null !");
    }
    Message mqMessage = new Message(topic, tags, srcByteArray);

    return mqMessage;
  }

  /**
   * 获取MQ消息 Message
   *
   * @param tagsPre 消息类型tagsPre
   * @param mqttMessage 需要发送的内容
   */
  public Message getMessage(String topic, String tagsPre, MqMessage mqttMessage) {
    CsMachine csMachine = queryTerminalService
        .queryCsMachineByCarNumber(mqttMessage.getCarNumber());
    if (csMachine == null || csMachine.getCsmId() <= 0) {
      return null;
    }
    SrvHost srvHost = queryHostInfoService.queryHostById(csMachine.getCsmAccess());
    if (srvHost == null) {
      return null;
    }
    return getMessage(srvHost, topic, tagsPre, mqttMessage);
  }

  /**
   * 获取MQ消息 Message
   *
   * @param srvHost srvHost
   * @param topic topic
   * @param tagsPre tagsPre
   * @param mqttMessage mqttMessage
   */
  public Message getMessage(SrvHost srvHost, String topic, String tagsPre,
      MqMessage mqttMessage) {
    if (StringUtils.empty(topic)) {
      topic = srvHost.getShTopic().trim();
    }

    return new Message(topic,
        tagsPre + String.valueOf(srvHost.getShId()),
        Tools.HexString2Bytes(mqttMessage.getHexString()));
  }

  /**
   * 获取MQ消息 Message
   *
   * @param tagsPre 消息类型tag
   * @param t808Message 需要发送的内容
   */
  public Message getMessage(CsMachine csMachine, String topic, String tagsPre,
      T808Message t808Message) {
    if (csMachine == null || csMachine.getCsmId() <= 0) {
      return null;
    }

    SrvHost srvHost = queryHostInfoService.queryHostById(csMachine.getCsmAccess());
    if (StringUtils.empty(topic)) {
      topic = srvHost.getShTopic().trim();
    }

    return new Message(topic,
        tagsPre + String.valueOf(srvHost.getShId()),
        Tools.HexString2Bytes(t808Message.getPacketDescr()));
  }

  /**
   * 获取MQ消息 Message
   *
   * @param tagsPre 消息类型tag
   * @param gbMessage 需要发送的内容
   */
  public Message getMessage(String topic, String tagsPre, GBMessage gbMessage) {
    CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(gbMessage.getVin());
    if (csVehicle == null || csVehicle.getCsvId() <= 0) {
      return null;
    }

    SrvHost srvHost = queryHostInfoService.queryHostById(csVehicle.getCsvAccess());
    if (StringUtils.empty(srvHost.getShTopic())) {
      topic = srvHost.getShTopic().trim();
    }

    return new Message(topic,
        tagsPre + String.valueOf(srvHost.getShId()),
        Tools.HexString2Bytes(gbMessage.getPacketDescr()));
  }

  /**
   * 将其它协议(除mqtt，MQ以外，诸如jt808协议)字节流，发送到MQ消息中间件
   *
   * @param topic 主题，默认为ser
   * @param protocol 协议编码，如jt808
   */
  public Message getProtocolMessage(String topic, String protocol,
      final byte[] srcByteArray) {
    if (StringUtils.empty(topic) || StringUtils.empty(protocol)) {
      return null;
    }
    Message mqMessage = new Message(topic, protocol, srcByteArray);
    return mqMessage;
  }

  /**
   * 获取MQ消息 Message，主要是点对点消息
   */
  public Message getP2pMessage(String topic, String tags, MqMessage mqttMessage) {
    if (StringUtils.empty(tags)) {
      tags = "";
    }
    Message message = new Message( //
        // Message Topic
        topic,
        // Message Tag 可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在MQ服务器过滤
        tags,
        // Message Body 可以是任何二进制形式的数据， MQ不做任何干预
        // 需要Producer与Consumer协商好一致的序列化和反序列化方式
        mqttMessage.WriteToBytes());
    // 设置代表消息的业务关键属性，请尽可能全局唯一
    // 以方便您在无法正常收到消息情况下，可通过MQ 控制台查询消息并补发
    // 注意：不设置也不会影响消息正常收发
    //		message.setKey("ORDERID_100");
    /**
     * 使用MQ客户端给MQTT设备发送P2P消息时，需要在MQ消息中设置mqttSecondTopic属性 设置的值是“/p2p/”+目标ClientID
     */
    // TODO:clientID终端设置 默认设置车机号
    if (StringUtils.empty(mqttMessage.getClientId())) {
      mqttMessage.setClientId(mqttMessage.getCarNumber());
    }
    message.putUserProperties("mqttSecondTopic", "/p2p/GID_car@@@" + mqttMessage.getClientId());
    return message;
  }

  /**
   * 针对指定车机，发送消息，点对点发送
   */
  public MqMessage getP2pMessage(CsMachine csMachine, String message,
      final byte[] srcByteArray) {
    if (csMachine == null) {
      return null;
    }

    MqMessage mqMessage = new MqMessage();
    mqMessage.ReadFromBytes(srcByteArray);
    mqMessage.setHexString(message);
    mqMessage.setDownTopic(getP2pTopic(csMachine));

    if (StringUtils.empty(mqMessage.getDownTopic())) {
      return null;
    }

    return mqMessage;
  }

  /**
   * 通过车机，发送消息
   */
  public String getP2pTopic(CsMachine csMachine) {
    if (csMachine.getCsmProtocol() == null || StringUtils.empty(csMachine.getCsmNumber())) {
      return null;
    } else if (csMachine.getCsmProtocol() == 3L) {
      return car + "/p2p/GID_car@@@" + csMachine.getCsmNumber();
    } else if (csMachine.getCsmProtocol() == 2L) {
      return protocol + "/" + csMachine.getCsmProtocol() + "/";
    } else if (csMachine.getCsmProtocol() == 1L) {
      if (StringUtils.empty(csMachine.getCsmMqttFlag())) {
        return COMMOND_DOWN_STREAM_TEMPLATE.replace("{1}", csMachine.getCsmNumber())
            .replace("{0}", "jhz");
      } else {
        return csMachine.getCsmMqttFlag().trim();
      }
    }
    return null;
  }
}
