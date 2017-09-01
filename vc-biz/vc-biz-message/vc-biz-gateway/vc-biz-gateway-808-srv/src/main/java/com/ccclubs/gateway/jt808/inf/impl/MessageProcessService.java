package com.ccclubs.gateway.jt808.inf.impl;

import com.ccclubs.gateway.jt808.inf.I808MessageProcessService;
import com.ccclubs.gateway.jt808.inf.IAckService;
import com.ccclubs.gateway.jt808.inf.IGpsDataService;
import com.ccclubs.protocol.dto.jt808.T808Message;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 终端上行数据处理服务
 */
public class MessageProcessService implements I808MessageProcessService {

  private static final Logger logger = LoggerFactory.getLogger(MessageProcessService.class);

  @Resource(name = "jt808GpsDataService")
  private IGpsDataService gpsDataService;
  @Resource(name = "jt808AckService")
  private IAckService ackService;

  public void processMsg(T808Message msgFromTerminal) {
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
      logger.error(ex.getMessage(), ex);
    }
  }
}
