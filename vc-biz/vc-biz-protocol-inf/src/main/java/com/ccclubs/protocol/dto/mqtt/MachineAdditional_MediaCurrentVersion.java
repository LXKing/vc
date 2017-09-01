package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 车机屏当前APP版本，终端信息
 */
public class MachineAdditional_MediaCurrentVersion implements IMachineAdditionalItem {

  /**
   * 车机屏当前APP版本
   */
  private int mediaCurrentVersion;

  @Override
  public byte getAdditionalId() {
    return 0x0D;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }


  public int getMediaCurrentVersion() {
    return mediaCurrentVersion & 0xFFFF;
  }

  public void setMediaCurrentVersion(int mediaCurrentVersion) {
    this.mediaCurrentVersion = mediaCurrentVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getMediaCurrentVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setMediaCurrentVersion(buff.getShort());
  }
}
