package com.ccclubs.quota.inf;

import com.ccclubs.quota.orm.model.CsIndexReport;
import com.ccclubs.quota.vo.CsIndexReportInput;
import com.github.pagehelper.PageInfo;

public interface CsIndexQuotaInf {
	/**
	 * 指标统计标准参照
	 */
	void metaBuilder();
	/**
	 * 未纳入指标统计车辆列表
	 */
	void exceptListBuilder();
	/**
	 * 超标统计车辆列表
	 */
	void outrangeListBuilder();
	/**
	 * 指标统计表
	 */
	void reportBuilder();
	
	PageInfo<CsIndexReport> bizQuota(CsIndexReportInput input);

	//报表导出
	void reportExport(String conditonFilePath,String generateFilePath);
}
