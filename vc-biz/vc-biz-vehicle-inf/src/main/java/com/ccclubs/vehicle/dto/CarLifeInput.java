package com.ccclubs.vehicle.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/25
 * @Time: 11:09
 * @Description: 车辆与车机绑定历史周期的输入类！
 */

public class CarLifeInput implements Serializable {
    private static final long serialVersionUID = -205494544762221046L;

    @NotNull(message = "车辆vin码必填")
    private String vin;

    private String appId;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
