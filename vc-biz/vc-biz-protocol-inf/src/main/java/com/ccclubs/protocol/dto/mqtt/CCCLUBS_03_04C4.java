package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

public class CCCLUBS_03_04C4 implements IMessageBody {

  /**
   * 多媒体DVD当前版本
   */
  private Short mediaCurrentVersion;

  public Short getMediaCurrentVersion() {
    return mediaCurrentVersion;
  }

  public void setMediaCurrentVersion(Short mediaCurrentVersion) {
    this.mediaCurrentVersion = mediaCurrentVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getMediaCurrentVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    short bleBytes = buff.getShort();
    setMediaCurrentVersion(bleBytes);
  }
}
