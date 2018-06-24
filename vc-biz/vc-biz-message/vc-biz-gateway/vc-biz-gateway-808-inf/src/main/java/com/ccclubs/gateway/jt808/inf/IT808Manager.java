package com.ccclubs.gateway.jt808.inf;

import com.ccclubs.gateway.jt808.dto.GpsConnection;
import com.ccclubs.protocol.dto.jt808.T808Message;

import java.util.Collection;

/**
 * JT808外部接口
 */
public interface IT808Manager {

  /**
   * 启动808Server监听
   */
  boolean startServer();


  boolean send(T808Message msg);

  /**
   * 停止服务
   */
  void stopServer();

  /**
   *
   * @return
   */
  Collection<GpsConnection> getGpsConnections();


  int getListenPort();


  void setListenPort(int listenPort);

  //public void processMsg(T808Message msgFromTerminal);

}