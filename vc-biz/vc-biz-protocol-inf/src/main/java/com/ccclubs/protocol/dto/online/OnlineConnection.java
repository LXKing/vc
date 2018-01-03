package com.ccclubs.protocol.dto.online;

import java.io.Serializable;

/**
 * 终端在线描述
 * @author qsxiaogang
 * @create 2018-01-02
 **/
public class OnlineConnection  implements Serializable {

  private static final long serialVersionUID = -6519276463068646693L;

  /**
   * 唯一标识，可以是车机号，手机号，VIN
   * 主要依赖于使用的协议
   */
  private String key;
  /**
   * 终端的IP
   */
  private String clientIp;
  /**
   * 网关的IP
   */
  private String serverIp;

  /**
   * 报文上报最后时间
   */
  private Long msgLastTime;

  public OnlineConnection() {
  }

  public OnlineConnection(String key, String clientIp, String serverIp, Long msgLastTime) {
    this.key = key;
    this.clientIp = clientIp;
    this.serverIp = serverIp;
    this.msgLastTime = msgLastTime;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getClientIp() {
    return clientIp;
  }

  public void setClientIp(String clientIp) {
    this.clientIp = clientIp;
  }

  public String getServerIp() {
    return serverIp;
  }

  public void setServerIp(String serverIp) {
    this.serverIp = serverIp;
  }

  public Long getMsgLastTime() {
    return msgLastTime;
  }

  public void setMsgLastTime(Long msgLastTime) {
    this.msgLastTime = msgLastTime;
  }
}
