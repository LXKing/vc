package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.entity.CsVehicleCrieria;
import com.ccclubs.admin.entity.VerUpManageCrieria;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.VerUpManage;
import com.ccclubs.admin.model.VerUpgrade;
import com.ccclubs.admin.orm.mapper.CsVehicleMapper;
import com.ccclubs.admin.orm.mapper.VerUpManageMapper;
import com.ccclubs.admin.orm.mapper.VerUpgradeMapper;
import com.ccclubs.admin.service.IVerUpManageService;
import com.ccclubs.frm.base.CrudService;
import com.ccclubs.upgrade.dto.UpgradeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 车机升级管理的Service实现
 * @author Joel
 */
@Service
public class VerUpManageServiceImpl extends CrudService<VerUpManageMapper, VerUpManage, Integer> implements IVerUpManageService {

    @Autowired
    private VerUpManageMapper verUpManageMapper;

    @Autowired
    private CsVehicleMapper csVehicleMapper;

    @Autowired
    private VerUpgradeMapper verUpgradeMapper;

    @Override
    public List<CsVehicle> getAllUpgradeVehicle() {
        return verUpManageMapper.getAllUpgradeVehicle();
    }

    @Override
    public int insertBatchUpgradeManages(List<VerUpManage> verUpManages) {
        return getDao().insertBatchSelective(verUpManages);
    }

    @Override
    public List<UpgradeInput> getUpgradeInput(Integer[] upgradeManageIds, Integer upgradeVersionId) {
        // 获取升级版本信息
        VerUpgrade verUpgrade = verUpgradeMapper.selectByPrimaryKey(upgradeVersionId);

        // 获取升级管理列表
        VerUpManageCrieria upManageExample = new VerUpManageCrieria();
        upManageExample.createCriteria().andidIn(Arrays.asList(upgradeManageIds));
        List<VerUpManage> manages = selectByExample(upManageExample);

        if (null != manages && manages.size() > 0) {
            // 获取车辆列表
            CsVehicleCrieria vehicleCrieria = new CsVehicleCrieria();
            vehicleCrieria.createCriteria().andcsvIdIn(manages.stream().map(m -> m.getVehicleId()).collect(Collectors.toList()));
            List<CsVehicle> vehicleList = csVehicleMapper.selectByExample(vehicleCrieria);
            // 组装升级Input
            List<UpgradeInput> inputs = vehicleList.stream().map(v -> {
                UpgradeInput newInput = new UpgradeInput();
                newInput.setVin(v.getCsvVin());
                if (null != verUpgrade) {
                    newInput.setFilename(verUpgrade.getFileName());
                }
                return newInput;
            }).collect(Collectors.toList());
            return inputs;
        }

        return new ArrayList<>();
    }
}