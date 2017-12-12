package com.ccclubs.vehicle.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 众泰主机厂推送车辆信息入参
 *
 * @author qsxiaogang
 * @create 2017-12-09
 **/
public class VehiclePushInput implements Serializable {


  /**
   * 车型代码
   */
  @NotNull(message = "车型代码必填")
  private String csvModelCode;
  /**
   * 车辆类型:
   */
  @NotNull(message = "车型备案型号必填")
  private String csvType;
  /**
   * 车型
   */
  @NotNull(message = "车型备案型号必填")
  private String csvModel;

  /**
   * 车颜色代码0: 白套红橙1: 白套玫瑰金2: 白套苹果绿3: 红橙套黑4: 红套黑5: 黄/黑6: 黄套黑7: 蓝白套8: 苹果绿/白9: 深空黑/红橙10: 紫白套
   */
  @NotNull(message = "车身颜色必填")
  private String csvColorCode;
  /**
   * 内饰颜色
   */
  private String csvInteriorColorCode;

  /**
   * 出厂日期
   */
  @NotNull(message = "出厂日期(yyyy-MM-dd)必填")
  @Pattern(regexp = "^((((19|20)\\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$", message = "日期格式不正确(YYYY-MM-DD)")
  private String csvProdDate;

  /**
   * 车架号
   */
  @NotNull(message = "车辆VIN码必填")
  private String csvVin;

  /**
   * 发动机号
   */
  @NotNull(message = "发动机号必填")
  private String csvEngineNo;

  /**
   * 终端序列号
   */
  @NotNull(message = "终端序列号必填")
  private String csvMachine;

  /**
   * 合格证号
   */
  private String csvCertific;

  /**
   * 可充电储能系统编码
   */
  @NotNull(message = "可充电储能系统编码必填")
  private String csvBataccuCode;

  public String getCsvModelCode() {
    return csvModelCode;
  }

  public void setCsvModelCode(String csvModelCode) {
    this.csvModelCode = csvModelCode;
  }

  public String getCsvType() {
    return csvType;
  }

  public void setCsvType(String csvType) {
    this.csvType = csvType;
  }

  public String getCsvModel() {
    return csvModel;
  }

  public void setCsvModel(String csvModel) {
    this.csvModel = csvModel;
  }

  public String getCsvColorCode() {
    return csvColorCode;
  }

  public void setCsvColorCode(String csvColorCode) {
    this.csvColorCode = csvColorCode;
  }

  public String getCsvInteriorColorCode() {
    return csvInteriorColorCode;
  }

  public void setCsvInteriorColorCode(String csvInteriorColorCode) {
    this.csvInteriorColorCode = csvInteriorColorCode;
  }

  public String getCsvProdDate() {
    return csvProdDate;
  }

  public void setCsvProdDate(String csvProdDate) {
    this.csvProdDate = csvProdDate;
  }

  public String getCsvVin() {
    return csvVin;
  }

  public void setCsvVin(String csvVin) {
    this.csvVin = csvVin;
  }

  public String getCsvEngineNo() {
    return csvEngineNo;
  }

  public void setCsvEngineNo(String csvEngineNo) {
    this.csvEngineNo = csvEngineNo;
  }

  public String getCsvMachine() {
    return csvMachine;
  }

  public void setCsvMachine(String csvMachine) {
    this.csvMachine = csvMachine;
  }

  public String getCsvCertific() {
    return csvCertific;
  }

  public void setCsvCertific(String csvCertific) {
    this.csvCertific = csvCertific;
  }

  public String getCsvBataccuCode() {
    return csvBataccuCode;
  }

  public void setCsvBataccuCode(String csvBataccuCode) {
    this.csvBataccuCode = csvBataccuCode;
  }
}
