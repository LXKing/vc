package com.ccclubs.vehicle.inf.modify;

import com.ccclubs.vehicle.dto.ModifyVehicleInput;
import com.ccclubs.vehicle.dto.ModifyVehicleOutput;

/**
 * 车辆信息修改
 *
 * @author jianghaiyang
 * @create 2017-07-31
 **/
public interface ModifyVehicleInf {
    ModifyVehicleOutput vehicleModify(ModifyVehicleInput input);
}
