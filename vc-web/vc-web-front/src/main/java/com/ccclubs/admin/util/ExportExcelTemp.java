package com.ccclubs.admin.util;

import com.ccclubs.admin.vo.Resolver;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportExcelTemp<T> implements Serializable {

    private HSSFWorkbook workbook;
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


    public ExportExcelTemp() {
        HSSFWorkbook workbook;
        workbook = new HSSFWorkbook();
        setWorkbook(workbook);
        setSheetNumber(0);
    }

    public ExportExcelTemp(String savePath) {
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

        } catch (Exception e) {


            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (readFile != null) {
                readFile.close();
            }
            if (workbook != null) {
                workbook.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param workbook
     * @param sheetNum   (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle （sheet的名称）
     * @param headers    （表格的标题）
     * @param dataset    （表格的数据）
     * @throws Exception
     * @Title: exportExcel
     * @Description: 导出Excel的方法
     * @author: evan @ 2014-01-09
     */
    @Deprecated
    public void exportExcel(HSSFWorkbook workbook, int sheetNum,
                            String sheetTitle, String[] headers, Collection<T> dataset) throws Exception {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        HSSFCellStyle style = getDefStyle(workbook);

        /**
         *数据空时设置的背景色
         */
//        HSSFCellStyle styleground = workbook.createCellStyle();
//        styleground.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);// 设置背景色
//        styleground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
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
            Field[] srcfield = t.getClass().getDeclaredFields();
            Field[] fields = new Field[srcfield.length - 1];
            fields = srcfield;
            HashMap<String, Resolver<T>> resolvers = null;
            for (int i = (fields.length - 1); i >= 0; i--) {
                Field field = fields[i];
                String fieldName = field.getName();
                if (fieldName.equals("resolvers")) {
                    field.setAccessible(true);
                    resolvers = (HashMap<String, Resolver<T>>) field.get(t);
                    break;
                }
            }

            for (short i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                //
                if ("serialVersionUID".equals(fieldName)
                        || "dataType".equals(fieldName)
                        || "resolvers".equals(fieldName)) {
                    continue;
                }

                HSSFCell cell = row.createCell(i);
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {

                    Object value;
                    if (resolvers.containsKey(fieldName.trim() + "Text")) {
                        value = resolvers.get(fieldName.trim() + "Text").execute(t);
                    } else {
                        Class tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName,
                                new Class[]{});
                        value = getMethod.invoke(t, new Object[]{});
                    }
                    // 在这里得到resovler 中的key进行比较，如果有，则使用resovler中的值。
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;

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
                    } else if (value instanceof Float) {
                        BigDecimal b = new BigDecimal((Float) value);
                        textValue = b.setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();

                    } else if (value instanceof Double) {
                        BigDecimal b = new BigDecimal((Double) value);
                        textValue = b.setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();

                    } else if (value instanceof Integer) {
                        BigDecimal b = new BigDecimal((Integer) value);
                        textValue = b.setScale(0, BigDecimal.ROUND_HALF_UP).toString();

                    } else {
                        // 其它数据类型都当作字符串简单处理
                        if (value != null) {
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
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 清理资源
                }
            }
        }
    }


    /**
     * @param workbook   工作簿
     * @param sheetNum   (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle （sheet的名称）
     * @param headers    （表格的标题）
     * @param dataset    （表格的数据）
     * @param fieldMap   (表格的标题对应的字段名k，和对应的标题中文V)
     * @Title: exportToExcel
     * @Description: 导出Excel的方法
     * @author: Alban @ 2018-01-03
     */
    public void exportToExcel(HSSFWorkbook workbook, int sheetNum,
                              String sheetTitle, String[] headers,
                              Collection<T> dataset, Map<String, String> fieldMap) throws IllegalAccessException {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        HSSFCellStyle style = getDefStyle(workbook);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(fieldMap.get(headers[i]));
            cell.setCellValue(text.toString());
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        Field[] srcfield=null;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = it.next();
            boolean haveResolvers=false;
            if (true){
                srcfield=new Field[headers.length];
                try {
                    for (int i=0;i<headers.length;i++){
                        String fieldNameTemp=headers[i];
                        if (fieldNameTemp.indexOf("Text")>-1){
                            haveResolvers=true;
                            srcfield[i]=t.getClass().getDeclaredField(fieldNameTemp.split("Text")[0]);
                        }
                        else {
                            srcfield[i]=t.getClass().getDeclaredField(fieldNameTemp);
                        }
                    }
                }catch (NoSuchFieldException e){
                    e.printStackTrace();
                }

            }
//            Field[] srcfield = t.getClass().getDeclaredFields();
            HashMap<String, Resolver<T>> resolvers = null;
            if (haveResolvers){
                try {
                    Field field =t.getClass().getDeclaredField("resolvers");
                    field.setAccessible(true);
                    resolvers = (HashMap<String, Resolver<T>>) field.get(t);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }

            for (short i = 0; i < srcfield.length; i++) {
                Field field = srcfield[i];
                String fieldName = field.getName();
                if ("serialVersionUID".equals(fieldName)
                        || "dataType".equals(fieldName)
                        || "resolvers".equals(fieldName)) {
                    continue;
                }

                HSSFCell cell = row.createCell(i);

                Object value;
                if (resolvers!=null&&resolvers.containsKey(fieldName.trim()+"Text")) {
                    value = resolvers.get(fieldName.trim()+"Text").execute(t);
                } else {
                    field.setAccessible(true);
                    value=field.get(t);
                }

                String textValue=dealDataToCellString(value);
                // 如果不是图片数据，就当做富文本简单处理
                if (textValue != null) {
                    HSSFRichTextString richString = new HSSFRichTextString(
                            textValue);
                    cell.setCellValue(richString);
                }

            }
        }


    }

    /**
     * 判断要操作的值的类型
     * */
    private String dealDataToCellString( Object value){
        String textValue = null;
        // 判断值的类型后进行强制类型转换
        if (value instanceof Date) {
            Date date = (Date) value;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            textValue = sdf.format(date);
        } else if (value instanceof Float) {
            BigDecimal b = new BigDecimal((Float) value);
            textValue = b.setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
        } else if (value instanceof Double) {
            BigDecimal b = new BigDecimal((Double) value);
            textValue = b.setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
        } else if (value instanceof Integer) {
            BigDecimal b = new BigDecimal((Integer) value);
            textValue = b.setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        } else if (value instanceof byte[]) {
            //如果是图片等，啥也不做。
            textValue = "";
        } else {
            // 其它数据类型都当作字符串简单处理
            if (value != null) {
                textValue = value.toString();
            }
        }
        return textValue;
    }
    /**
     * 生成一个我们自定义的默认样式。
     */
    private HSSFCellStyle getDefStyle(HSSFWorkbook workbook) {
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
        return style;

    }


}
