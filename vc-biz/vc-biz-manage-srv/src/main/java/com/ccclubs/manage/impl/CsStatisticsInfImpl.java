package com.ccclubs.manage.impl;

import com.ccclubs.manage.dto.CsStatisticsInput;
import com.ccclubs.manage.inf.CsStatisticsInf;
import com.ccclubs.manage.orm.mapper.CsStatisticsMapper;
import com.ccclubs.manage.orm.model.CsStatistics;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/30
 * Time: 16:21
 * Email:fengjun@ccclubs.com
 */
public class CsStatisticsInfImpl implements CsStatisticsInf {

    @Resource
    private CsStatisticsMapper csStatisticsMapper;

    @Override
    public boolean insertCsStatistics(CsStatistics csStatistics) {
        return csStatisticsMapper.insertSelective(csStatistics)>0;
    }

    @Override
    public boolean getAllCsStatistics() {
        return false;
    }

    @Override
    public boolean getCsStatisticsList(CsStatisticsInput csStatisticsInput) {
        return false;
    }
}
