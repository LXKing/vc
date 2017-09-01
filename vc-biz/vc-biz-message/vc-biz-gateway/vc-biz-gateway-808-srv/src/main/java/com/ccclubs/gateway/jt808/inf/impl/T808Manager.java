package com.ccclubs.gateway.jt808.inf.impl;


import com.ccclubs.gateway.jt808.dto.GpsConnection;
import com.ccclubs.gateway.jt808.inf.IAckService;
import com.ccclubs.gateway.jt808.inf.IJT808Server;
import com.ccclubs.gateway.jt808.inf.IMessageSender;
import com.ccclubs.gateway.jt808.inf.IT808Manager;
import com.ccclubs.protocol.dto.jt808.T808Message;
import java.util.Collection;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提供外部调用808平台的接口 启动服务StartServer方法
 */
public class T808Manager implements IT808Manager {

  private static Logger logger = LoggerFactory.getLogger(T808Manager.class);
  /**
   * gps服务器的监听端口
   */
  private int listenPort;
  @Resource(name = "jt808TcpServer")
  private IJT808Server jt808Server;

  /**
   * 流水号计数器，每次下发自动增加1
   */
  private static int serialNo = 0;
  /**
   * 应答服务
   */
  @Resource(name = "jt808AckService")
  private IAckService ackService;

  public static int getSerialNo() {
    if (serialNo == Integer.MAX_VALUE) {
      serialNo = 0;
    }
    return serialNo++;
  }

  public Collection<GpsConnection> getGpsConnections() {
    return getJt808Server().getGpsConnections();
  }

  // 向上级平台发送数据
  private boolean send(String simNo, byte[] msg) {
    // 优先使用主链路发送数据
    boolean res = getJt808Server().send(simNo, msg);
    return res;
  }

  // 向发送数据
  public boolean send(T808Message msg) {
    msg.getHeader().setMessageSerialNo((short) getSerialNo());
    // msg.setPacketDescr(strMsg);
    boolean res = send(msg.getSimNo(), msg.WriteToBytes());
    //		GlobalConfig.putMsg(msg);
    logger.info("DOWN >> {}", msg.getPacketDescr());
    return res;
  }

  /**
   * 启动JT808服务器
   */
  public boolean startServer() {
//		GlobalConfig.paramModel.setLocalPort(getListenPort());
    // 启动服务器
    boolean res = getJt808Server().start();
    if (res) {
      // 应答服务，调用Server，发送应答数据包
      ackService.setMessageSender(new IMessageSender() {
        @Override
        public void send808Message(T808Message tm) {
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
      getJt808Server().stop();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  public void setJt808Server(IJT808Server jt808Server) {
    this.jt808Server = jt808Server;
  }

  public IJT808Server getJt808Server() {
    return jt808Server;
  }

  public void setAckService(IAckService ackService) {
    this.ackService = ackService;
  }

  public IAckService getAckService() {
    return ackService;
  }

  public int getListenPort() {
    return listenPort;
  }

  public void setListenPort(int listenPort) {
    this.listenPort = listenPort;
  }
}
