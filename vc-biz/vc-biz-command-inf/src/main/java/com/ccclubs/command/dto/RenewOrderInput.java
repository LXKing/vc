package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 订单续订
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class RenewOrderInput extends CommonInput implements java.io.Serializable{
    @NotNull(message = "车辆vin码必填")
    private String vin;

    @NotNull(message = "订单号必填")
    private Long orderId;

    @NotNull(message = "续订后的截止时间(yyyy-MM-dd HH:mm:ss)必填")
    @Pattern(regexp = "^(\\d{4})-([0-1]\\d)-([0-3]\\d)\\s([0-5]\\d):([0-5]\\d):([0-5]\\d)$",message = "日期格式匹配不正确(yyyy-MM-dd HH:mm:ss)")
    private String renewEndTime;

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

    public String getRenewEndTime() {
        return renewEndTime;
    }

    public void setRenewEndTime(String renewEndTime) {
        this.renewEndTime = renewEndTime;
    }

    @Override
    public String toString() {
        return "RenewOrderInput{" +
                "vin='" + vin + '\'' +
                ", orderId=" + orderId +
                ", renewEndTime='" + renewEndTime + '\'' +
                '}';
    }
}
