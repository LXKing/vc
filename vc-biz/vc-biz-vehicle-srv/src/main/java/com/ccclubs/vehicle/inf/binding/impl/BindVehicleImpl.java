package com.ccclubs.vehicle.inf.binding.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.mongo.modify.UpdateVehicleService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.vo.VehicleVo;
import com.ccclubs.vehicle.dto.BindVehicleInput;
import com.ccclubs.vehicle.dto.BindVehicleOutput;
import com.ccclubs.vehicle.inf.binding.BindVehicleInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 终端绑定车辆
 *
 * @author jianghaiyang
 * @create 2017-07-03
 **/
@Service(version = VehicleServiceVersion.V1)
public class BindVehicleImpl implements BindVehicleInf {

  @Autowired
  CsVehicleMapper vdao;
  @Autowired
  QueryTerminalService queryTerminalService;
  @Autowired
  QueryVehicleService queryVehicleService;
  @Autowired
  UpdateVehicleService updateVehicleService;

  /**
   * 车机绑定
   */
  @Override
  @DataAuth
  public BindVehicleOutput bindVehicle(BindVehicleInput input) {

    CsVehicle vehicle = queryVehicleService.queryVehicleByVin(input.getVin());
    CsMachine machine = queryTerminalService.queryCsMachineByTeNo(input.getTeNo());

    // 1.校验输入的车辆和终端是否存在
    if (vehicle == null) {
      throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
    }

    if (machine == null || machine.getCsmId() == null) {
      throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
    }

    // 如果当前车辆所对应的车机正好就是该车机，直接返回
    if(machine.getCsmId().equals(vehicle.getCsvMachine())){
      BindVehicleOutput output = new BindVehicleOutput();
      output.setTeNo(input.getTeNo());
      return output;
    }

    boolean vAble = isVehicleAbleToBind(vehicle);//车辆可绑定
    boolean mAble = isTerminalAbleToBind(input.getTeNo());//终端可绑定

    // 2.校验通过，终端和车辆可绑定
    if (vAble && mAble) {
      //开始绑定【更新】
      vehicle.setCsvMachine(machine.getCsmId());
      vehicle.setCsvUpdateTime(new Date());
      updateVehicleService.update(vehicle);
    }

    BindVehicleOutput output = new BindVehicleOutput();
    output.setTeNo(input.getTeNo());
    return output;
  }

  private boolean isTerminalAbleToBind(String teNo) {
    VehicleVo queryVo = new VehicleVo();
    queryVo.setTeNo(teNo);
    VehicleVo result = vdao.selectByVinAndTeNo(queryVo);
    if (null == result) {
      return true;
    } else {
      // 终端已经绑定有车辆
      throw new ApiException(ApiEnum.TERMINAL_BINDING_EXISTS, result.getVin());
    }
  }

  private boolean isVehicleAbleToBind(CsVehicle csVehicle) {
    if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
      return true;
    } else {
      // 车辆已经绑定有终端
      CsMachine csMachine = queryTerminalService.queryCsMachineById(csVehicle.getCsvMachine());
      // 车辆已绑定的终端信息异常，cs_machine中不存在
      if (null == csMachine) {
        return true;
      } else {
        throw new ApiException(ApiEnum.VEHICLE_BINDING_EXISTS, csVehicle.getCsvMachine());
      }
    }
  }

}
