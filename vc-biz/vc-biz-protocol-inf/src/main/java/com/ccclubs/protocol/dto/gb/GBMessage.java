package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IGbMessage;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GBMessage implements Serializable{

  private static final long serialVersionUID =         1L;

  private static final Logger logger = LoggerFactory.getLogger(GBMessage.class);

  private static byte _PrefixID = 0x23;

  public static byte getPrefixID() {
    return _PrefixID;
  }

  private GBMessageHeader header = new GBMessageHeader();

  /**
   * 报文头
   */
  public final GBMessageHeader getHeader() {
    return header;
  }

  public final void setHeader(GBMessageHeader value) {
    header = value;
  }

  public final int getMessageType() {
    return getHeader().getMessageType();
  }

  public final int getAckType() {
    return getHeader().getAckType();
  }

  public final int getEncodType() {
    return getHeader().getEncodeType();
  }

  public final String getVin() {
    return getHeader().getVin();
  }

  private byte _checkSum;

  public final byte getCheckSum() {
    return _checkSum;
  }

  private IGbMessage messageContents;

  public final IGbMessage getMessageContents() {
    return messageContents;
  }

  public final void setMessageContents(IGbMessage value) {
    messageContents = value;
  }

  private String packetDescr;

  public final String getPacketDescr() {
    return packetDescr;
  }

  public final void setPacketDescr(String value) {
    packetDescr = value;
  }

  private String errorMessage;

  public final String getErrorMessage() {
    return errorMessage;
  }

  public final void setErrorMessage(String value) {
    errorMessage = value;
  }

  public final byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    byte[] bodyBytes = null;

    if (getMessageContents() != null) {
      bodyBytes = getMessageContents().WriteToBytes();
    }

    if (bodyBytes != null) {
      header.setMessageSize(bodyBytes.length);
      byte[] headerBytes = header.WriteToBytes();
      buff.put(headerBytes);
      buff.put(bodyBytes);
    } else {
      header.setMessageSize(0);
      byte[] headerBytes = header.WriteToBytes();
      buff.put(headerBytes);
    }

    byte[] messageBytes = buff.array();
    byte checkSum = getCheckXor(messageBytes, 0, messageBytes.length);
    // messageBytes[messageBytes.length - 1] = checkSum; // 填充校验码
    buff.put(checkSum);
    byte[] escapedBytes = buff.array(); // 转义
    buff.clear();
    buff.put(_PrefixID);
    buff.put(_PrefixID);
    buff.put(escapedBytes);

    byte[] data = buff.array();
    this.packetDescr = Tools.ToHexString(data);
    return data;

  }

  public final void ReadFromBytes(byte[] messageBytes) {
    this.packetDescr = Tools.ToHexString(messageBytes);
    byte[] validMessageBytes = messageBytes;

    try {
      // 检测校验码
      byte xor = getCheckXor(validMessageBytes, 2, validMessageBytes.length - 1);
      byte realXor = validMessageBytes[validMessageBytes.length - 1];
      if (xor == realXor) {
        _checkSum = xor;
        try {
          try {
            byte[] headerBytes = new byte[GBMessageHeader.getHeaderSize()];
            System.arraycopy(validMessageBytes, 2, headerBytes, 0, headerBytes.length);
            header.ReadFromBytes(headerBytes);

            int start = GBMessageHeader.getHeaderSize() + 2;
            if (header.getMessageSize() > 0) {
              byte[] sourceData = new byte[header.getMessageSize()];
              System.arraycopy(validMessageBytes, start, sourceData, 0, sourceData.length);
              // 进行解析
              setMessageContents(GBMessageFactory.Create(header.getMessageType(), sourceData));
            }
          } finally {
            // binaryReader.dispose();
          }
        } finally {
          // ms.dispose();
        }
      } else {
        setErrorMessage("校验码不正确");
        logger.error(getErrorMessage() + ":" + Tools.ToHexFormatString(messageBytes));
      }

    } catch (Exception ex) {
      logger.error("GBMessage : ReadFromBytes() " + Tools.ToHexFormatString(messageBytes));
      setErrorMessage("解析异常:" + ex.getMessage());
      logger.error(getErrorMessage(), ex);
      // logger.error("解析错误:", ex);
    }
    // _dataBlock = messageBytes;
  }

  /**
   * 获取校验和
   */
  private byte getCheckXor(byte[] data, int pos, int len) {
    byte A = 0;
    for (int i = pos; i < len; i++) {
      A ^= data[i];
    }
    return A;
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    //		if (messageContents != null)
    //			return messageContents.toString();
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("{");
    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "起始符", "##"));
    if (getHeader() == null || !StringUtils.empty(getErrorMessage())) {
      sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "错误信息", getErrorMessage()));
      sBuilder.append("}");
      return sBuilder.toString();
    }

    sBuilder.append(jsonSplit);
    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "命令标识", getMessageTypeString()));

    sBuilder.append(jsonSplit);
    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "应答标志", getAckString()));

    sBuilder.append(jsonSplit);
    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "唯一识别码", getVin()));

    sBuilder.append(jsonSplit);
    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "数据单元加密方式", getEncodTypeString()));

    sBuilder.append(jsonSplit);
    sBuilder.append(String.format("\"%1$s\":%2$s", "数据单元长度", getHeader().getMessageSize()));

    if (getMessageContents() != null) {
      sBuilder.append(jsonSplit);
      sBuilder.append(getMessageContents().toString());
    }

    sBuilder.append(jsonSplit);
    sBuilder.append(String.format("\"%1$s\":\"0x%2$s\"", "校验码", Tools.ToHexString(getCheckSum())));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  private String getMessageTypeString() {
    switch (getMessageType()) {
      case 0x01:
        return "车辆登入";
      case 0x02:
        return "实时信息上报";
      case 0x03:
        return "补发信息上报";
      case 0x04:
        return "车辆登出";
      case 0x05:
      case 0x06:
        return "平台传输数据占用";
      case 0x07:
        return "心跳";
      case 0x08:
        return "终端校时";
      default:
        return "0x" + Tools.ToHexString((byte) getMessageType());
    }
  }

  private String getAckString() {
    switch (getAckType()) {
      case 0x01:
        return "成功";
      case 0x02:
        return "错误";
      case 0x03:
        return "VIN重复";
      case 0xFE:
        return "命令";
      default:
        return "";
    }
  }

  private String getEncodTypeString() {
    switch (getEncodType()) {
      case 0x01:
        return "数据不加密";
      case 0x02:
        return "数据经过RSA算法加密";
      case 0x03:
        return "数据经过AES128位算法加密";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效，其他预留";
      default:
        return "";
    }
  }
}