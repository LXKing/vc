package com.ccclubs.admin.service;

import com.ccclubs.admin.query.HistoryStateQuery;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.phoenix.output.CarStateHistoryOutput;
import com.github.pagehelper.PageInfo;

/**
 * 车辆状态历史数据的Service接口
 * @author Joel
 */
public interface IHistoryStateService{

    TableResult<HistoryState> getPage(HistoryStateQuery query, Integer page, Integer rows,String order);

}