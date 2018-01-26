package com.ccclubs.admin.service;

import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.CsTboxBindHis;

import java.util.List;

/**
 * 的Service接口
 * @author Joel
 */
public interface ICsTboxBindHisService extends BaseService<CsTboxBindHis, Long>{

    void insertBatchSelective(List<CsTboxBindHis> list);
}