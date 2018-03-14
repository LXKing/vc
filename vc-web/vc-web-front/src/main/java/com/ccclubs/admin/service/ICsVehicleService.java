package com.ccclubs.admin.service;

import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.pub.orm.page.PageInput;
import com.ccclubs.pub.orm.vo.VehicleMachineVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆信息管理的Service接口
 * @author Joel
 */
public interface ICsVehicleService extends BaseService<CsVehicle, Integer>{
  int unbindTbox(CsVehicle record);

 void insertBatchSelective(List<CsVehicle> list);

  void updateBatchByExampleSelective(List<CsVehicle> list);

    /**
     * 根据用户查询名下车辆
     * @param vo
     * @return
     */
    PageInfo<VehicleMachineVo> queryVehicleMachineByPage(VehicleMachineVo vo, PageInput input);

    /**
     * 根据用户查询名下车辆
     * @param vo
     * @return
     */
    List<VehicleMachineVo> queryVehicleMachineByUser(VehicleMachineVo vo);
}