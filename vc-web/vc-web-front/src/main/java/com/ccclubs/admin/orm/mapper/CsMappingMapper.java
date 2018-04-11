package com.ccclubs.admin.orm.mapper;

import com.ccclubs.frm.base.BaseDAO;
import com.ccclubs.admin.model.CsMapping;

import java.util.List;

/**
 * 车管关系的Mapper实现
 * @author Joel
 */
public interface CsMappingMapper extends BaseDAO<CsMapping,Integer>{

    void insertBatchSelective(List<CsMapping> list);
}
