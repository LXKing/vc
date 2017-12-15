package com.ccclubs.manage.inf;

import com.ccclubs.manage.dto.CsStatisticsInput;
import com.ccclubs.manage.orm.model.CsStatistics;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/27
 * Time: 15:26
 * Email:fengjun@ccclubs.com
 */
public interface CsStatisticsInf {
    boolean insertCsStatistics(CsStatistics csStatistics);
    boolean getAllCsStatistics();
    boolean getCsStatisticsList(CsStatisticsInput csStatisticsInput);
}
