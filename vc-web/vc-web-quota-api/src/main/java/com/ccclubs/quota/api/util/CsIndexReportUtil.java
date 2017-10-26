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
import java.math.BigDecimal;
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

    public static ByteArrayOutputStream outToExcel(Map<String,CsIndexReport> existDateMap,List<CsIndexReport> vinList){

        String[] headersExit ={"VIN码","车机号","月均行驶里程(km)","平均单日运行时间(h)","百公里耗电量(kwh)","车辆纯电续驶里程(km)"
                ,"最大充电功率(kw)","车辆一次充满电所用最少时间(h)","当前累计行驶里程(km)","累计充电量(kwh)"};
        vinList.remove(0);
        //正常数据
        Map<String,List<CsIndexReport>> dateMap=getZtNormData( existDateMap, vinList);

//         Map<String,List<CsIndexReport>> dateMap=getZtExceptionData( existDateMap, vinList);
        //
        ExportExcelTemp eeu = new ExportExcelTemp();
        HSSFWorkbook workbook=eeu.getWorkbook();
        int sheetNumber=eeu.getSheetNumber();
        //输出地址
        ByteArrayOutputStream outPutByte = new ByteArrayOutputStream();
        try{
            //
            String headers[]=headersExit;
            for(String weekkey:dateMap.keySet()){
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

    public static Map<String,List<CsIndexReport>> getZtNormData(Map<String,CsIndexReport> existDateMap,List<CsIndexReport> vinList){
        for (CsIndexReport csIndexReport:vinList){
            if (existDateMap.containsKey(csIndexReport.getCsVin())){
                CsIndexReport tempCsIndexReport=existDateMap.get(csIndexReport.getCsVin());
                //
                csIndexReport.setCsNumber(tempCsIndexReport.getCsNumber());
                csIndexReport.setMonthlyAvgMile(tempCsIndexReport.getMonthlyAvgMile());
                csIndexReport.setAvgDriveTimePerDay(tempCsIndexReport.getAvgDriveTimePerDay());
                csIndexReport.setPowerConsumePerHundred(tempCsIndexReport.getPowerConsumePerHundred());
                csIndexReport.setElectricRange(tempCsIndexReport.getElectricRange());
                csIndexReport.setMaxChargePower(tempCsIndexReport.getMaxChargePower());
                csIndexReport.setMinChargeTime(tempCsIndexReport.getMinChargeTime());
                csIndexReport.setCumulativeMileage(tempCsIndexReport.getCumulativeMileage());
                csIndexReport.setCumulativeCharge(tempCsIndexReport.getCumulativeCharge());
            }
        }
        Map<String,List<CsIndexReport>>dateMap=new HashMap<>();
        dateMap.put("查询结果",vinList);
        //
        return dateMap;
    }






    public static Map<String,List<CsIndexReport>> getZtExceptionData(Map<String,CsIndexReport> existDateMap,List<CsIndexReport> vinList){

        //异常筛选
        //8<百公里耗电量<25
        List<CsIndexReport>  powerConsumptionPerHundredList=new ArrayList<>();

        //120<纯电续航里程<200
        List<CsIndexReport>  pureElectricMileageList=new ArrayList<>();

        //if累计行驶里程>0,then 月均行驶里程>0，平均单日运行时间>0,累计充电量>0
        List<CsIndexReport>  cumulativeMileageList=new ArrayList<>();

        //4.--2<最大充电功率<36
        List<CsIndexReport>  maximumChargingPowerList=new ArrayList<>();

        //5、一次充满电最少时间>0.8
        List<CsIndexReport>  minimumFullTimeList=new ArrayList<>();

        //
        List<CsIndexReport>  meetFiveConditionList=new ArrayList<>();

        for (CsIndexReport csIndexReport:vinList){
            if (existDateMap.containsKey(csIndexReport.getCsVin())){
                CsIndexReport tempCsIndexReport=existDateMap.get(csIndexReport.getCsVin());
                //
                csIndexReport.setCsNumber(tempCsIndexReport.getCsNumber());
                csIndexReport.setMonthlyAvgMile(tempCsIndexReport.getMonthlyAvgMile());
                csIndexReport.setAvgDriveTimePerDay(tempCsIndexReport.getAvgDriveTimePerDay());
                csIndexReport.setPowerConsumePerHundred(tempCsIndexReport.getPowerConsumePerHundred());
                csIndexReport.setElectricRange(tempCsIndexReport.getElectricRange());
                csIndexReport.setMaxChargePower(tempCsIndexReport.getMaxChargePower());
                csIndexReport.setMinChargeTime(tempCsIndexReport.getMinChargeTime());
                csIndexReport.setCumulativeMileage(tempCsIndexReport.getCumulativeMileage());
//                csIndexReport.setCurrentCumulativeMileage(tempCsIndexReport.getCurrentCumulativeMileage());
                csIndexReport.setCumulativeCharge(tempCsIndexReport.getCumulativeCharge());

                //1.百公里耗电量
                BigDecimal powerConsumePerHundred= tempCsIndexReport.getPowerConsumePerHundred();
                int a=powerConsumePerHundred.compareTo(BigDecimal.valueOf(8));
                int b=powerConsumePerHundred.compareTo(BigDecimal.valueOf(25));
                if(!(a==1&&b==-1)){
                    powerConsumptionPerHundredList.add(csIndexReport);
                }
                //2、120<纯电续航里程<200
                BigDecimal electricRange= tempCsIndexReport.getElectricRange();
                a=electricRange.compareTo(BigDecimal.valueOf(120));
                b=electricRange.compareTo(BigDecimal.valueOf(200));
                if(!(a==1&&b==-1)){
                    pureElectricMileageList.add(csIndexReport);
                }
                //3、if累计行驶里程>0,then 月均行驶里程>0，平均单日运行时间>0,累计充电量>0
                int cumulativeMileage= tempCsIndexReport.getCumulativeMileage().compareTo(BigDecimal.valueOf(0));
                int monthlyAvgMile= tempCsIndexReport.getMonthlyAvgMile().compareTo(BigDecimal.valueOf(0));
                int avgDriveTimePerDay = tempCsIndexReport.getAvgDriveTimePerDay().compareTo(BigDecimal.valueOf(0));
                int cumulativeCharge=tempCsIndexReport.getCumulativeCharge().compareTo(BigDecimal.valueOf(0));


                if(!(cumulativeMileage==1&&monthlyAvgMile==1
                        &&avgDriveTimePerDay==1&&cumulativeCharge==1)){
                    cumulativeMileageList.add(csIndexReport);
                }

                //4、2<最大充电功率<36
                BigDecimal maxChargePower= tempCsIndexReport.getMaxChargePower();
                a=maxChargePower.compareTo(BigDecimal.valueOf(2));
                b=maxChargePower.compareTo(BigDecimal.valueOf(36));
                if(!(a==1&&b==-1)){
                    maximumChargingPowerList.add(csIndexReport);
                }
                //5、一次充满电最少时间>0.8
                BigDecimal minChargeTime= tempCsIndexReport.getMinChargeTime();
                a=minChargeTime.compareTo(BigDecimal.valueOf(0.8));
                if(!(a==1)){
                    minimumFullTimeList.add(csIndexReport);
                }

                //6. 5个条件都满足
                //1.
                int powerConsumePerHundredA=powerConsumePerHundred.compareTo(BigDecimal.valueOf(8));
                int powerConsumePerHundredB=powerConsumePerHundred.compareTo(BigDecimal.valueOf(25));
                //2.
                int electricRangeA=electricRange.compareTo(BigDecimal.valueOf(120));
                int electricRangeB=electricRange.compareTo(BigDecimal.valueOf(200));
                //3.
                int cumulativeMileageA= tempCsIndexReport.getCumulativeMileage().compareTo(BigDecimal.valueOf(0));
                int monthlyAvgMileB= tempCsIndexReport.getMonthlyAvgMile().compareTo(BigDecimal.valueOf(0));
                int avgDriveTimePerDayC = tempCsIndexReport.getAvgDriveTimePerDay().compareTo(BigDecimal.valueOf(0));
                int cumulativeChargeD=tempCsIndexReport.getCumulativeCharge().compareTo(BigDecimal.valueOf(0));
                //4.
                int maxChargePowerA=maxChargePower.compareTo(BigDecimal.valueOf(2));
                int maxChargePowerB=maxChargePower.compareTo(BigDecimal.valueOf(36));
                //5.
                int  minChargeTimeA=minChargeTime.compareTo(BigDecimal.valueOf(0.8));

                if((powerConsumePerHundredA==1&&powerConsumePerHundredB==-1)&&

                        (electricRangeA==1&&electricRangeB==-1) &&

                        (cumulativeMileageA==1&&monthlyAvgMileB==1&&avgDriveTimePerDayC==1&&cumulativeChargeD==1)&&

                        (maxChargePowerA==1&&maxChargePowerB==-1)&&

                        (minChargeTimeA==1)
                        ){

                    meetFiveConditionList.add(csIndexReport);
                }



            }
        }

        Map<String,List<CsIndexReport>>dateMap=new HashMap<>();
        dateMap.put("查询结果",vinList);
        //
        dateMap.put("!(8<百公里耗电量<25)",powerConsumptionPerHundredList);
        dateMap.put("!(120<纯电续航里程<200)",pureElectricMileageList);
        dateMap.put("!(if累计行驶里程>0,then月均行驶里程>0,平均单日运行时间>0,累计充电量>0)",cumulativeMileageList);
        dateMap.put("!(2<最大充电功率<36)",maximumChargingPowerList);
        dateMap.put("!(一次充满电最少时间>0.8)",minimumFullTimeList);
        dateMap.put("五个条件都满足",meetFiveConditionList);

        return dateMap;
    }















    @Scheduled(cron="0 15 3 * * ?")
    public void clearExcelBinaryMap(){
            //清除excel内存中的数据
            excelBinaryMap.clear();
    }




}
