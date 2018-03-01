package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.vo.VehicleMachineVo;

import java.util.List;

public interface BackCsVehicleMapper {

    List<VehicleMachineVo> queryVehicleMachineByPage(VehicleMachineVo vo);

}