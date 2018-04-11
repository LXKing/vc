package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. <b>中导专用<b/>分时租赁插件版本，终端信息
 */
@Deprecated
public class MachineAdditional_Z_PluginVersion implements IMachineAdditionalItem {

  /**
   * 分时租赁插件插件版本
   */
  private int pluginVersion;

  @Override
  public byte getAdditionalId() {
    return 30;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  public int getPluginVersion() {
    return pluginVersion;
  }

  public void setPluginVersion(int pluginVersion) {
    this.pluginVersion = pluginVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getPluginVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setPluginVersion(buff.getShort());
  }
}
