package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.model.VerModule;
import com.ccclubs.admin.orm.mapper.VerModuleMapper;
import com.ccclubs.admin.service.IVerModuleService;
import com.ccclubs.frm.base.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 版本模块管理的Service实现
 * @author Joel
 */
@Service
public class VerModuleServiceImpl extends CrudService<VerModuleMapper, VerModule, Integer> implements IVerModuleService {

    @Autowired
    private VerModuleMapper verModuleMapper;

    public List<VerModule> getAllModulesOrdered() {
        List<VerModule> modules = verModuleMapper.selectAllModule();
        if (Objects.isNull(modules)) {
            modules = new ArrayList<>();
        }
        return modules;
    }
}