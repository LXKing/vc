package com.ccclubs.protocol.dto.transform;

import com.ccclubs.protocol.util.StringUtils;
import java.util.Date;

/**
 * 未注册的终端信息
 * @author qsxiaogang
 * @create 2017-11-24
 **/
public class TerminalNotRegister {

  private String key;
  private String protocol;
  private String time;
  private String des;
  private String message;

  public TerminalNotRegister(String key, String protocol, String des, String message) {
    this.key = key;
    this.protocol = protocol;
    this.des = des;
    this.message = message;
    this.time = StringUtils.date(new Date(),"YYYY-MM-dd HH:mm:ss");
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getDes() {
    return des;
  }

  public void setDes(String des) {
    this.des = des;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
