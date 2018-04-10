package com.ccclubs.terminal.inf.state.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.common.query.QueryStateService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.terminal.dto.VehicleStateQryInput;
import com.ccclubs.terminal.dto.VehicleStateQryOutput;
import com.ccclubs.terminal.dto.VehicleStatesQryInput;
import com.ccclubs.terminal.dto.VehicleStatesQryOutput;
import com.ccclubs.terminal.inf.state.QueryVehicleStateInf;
import com.ccclubs.terminal.version.TerminalServiceVersion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆状态数据查询实现
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
@Service(version = TerminalServiceVersion.V1)
public class QueryVehicleStateImpl implements QueryVehicleStateInf {

  @Autowired
  QueryVehicleService queryVehicleService;

  @Autowired
  QueryTerminalService queryTerminalService;

  @Autowired
  private QueryStateService queryStateService;

  @Override
  @DataAuth
  public VehicleStateQryOutput getRealTimeCarState(VehicleStateQryInput input) {

    //Step1.查询车辆
    CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(input.getVin());
    // 未查询到车辆
    if (null == csVehicle) {
      throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
    }

    //Step2.查询终端
    // 未查询到终端
    if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
      throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
    }

    //Step3.查询状态
//    CsMachine csMachine = queryTerminalService.queryCsMachineById(csVehicle.getCsvMachine());
    CsState csState = queryStateService.queryStateByVehicleId(csVehicle.getCsvId());
    if (null == csState) {
      throw new ApiException(ApiEnum.VEHICLE_STATE_NOT_FOUND);
    }
    VehicleStateQryOutput output = new VehicleStateQryOutput();
    BeanUtils.copyProperties(csState, output);
    return output;
  }

  @Override
  @DataAuth
  public VehicleStatesQryOutput getRealTimeCarStates(VehicleStatesQryInput input) {
    VehicleStatesQryOutput output=new VehicleStatesQryOutput();
    List<VehicleStateQryOutput> vehicleStateQryOutputList=new ArrayList<>();
    String[] vins=input.getVins();
    for (String vin:vins
         ) {
      CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(vin);
      // 未查询到车辆
      if (null == csVehicle) {
        continue;
      }

      //Step2.查询终端
      // 未查询到终端
      if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
        continue;
      }

      //Step3.查询状态
      CsState csState = queryStateService.queryStateByVehicleId(csVehicle.getCsvId());
      if (null == csState) {
        continue;
      }
      VehicleStateQryOutput vehicleStateQryOutput = new VehicleStateQryOutput();
      BeanUtils.copyProperties(csState, vehicleStateQryOutput);
      vehicleStateQryOutput.setCssVin(vin);
      vehicleStateQryOutputList.add(vehicleStateQryOutput);
    }
    output.setVehicleStateQryOutputList(vehicleStateQryOutputList);
    return output;
  }
}
