package com.ccclubs.admin.service;

import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.VerUpManage;
import com.ccclubs.frm.base.BaseService;
import com.ccclubs.upgrade.dto.UpgradeInput;

import java.util.List;

/**
 * 车机升级管理的Service接口
 * @author Joel
 */
public interface IVerUpManageService extends BaseService<VerUpManage, Integer> {

    /**
     *  查询所有绑定了升级版本的车辆
     * @return
     */
    List<CsVehicle> getAllUpgradeVehicle();

    /**
     * 批量新增车辆版本信息
     * @param verUpManages
     * @return
     */
    int insertBatchUpgradeManages(List<VerUpManage> verUpManages);

    /**
     * 根据车辆升级ID和升级版本ID获取升级输入
     * @param upgradeManageIds
     * @param upgradeVersionId
     * @return
     */
    List<UpgradeInput> getUpgradeInput(Integer[] upgradeManageIds, Integer upgradeVersionId);
	
}