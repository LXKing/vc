package com.ccclubs.protocol.dto.mqtt.can;

import com.ccclubs.protocol.dto.mqtt.CStruct;
import com.ccclubs.protocol.inf.ICanData;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qsxiaogang
 */
public class CanDataTypeII extends CStruct implements ICanData {

  public int mCanId;

  public byte mCanLength;

  public byte mCanData1;
  public byte mCanData2;
  public byte mCanData3;
  public byte mCanData4;
  public byte mCanData5;
  public byte mCanData6;
  public byte mCanData7;
  public byte mCanData8;

  @Override
  public int getLength() {
    return CStruct.sizeof(CanDataTypeII.class);
  }

  @Override
  public void traceStruct() {
    CStruct.trace(this);
  }

  @Override
  public Map<String, Object> getMap() {
    Map<String, Object> mapResult = new HashMap<String, Object>();
    return mapResult;
  }

  @Override
  public Class getClassType() {
    return CanDataTypeII.class;
  }

  @Override
  public int getCanId() {
    return mCanId;
  }

  @Override
  public Map<String, Object> getErrorInfoMap() {
    Map<String, Object> mapResult = new HashMap<String, Object>();
    return mapResult;
  }

}
