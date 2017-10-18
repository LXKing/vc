package com.ccclubs.engine.rule.inf.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.aop.Timer;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.engine.rule.inf.IMqAckService;
import com.ccclubs.engine.rule.inf.IParseGbDataService;
import com.ccclubs.engine.rule.inf.util.LogicHelperJt808;
import com.ccclubs.engine.rule.inf.util.TransformUtils;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.jt808.JT_0200;
import com.ccclubs.protocol.dto.jt808.JT_0201;
import com.ccclubs.protocol.dto.jt808.JT_0704;
import com.ccclubs.protocol.dto.jt808.JT_0900;
import com.ccclubs.protocol.dto.jt808.JT_0900_can;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.inf.IMqMessageProcessService;
import com.ccclubs.protocol.inf.IParseDataService;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagProperty;
import com.ccclubs.protocol.util.MqTagUtils;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.SrvHost;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MqMessageProcessService implements IMqMessageProcessService {

  private static Logger logger = LoggerFactory.getLogger(MqMessageProcessService.class);

  private IMqAckService mqAckService;
  private IParseDataService parseDataService;
  private IParseGbDataService parseGbDataService;

  @Resource(name = "producer")
  private Producer client;

  @Value("${" + ConstantUtils.MQ_TOPIC + "}")
  String topic;

  @Resource
  MessageFactory messageFactory;

  @Resource
  LogicHelperJt808 logicHelperJt808;

  @Resource
  TerminalUtils terminalUtils;

  @Resource
  QueryAppInfoService queryHostInfoService;

  @Autowired
  EnvironmentUtils environmentUtils;

  /**
   * 通过 TAG 区分是哪种协议
   *
   * @param tag 区分是哪种协议
   * @param upTopic mqtt主题
   * @param srcByteArray 原始字节数组
   * @param hexString 原始字节十六进制字符串
   */
  @Override
  public void processAliMqMsg(String tag, String upTopic, final byte[] srcByteArray,
      final String hexString) {
    if (StringUtils.empty(tag)) {
      tag = MqTagUtils.PROTOCOL_MQTT;
    }

    // 808协议
    if (tag.startsWith(MqTagUtils.PROTOCOL_JT808)) {
      T808Message msgFromTerminal = new T808Message();
      msgFromTerminal.ReadFromBytes(srcByteArray);
      // 消息类型
      int headerType = msgFromTerminal.getHeader().getMessageType();

      MachineMapping mapping = terminalUtils.getMapping(msgFromTerminal.getSimNo());
      if (mapping == null || mapping.getMachine() == null || StringUtils
          .empty(mapping.getNumber())) {
        logger.info("808协议: {} 当前在线，但系统中不存在，请排查原因 ", msgFromTerminal.getSimNo());
        return;
      }
      // 0x0200,0x0201,0x0704,0x0900
      if (headerType == 0x0200 || headerType == 0x0201) {
        // 定位补报，需要将补报的定位信息批量入库
        JT_0200 jvi;
        if (headerType == 0x0200) {
          jvi = (JT_0200) msgFromTerminal.getMessageContents();
        } else {
          JT_0201 jt = (JT_0201) msgFromTerminal.getMessageContents();
          jvi = jt.getPositionReport();
        }
        if (jvi == null) {
          return;
        }
        CsState csState = logicHelperJt808.saveStatusData(msgFromTerminal, jvi);
        transferToMq(csState);
      } else if (headerType == 0x0704) {
        // 定位补报，需要将补报的定位信息批量入库
        JT_0704 rd = (JT_0704) msgFromTerminal.getMessageContents();
        List<JT_0200> packetList = rd.getPositionReportList();
        // 定位补传数据暂时不入库 2017-10-11
//        for (JT_0200 jvi : packetList) {
//          logicHelperJt808.saveStatusData(msgFromTerminal, jvi);
//        }
      } else if (headerType == 0x0900) {
        // 终端对平台的上行透传
        JT_0900 ack = (JT_0900) msgFromTerminal.getMessageContents();
        if (ack == null) {
          return;
        }

        int msgType = ack.getMessageType();
        // 0x01 can透传信息；0xFD can 补传信息
        if (msgType == 0x01 || (msgType & 0xFF) == 0xFD) {
          byte[] msgContent = ack.getMessageContent();
          JT_0900_can canData = new JT_0900_can();
          canData.ReadFromBytes(msgContent);
          if (msgType == 0x01) {
            transferToMq(msgFromTerminal, MqTagProperty.MQ_TERMINAL_CAN);
            logicHelperJt808.saveCanData(msgFromTerminal, canData);
          } else {
            transferToMq(msgFromTerminal, MqTagProperty.MQ_TERMINAL_CAN_FD);
            logicHelperJt808.saveCanData(msgFromTerminal, canData, ConstantUtils.NOTIFY_FD);
          }
        }
      }
      return;
    }

    // 国标协议
    if (tag.startsWith(MqTagUtils.PROTOCOL_GB)) {
      GBMessage gbMessage = new GBMessage();
      gbMessage.ReadFromBytes(srcByteArray);

      if (null == gbMessage.getHeader() || StringUtils
          .empty(gbMessage.getVin())) {
        return;
      }

      getParseGbDataService().processMessage(gbMessage, srcByteArray);
      return;
    }

    // MQTT 分时租赁 协议
    if (tag.startsWith(MqTagUtils.PROTOCOL_MQTT)) {
      MqMessage mqMessage = new MqMessage();
      mqMessage.ReadFromBytes(srcByteArray);

      MachineMapping mapping = terminalUtils.getMapping(mqMessage.getCarNumber());

      if (mapping == null || mapping.getMachine() == null || StringUtils
          .empty(mapping.getNumber())) {
        logger.info("MQTT协议终端 或 808协议含分时租赁插件终端：{} 当前在线，但系统中不存在，请排查原因 ", mqMessage.getCarNumber());
        return;
      }

      if (!StringUtils.empty(mqMessage.getCarNumber())) {
        mqMessage.setUpTopic(upTopic);
        mqMessage.setHexString(hexString);
        // 设置时间有效性，暂时设置为 60*1000 ，主要用于流转
        mqMessage.setTimeStamp(System.currentTimeMillis());

        // 消息入库
        getParseDataService().processMessage(mqMessage);

        // 启动应答服务
        getMqAckService().beginAck(mqMessage);
      }
      return;
    }
  }

  /**
   * 转发到MQ，topic：terminal，tag
   */
  private void transferToMq(T808Message message, String tag) {
    try {
      Message mqMessage = messageFactory
          .getMessage(topic, tag, message);

      if (mqMessage != null) {
        CsMachine csMachine = terminalUtils.getCsMachineBySim(message.getSimNo());
        // 只有标记为地标类型的终端才转发。
        if (csMachine == null || csMachine.getCsmId() <= 0 || StringUtils
            .empty(csMachine.getCsmLandmark()) || "#0#".equals(csMachine.getCsmLandmark().trim())) {
          return;
        }
        if (environmentUtils.isProdEnvironment()) {
          client.send(mqMessage);
        }
      } else {
        logger.error(message.getSimNo() + " 未授权给应用");
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 转发到MQ，已有绑定关系，不具备分时租赁功能的808协议的0200定位数据
   */
  private void transferToMq(CsState csState) {
    try {
      if (csState == null) {
        return;
      }

      MachineMapping mapping = terminalUtils.getMapping(csState.getCssNumber());
      // 终端未绑定到车辆，不转发
      if (mapping == null || mapping.getCar() == null) {
        return;
      }
      // 终端具备分时租赁功能，不转发，目前按照插件版本>0来判断终端具备分时租赁功能
      CsMachine csMachine = terminalUtils.getMappingMachine(mapping.getNumber());
      if (csMachine == null || (csMachine.getCsmTlV2() != null && csMachine.getCsmTlV2() > 0)) {
        return;
      }

      SrvHost srvHost = queryHostInfoService.queryHostById(csMachine.getCsmAccess());
      if (srvHost == null) {
        return;
      }

      Message mqMessage = messageFactory
          .getMessage(srvHost.getShTopic().trim(),
              MqTagProperty.MQ_TERMINAL_STATUS + srvHost.getShId(),
              JSON.toJSONBytes(TransformUtils
                  .transform2TerminalStatus(csMachine, mapping.getVin(), csState)));

      if (mqMessage != null) {
        if (environmentUtils.isProdEnvironment()) {
          client.send(mqMessage);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  public Producer getClient() {
    return client;
  }

  public void setClient(Producer client) {
    this.client = client;
  }

  public IMqAckService getMqAckService() {
    return mqAckService;
  }

  public void setMqAckService(IMqAckService mqAckService) {
    this.mqAckService = mqAckService;
  }

  public IParseDataService getParseDataService() {
    return parseDataService;
  }

  public void setParseDataService(IParseDataService parseDataService) {
    this.parseDataService = parseDataService;
  }

  public IParseGbDataService getParseGbDataService() {
    return parseGbDataService;
  }

  public void setParseGbDataService(IParseGbDataService parseGbDataService) {
    this.parseGbDataService = parseGbDataService;
  }
}
