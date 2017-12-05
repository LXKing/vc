package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.SrvDictMapper;
import com.ccclubs.admin.model.SrvDict;
import com.ccclubs.admin.service.ISrvDictService;

/**
 * 字典信息管理的Service实现
 * @author Joel
 */
@Service
public class SrvDictServiceImpl extends CrudService<SrvDictMapper, SrvDict, Integer> implements ISrvDictService{
	
}