package com.ccclubs.gateway.gb.inf;

import com.ccclubs.gateway.gb.dto.GpsConnection;
import com.ccclubs.protocol.dto.gb.GBMessage;
import java.util.Collection;

/**
 * GB外部接口
 */
public interface IGbManager {

  /**
   * 启动GBServer监听
   */
  boolean startServer();

  boolean send(GBMessage msg);

  /**
   * 停止服务
   */
  void stopServer();

  /**
   * 获取当前的socket链接集合
   */
  Collection<GpsConnection> getGpsConnections();

}