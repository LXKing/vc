package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsMappingMapper;
import com.ccclubs.admin.model.CsMapping;
import com.ccclubs.admin.service.ICsMappingService;

/**
 * 车管关系的Service实现
 * @author Joel
 */
@Service
public class CsMappingServiceImpl extends CrudService<CsMappingMapper, CsMapping, Integer> implements ICsMappingService{
	
}