package com.ccclubs.protocol.dto.mqtt.can;

import com.ccclubs.protocol.dto.mqtt.CStruct;
import com.ccclubs.protocol.inf.ICanData;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CanHelperFactory {

  private final static byte CAN_STATUS_FUC_CODE = 0x69; // CAN数据标识位

  public static ICanData getCanData(CanStatusZotye can) {
    ICanData canData;
    switch (can.mCanType) {
      case 0x01:
        try {
          canData = new CanDataTypeI();
        } catch (Exception e) {
          canData = null;
        }
        break;
      case 0x02:
        try {
          canData = new CanDataTypeII();
        } catch (Exception e) {
          canData = null;
        }
        break;
      default:
        canData = null;
        break;
    }
    return canData;
  }

  /**
   * 解析CanData，返回Can包数据list
   */
  public static List<ICanData> parseCanData(final String canData) {
    // 遍历数据包个数
    List<ICanData> canDataList = new ArrayList<>();
    try {
      // 解析Can数据 add at 2016-04-29
      // 第17位为 0x69 为CAN数据
      final byte[] mMessage = Tools.HexString2Bytes(canData);
      if (mMessage.length > CanStatusZotye.sizeof(CanStatusZotye.class)
          && mMessage[16] == CAN_STATUS_FUC_CODE) {
        CanStatusZotye canZotye = CanStatusZotye.readObject(mMessage, CanStatusZotye.class);
        if (canZotye == null || canZotye.mCanNum <= 0) {
          return canDataList;
        }

        int headDataLength = CStruct.sizeof(CanStatusZotye.class);
        // 获取CanData子集对象
        ICanData itemData = CanHelperFactory.getCanData(canZotye);
        int itemLength = itemData.getLength();
        for (int i = 0; i < canZotye.mCanNum; i++) {
          try {
            ICanData data = CStruct
                .readObject(Tools.subBytes(mMessage, headDataLength + itemLength * i, itemLength),
                    itemData.getClassType());
            if (data != null && data.getCanId() > 0) {
              // data.traceStruct();
              // $.trace($.json(data.getMap()));
              canDataList.add(data);
            }
          } catch (Exception e) {
            e.printStackTrace();
            continue;
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.print("canData error : " + canData);
      return canDataList;
    }
    return canDataList;
  }

  public static String parseCanErrorData(final String canData) {
    List<ICanData> canDataList = parseCanData(canData);
    if (canDataList.size() == 0) {
      return "";
    }

    StringBuilder sBuilder = new StringBuilder();
    for (ICanData iCanData : canDataList) {
      Map<String, Object> map = iCanData.getErrorInfoMap();

      for (Map.Entry<String, Object> entry : map.entrySet()) {
        sBuilder.append("[");
        sBuilder.append(entry.getKey());
        sBuilder.append(":");
        sBuilder.append(entry.getValue());
        sBuilder.append("]");
      }
    }

    return StringUtils.empty(sBuilder.toString()) ? "" : sBuilder.toString();
  }
}
