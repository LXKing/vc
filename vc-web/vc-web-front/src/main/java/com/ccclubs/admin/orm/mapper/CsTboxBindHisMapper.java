package com.ccclubs.admin.orm.mapper;

import com.ccclubs.frm.base.BaseDAO;
import com.ccclubs.admin.model.CsTboxBindHis;

import java.util.List;

/**
 * 的Mapper实现
 * @author Joel
 */
public interface CsTboxBindHisMapper extends BaseDAO<CsTboxBindHis,Long>{

    void insertBatchSelective(List<CsTboxBindHis> list);
}
