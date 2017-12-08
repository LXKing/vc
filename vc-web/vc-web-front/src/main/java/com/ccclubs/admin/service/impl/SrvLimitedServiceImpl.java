package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.SrvLimitedMapper;
import com.ccclubs.admin.model.SrvLimited;
import com.ccclubs.admin.service.ISrvLimitedService;

/**
 * 权限配置管理的Service实现
 * @author Joel
 */
@Service
public class SrvLimitedServiceImpl extends CrudService<SrvLimitedMapper, SrvLimited, Integer> implements ISrvLimitedService{
	
}