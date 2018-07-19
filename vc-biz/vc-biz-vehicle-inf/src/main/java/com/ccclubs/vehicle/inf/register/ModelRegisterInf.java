package com.ccclubs.vehicle.inf.register;

import com.ccclubs.vehicle.dto.ModelRegisterInput;
import com.ccclubs.vehicle.dto.RegisterOutput;
import com.ccclubs.vehicle.dto.VehicleRegisterInput;

/**
 * 车型注册
 *
 * @author jianghaiyang
 * @create 2017-07-24
 **/
public interface ModelRegisterInf {
    //车型注册
    RegisterOutput vehicleModelRegister(ModelRegisterInput... inputs);
}
