package com.ccclubs.admin.service;

import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.CsMapping;

import java.util.List;

/**
 * 车管关系的Service接口
 * @author Joel
 */
public interface ICsMappingService extends BaseService<CsMapping, Integer>{

    void insertBatchSelective(List<CsMapping> list);
}