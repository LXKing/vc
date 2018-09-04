package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.model.VerFtpSer;
import com.ccclubs.admin.orm.mapper.VerFtpSerMapper;
import com.ccclubs.admin.service.IVerFtpSerService;
import com.ccclubs.frm.base.CrudService;
import org.springframework.stereotype.Service;

/**
 * 升级文件服务器管理的Service实现
 * @author Joel
 */
@Service
public class VerFtpSerServiceImpl extends CrudService<VerFtpSerMapper, VerFtpSer, Integer> implements IVerFtpSerService {
	
}