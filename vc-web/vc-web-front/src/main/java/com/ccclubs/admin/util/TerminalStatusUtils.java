package com.ccclubs.admin.util;

/**
 * @author qsxiaogang
 * @create 2017-12-17
 **/
public class TerminalStatusUtils {

  private static final String SEPARATOR = ",";

  /**
   * 获取车门详细信息
   */
  public static String getDoorString(short doorStatus) {
    // 取高字节
    byte doorMask = (byte) (doorStatus >> 8);
    // 取低字节
    byte doorValue = (byte) (doorStatus & 0xF);

    StringBuilder stringBuilder = new StringBuilder();
    // Bit0 所有门状态有效位：0-无效，1-有效
    if ((doorMask & 0x1) == 0x1) {
      if ((doorValue & 0x1) == 0x01) {
        // 排除 "所有门状态" 外，其他所有门的状态位都为0，那么直接返回有车门未关
        if (((doorValue >> 1) & 0xF) == 0) {
          return "有车门未关";
        }
      } else {
        return "全关";
      }
    }

    // Bit1 左前门有效位：0-无效，1-有效
    if (((doorMask >> 1) & 0x1) == 0x01) {
      if (((doorValue >> 1) & 0x1) == 0x01) {
        stringBuilder.append("驾驶员门");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit2 右前门有效位：0-无效，1-有效
    if (((doorMask >> 2) & 0x1) == 0x01) {
      if (((doorValue >> 2) & 0x1) == 0x01) {
        stringBuilder.append("副驾驶员门");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit3 左后门有效位：0-无效，1-有效
    if (((doorMask >> 3) & 0x1) == 0x01) {
      if (((doorValue >> 3) & 0x1) == 0x01) {
        stringBuilder.append("驾驶员后门");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit4 右后门有效位：0-无效，1-有效
    if (((doorMask >> 4) & 0x1) == 0x01) {
      if (((doorValue >> 4) & 0x1) == 0x01) {
        stringBuilder.append("副驾驶员后门");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit5 行李舱门有效位：0-无效，1-有效
    if (((doorMask >> 5) & 0x1) == 0x01) {
      if (((doorValue >> 5) & 0x1) == 0x01) {
        stringBuilder.append("后备箱门");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit6 前机舱有效位：0-无效，1-有效
    if (((doorMask >> 6) & 0x1) == 0x01) {
      if (((doorValue >> 6) & 0x1) == 0x01) {
        stringBuilder.append("引擎盖门");
        stringBuilder.append(SEPARATOR);
      }
    }

    if (stringBuilder.length() > 0) {
      return stringBuilder.toString().substring(0, stringBuilder.length() - 1) + "未关";
    }

    return "";
  }

  /**
   * 获取车灯详细信息
   */
  private static String getLightString(int lightStatus) {
    // 取高双字节
    short lightMask = (short) (lightStatus >> 16);
    // 取低双字节
    short lightValue = (short) (lightStatus & 0xFF);

    StringBuilder stringBuilder = new StringBuilder();

    // Bit0 所有灯状态有效位：0-无效，1-有效
    if ((lightMask & 0x1) == 0x1) {
      if ((lightValue & 0x1) == 0x01) {
        // 排除 "所有灯状态" 外，其他所有灯的状态位都为0，那么直接返回有车灯未关
        if (((lightValue >> 1) & 0xF) == 0) {
          return "有车灯未关";
        }
      } else {
        return "全关";
      }
    }

    // Bit1 近光灯有效位： 0-OFF，1-ON
    if (((lightMask >> 1) & 0x1) == 0x01) {
      if (((lightValue >> 1) & 0x1) == 0x01) {
        stringBuilder.append("近光灯");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit2 远光灯有效位：0-OFF，1-ON
    if (((lightMask >> 2) & 0x1) == 0x01) {
      if (((lightValue >> 2) & 0x1) == 0x01) {
        stringBuilder.append("远光灯");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit3 前雾灯有效位：0-OFF，1-ON
    if (((lightMask >> 3) & 0x1) == 0x01) {
      if (((lightValue >> 3) & 0x1) == 0x01) {
        stringBuilder.append("前雾灯");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit4 后雾灯有效位：0-OFF，1-ON
    if (((lightMask >> 4) & 0x1) == 0x01) {
      if (((lightValue >> 4) & 0x1) == 0x01) {
        stringBuilder.append("后雾灯");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit5 左转向有效位：0-OFF，1-ON
    if (((lightMask >> 5) & 0x1) == 0x01) {
      if (((lightValue >> 5) & 0x1) == 0x01) {
        stringBuilder.append("左转向灯");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit6 右转向有效位：0-OFF，1-ON
    if (((lightMask >> 6) & 0x1) == 0x01) {
      if (((lightValue >> 6) & 0x1) == 0x01) {
        stringBuilder.append("右转向灯");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit7 位置灯有效位：0-OFF，1-ON
    if (((lightMask >> 7) & 0x1) == 0x01) {
      if (((lightValue >> 7) & 0x1) == 0x01) {
        stringBuilder.append("位置灯");
        stringBuilder.append(SEPARATOR);
      }
    }
    // Bit8 故障灯有效位：0-无效，1-有效
    if (((lightMask >> 8) & 0x1) == 0x01) {
      if (((lightValue >> 8) & 0x1) == 0x01) {
        stringBuilder.append("故障灯");
        stringBuilder.append(SEPARATOR);
      }
    }

    if (stringBuilder.length() > 0) {
      return stringBuilder.toString().substring(0, stringBuilder.length() - 1) + "未关";
    }

    return "";
  }
}
