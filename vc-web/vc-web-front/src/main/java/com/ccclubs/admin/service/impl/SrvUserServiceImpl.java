package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.SrvUserMapper;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.admin.service.ISrvUserService;

/**
 * 用户管理的Service实现
 * @author Joel
 */
@Service
public class SrvUserServiceImpl extends CrudService<SrvUserMapper, SrvUser, Integer> implements ISrvUserService{
	
}