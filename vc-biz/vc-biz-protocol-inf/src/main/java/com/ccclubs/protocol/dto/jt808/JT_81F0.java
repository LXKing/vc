package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * 通领终端升级指令
 */
public class JT_81F0 implements IMessageBody {

  /**
   * 命令字
   */
  private byte messageType;
  /**
   * 拨号点名称
   */
  private String dialPointName;
  /**
   * 拨号用户名
   */
  private String dialUserName;
  /**
   * 拨号密码
   */
  private String dialPassword;
  /**
   * FTP 地址
   */
  private String ftpAddress;
  /**
   * FTP 端口
   */
  private String ftpPort;
  /**
   * FTP 用户名
   */
  private String ftpUserName;
  /**
   * FTP 密码
   */
  private String ftpPassword;
  /**
   * 文件名
   */
  private String fileName;
  /**
   * 连接到指定服务器时限
   * 单位：分（ min），值非0 表示在终端接收到升级或连接指定
   * 服务器指令后的有效期截止前，终端应连回原地址。若值为
   * 0，则表示一直连接指定服务器
   */
  private String connectToServerTimeLimit;

  public byte getMessageType() {
    return messageType;
  }

  public void setMessageType(byte messageType) {
    this.messageType = messageType;
  }

  public String getDialPointName() {
    return dialPointName;
  }

  public void setDialPointName(String dialPointName) {
    this.dialPointName = dialPointName;
  }

  public String getDialUserName() {
    return dialUserName;
  }

  public void setDialUserName(String dialUserName) {
    this.dialUserName = dialUserName;
  }

  public String getDialPassword() {
    return dialPassword;
  }

  public void setDialPassword(String dialPassword) {
    this.dialPassword = dialPassword;
  }

  public String getFtpAddress() {
    return ftpAddress;
  }

  public void setFtpAddress(String ftpAddress) {
    this.ftpAddress = ftpAddress;
  }

  public String getFtpPort() {
    return ftpPort;
  }

  public void setFtpPort(String ftpPort) {
    this.ftpPort = ftpPort;
  }

  public String getFtpUserName() {
    return ftpUserName;
  }

  public void setFtpUserName(String ftpUserName) {
    this.ftpUserName = ftpUserName;
  }

  public String getFtpPassword() {
    return ftpPassword;
  }

  public void setFtpPassword(String ftpPassword) {
    this.ftpPassword = ftpPassword;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getConnectToServerTimeLimit() {
    return connectToServerTimeLimit;
  }

  public void setConnectToServerTimeLimit(String connectToServerTimeLimit) {
    this.connectToServerTimeLimit = connectToServerTimeLimit;
  }

  private static String separator = ";";

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getMessageType());
    if (!StringUtils.empty(getDialPointName())) {
      byte[] strBytes = BitConverter.getBytes(getDialPointName());
      buff.put(strBytes);
    }
    buff.put(BitConverter.getBytes(separator));

    if (!StringUtils.empty(getDialUserName())) {
      byte[] strBytes = BitConverter.getBytes(getDialUserName());
      buff.put(strBytes);
    }
    buff.put(BitConverter.getBytes(separator));

    if (!StringUtils.empty(getDialPassword())) {
      byte[] strBytes = BitConverter.getBytes(getDialPassword());
      buff.put(strBytes);
    }
    buff.put(BitConverter.getBytes(separator));

    if (!StringUtils.empty(getFtpAddress())) {
      byte[] strBytes = BitConverter.getBytes(getFtpAddress());
      buff.put(strBytes);
    }
    buff.put(BitConverter.getBytes(separator));

    if (!StringUtils.empty(getFtpPort())) {
      byte[] strBytes = BitConverter.getBytes(getFtpPort());
      buff.put(strBytes);
    }
    buff.put(BitConverter.getBytes(separator));

    if (!StringUtils.empty(getFtpUserName())) {
      byte[] strBytes = BitConverter.getBytes(getFtpUserName());
      buff.put(strBytes);
    }
    buff.put(BitConverter.getBytes(separator));

    if (!StringUtils.empty(getFtpPassword())) {
      byte[] strBytes = BitConverter.getBytes(getFtpPassword());
      buff.put(strBytes);
    }
    buff.put(BitConverter.getBytes(separator));

    if (!StringUtils.empty(getFileName())) {
      byte[] strBytes = BitConverter.getBytes(getFileName());
      buff.put(strBytes);
    }
    buff.put(BitConverter.getBytes(separator));

    if (!StringUtils.empty(getConnectToServerTimeLimit())) {
      byte[] strBytes = BitConverter.getBytes(getConnectToServerTimeLimit());
      buff.put(strBytes);
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);

    setMessageType(buff.get());

    byte[] strBytes = buff.gets(messageBodyBytes.length - 1);
    String strValue = BitConverter.getString(strBytes, 0,
        strBytes.length);

    String[] strArray = strValue.split(separator);
    if (strArray.length != 9) {
      return;
    }

    setDialPointName(strArray[0]);
    setDialUserName(strArray[1]);
    setDialPassword(strArray[2]);
    setFtpAddress(strArray[3]);
    setFtpPort(strArray[4]);
    setFtpUserName(strArray[5]);
    setFtpPassword(strArray[6]);
    setFileName(strArray[7]);
    setConnectToServerTimeLimit(strArray[8]);
  }

}
