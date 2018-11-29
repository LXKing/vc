package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.model.VerUpgrade;
import com.ccclubs.admin.orm.mapper.VerUpgradeMapper;
import com.ccclubs.admin.service.IVerUpgradeService;
import com.ccclubs.frm.base.CrudService;
import org.springframework.stereotype.Service;

/**
 * 升级版本管理的Service实现
 * @author Joel
 */
@Service
public class VerUpgradeServiceImpl extends CrudService<VerUpgradeMapper, VerUpgrade, Integer> implements IVerUpgradeService {
	
}