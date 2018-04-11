package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsMachineMapper;
import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.service.ICsMachineService;

import java.util.List;

/**
 * T-box信息管理的Service实现
 * @author Joel
 */
@Service
public class CsMachineServiceImpl extends CrudService<CsMachineMapper, CsMachine, Integer> implements ICsMachineService{
    @Override
    public void insertBatchSelective(List<CsMachine> list) {
        getDao().insertBatchSelective( list);
    }
}