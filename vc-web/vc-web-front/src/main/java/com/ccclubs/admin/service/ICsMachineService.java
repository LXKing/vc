package com.ccclubs.admin.service;

import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.CsMachine;

import java.util.List;

/**
 * T-box信息管理的Service接口
 * @author Joel
 */
public interface ICsMachineService extends BaseService<CsMachine, Integer>{

    void insertBatchSelective(List<CsMachine> list);
}