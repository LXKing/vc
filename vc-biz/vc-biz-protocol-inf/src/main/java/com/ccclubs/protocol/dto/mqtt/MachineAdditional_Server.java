package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 服务器名，终端信息
 */
public class MachineAdditional_Server implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 服务器名
   */
  private String serverName;

  @Override
  public byte getAdditionalId() {
    return 0x0F;
  }

  @Override
  public byte getAdditionalLength() {
    return additionalLength;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  public String getServerName() {
    return StringUtils.trim(serverName);
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getServerName());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setServerName(new String(bytes));
  }
}
