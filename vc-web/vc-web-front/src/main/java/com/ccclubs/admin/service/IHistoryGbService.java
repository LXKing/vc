package com.ccclubs.admin.service;

import com.ccclubs.admin.query.HistoryGbQuery;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.HistoryGb;
import com.ccclubs.protocol.dto.gb.GBMessage;

/**
 * 车辆国标历史数据的Service接口
 * @author Joel
 */
public interface IHistoryGbService{
    TableResult<HistoryGb> getPage(HistoryGbQuery query, Integer page, Integer rows, String order);
    TableResult<GBMessage> getGbMessagePage(HistoryGbQuery query, Integer page, Integer rows, String order);
}