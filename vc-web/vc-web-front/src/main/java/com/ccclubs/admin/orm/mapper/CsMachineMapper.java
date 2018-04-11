package com.ccclubs.admin.orm.mapper;

import com.ccclubs.frm.base.BaseDAO;
import com.ccclubs.admin.model.CsMachine;

import java.util.List;

/**
 * T-box信息管理的Mapper实现
 * @author Joel
 */
public interface CsMachineMapper extends BaseDAO<CsMachine,Integer>{
    void insertBatchSelective(List<CsMachine> list);
}
