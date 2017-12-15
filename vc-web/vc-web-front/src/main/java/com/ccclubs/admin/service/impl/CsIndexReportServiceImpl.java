package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsIndexReportMapper;
import com.ccclubs.admin.model.CsIndexReport;
import com.ccclubs.admin.service.ICsIndexReportService;

/**
 * 指标统计的Service实现
 * @author Joel
 */
@Service
public class CsIndexReportServiceImpl extends CrudService<CsIndexReportMapper, CsIndexReport, Long> implements ICsIndexReportService{
	
}