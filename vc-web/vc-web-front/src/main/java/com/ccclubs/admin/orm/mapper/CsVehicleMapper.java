package com.ccclubs.admin.orm.mapper;

import com.ccclubs.frm.base.BaseDAO;
import com.ccclubs.admin.model.CsVehicle;

import java.util.List;

/**
 * 车辆信息管理的Mapper实现
 * @author Joel
 */
public interface CsVehicleMapper extends BaseDAO<CsVehicle,Integer>{
  /**
   * 解绑Tbox
   *
   * @mbg.generated
   * @param record
   */
  int unbindTbox(CsVehicle record);

  void insertBatchSelective(List<CsVehicle> list);

  void updateBatchByExampleSelective(List<CsVehicle> list);
}
