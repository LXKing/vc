package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;

/**
 * Created by qsxiaogang on 2018/5/24. GPS 辅助定位数据
 */
public class MachineAdditional_GpsAssistStatus implements IMachineAdditionalItem {

  /**
   * 经度，平均值
   */
  private int longitudeAvg;

  /**
   * 纬度，平均值
   */
  private int latitudeAvg;

  /**
   * 经度，最大值
   */
  private int longitudeMax;

  /**
   * 纬度，最大值
   */
  private int latitudeMax;

  /**
   * 经度，最小值
   */
  private int longitudeMin;

  /**
   * 纬度，最小值
   */
  private int latitudeMin;

  public int getLongitudeAvg() {
    return longitudeAvg;
  }

  public BigDecimal getLongitudeAvgDecimal() {
    return AccurateOperationUtils
        .mul(getLongitudeAvg(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
  }

  public void setLongitudeAvg(int longitudeAvg) {
    this.longitudeAvg = longitudeAvg;
  }

  public int getLatitudeAvg() {
    return latitudeAvg;
  }

  public BigDecimal getLatitudeAvgDecimal() {
    return AccurateOperationUtils
        .mul(getLatitudeAvg(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
  }

  public void setLatitudeAvg(int latitudeAvg) {
    this.latitudeAvg = latitudeAvg;
  }

  public int getLongitudeMax() {
    return longitudeMax;
  }

  public BigDecimal getLongitudeMaxDecimal() {
    return AccurateOperationUtils
        .mul(getLongitudeMax(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
  }


  public void setLongitudeMax(int longitudeMax) {
    this.longitudeMax = longitudeMax;
  }

  public int getLatitudeMax() {
    return latitudeMax;
  }

  public BigDecimal getLatitudeMaxDecimal() {
    return AccurateOperationUtils
        .mul(getLatitudeMax(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
  }

  public void setLatitudeMax(int latitudeMax) {
    this.latitudeMax = latitudeMax;
  }

  public int getLongitudeMin() {
    return longitudeMin;
  }

  public BigDecimal getLongitudeMinDecimal() {
    return AccurateOperationUtils
        .mul(getLongitudeMin(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
  }

  public void setLongitudeMin(int longitudeMin) {
    this.longitudeMin = longitudeMin;
  }

  public int getLatitudeMin() {
    return latitudeMin;
  }

  public BigDecimal getLatitudeMinDecimal() {
    return AccurateOperationUtils
        .mul(getLatitudeMin(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
  }

  public void setLatitudeMin(int latitudeMin) {
    this.latitudeMin = latitudeMin;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 0x9B;
  }

  @Override
  public byte getAdditionalLength() {
    return 24;
  }


  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getLongitudeAvg());
    buff.put(getLatitudeAvg());
    buff.put(getLongitudeMax());
    buff.put(getLatitudeMax());
    buff.put(getLongitudeMin());
    buff.put(getLatitudeMin());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setLongitudeAvg(buff.getInt());
    setLatitudeAvg(buff.getInt());
    setLongitudeMax(buff.getInt());
    setLatitudeMax(buff.getInt());
    setLongitudeMin(buff.getInt());
    setLatitudeMin(buff.getInt());
  }
}
