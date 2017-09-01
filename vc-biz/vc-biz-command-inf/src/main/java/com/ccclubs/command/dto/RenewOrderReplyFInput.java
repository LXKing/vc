package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;

/**
 * 订单续订应答失败
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public class RenewOrderReplyFInput extends CommonInput implements java.io.Serializable{
    @NotNull(message = "车辆vin码必填")
    private String vin;

    @NotNull(message = "订单号必填")
    private Long orderId;

    @NotNull(message = "续订结果标志必填")
    private Byte flag;

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

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "RenewOrderReplyFInput{" +
                "vin='" + vin + '\'' +
                ", orderId=" + orderId +
                ", flag=" + flag +
                '}';
    }
}
