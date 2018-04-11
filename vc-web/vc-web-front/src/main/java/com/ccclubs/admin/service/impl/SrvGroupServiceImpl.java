package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.SrvGroupMapper;
import com.ccclubs.admin.model.SrvGroup;
import com.ccclubs.admin.service.ISrvGroupService;

/**
 * 角色组管理的Service实现
 * @author Joel
 */
@Service
public class SrvGroupServiceImpl extends CrudService<SrvGroupMapper, SrvGroup, Integer> implements ISrvGroupService{
	
}