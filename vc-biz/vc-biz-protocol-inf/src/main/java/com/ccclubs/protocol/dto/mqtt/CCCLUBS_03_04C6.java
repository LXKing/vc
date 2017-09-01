package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

public class CCCLUBS_03_04C6 implements IMessageBody {

  /**
   * 多媒体DVD最新版本
   */
  private Short mediaNewVersion;

  public Short getMediaNewVersion() {
    return mediaNewVersion;
  }

  public void setMediaNewVersion(Short mediaNewVersion) {
    this.mediaNewVersion = mediaNewVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getMediaNewVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    short bleBytes = buff.getShort();
    setMediaNewVersion(bleBytes);
  }
}
