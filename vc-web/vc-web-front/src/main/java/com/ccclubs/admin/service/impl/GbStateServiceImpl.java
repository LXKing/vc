package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.GbStateMapper;
import com.ccclubs.admin.model.GbState;
import com.ccclubs.admin.service.IGbStateService;

/**
 * 车辆国标历史信息的Service实现
 * @author Joel
 */
@Service
public class GbStateServiceImpl extends CrudService<GbStateMapper, GbState, Integer> implements IGbStateService{
	
}