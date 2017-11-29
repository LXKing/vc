package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsModelMapper;
import com.ccclubs.admin.model.CsModel;
import com.ccclubs.admin.service.ICsModelService;

/**
 * 接入车型管理的Service实现
 * @author Joel
 */
@Service
public class CsModelServiceImpl extends CrudService<CsModelMapper, CsModel, Integer> implements ICsModelService{
	
}