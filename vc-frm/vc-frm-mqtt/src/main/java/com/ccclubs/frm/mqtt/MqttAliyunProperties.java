package com.ccclubs.frm.mqtt;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by qsxiaogang on 2017/7/21.
 */
@ConfigurationProperties(prefix = "mqttAliyun")
public class MqttAliyunProperties {

  private String host;
  private String port;
  private String preId;
  private String subTopic;
  private String userName;
  private String pwd;
  private boolean logUpDown;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getPreId() {
    return preId;
  }

  public void setPreId(String preId) {
    this.preId = preId;
  }

  public String getSubTopic() {
    return subTopic;
  }

  public void setSubTopic(String subTopic) {
    this.subTopic = subTopic;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public boolean isLogUpDown() {
    return logUpDown;
  }

  public void setLogUpDown(boolean logUpDown) {
    this.logUpDown = logUpDown;
  }
}
