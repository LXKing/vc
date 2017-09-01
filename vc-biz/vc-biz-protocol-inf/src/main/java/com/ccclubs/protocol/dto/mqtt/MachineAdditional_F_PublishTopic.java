package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17.
 * <b>富士康专用<b/>富士康发布主题，终端信息
 */
public class MachineAdditional_F_PublishTopic implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 富士康发布主题
   */
  private String publishTopic;

  public String getPublishTopic() {
    return StringUtils.trim(publishTopic);
  }

  public void setPublishTopic(String publishTopic) {
    this.publishTopic = publishTopic;
  }

  @Override
  public byte getAdditionalId() {
    return 0x16;
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
    buff.put(getPublishTopic());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setPublishTopic(new String(bytes));
  }
}
