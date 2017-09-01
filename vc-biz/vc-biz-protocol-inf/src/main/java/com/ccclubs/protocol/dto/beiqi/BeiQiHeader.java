package com.ccclubs.protocol.dto.beiqi;

import java.io.Serializable;

/**
 * 北汽新能源平台返回结果 消息头
 * Created by qsxiaogang on 2017/3/16.
 */
public class BeiQiHeader implements Serializable {

  private static final long serialVersionUID = 226756512058893157L;
  /**
   * 接口名的消息返回标示
   */
  private String cmd;

  public String getCmd() {
    return cmd;
  }

  public void setCmd(String cmd) {
    this.cmd = cmd;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"cmd\":\"")
        .append(cmd).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
