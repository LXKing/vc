package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.Tools;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class T808Message {

  private static final Logger logger = LoggerFactory.getLogger(T808Message.class);

  private T808MessageHeader header = new T808MessageHeader();

  private int status;
  /**
   * 如果是分包，分包是不能解析的，等待和其他包合成一个完整的包才能解析
   */
  private byte[] childPacket;

  public String getSimNo() {
    if (header != null) {
      return header.getSimId();
    }
    return "";
  }

  public String toString() {
    if (messageContents != null) {
      return messageContents.toString();
    } else if (this.getHeader().getIsPackage()) {
      return "分包号:" + this.getHeader().getMessagePacketNo() + ",总包数:" + this.getHeader()
          .getMessageTotalPacketsCount();
    }
    return "";
  }

  public final int getStatus() {
    return status;
  }

  public final void setStatus(int value) {
    status = value;
  }

  /**
   * 报文头
   */
  public final T808MessageHeader getHeader() {
    return header;
  }

  public final void setHeader(T808MessageHeader value) {
    header = value;
  }

  private static byte _PrefixID = 0x7E;

  public static byte getPrefixID() {
    return _PrefixID;
  }

  public final int getMessageType() {
    return getHeader().getMessageType();
  }

  private byte[] _checkSum = null;

  public final byte[] getCheckSum() {
    return _checkSum;
  }

  private IMessageBody messageContents;

  public final IMessageBody getMessageContents() {
    return messageContents;
  }

  public final void setMessageContents(IMessageBody value) {
    messageContents = value;
  }

  private String plateNo;

  public final String getPlateNo() {
    return plateNo;
  }

  public final void setPlateNo(String value) {
    plateNo = value;
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
    // buff.mark();
    byte[] bodyBytes = null;
    if (getMessageContents() != null) {
      bodyBytes = getMessageContents().WriteToBytes();
    }
    // java.util.ArrayList<Byte> messageBytes = new
    // java.util.ArrayList<Byte>();
    if (bodyBytes != null) {
      header.setMessageSize(bodyBytes.length);
      header.setIsPackage(false);
      byte[] headerBytes = header.WriteToBytes();
      buff.put(headerBytes);
      buff.put(bodyBytes);
    } else {
      header.setMessageSize(0);
      byte[] headerBytes = header.WriteToBytes();
      buff.put(headerBytes);
    }
    // int pos = buff.position();
    // byte[] messageBytes = new byte[pos - buff.markValue() + 1];
    // buff.get(messageBytes);
    byte[] messageBytes = buff.array();
    byte checkSum = GetCheckXor(messageBytes, 0, messageBytes.length);
    // messageBytes[messageBytes.length - 1] = checkSum; // 填充校验码
    buff.put(checkSum);
    byte[] escapedBytes = Escape(buff.array()); // 转义
    buff.clear();
    buff.put(_PrefixID);
    buff.put(escapedBytes);
    buff.put(_PrefixID);

    byte[] data = buff.array();
    this.packetDescr = Tools.ToHexString(data);
    return data;

  }

  public static ConcurrentMap<String, List<byte[]>> msgMap = new ConcurrentHashMap<String, List<byte[]>>();

  private void getWholePacket() {
    T808MessageHeader header = this.getHeader();
    if (header.getIsPackage() == false) {
      return;
    }
    String key = this.getSimNo() + "_" + this.getMessageType();
    if (header.getMessagePacketNo() == 1) {
      List<byte[]> ls = new ArrayList();
      ls.add(this.childPacket);
      msgMap.put(key, ls);
    } else if (header.getMessagePacketNo() > 1) {
      List<byte[]> ls = msgMap.get(key);
      ls.add(this.childPacket);
      if (header.getMessagePacketNo() == header.getMessageTotalPacketsCount()) {
        int totalByteNum = 0;
        for (byte[] bs : ls) {
          totalByteNum += bs.length;
        }
        byte[] totalBytes = new byte[totalByteNum];
        int m = 0;
        int start = 0;
        for (byte[] bs : ls) {
          System.arraycopy(bs, 0, totalBytes, start, bs.length);
          start += bs.length;
        }
        setMessageContents(T808MessageFactory.Create(header.getMessageType(), totalBytes));
        msgMap.remove(key);
      }
    }
  }

  public final void ReadFromBytes(byte[] messageBytes) {

    this.packetDescr = Tools.ToHexString(messageBytes);
    byte[] validMessageBytes = UnEscape(messageBytes);
    // setPacketDescr(ParseUtil.ToHexString(messageBytes, 0,
    // messageBytes.length));
    try {
      // 检测校验码
      byte xor = GetCheckXor(validMessageBytes, 1, validMessageBytes.length - 2);
      byte realXor = validMessageBytes[validMessageBytes.length - 2];
      if (xor == realXor) {
        _checkSum = new byte[]{xor};
        try {
          try {
            int tempLen = validMessageBytes.length - 1 - 1 - 1;
            byte[] headerBytes = new byte[tempLen < 16 ? 12 : 16];
            System.arraycopy(validMessageBytes, 1, headerBytes, 0, headerBytes.length);
            header.ReadFromBytes(headerBytes);

            int start = 17;
            if (!header.getIsPackage()) { // 不分包则少4个字节的分包信息
              start = 13;
            }
            if (header.getMessageSize() > 0) {
              byte[] sourceData = new byte[header.getMessageSize()];
              System.arraycopy(validMessageBytes, start, sourceData, 0, sourceData.length);
              if (header.getIsPackage() && header.getMessagePacketNo() > 1) {
                // 分包的消息体是纯数据不进行解析，保留在消息中.
                childPacket = new byte[header.getMessageSize()];
                System.arraycopy(sourceData, 0, childPacket, 0, header.getMessageSize());
                // getWholePacket();// 等所有的包都到达后，再进行解析

              } else {
                // 其余的包都进行解析
                setMessageContents(T808MessageFactory.Create(header.getMessageType(), sourceData));
              }

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
      logger.error("T808Message : ReadFromBytes() " + Tools.ToHexFormatString(messageBytes));
      setErrorMessage("解析异常:" + ex.getMessage());
      logger.error(getErrorMessage(), ex);
      // logger.error("解析错误:", ex);
    }
    // _dataBlock = messageBytes;
  }

  /**
   * 获取校验和
   */
  private byte GetCheckXor(byte[] data, int pos, int len) {
    byte A = 0;
    for (int i = pos; i < len; i++) {
      A ^= data[i];
    }
    return A;
  }

  /**
   * 将标识字符的转义字符还原
   */
  private byte[] UnEscape(byte[] data) {
    MyBuffer buff = new MyBuffer();
    for (int i = 0; i < data.length; i++) {
      if (data[i] == 0x7D) {
        if (data[i + 1] == 0x01) {
          buff.put((byte) 0x7D);
          i++;
        } else if (data[i + 1] == 0x02) {
          buff.put((byte) 0x7E);
          i++;
        }
      } else {
        buff.put(data[i]);
      }
    }

    byte[] a = buff.array();

    return a;
  }

  /**
   * 加入标示符的转义进行封装
   */
  private byte[] Escape(byte[] data) {
    MyBuffer tmp = new MyBuffer();
    for (int j = 0; j < data.length; j++) {
      if (data[j] == 0x7D) {
        tmp.put((byte) 0x7D);
        tmp.put((byte) 0x01);
      } else if (data[j] == 0x7E) {
        tmp.put((byte) 0x7D);
        tmp.put((byte) 0x02);
      } else {
        tmp.put(data[j]);
      }
    }

    return tmp.array();
  }

  public byte[] getChildPacket() {
    return childPacket;
  }

  public void setChildPacket(byte[] childPacket) {
    this.childPacket = childPacket;
  }

}