package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IGbMessage;
import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.Tools;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实时数据
 *
 * @author qsxiaogang
 */
public class GB_02 implements IGbMessage {

  private static final Logger logger = LoggerFactory.getLogger(GB_02.class);

  private int getMessageType() {
    return 0x02;
  }

  private String time;

  @Override
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  private List<IRealTimeAdditionalItem> additionals;

  public List<IRealTimeAdditionalItem> getAdditionals() {
    return additionals;
  }

  public void setAdditionals(List<IRealTimeAdditionalItem> additionals) {
    this.additionals = additionals;
  }

  /**
   * 获取 实时信息指定数据项
   * @param additionalId
   * @return
   */
  public IRealTimeAdditionalItem getRealTimeAdditionalItem(int additionalId) {
    for (IRealTimeAdditionalItem item : this.getAdditionals()) {
      if (additionalId == item.getAdditionalId()){
        return item;
      }
    }

    return null;
  }


  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(Byte.parseByte(getTime().substring(2, 4), 10));
    buff.put(Byte.parseByte(getTime().substring(5, 7), 10));
    buff.put(Byte.parseByte(getTime().substring(8, 10), 10));
    buff.put(Byte.parseByte(getTime().substring(11, 13), 10));
    buff.put(Byte.parseByte(getTime().substring(14, 16), 10));
    buff.put(Byte.parseByte(getTime().substring(17, 19), 10));
    for (IRealTimeAdditionalItem item : additionals) {
      if (item != null) {
        //				$.trace(Tools.ToHexString((byte)item.getAdditionalId()).toLowerCase());
        //				$.trace(Tools.ToHexString(item.WriteToBytes()).toLowerCase());
        buff.put((byte) item.getAdditionalId());
        buff.put(item.WriteToBytes());
      }
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] timeBytes = buff.gets(6);
    setTime(
        "20" + String.format("%02d", timeBytes[0]) + "-" + String.format("%02d", timeBytes[1]) + "-"
            + String.format("%02d", timeBytes[2]) + " "
            + String.format("%02d", timeBytes[3]) + ":" + String.format("%02d", timeBytes[4]) + ":"
            + String.format("%02d", timeBytes[5]));

    int pos = 6;
    this.additionals = new ArrayList<>();
    while (buff.hasRemain()) {
      int subCode = (buff.get() & 0xFF);
      byte[] subBytes = new byte[messageBodyBytes.length - pos - 1];
      System.arraycopy(messageBodyBytes, pos + 1, subBytes, 0, subBytes.length);
      //			$.trace(Tools.ToHexString((byte)subCode).toLowerCase());
      //			$.trace(Tools.ToHexString(subBytes).toLowerCase());
      IRealTimeAdditionalItem item = GBMessageFactory.Create(getMessageType(), subCode, subBytes);

      if (item != null) {
        getAdditionals().add(item);
        if (item.getAdditionalLength() != -1) {
          pos = pos + 1 + item.getAdditionalLength();
          buff.gets(item.getAdditionalLength());
        } else {
          int itemLength = item.WriteToBytes().length;
          pos = pos + 1 + itemLength;
          buff.gets(itemLength);
        }
      } else {
        logger.info("未知的附加协议:" + Tools.ToHexString(subCode));
        break;
      }
    }
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "数据单元", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "数据采集时间", getTime()));

    if (additionals.size() > 0) {
      sBuilder.append(jsonSplit);
      for (int i = 0, length = additionals.size(); i < length; i++) {
        IRealTimeAdditionalItem item = additionals.get(i);
        sBuilder.append(item.toString());
        if (i != length - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("}");
    return sBuilder.toString();
  }
}
