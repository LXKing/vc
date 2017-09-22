package com.ccclubs.quota.api.util;

import com.ccclubs.olap.orm.model.ZhiFABean;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class ZhiFaReportUtil {

     public static  ByteArrayOutputStream  getZhiFaReport(Map<String,List<ZhiFABean>> dateMap){
         String[] headers ={"车牌号","类型","车牌别名","当天使用次数","充电次数","当天总里程(公里)","日期","极值"};
         return writeToExcel(dateMap,headers);
     }

    public static  ByteArrayOutputStream writeToExcel(Map<String,List<ZhiFABean>> dateMap, String[] headers){
        ExportExcelZhiFa eeu = new ExportExcelZhiFa();
        HSSFWorkbook workbook=eeu.getWorkbook();
        int sheetNumber=eeu.getSheetNumber();
        //
        //输出地址
//            OutputStream out = new FileOutputStream(savePath);
        ByteArrayOutputStream outPutByte = new ByteArrayOutputStream();
        try{
            //
            for(String weekkey:dateMap.keySet()){
                List<ZhiFABean> data=dateMap.get(weekkey);
                eeu.exportExcel(workbook, sheetNumber++, weekkey, headers, data);
            }
            workbook.write(outPutByte);
        }catch (Exception e){
            e.printStackTrace();
        }
        return outPutByte;
    }
}
