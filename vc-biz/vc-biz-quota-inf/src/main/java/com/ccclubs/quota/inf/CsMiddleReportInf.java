package com.ccclubs.quota.inf;

/**
 * Created by Administrator on 2018/2/5 0005.
 */
public interface CsMiddleReportInf {

    /**
     * 通过接口调用的方式触发国标数据统计
     */
    void  triggerMiddleReport();

    /**
     * 计算国补数据指标数据
     */
    void updateReportData();
}
