package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

public class CCCLUBS_03 implements IMessageBody {

  private int subFucCode;
  /**
   * 输出地址
   */
  private int outputAddress;
  /**
   * 输出数量
   */
  private int quantityOfOutputs;

  private IMessageBody messageContents;

  public int getSubFucCode() {
    return subFucCode & 0xFF;
  }

  public void setSubFucCode(int subFucCode) {
    this.subFucCode = subFucCode;
  }

  public int getOutputAddress() {
    return outputAddress;
  }

  public void setOutputAddress(int outputAddress) {
    this.outputAddress = outputAddress;
  }

  public int getQuantityOfOutputs() {
    return quantityOfOutputs;
  }

  public void setQuantityOfOutputs(int quantityOfOutputs) {
    this.quantityOfOutputs = quantityOfOutputs;
  }

  public IMessageBody getMessageContents() {
    return messageContents;
  }

  public void setMessageContents(IMessageBody messageContents) {
    this.messageContents = messageContents;
  }

  /**
   * 获取MAC地址 <b>需要校验返回值</b>
   */
  public final String getMacValue() {
    IMessageBody item = getMessageContents();
    if (item == null) {
      return null;
    }
    if ((getOutputAddress() & 0xFFFF) == 0x0066) {
      CCCLUBS_03_0066 macItem = (CCCLUBS_03_0066) item;
      return macItem.getMacValue();
    } else {
      return null;
    }
  }

  /**
   * 获取插枪还车状态<b>需要校验返回值</b>
   */
  public final short getGunValue() {
    IMessageBody item = getMessageContents();
    if (item == null) {
      return 0;
    }
    if ((getOutputAddress() & 0xFFFF) == 0x0492) {
      CCCLUBS_03_0492 gunItem = (CCCLUBS_03_0492) item;
      return gunItem.getGun();
    } else {
      return 0;
    }
  }

  /**
   * 获取蓝牙密钥 <b>需要校验返回值</b>
   */
  public final String getBleKey() {
    IMessageBody item = getMessageContents();
    if (item == null) {
      return null;
    }
    if ((getOutputAddress() & 0xFFFF) == 0x0481) {
      CCCLUBS_03_0481 macItem = (CCCLUBS_03_0481) item;
      return macItem.getBleKey();
    } else {
      return null;
    }
  }

  /**
   * 获取多媒体DVD当前版本<b>需要校验返回值</b>
   */
  public final short getMediaCurrentVersion() {
    IMessageBody item = getMessageContents();
    if (item == null) {
      return 0;
    }
    if ((getOutputAddress() & 0xFFFF) == 0x04C4) {
      CCCLUBS_03_04C4 mediaItem = (CCCLUBS_03_04C4) item;
      return mediaItem.getMediaCurrentVersion();
    } else {
      return 0;
    }
  }

  /**
   * 获取多媒体DVD最新版本<b>需要校验返回值</b>
   */
  public final short getMediaNewVersion() {
    IMessageBody item = getMessageContents();
    if (item == null) {
      return 0;
    }
    if ((getOutputAddress() & 0xFFFF) == 0x04C4) {
      CCCLUBS_03_04C6 mediaItem = (CCCLUBS_03_04C6) item;
      return mediaItem.getMediaNewVersion();
    } else {
      return 0;
    }
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getSubFucCode());
    buff.put((short) getOutputAddress());
    buff.put((short) getQuantityOfOutputs());
    if (getMessageContents() != null) {
      buff.put(getMessageContents().WriteToBytes());
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {

    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setSubFucCode(buff.get());
    setOutputAddress(buff.getShort());
    setQuantityOfOutputs(buff.getShort());
    setMessageContents(MqMessageFactory.Create(getSubFucCode(), getOutputAddress(),
        buff.gets(messageBodyBytes.length - 1 - 2 - 2)));

  }

}
