package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 车机屏当前APP版本，终端信息
 */
public class MachineAdditional_MediaNewVersion implements IMachineAdditionalItem {

  /**
   * 车机屏最新APP版本
   */
  private int mediaNewVersion;

  @Override
  public byte getAdditionalId() {
    return 0x0E;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  public int getMediaNewVersion() {
    return mediaNewVersion;
  }

  public void setMediaNewVersion(int mediaNewVersion) {
    this.mediaNewVersion = mediaNewVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getMediaNewVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setMediaNewVersion(buff.getShort());
  }
}
