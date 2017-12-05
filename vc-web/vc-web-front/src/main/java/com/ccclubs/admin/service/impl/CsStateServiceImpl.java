package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsStateMapper;
import com.ccclubs.admin.model.CsState;
import com.ccclubs.admin.service.ICsStateService;

/**
 * 车辆实时状态的Service实现
 * @author Joel
 */
@Service
public class CsStateServiceImpl extends CrudService<CsStateMapper, CsState, Integer> implements ICsStateService{
	
}