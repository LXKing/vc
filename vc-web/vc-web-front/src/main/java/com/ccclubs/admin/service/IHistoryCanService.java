package com.ccclubs.admin.service;

import com.ccclubs.admin.query.HistoryCanQuery;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.HistoryCan;

/**
 * 车辆CAN历史数据的Service接口
 * @author Joel
 */
public interface IHistoryCanService{
    TableResult<HistoryCan> getPage(HistoryCanQuery query, Integer page, Integer rows, String order);
}