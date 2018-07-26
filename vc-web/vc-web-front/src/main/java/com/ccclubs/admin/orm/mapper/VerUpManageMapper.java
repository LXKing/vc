package com.ccclubs.admin.orm.mapper;

import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.VerUpManage;
import com.ccclubs.frm.base.BaseDAO;

import java.util.List;

/**
 * 车机升级管理的Mapper实现
 * @author Joel
 */
public interface VerUpManageMapper extends BaseDAO<VerUpManage,Integer> {

    /**
     *  查询所有绑定了升级版本的车辆
     * @return
     */
    List<CsVehicle> getAllUpgradeVehicle();

    /**
     * 批量新增
     * @param verUpManages
     * @return
     */
    int insertBatchSelective(List<VerUpManage> verUpManages);
}
