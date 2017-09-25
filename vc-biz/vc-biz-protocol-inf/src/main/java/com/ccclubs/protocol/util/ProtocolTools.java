package com.ccclubs.protocol.util;


import com.ccclubs.protocol.dto.jt808.JT_0900;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.jt808.T808MessageHeader;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by qsxiaogang on 2017/7/2.
 */
public class ProtocolTools {

  /**
   * 分时租赁协议包装成808协议格式
   *
   * @param simNo 手机号
   * @param srcArray 分时租赁协议字节数组{@link com.ccclubs.protocol.dto.mqtt.MqMessage}
   */
  public static T808Message package2T808Message(String simNo, byte[] srcArray) {
    T808Message ts = new T808Message();
    ts.setHeader(new T808MessageHeader());
    ts.getHeader().setSimId(simNo);
    ts.getHeader().setIsPackage(false);
    ts.getHeader().setMessageType(0x8900);
    JT_0900 cmdData = new JT_0900();
    cmdData.setMessageType((byte) 0xF1);
    cmdData.setMessageContent(srcArray);
    ts.setMessageContents(cmdData);
    return ts;
  }

  /**
   * 终端时间转换成服务器时间
   *
   * @param terminalTime 终端时间
   */
  public static Long transformToServerTime(int terminalTime) {
    if (terminalTime < 0) {
      terminalTime = (terminalTime & 0xFFFFFFFF);
    }
    if (ConstantUtils.MACHINE_TIME + terminalTime * 1000L < ConstantUtils.MIN_SYSTEM_TIME) {
      return ConstantUtils.MIN_SYSTEM_TIME;
    } else {
      return ConstantUtils.MACHINE_TIME + terminalTime * 1000L;
    }
  }

  /**
   * 服务器时间转换成终端时间
   *
   * @param serverTime 服务器时间
   */
  public static int transformToTerminalTime(Date serverTime) {
    return transformToTerminalTime(serverTime.getTime());
  }

  /**
   * 服务器时间转换成终端时间
   *
   * @param serverTime 服务器时间
   */
  public static int transformToTerminalTime(Long serverTime) {
    return (int) ((serverTime - ConstantUtils.MACHINE_TIME) / 1000L);
  }

  /**
   * 判断GPS坐标是否有效
   *
   * @param lng 精度
   * @param lat 纬度
   */
  public static boolean isValid(double lng, double lat) {
    if (lng == 0 || lat == 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * 将单字节门状态转换为双字节带mask的门状态
   */
  public static int getTransformDoorStatus(byte mDoorStatus) {
    byte mask = 0;
    byte value = 0;
    // 取bit0-bit1，0-车门未全部关好，1-车门关好，2-车门信息未检测到
    if ((mDoorStatus & 0x3) == 0x01) {
      mask = (byte) (mask | 0x01);//bit0置1
      value = (byte) (value & 0xFE);//bit0置0
    } else if ((mDoorStatus & 0x3) == 0x00) {
      mask = (byte) (mask | 0x01);//bit0置1
      value = (byte) (value | 0x01);//bit0置1
    } else if ((mDoorStatus & 0x3) == 0x10) {
//      mask = 0;//bit0置1
//      value = 0;//bit0置0
      return 0;
    }
    // 取bit2-bit3，01是关，00是开
    if ((mDoorStatus >> 2 & 0x3) == 0x01) {
      mask = (byte) (mask | 0x2);//bit1置1
      value = (byte) (value & 0xFD);//bit1置0
    } else if ((mDoorStatus >> 2 & 0x3) == 0x00) {
      mask = (byte) (mask | 0x02);//bit1置1
      value = (byte) (value | 0x02);//bit1置1
    }

    // 取bit4-bit5，01是关，00是开
    if ((mDoorStatus >> 4 & 0x3) == 0x01) {
      mask = (byte) (mask | 0x4);//bit2置1
      value = (byte) (value & 0xFB);//bit2置0
    } else if ((mDoorStatus >> 4 & 0x3) == 0x00) {
      mask = (byte) (mask | 0x04);//bit2置1
      value = (byte) (value | 0x04);//bit2置1
    }

    // 取bit6-bit7，01是关，00是开
    if ((mDoorStatus >> 6 & 0x3) == 0x01) {
      mask = (byte) (mask | 0x20);//bit5置1
      value = (byte) (value & 0xDF);//bit5置0
    } else if ((mDoorStatus >> 6 & 0x3) == 0x00) {
      mask = (byte) (mask | 0x20);//bit5置1
      value = (byte) (value | 0x20);//bit5置1
    }

    return (mask << 8) + (value & 0xFF);
  }

  /**
   * 获取空调当前状态
   * @param airConditioner
   * @return
   */
  public static int getAirConditionerCircular(int airConditioner) {
    return airConditioner & 0x01;
  }

  /**
   * 获取空调PTC状态
   * @param airConditioner
   * @return
   */
  public static int getAirConditionerPtc(int airConditioner) {
    return (airConditioner >> 1) & 0x01;
  }

  /**
   * 获取空调压缩机状态
   * @param airConditioner
   * @return
   */
  public static int getAirConditionerCompres(int airConditioner) {
    return (airConditioner >> 2) & 0x01;
  }

  /**
   * 0x0：OFF 0x1：1档风量 0x2：2档风量 0x3：3档风量 0x4：4档风量
   */
  public static int getAirConditionerFan(int airConditioner) {
    return (airConditioner >> 3) & 0x07;
  }

  public static Object[] getArray(List<Map> requests, List<Map> values) {
    List list = new java.util.ArrayList();

    for (Map map : values) {
      for (Map struct : requests) {
        String name = (String) struct.get("name");
        String type = (String) struct.get("type");
        Integer size = Integer.parseInt(StringUtils.or(struct.get("size"), "0").toString());
        Object oValue = StringUtils.or(struct.get("defaultValue"), map.get(name));
        Object value = null;
        if (StringUtils.equals(type, "String")) {
          String sValue = ((String) oValue).trim();
          // 自定义长度
          if (size == 0) {
            value = Tools.HexString2Bytes(
                Tools.ToHexString(sValue) + "0000");
          } else {
            // 长度不够，需要补0x00
            if (sValue.length() < size) {
              MyBuffer buff = new MyBuffer();
              buff.put(sValue.getBytes());
              for (int i = 0; i + sValue.getBytes().length < size; i++) {
                buff.put((byte) 0x00);
              }
              value = buff.array();
            } else {
              // 固定长度
              byte bytes[] = new byte[size];
              System
                  .arraycopy(sValue.getBytes(), 0, bytes, 0,
                      Math.min(sValue.getBytes().length, size));
              value = bytes;
            }
          }
        } else if (StringUtils.equals(type, "Byte")) {
          String sValue = (String) oValue;
          value = (byte) Long
              .parseLong(sValue.replace("0x", ""), sValue.toLowerCase().startsWith("0x") ? 16 : 10);
        } else if (StringUtils.equals(type, "Short")) {
          String sValue = (String) oValue;
          value = (short) Long
              .parseLong(sValue.replace("0x", ""), sValue.toLowerCase().startsWith("0x") ? 16 : 10);
        } else if (StringUtils.equals(type, "Integer")) {
          String sValue = (String) oValue;
          value = (int) Long
              .parseLong(sValue.replace("0x", ""), sValue.toLowerCase().startsWith("0x") ? 16 : 10);
        } else if (StringUtils.equals(type, "Long")) {
          String sValue = (String) oValue;
          value = Long
              .parseLong(sValue.replace("0x", ""), sValue.toLowerCase().startsWith("0x") ? 16 : 10);
        } else if (StringUtils.equals(type, "Double")) {
          String sValue = (String) oValue;
          value = Double.parseDouble(sValue);
        } else if (StringUtils.equals(type, "Float")) {
          String sValue = (String) oValue;
          value = Double.parseDouble(sValue);
        } else if (StringUtils.equals(type, "Array")) {
          List<Map> array = (List<Map>) oValue;
          Object[] arr = getArray((List<Map>) struct.get("child"), array);
          for (Object a : arr) {
            list.add(a);
          }
          continue;
        }
        list.add(value);
      }
    }
    return list.toArray();
  }
}
