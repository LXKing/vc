package com.ccclubs.admin.service;

import com.ccclubs.admin.model.HistoryCan;
import com.ccclubs.admin.query.HistoryCanQuery;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.phoenix.orm.dto.CanStateDto;

/**
 * 车辆CAN历史数据的Service接口
 *
 * @author Joel
 */
public interface IHistoryCanService {
    TableResult<HistoryCan> getPage(HistoryCanQuery query, Integer page, Integer rows, String order);

    /**
     * 2018/9/14
     * 获取车辆状态历史can数据详情
     *
     * @param carNumber 车机号
     * @param canTime   can记录时间戳
     * @return com.ccclubs.admin.vo.VoResult<>
     * @author machuanpeng
     */
    CanStateDto getHistoryStateDetail(String carNumber, Long canTime);
}