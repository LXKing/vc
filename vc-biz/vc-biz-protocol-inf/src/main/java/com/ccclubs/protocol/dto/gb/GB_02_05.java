package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;

/**
 * 车辆位置数据
 *
 * @author qsxiaogang
 */
public class GB_02_05 implements IRealTimeAdditionalItem {

  /**
   * 字节位 描述 0 0:有效定位；1:无效定位（当数据通信正常，而不能获取定位信息时，发送最后一次有效定位信息，并将定位状态置为无效。） 1 0:北纬；1:南纬。 2 0:东经；1:西经。
   * 3~7 保留。
   */
  private byte positionStatus;
  /**
   * 以度为单位的纬度值乘以10的6次方，精确到百万分之一度。
   */
  private int latitude;
  /**
   * 以度为单位的纬度值乘以10的6次方，精确到百万分之一度。
   */
  private int longitude;

  @Override
  public int getAdditionalId() {
    return 0x05;
  }

  @Override
  public int getAdditionalLength() {
    return 9;
  }

  public byte getPositionStatus() {
    return positionStatus;
  }

  public void setPositionStatus(byte positionStatus) {
    this.positionStatus = positionStatus;
  }

  public int getLatitude() {
    return latitude;
  }

  public void setLatitude(int latitude) {
    this.latitude = latitude;
  }

  public int getLongitude() {
    return longitude;
  }

  public void setLongitude(int longitude) {
    this.longitude = longitude;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getPositionStatus());
    buff.put(getLongitude());
    buff.put(getLatitude());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setPositionStatus(buff.get());
    setLongitude(buff.getInt());
    setLatitude(buff.getInt());
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "车辆位置数据", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "定位状态", getPositionStatusString()));
    sBuilder.append(jsonSplit);
    BigDecimal bigDecimalLong = AccurateOperationUtils.mul(getLongitude(), 0.000001);
    bigDecimalLong = bigDecimalLong.setScale(6, BigDecimal.ROUND_HALF_UP);
    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "经度", bigDecimalLong.toString()));
    sBuilder.append(jsonSplit);

    BigDecimal bigDecimalLat = AccurateOperationUtils.mul(getLatitude(), 0.000001);
    bigDecimalLat = bigDecimalLat.setScale(6, BigDecimal.ROUND_HALF_UP);
    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "纬度", bigDecimalLat.toString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getPositionStatusString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append((getPositionStatus() & 0x1) == 0 ? "有效定位" : "无效定位");
    sBuilder.append(";");
    sBuilder.append((getPositionStatus() & 0x2) == 0 ? "北纬" : "南纬");
    sBuilder.append(";");
    sBuilder.append((getPositionStatus() & 0x4) == 0 ? "东经" : "西经");

    return sBuilder.toString();
  }
}
