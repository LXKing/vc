package com.ccclubs.vehicle.inf.binding;

import com.ccclubs.vehicle.dto.*;

/**
 * 终端绑定车辆
 *
 * @author jianghaiyang
 * @create 2017-07-03
 **/
public interface BindVehicleInf {

    BindVehicleOutput bindVehicle(BindVehicleInput input);
}
