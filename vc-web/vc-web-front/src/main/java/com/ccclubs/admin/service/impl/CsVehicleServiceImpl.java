package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.orm.mapper.CsVehicleMapper;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.frm.base.CrudService;
import org.springframework.stereotype.Service;

/**
 * 车辆信息管理的Service实现
 *
 * @author Joel
 */
@Service
public class CsVehicleServiceImpl extends
    CrudService<CsVehicleMapper, CsVehicle, Integer> implements ICsVehicleService {

  public int unbindTbox(CsVehicle record) {
    return getDao().unbindTbox(record);
  }
}