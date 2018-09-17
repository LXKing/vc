package com.ccclubs.admin.service;

import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.admin.query.HistoryStateQuery;
import com.ccclubs.admin.vo.TableResult;

/**
 * 车辆状态历史数据的Service接口
 *
 * @author Joel
 */
public interface IHistoryStateService {

    TableResult<HistoryState> getPage(HistoryStateQuery query, Integer page, Integer rows, String order);

    TableResult<HistoryState> getJt808PositionPage(HistoryStateQuery query, Integer page, Integer rows, String order);
}