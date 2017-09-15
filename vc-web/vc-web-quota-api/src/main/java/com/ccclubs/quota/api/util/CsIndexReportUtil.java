package com.ccclubs.quota.api.util;

import com.ccclubs.quota.orm.model.CsIndexReport;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Administrator on 2017/9/11 0011.
 */

@Component
public class CsIndexReportUtil {

    public   static  Map<String ,ByteArrayOutputStream >  excelBinaryMap=new HashMap<>();

    public static  List<CsIndexReport> getConditionVinList( MultipartFile[] files){

        List<CsIndexReport> vinList=new ArrayList<>();
        try {
            InputStream is = files[0].getInputStream();
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    String rowinfo = "";
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        CsIndexReport csIndexReport = new CsIndexReport();
                        HSSFCell cell = hssfRow.getCell(0);
                        if (cell != null) {
                            String value = cell.getStringCellValue();
                            csIndexReport.setCsVin(value.toUpperCase());
                            vinList.add(csIndexReport);
                        }
                    }
                }
                break;
            }
            return vinList;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ByteArrayOutputStream outToExcel(Map<String,List<CsIndexReport>> dateMap,List<CsIndexReport> vinList){

        String[] headersExit ={"VIN码","车机号","月均行驶里程(km)","平均单日运行时间(h)","百公里耗电量(kw/100km)","车辆纯电续驶里程(km)"
                ,"最大充电功率(kw/h)","车辆一次充满电所用最少时间(h)","累计行驶里程(km)","累计充电量(kw)"};


        String[] headersNotExit={"不存在的VIN码","重复的VIN码"};


        writeRepeatVin(vinList,dateMap);
        //
        ExportExcelTemp eeu = new ExportExcelTemp();
        HSSFWorkbook workbook=eeu.getWorkbook();
        int sheetNumber=eeu.getSheetNumber();
        //输出地址
        ByteArrayOutputStream outPutByte = new ByteArrayOutputStream();
        try{
            //
            String headers[];
            for(String weekkey:dateMap.keySet()){
                if("存在的VIN码".equals(weekkey)){
                    headers=headersExit;
                }else {
                    headers=headersNotExit;
                }
                //
                List<CsIndexReport> data=dateMap.get(weekkey);
                int exist= workbook.getSheetIndex(weekkey);
                if(exist==0){//存在则删除
                    workbook.removeSheetAt(workbook.getSheetIndex(weekkey));
                    sheetNumber--;
                }
                eeu.exportExcel(workbook, sheetNumber++, weekkey, headers, data);
            }
            workbook.write(outPutByte);
//			out.close();
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
    public static void writeRepeatVin( List<CsIndexReport> vinList,Map<String,List<CsIndexReport>> dateMap){

        List<CsIndexReport> notExit=  dateMap.get("异常的VIN码");
        Set<CsIndexReport> uniqueSet = new HashSet(vinList);
        int i=0;
        for (CsIndexReport temp : uniqueSet) {
            if(Collections.frequency(vinList, temp)>1){
                if (notExit.get(i)==null){
                    CsIndexReport csIndexReport=new CsIndexReport();
                    csIndexReport.setCsNumber(temp.getCsVin());
                    notExit.add(csIndexReport);
                }else {
                    notExit.get(i).setCsNumber(temp.getCsVin());
                    i++;
                }
            }
        }
    }

    @Scheduled(cron="0 15 3 * * ?")
    public void clearExcelBinaryMap(){
            //清除excel内存中的数据
            excelBinaryMap.clear();
    }




}