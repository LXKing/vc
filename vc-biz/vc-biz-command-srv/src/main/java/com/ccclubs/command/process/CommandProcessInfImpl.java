package com.ccclubs.command.process;

import com.ccclubs.command.util.CommandMessageFactory;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.util.MqttConstants;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.dao.CsRemoteDao;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.CmdUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.model.CsMachine;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CommandProcessInfImpl implements CommandProcessInf {

  /**
   * 通领，中导终端下发指令
   */
  @Resource(name = "aliyunMqttClient")
  private IMqClient mqttClient;
  /**
   * 富士康终端下发指令
   */
  @Resource(name = "ownMqttClient")
  private IMqClient customMqttClient;

  @Autowired
  CsRemoteDao rdao;

  @Autowired
  QueryTerminalService queryTerminalService;

  private static Logger logger = LoggerFactory.getLogger(CommandProcessInfImpl.class);

  @Override
  public void dealZdHttpUpdateCommand(CsMachine csMachine, byte[] srcArray) {
    String downTopic = CommandMessageFactory.getP2pTopic(csMachine);
    if (StringUtils.empty(downTopic)) {
      return;
    }
    downTopic = downTopic + "update/";

    sendFinalMessage(csMachine, downTopic, srcArray, true);
  }

  @Override
  public void dealRemoteCommand(CsMachine csMachine, byte[] srcArray, boolean isUpdate) {
    if (isUpdate) {
      String downTopic = CommandMessageFactory.getP2pTopic(csMachine);
      if (StringUtils.empty(downTopic)) {
        return;
      }

      sendFinalMessage(csMachine, downTopic, srcArray, true);
    } else {
      sendMessage(csMachine, Tools.ToHexString(srcArray), srcArray);
    }
  }

  @Override
  public void dealRemoteCommand(CsRemote remote, Object[] array) {
    try {
      Query query = new Query(Criteria.where("_id").is(remote.getId()));
      final Update update = new Update();
      String resultCode = CmdUtils
          .getSimpleMQTTRemoteCommend(remote.getCsrId(), remote.getCsrNumber(), array);

      if (!StringUtils.empty(resultCode)) {
        update.set("csrCode", resultCode);
        sendMessage(remote, resultCode);
      }
      update.set("csrState", 1);

      rdao.update(query, update);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
      throw new ApiException(ApiEnum.SYSTEM_ERROR);
    }
  }

  private void sendMessage(CsRemote csRemote, String message) {
    CsMachine machine = queryTerminalService.queryCsMachineByCarNumber(csRemote.getCsrNumber());
    if (null == machine) {
      throw new ApiException(ApiEnum.COMMAND_REQUIRED_TERMINAL_MISSING);
    }
    sendMessage(machine, message, Tools.HexString2Bytes(message));
  }

  private void sendMessage(CsMachine csMachine, String message, byte[] srcArray) {
    MqMessage mqMessage = CommandMessageFactory.getP2pMessage(csMachine, message, srcArray);
    if (mqMessage == null) {
      throw new ApiException(ApiEnum.TERMINAL_PROTOCOL_NOT_SUPPORT);
    }
    if (StringUtils.empty(mqMessage.getDownTopic())) {
      throw new ApiException(ApiEnum.TERMINAL_TOPIC_NOT_SET);
    }

    sendFinalMessage(csMachine, mqMessage.getDownTopic(), srcArray, false);
  }


  private void sendFinalMessage(CsMachine csMachine, String topic, byte[] srcArray,
      boolean isT808Message) {
    // 富士康终端下发指令
    if (csMachine.getCsmProtocol() == 1L) {
      customMqttClient.send(topic, srcArray);
      return;
    }
    // 通领，中导车机下发指令
    if (isT808Message) {
      mqttClient.send(topic, srcArray);
    } else {
      T808Message ts = ProtocolTools.package2T808Message(csMachine.getCsmMobile().trim(), srcArray);
      mqttClient.send(topic, ts.WriteToBytes(), MqttConstants.QOS_1);
    }
  }

}
