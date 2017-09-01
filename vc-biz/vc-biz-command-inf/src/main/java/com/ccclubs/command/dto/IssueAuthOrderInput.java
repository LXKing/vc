package com.ccclubs.command.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 下发订单-有授权信息
 *
 * @author jianghaiyang
 * @create 2017-08-01
 **/
public class IssueAuthOrderInput extends CommonInput implements Serializable {
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

    @NotNull(message = "RFID号(8位)必填")
    @Length(min = 8, max = 8, message = "RFID号(8位)必填")
    private String rfid;

    @NotNull(message = "授权码(6位)必填")
    @Min(value = 100000, message = "授权码最小值 100000")
    @Max(value = 999999, message = "授权码最大值 999999")
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
