package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.orm.mapper.CsVehicleMapper;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.frm.base.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆信息管理的Service实现
 *
 * @author Joel
 */
@Service
public class CsVehicleServiceImpl extends
    CrudService<CsVehicleMapper, CsVehicle, Integer> implements ICsVehicleService {

  @Override
  public int unbindTbox(CsVehicle record) {
    return getDao().unbindTbox(record);
  }

  @Override
  public void insertBatchSelective(List<CsVehicle> list) {
         getDao().insertBatchSelective(list);
  }

  @Override
  public void updateBatchByExampleSelective(List<CsVehicle> list) {
    getDao().updateBatchByExampleSelective(list);
  }
}