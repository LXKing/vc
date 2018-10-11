package com.ccclubs.admin.service.impl;

import com.ccclubs.admin.constants.Constants;
import com.ccclubs.admin.model.*;
import com.ccclubs.admin.service.IReportService;
import com.ccclubs.admin.util.ExportExcelTemp;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    RedisTemplate redisTemplate;

    private static Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    /**
     * 车辆信息导出核心服务
     *
     * @param csVehicleList 依据条件查询得到的结果（一般为当前页的）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    @Deprecated
    public ByteArrayOutputStream reportVehicles(List<CsVehicle> csVehicleList) {

        //表头与字段顺序对应
        String[] headersExit = {
                "编号", "接入商", "车牌号",
                "车架号", "发动机(电机)编号", "合格证号",
                "车型", "车机设备", "车身颜色",
                "可充电储能系统编码", "出厂日期", "地标类型",
                "车辆领域", "车型代码", "车型备案号",
                "内饰颜色", "状态", "添加时间",
                "修改时间"};
        String sheetName = "Vehicle";
        return baseReportService(headersExit, sheetName, csVehicleList);

    }

    /**
     * 车机信息导出核心服务
     *
     * @param csMachineList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    @Deprecated
    public ByteArrayOutputStream reportMachines(List<CsMachine> csMachineList) {

        //表头与字段顺序对应
        String[] headersExit = {"编号", "接入商", "子域"
                , "车机号", "序列号", "终端类型"
                , "终端型号", "厂商代码", "终端批号"
                , "终端流水", "SIM卡", "ICCID"
                , "服务密码", "协议类型", "功能标签"
                , "蓝牙版本", "蓝牙地址", "蓝牙密码"
                , "服务器标识", "超级手机号", "硬件版本"
                , "DVD当前版本", "DVD最新版本", "适配车型"
                , "软件版本", "分时租赁版本", "网络类型"
                , "终端协议", "CAN1波特率", "备注信息"
                , "修改时间", "添加时间", "状态"};
        String sheetName = "Machines";
        return baseReportService(headersExit, sheetName, csMachineList);

    }

    /**
     * 历史状态数据导出核心服务
     *
     * @param historyStateList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    @Deprecated
    public ByteArrayOutputStream reportHistoryStates(List<HistoryState> historyStateList) {

        //表头与字段顺序对应
        String[] headersExit = {
                "车机号", "授权系统",
                "添加时间", "下位机时间", "租赁状态",
                "报警代码", "RFID卡号", "用户RFID",
                "累计里程", "发动机温度", "总里程",
                "车速", "转速", "燃油量",
                "小电池电量", "动力电池电量", "充电状态",
                "订单油里程", "订单电量程", "续航里程",
                "温度", "卫星数量", "卫星信号强度",
                "gps有效性", "CSQ", "经度",
                "纬度", "方向角度", "循环模式",
                "PTC启停", "压缩机", "档风量",
                "功耗模式", "车门状态", "发动机",
                "钥匙状态", "灯状态", "锁状态",
                "网络类型", "LAC", "CI",
                "订单号", "档位"};
        String sheetName = "HistoryStates";
        return baseReportService(headersExit, sheetName, historyStateList);

    }

    /**
     * 统计数据导出核心服务
     *
     * @param csStatisticsList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    @Deprecated
    public ByteArrayOutputStream reportStatistics(List<CsStatistics> csStatisticsList) {

        //表头与字段顺序对应
        String[] headersExit = {
                "编号", "统计时间", "间隔时间",
                "总注册数", "在线数", "离线数",
                "运行数", "充电数", "运行总里程",
                "总充电量", "电池增量", "总运行时间",
                "增量里程", "授权系统", "车型"};
        String sheetName = "Statistics";
        return baseReportService(headersExit, sheetName, csStatisticsList);

    }

    /**
     * 指标数据导出核心服务
     *
     * @param csIndexReportList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    @Deprecated
    public ByteArrayOutputStream reportIndexReport(List<CsIndexReport> csIndexReportList) {
        //表头与字段顺序对应
        String[] headersExit = {
                "车辆VIN码", "车机号",
                "月均行驶里程(KM)", "平均单日运行时间", "百公里耗电量",
                "车辆纯电续驶里程", "最大充电功率", "车辆一次充满电所用最少时间",
                "累计行驶里程", "累计充电量", "数据类型",
                "此行创建时间", "此行更新时间", "车辆出厂日期"
        };
        String sheetName = "IndexReport";
        return baseReportService(headersExit, sheetName, csIndexReportList);
    }


    /**
     * 实时数据导出核心服务
     *
     * @param csStateList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    @Deprecated
    public ByteArrayOutputStream reportCsState(List<CsState> csStateList) {
        //表头与字段顺序对应
        String[] headersExit = {
                "编号", "接入商", "子域",
                "车机号", "车辆", "接收时间",
                "报文时间", "租赁状态", "报警码",
                "RFID卡号", "用户RFID", "累计里程",
                "发动机温度", "订单总里程", "车速",
                "转速", "燃油量", "小电瓶电量",
                "SOC", "充电状态", "订单油里程",
                "订单电里程", "续航里程", "温度",
                "CSQ", "经度", "纬度",
                "GPS有效性", "GPS强度", "GPS卫星数",
                "方向角", "循环模式", "PTC启停",
                "压缩机", "档风量", "功耗模式",
                "车门状态", "发动机状态", "钥匙状态",
                "档位", "车灯状态", "车锁状态",
                "网络类型", "LAC", "CI",
                "订单号", "报文数据"
        };
        String sheetName = "CsState";
        return baseReportService(headersExit, sheetName, csStateList);
    }

    /**
     * 导出核心服务
     *
     * @param list        依据条件查询得到的结果（一般为当前页）。
     * @param headNameMap 需要导出的字段名和对应的中文
     * @return 已经生成为文件的二进制流。
     */
    @Override
    public ByteArrayOutputStream reportOutputStream(Collection list, Map<String, String> headNameMap) {
        String[] headersExit = new String[headNameMap.keySet().size()];
        int i = 0;
        for (String headString : headNameMap.keySet()) {
            headersExit[i++] = headString;
        }
        String sheetName = "Data";
        logger.info("start reportBaseService :" + headNameMap.toString());
        return reportBaseService(headersExit, sheetName, list, headNameMap);
    }


    @Override
    public String getFileUrlByUUID(String uuid) {
        String filePath = (String) redisTemplate.opsForHash().get(Constants.REDIS_KEY_REPORT_FILE_MAP, uuid);
        return filePath;
    }

    @Override
    public void putFileUrlMap(String uuid, String filePath) {
        redisTemplate.expire(Constants.REDIS_KEY_REPORT_FILE_MAP, 8, TimeUnit.HOURS);
        redisTemplate.opsForHash().put(Constants.REDIS_KEY_REPORT_FILE_MAP, uuid, filePath);
    }

    @Override
    public Boolean existKey(String key) {
        return redisTemplate.opsForHash().hasKey(Constants.REDIS_KEY_REPORT_FILE_MAP, key);
    }


    @Deprecated
    private static ByteArrayOutputStream baseReportService(
            String[] headersExit, String sheetName, Collection list) {
        ExportExcelTemp eeu = new ExportExcelTemp();
        HSSFWorkbook workbook = eeu.getWorkbook();
        int sheetNumber = eeu.getSheetNumber();
        //输出流
        ByteArrayOutputStream outPutByte = new ByteArrayOutputStream();
        try {
            String headers[] = headersExit;
            int exist = workbook.getSheetIndex(sheetName);
            if (exist == 0) {
                //存在则删除
                workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
                sheetNumber--;
            }
            eeu.exportExcel(workbook, sheetNumber++, sheetName, headers, list);
            workbook.write(outPutByte);
            eeu.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                eeu.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return outPutByte;

    }

    private static ByteArrayOutputStream reportBaseService(
            String[] headersExit, String sheetName, Collection list, Map<String, String> fieldMap) {
        ExportExcelTemp eeu = new ExportExcelTemp();
        HSSFWorkbook workbook = eeu.getWorkbook();
        int sheetNumber = eeu.getSheetNumber();
        //输出流
        ByteArrayOutputStream outPutByte = new ByteArrayOutputStream();
        try {
            String headers[] = headersExit;
            int exist = workbook.getSheetIndex(sheetName);
            if (exist == 0) {
                //存在则删除
                workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
                sheetNumber--;
            }
            eeu.exportToExcelNew(workbook, sheetNumber++, sheetName, headers, list, fieldMap);
            workbook.write(outPutByte);
            eeu.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                eeu.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return outPutByte;

    }

}
