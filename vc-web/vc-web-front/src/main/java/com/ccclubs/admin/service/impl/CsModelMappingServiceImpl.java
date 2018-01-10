package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsModelMappingMapper;
import com.ccclubs.admin.model.CsModelMapping;
import com.ccclubs.admin.service.ICsModelMappingService;

/**
 * 主机厂用户车型管理的Service实现
 * @author Joel
 */
@Service
public class CsModelMappingServiceImpl extends CrudService<CsModelMappingMapper, CsModelMapping, Integer> implements ICsModelMappingService{
	
}