package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.SrvHostMapper;
import com.ccclubs.admin.model.SrvHost;
import com.ccclubs.admin.service.ISrvHostService;

/**
 * 接入商信息管理的Service实现
 * @author Joel
 */
@Service
public class SrvHostServiceImpl extends CrudService<SrvHostMapper, SrvHost, Integer> implements ISrvHostService{
	
}