package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.VerUpgradeRecordMapper;
import com.ccclubs.admin.model.VerUpgradeRecord;
import com.ccclubs.admin.service.IVerUpgradeRecordService;

/**
 * 车机升级记录的Service实现
 * @author Joel
 */
@Service
public class VerUpgradeRecordServiceImpl extends CrudService<VerUpgradeRecordMapper, VerUpgradeRecord, Integer> implements IVerUpgradeRecordService{
	
}