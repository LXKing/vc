package com.ccclubs.terminal.inf.state;

import com.ccclubs.terminal.dto.VehicleStateQryOutput;
import com.ccclubs.terminal.dto.VehicleStateQryInput;
import com.ccclubs.terminal.dto.VehicleStatesQryInput;
import com.ccclubs.terminal.dto.VehicleStatesQryOutput;

/**
 * 车辆状态数据
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public interface QueryVehicleStateInf {
    VehicleStateQryOutput getRealTimeCarState(VehicleStateQryInput input);
    VehicleStatesQryOutput getRealTimeCarStates(VehicleStatesQryInput input);
}
