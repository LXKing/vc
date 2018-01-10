package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsStatisticsMapper;
import com.ccclubs.admin.model.CsStatistics;
import com.ccclubs.admin.service.ICsStatisticsService;

/**
 * 车辆统计数据的Service实现
 * @author Joel
 */
@Service
public class CsStatisticsServiceImpl extends CrudService<CsStatisticsMapper, CsStatistics, Integer> implements ICsStatisticsService{
	
}