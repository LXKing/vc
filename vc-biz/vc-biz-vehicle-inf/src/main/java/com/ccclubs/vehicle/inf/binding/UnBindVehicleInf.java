package com.ccclubs.vehicle.inf.binding;

import com.ccclubs.vehicle.dto.UnBindVehicleInput;
import com.ccclubs.vehicle.dto.UnBindVehicleOutput;

/**
 * 终端车辆解绑
 *
 * @author jianghaiyang
 * @create 2017-07-05
 **/
public interface UnBindVehicleInf {
    UnBindVehicleOutput unBindVehicle(UnBindVehicleInput input);
}
