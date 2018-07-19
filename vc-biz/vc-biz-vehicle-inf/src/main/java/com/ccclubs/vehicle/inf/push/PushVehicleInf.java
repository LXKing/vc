package com.ccclubs.vehicle.inf.push;

import com.ccclubs.vehicle.dto.VehiclePushInput;
import com.ccclubs.vehicle.dto.VehiclePushOutput;

/**
 * 主机厂车辆推送
 *
 * @author qsxiaogang
 * @create 2017-12-09
 **/
public interface PushVehicleInf {

  VehiclePushOutput vehiclePushSave(VehiclePushInput input);

    //:推送车辆数据
  VehiclePushOutput vehiclePushSave(String input);

}
