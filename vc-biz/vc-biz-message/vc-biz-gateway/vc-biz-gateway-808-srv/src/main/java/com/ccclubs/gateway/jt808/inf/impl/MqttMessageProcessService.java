package com.ccclubs.gateway.jt808.inf.impl;

import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.gateway.jt808.inf.IJT808Server;
import com.ccclubs.protocol.dto.jt808.SL_Update;
import com.ccclubs.protocol.dto.jt808.T808Message;
import javax.annotation.Resource;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理远程控制指令，接收mqtt消息，通过0x8900转发成808命令 FIXME：808网关只发送中导升级指令，拼装好的808消息格式（7E打头的数据）
 */
public class MqttMessageProcessService implements IMessageProcessService {

  private static Logger logger = LoggerFactory.getLogger(MqttMessageProcessService.class);

  @Resource(name = "jt808TcpServer")
  private IJT808Server jt808Server;

  @Override
  public void processMsg(String upTopic, MqttMessage msg, String hexString) {
    //如果是中岛升级指令
    if (upTopic.contains("update")) {
      SL_Update slUpdate = new SL_Update();
      slUpdate.ReadFromBytes(msg.getPayload());
      //是否是升级指令
      if (jt808Server.isOnline(slUpdate.getSimId())) {
        jt808Server.send(slUpdate.getSimId(), slUpdate.getMsgBody());
        // 便于ELK日志分析
        logger.info("DOWN >> 7E000000010{}{}7E", slUpdate.getSimId(), hexString);
      }
    } else {
      // 自定义完整的808消息数据(7E打头，7E结尾)，透传
      if (hexString.startsWith("7E") && hexString.endsWith("7E")) {
        T808Message t808Message = new T808Message();
        t808Message.ReadFromBytes(msg.getPayload());
        if (jt808Server.isOnline(t808Message.getSimNo())) {
          jt808Server.send(t808Message.getSimNo(), msg.getPayload());
          logger.info("DOWN >> {}", t808Message.getPacketDescr());
        }
      }
    }
  }
}
