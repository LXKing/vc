package com.ccclubs.terminal.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/8
 * @Time: 10:21
 * @Description: 此output类是批量查询车辆信息的输出类！
 */

public class VehicleStatesQryOutput implements Serializable {
    private static final long serialVersionUID = -7060080404004792080L;

    List<VehicleStateQryOutput> vehicleStateQryOutputList;

    public List<VehicleStateQryOutput> getVehicleStateQryOutputList() {
        return vehicleStateQryOutputList;
    }

    public void setVehicleStateQryOutputList(List<VehicleStateQryOutput> vehicleStateQryOutputList) {
        this.vehicleStateQryOutputList = vehicleStateQryOutputList;
    }
}
