package com.ccclubs.gateway.gb.inf.impl;


import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.gateway.gb.inf.IGbServer;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.util.Tools;
import javax.annotation.Resource;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理远程控制指令，接收mqtt消息，转发成国标命令
 */
public class MqttMessageProcessService implements IMessageProcessService {

  private static final Logger logger = LoggerFactory.getLogger(MqttMessageProcessService.class);
  @Resource(name = "gbTcpServer")
  private IGbServer gbServer;

  @Override
  public void processMsg(String upTopic, MqttMessage msg, String hexString) {
    // 自定义完整的808消息数据(7E打头，7E结尾)，透传
    if (hexString.startsWith("2323")) {
      GBMessage gbMessage = new GBMessage();
      gbMessage.ReadFromBytes(msg.getPayload());

      if (gbServer.isOnline(gbMessage.getVin())) {
        gbServer.send(gbMessage.getVin(), msg.getPayload());
        logger.info("DOWN >> " + gbMessage.getVin() + " 消息ID:" + Tools
            .ToHexString((byte) gbMessage.getMessageType()) + "  "
            + gbMessage.getPacketDescr());

      }
    }
  }
}
