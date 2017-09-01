package com.ccclubs.gateway.gb.inf.impl;


import com.ccclubs.gateway.gb.dto.GpsConnection;
import com.ccclubs.gateway.gb.inf.IAckService;
import com.ccclubs.gateway.gb.inf.IGbServer;
import com.ccclubs.gateway.gb.inf.IMessageSender;
import com.ccclubs.gateway.gb.inf.IGbManager;
import com.ccclubs.protocol.dto.gb.GBMessage;
import java.util.Collection;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提供外部调用GB平台的接口 启动服务StartServer方法
 */
public class GBManager implements IGbManager {

  private static final Logger logger = LoggerFactory.getLogger(GBManager.class);
  @Resource(name = "gbTcpServer")
  private IGbServer gbServer;

  /**
   * 应答服务
   */
  @Resource(name = "gbAckService")
  private IAckService ackService;

  public Collection<GpsConnection> getGpsConnections() {
    return gbServer.getGpsConnections();
  }

  // 向上级平台发送数据
  private boolean send(String vin, byte[] msg) {
    // 优先使用主链路发送数据
    boolean res = gbServer.send(vin, msg);
    return res;
  }

  // 向发送数据
  public boolean send(GBMessage msg) {
    boolean res = send(msg.getVin(), msg.WriteToBytes());
    //		GlobalConfig.putMsg(msg);
    logger.info(
        "DOWN >> " + msg.getVin() + " 消息ID:" + Integer.toHexString(msg.getMessageType()) + "  "
            + msg.getPacketDescr());
    return res;
  }

  /**
   * 启动GB服务器
   */
  public boolean startServer() {
    // 启动服务器
    boolean res = gbServer.start();
    if (res) {
      // 应答服务，调用Server，发送应答数据包
      ackService.setMessageSender(new IMessageSender() {
        @Override
        public void sendGbMessage(GBMessage tm) {
          send(tm);
        }
      });
    }
    return res;
  }

  /**
   * 停止服务
   */
  public void stopServer() {
    try {
      gbServer.stop();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

}
