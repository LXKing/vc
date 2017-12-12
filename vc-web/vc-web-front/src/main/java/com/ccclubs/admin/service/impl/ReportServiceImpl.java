package com.ccclubs.admin.service.impl;

import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.admin.service.IReportService;
import com.ccclubs.admin.unit.ExportExcelTemp;
import com.ccclubs.admin.vo.TableResult;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements IReportService {


    /**
     * 车辆信息导出核心服务
     *
     * @param csVehicleList 依据条件查询得到的结果（一般为当前页的）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    public ByteArrayOutputStream reportVehicles(List<CsVehicle> csVehicleList) {
        return null;
    }

    /**
     * 车机信息导出核心服务
     *
     * @param csMachineList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    public ByteArrayOutputStream reportMachines(List<CsMachine> csMachineList) {
        //表头与字段顺序对应
        String[] headersExit ={"编号","接入商","子域"
                ,"车机号","序列号","终端类型"
                ,"终端型号","厂商代码","终端批号"
                ,"终端流水","SIM卡","ICCID"
                ,"服务密码","协议类型","功能标签"
                ,"蓝牙版本","蓝牙地址","蓝牙密码"
                ,"服务器标识","超级手机号","硬件版本"
                ,"DVD当前版本","DVD最新版本","适配车型"
                ,"软件版本","分时租赁版本","网络类型"
                ,"终端协议","CAN1波特率","备注信息"
                ,"修改时间","添加时间","状态"};
        String sheetName="Machines";
        return baseReportService(headersExit,sheetName,csMachineList);
    }

    /**
     * 历史状态数据导出核心服务
     *
     * @param historyStateList 依据条件查询得到的结果（一般为当前页）。
     * @return 已经生成为文件的二进制流。
     */
    @Override
    public ByteArrayOutputStream reportHistoryStates(List<HistoryState> historyStateList) {
        return null;
    }



    private static ByteArrayOutputStream baseReportService(String[] headersExit,String sheetName,Collection list){
        ExportExcelTemp eeu = new ExportExcelTemp();
        HSSFWorkbook workbook=eeu.getWorkbook();
        int sheetNumber=eeu.getSheetNumber();
        //输出流
        ByteArrayOutputStream outPutByte = new ByteArrayOutputStream();
        try{
            String headers[]=headersExit;
            int exist= workbook.getSheetIndex(sheetName);
            if(exist==0){//存在则删除
                workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
                sheetNumber--;
            }
            eeu.exportExcel(workbook, sheetNumber++, sheetName, headers, list);
            workbook.write(outPutByte);
            eeu.close();
        }catch (Exception e){
            e.printStackTrace();
            try{
                eeu.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        return   outPutByte;


    }


}
