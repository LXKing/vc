package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.SrvProjectMapper;
import com.ccclubs.admin.model.SrvProject;
import com.ccclubs.admin.service.ISrvProjectService;

/**
 * 项目菜单管理的Service实现
 * @author Joel
 */
@Service
public class SrvProjectServiceImpl extends CrudService<SrvProjectMapper, SrvProject, Long> implements ISrvProjectService{
	
}