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
    //车辆基本信息修改
    ModifyVehicleOutput vehicleModify(ModifyVehicleInput input);
}
