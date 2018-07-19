package com.ccclubs.terminal.inf.state;

import com.ccclubs.terminal.dto.*;

/**
 * 车辆状态数据
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public interface QueryVehicleStateInf {
    //状态信息的实时读取
    VehicleStateQryOutput getRealTimeCarState(VehicleStateQryInput input);

    //状态信息批量实时读取
    VehicleStatesQryOutput getRealTimeCarStates(VehicleStatesQryInput input);

    //车辆在线状态判断
    VehicleOnlineOutput isOnline(VehicleOnlineInput input);
}
