package com.ccclubs.admin.service;

import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.CsVehicle;

/**
 * 车辆信息管理的Service接口
 * @author Joel
 */
public interface ICsVehicleService extends BaseService<CsVehicle, Integer>{
  int unbindTbox(CsVehicle record);
}