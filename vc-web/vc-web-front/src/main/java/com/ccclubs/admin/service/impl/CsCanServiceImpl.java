package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsCanMapper;
import com.ccclubs.admin.model.CsCan;
import com.ccclubs.admin.service.ICsCanService;

/**
 * 车辆实时CAN信息的Service实现
 * @author Joel
 */
@Service
public class CsCanServiceImpl extends CrudService<CsCanMapper, CsCan, Long> implements ICsCanService{
	
}