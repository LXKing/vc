package com.ccclubs.vehicle.inf.register;

import com.ccclubs.vehicle.dto.RegisterOutput;
import com.ccclubs.vehicle.dto.VehicleRegisterInput;

/**
 * 车辆注册
 *
 * @author jianghaiyang
 * @create 2017-07-24
 **/
public interface VehicleRegisterInf {
    //车辆注册
    RegisterOutput vehicleRegister(String appId, VehicleRegisterInput... inputs);
}
