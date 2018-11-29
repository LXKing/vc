package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.model.VerSoftHardware;
import com.ccclubs.admin.orm.mapper.VerSoftHardwareMapper;
import com.ccclubs.admin.service.IVerSoftHardwareService;
import com.ccclubs.frm.base.CrudService;
import org.springframework.stereotype.Service;

/**
 * 软硬件版本管理的Service实现
 * @author Joel
 */
@Service
public class VerSoftHardwareServiceImpl extends CrudService<VerSoftHardwareMapper, VerSoftHardware, Integer> implements IVerSoftHardwareService {
	
}