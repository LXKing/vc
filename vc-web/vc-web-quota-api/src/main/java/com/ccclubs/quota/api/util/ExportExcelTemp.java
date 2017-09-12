package com.ccclubs.quota.api.util;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportExcelTemp<T> implements Serializable{

    private HSSFWorkbook workbook ;
    private int sheetNumber = 0;
    //
    FileInputStream readFile;

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public int getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(int sheetNumber) {
        this.sheetNumber = sheetNumber;
    }


    public ExportExcelTemp(){
        HSSFWorkbook workbook;
        workbook = new HSSFWorkbook();
        setWorkbook(workbook);
        setSheetNumber(0);
    }

    public ExportExcelTemp(String savePath){

         try {
             File file = new File(savePath);
             HSSFWorkbook workbook;
             int sheetNumber = 0;
             if (file.exists()) {
                  readFile = new FileInputStream(file);
                 // 创建一个WorkBook，从指定的文件流中创建，即上面指定了的文件流
                 workbook = new HSSFWorkbook(readFile);
                 sheetNumber = workbook.getNumberOfSheets();

             } else {
                 workbook = new HSSFWorkbook();
                 sheetNumber = 0;
             }
             setWorkbook(workbook);
             setSheetNumber(sheetNumber);

         }catch (Exception e){


             e.printStackTrace();
         }
    }

    public void close(){
        try{
            if(readFile!=null){
                readFile.close();
            }
            if(workbook!=null){
                workbook.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /**
     * @Title: exportExcel
     * @Description: 导出Excel的方法
     * @author: evan @ 2014-01-09
     * @param workbook
     * @param sheetNum (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle  （sheet的名称）
     * @param headers    （表格的标题）
     * @param dataset   （表格的数据）
     * @throws Exception
     */
    public void exportExcel(HSSFWorkbook workbook, int sheetNum,
                            String sheetTitle, String[] headers, Collection<T> dataset) throws Exception {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] srcfield= t.getClass().getDeclaredFields();
            Field[] fields=new Field[srcfield.length-1];
            if(srcfield[0].getName()=="cs_number"){
                System.arraycopy(srcfield,1,fields,0,srcfield.length-1);
            }else {
                fields=srcfield;
            }
            for (short i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                //
                if("serialVersionUID".equals(fieldName)||"dataType".equals(fieldName)){
                    continue;
                }

                HSSFCell cell = row.createCell(i);
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();

                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if("csc_car_no".equals(fieldName)){
                        if ("kong".equals(value)){
                            for (int k=0;k<5;k++){
                                index++;
                                row = sheet.createRow(index);
                            }
                            break;
                        }

                    }



                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        textValue = sdf.format(date);
                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                                1023, 255, (short) 6, index, (short) 6, index);
                        anchor.setAnchorType(2);
//                        patriarch.createPicture(anchor, workbook.addPicture(
//                                bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else if(value instanceof Float){
                        BigDecimal b = new BigDecimal((Float)value);
                        textValue=  b.setScale(3, BigDecimal.ROUND_HALF_UP).toString();

                    }  else{
                        // 其它数据类型都当作字符串简单处理
                        if(value!=null){
                            textValue = value.toString();
                        }

                    }


                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);

                        HSSFRichTextString richString = new HSSFRichTextString(
                                textValue);

                        cell.setCellValue(richString);
                        if(textValue=="波谷"){
                            HSSFCellStyle styleground = workbook.createCellStyle();
                            styleground.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);// 设置背景色
                            styleground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                            cell.setCellStyle(styleground);
                        }else if(textValue=="波峰"){
                            HSSFCellStyle styleground = workbook.createCellStyle();
                            styleground.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);// 设置背景色
                            styleground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                            cell.setCellStyle(styleground);
                        }else if(textValue=="一周内未使用的车辆"){
                            HSSFCellStyle styleground = workbook.createCellStyle();
                            styleground.setFillForegroundColor(HSSFColor.RED.index);// 设置背景色
                            styleground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                            cell.setCellStyle(styleground);
                            break;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    // 清理资源
                }
            }
        }
    }


}
