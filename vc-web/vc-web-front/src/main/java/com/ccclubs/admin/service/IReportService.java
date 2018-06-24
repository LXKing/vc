package com.ccclubs.admin.service;

import com.ccclubs.admin.model.*;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Alban
 * @date 2017年12月11日
 */

public interface IReportService {

    /**
     * 车辆信息导出核心服务
     *
     * @param csVehicleList 依据条件查询得到的结果（一般为当前页的）。
     * @return 已经生成为文件的二进制流。
     */
    @Deprecated
    ByteArrayOutputStream reportVehicles(List<CsVehicle> csVehicleList);

    /**
     * 车机信息导出核心服务
     *
     * @param csMachineList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Deprecated
    ByteArrayOutputStream reportMachines(List<CsMachine> csMachineList);

    /**
     * 历史状态数据导出核心服务
     *
     * @param historyStateList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Deprecated
    ByteArrayOutputStream reportHistoryStates(List<HistoryState> historyStateList);

    /**
     * 统计数据导出核心服务
     *
     * @param csStatisticsList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Deprecated
    ByteArrayOutputStream reportStatistics(List<CsStatistics> csStatisticsList);

    /**
     * 指标数据导出核心服务
     *
     * @param csIndexReportList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Deprecated
    ByteArrayOutputStream reportIndexReport(List<CsIndexReport> csIndexReportList);

    /**
     * 实时数据导出核心服务
     *
     * @param csStateList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Deprecated
    ByteArrayOutputStream reportCsState(List<CsState> csStateList);

    /**
     * 导出核心服务
     *
     * @param list        依据条件查询得到的结果（一般为当前页）。
     * @param headNameMap 需要导出的字段名和对应的中文
     * @return 已经生成为文件的二进制流。
     */
    ByteArrayOutputStream reportOutputStream(Collection list, Map<String, String> headNameMap);

    /**
     *
     * */
    String getFileUrlByUUID(String uuid);

    void putFileUrlMap(String uuid, String filePath);

    Boolean existKey(String key);

}
