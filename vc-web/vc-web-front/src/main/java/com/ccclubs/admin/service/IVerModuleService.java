package com.ccclubs.admin.service;

import com.ccclubs.admin.model.VerModule;
import com.ccclubs.frm.base.BaseService;

import java.util.List;

/**
 * 版本模块管理的Service接口
 * @author Joel
 */
public interface IVerModuleService extends BaseService<VerModule, Integer> {

    /**
     * 获取排好序的所有软硬件模块
     * @return
     */
    List<VerModule> getAllModulesOrdered();
	
}