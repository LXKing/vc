package com.ccclubs.gateway.gb.inf.impl;


import com.ccclubs.gateway.gb.inf.IAckService;
import com.ccclubs.gateway.gb.inf.IGbMessageProcessService;
import com.ccclubs.gateway.gb.inf.IGpsDataService;
import com.ccclubs.protocol.dto.gb.GBMessage;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 终端上行数据处理服务
 */
public class MessageProcessService implements IGbMessageProcessService {

  private static final Logger logger = LoggerFactory.getLogger(MessageProcessService.class);
  @Resource(name = "gbGpsDataService")
  private IGpsDataService gpsDataService;
  @Resource(name = "gbAckService")
  private IAckService ackService;

  public void processMsg(GBMessage msgFromTerminal) {
    int msgType = msgFromTerminal.getMessageType();
    if (msgType == 0) {
      return;
    }
    // 应答服务
    ackService.beginAck(msgFromTerminal);
    try {
      // 消息入库
      gpsDataService.processMessage(msgFromTerminal);
    } catch (Exception ex) {
      ex.printStackTrace();
      logger.error(ex.getMessage(), ex);
    }
  }
}
