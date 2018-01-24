package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsTboxBindHisMapper;
import com.ccclubs.admin.model.CsTboxBindHis;
import com.ccclubs.admin.service.ICsTboxBindHisService;

import java.util.List;

/**
 * 的Service实现
 * @author Joel
 */
@Service
public class CsTboxBindHisServiceImpl extends CrudService<CsTboxBindHisMapper, CsTboxBindHis, Long> implements ICsTboxBindHisService{

    @Override
    public void insertBatchSelective(List<CsTboxBindHis> list) {
        getDao().insertBatchSelective(list);
    }
}