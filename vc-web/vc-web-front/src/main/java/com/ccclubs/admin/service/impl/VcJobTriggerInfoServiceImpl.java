package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.VcJobTriggerInfoMapper;
import com.ccclubs.admin.model.VcJobTriggerInfo;
import com.ccclubs.admin.service.IVcJobTriggerInfoService;

/**
 * 的Service实现
 * @author Joel
 */
@Service
public class VcJobTriggerInfoServiceImpl extends CrudService<VcJobTriggerInfoMapper, VcJobTriggerInfo, Long> implements IVcJobTriggerInfoService{
	
}