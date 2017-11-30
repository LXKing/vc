package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsStructMapper;
import com.ccclubs.admin.model.CsStruct;
import com.ccclubs.admin.service.ICsStructService;

/**
 * 控制指令管理的Service实现
 * @author Joel
 */
@Service
public class CsStructServiceImpl extends CrudService<CsStructMapper, CsStruct, Long> implements ICsStructService{
	
}