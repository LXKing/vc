package com.ccclubs.admin.service;

import com.ccclubs.admin.model.*;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.base.BaseService;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * @author Alban
 * @date 2017年12月11日
 *
 * */

public interface IReportService {

    /**
     * 车辆信息导出核心服务
     * @param csVehicleList 依据条件查询得到的结果（一般为当前页的）。
     * @return 已经生成为文件的二进制流。
     * */
    ByteArrayOutputStream reportVehicles(List<CsVehicle> csVehicleList);
    /**
     * 车机信息导出核心服务
     * @param  csMachineList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     * */
    ByteArrayOutputStream reportMachines(List<CsMachine> csMachineList);

    /**
     * 历史状态数据导出核心服务
     * @param historyStateList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     * */
    ByteArrayOutputStream reportHistoryStates(List<HistoryState> historyStateList);

    /**
     * 统计数据导出核心服务
     * @param csStatisticsList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     * */
    ByteArrayOutputStream reportStatistics(List<CsStatistics> csStatisticsList);

    /**
     * 指标数据导出核心服务
     * @param csIndexReportList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     * */
    ByteArrayOutputStream reportIndexReport(List<CsIndexReport> csIndexReportList);

}
