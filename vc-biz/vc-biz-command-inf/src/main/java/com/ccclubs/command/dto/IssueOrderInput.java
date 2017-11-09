package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class IssueOrderInput extends CommonInput implements java.io.Serializable {

  @NotNull(message = "车辆vin码必填")
  private String vin;

  @NotNull(message = "订单号必填")
  private Long orderId;

  @NotNull(message = "订单开始时间(yyyy-MM-dd HH:mm:ss)必填")
  @Pattern(regexp = "^(\\d{4})-([0-1]\\d)-([0-3]\\d)\\s([0-5]\\d):([0-5]\\d):([0-5]\\d)$", message = "日期格式匹配不正确(yyyy-MM-dd HH:mm:ss)")
  private String startTime;

  @NotNull(message = "订单结束时间(yyyy-MM-dd HH:mm:ss)必填")
  @Pattern(regexp = "^(\\d{4})-([0-1]\\d)-([0-3]\\d)\\s([0-5]\\d):([0-5]\\d):([0-5]\\d)$", message = "日期格式匹配不正确(yyyy-MM-dd HH:mm:ss)")
  private String endTime;

  @NotNull(message = "真实姓名必填")
  private String realName;

  @NotNull(message = "手机号(11位)必填")
  @Pattern(regexp = "^[0-9]{11}$", message = "手机号验证失败")//严格验证（^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$）
  private String mobile;

  @NotNull(message = "性别(0:女 1:男)必填")
  @InArray(message = "性别(0:女 1:男)")
  private Short gender;

  private String rfid;

  private Integer authCode;

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Short getGender() {
    return gender;
  }

  public void setGender(Short gender) {
    this.gender = gender;
  }

  public String getRfid() {
    return rfid;
  }

  public void setRfid(String rfid) {
    this.rfid = rfid;
  }

  public Integer getAuthCode() {
    return authCode;
  }

  public void setAuthCode(Integer authCode) {
    this.authCode = authCode;
  }
}
