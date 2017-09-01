package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17.
 * <b>富士康专用<b/>富士康订阅主题，终端信息
 */
public class MachineAdditional_F_SubscribeTopic implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 富士康订阅主题
   */
  private String subscribeTopic;

  public String getSubscribeTopic() {
    return StringUtils.trim(subscribeTopic);
  }

  public void setSubscribeTopic(String subscribeTopic) {
    this.subscribeTopic = subscribeTopic;
  }

  @Override
  public byte getAdditionalId() {
    return 0x17;
  }

  @Override
  public byte getAdditionalLength() {
    return additionalLength;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSubscribeTopic());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setSubscribeTopic(new String(bytes));
  }
}
