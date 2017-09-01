package com.ccclubs.olap.util;

import com.ccclubs.olap.bean.SocMiles;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BIReport {
    private static Logger logger = Logger.getLogger(BIReport.class);
    public static void generateCaReport(List<SocMiles> socMilesList){
        if(socMilesList!=null&&socMilesList.size()>0){
            SocMiles firstSocMiles = socMilesList.get(0);
            String first_cs_vin = firstSocMiles.getCs_vin();
            String path_str= "/downloads/report/"+first_cs_vin+".txt";

            Path path = Paths.get(path_str);
            Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
            FileAttribute<Set<PosixFilePermission>> attrs = PosixFilePermissions.asFileAttribute(perms);

            try{
                if(Files.exists(path)){
                    Files.delete(path);
                }
                Files.createFile(path,attrs);

                BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
                for(SocMiles socMiles:socMilesList){
                    writer.write("车架号:"+socMiles.getCs_vin()+" "+
                            "车机号:"+socMiles.getCs_number()+" "+
                            "充电序号:"+socMiles.getRow_no()+" "+
                            "充电开始时间:"+socMiles.getStart_time()+" "+
                            "充电结束时间:"+socMiles.getEnd_time()+" "+
                            "充电持续时间:"+DateTimeUtil.transformMillsToHourStr(socMiles.getPace_timemills())+"小时 "+
                            "充电开始电量百分比:"+socMiles.getStart_soc()+"% "+
                            "充电结束电量百分比:"+socMiles.getEnd_soc()+"% "+
                            "充电量百分比:"+socMiles.getChanged_soc()+"% "
                    );
                    writer.newLine();
                }
                writer.flush();
                writer.close();
            }
            catch (IOException ex){
                logger.error(ex.getMessage());
            }

        }
    }

    public static void generateSocReportToMysql(List<SocMiles> socMilesList) throws Exception {
        DBHelper dbHelper = new DBHelper();
        if(socMilesList!=null&&socMilesList.size()>0){
            SocMiles firstSocMiles = socMilesList.get(0);
            String first_cs_vin = firstSocMiles.getCs_vin();

            //先删除该车统计数据
            String sql=" DELETE FROM soc_miles_basic_zt WHERE cs_vin='%s'  ";
            try {
                sql = String.format(sql, first_cs_vin);
                dbHelper.deleteRecords(sql);
            }
            catch (Exception ex){
                ex.printStackTrace();
                inserLog(sql);
                throw ex;
            }

            //生成插入语句
            List<String> sql_list = new ArrayList<>();
            int row_no=0;
            for(SocMiles socMiles:socMilesList){
                row_no++;
                String insetSql = "INSERT INTO  soc_miles_basic_zt" +
                        "(cs_vin,cs_number,row_no,start_soc,end_soc,changed_soc,start_miles,end_miles,start_time,end_time,pace_timemills) "+
                        "values('%s','%s',%d,%d,%d,%d,%f,%f,'%s','%s',%d)";
                insetSql=String.format(insetSql,
                        socMiles.getCs_vin(),
                        socMiles.getCs_number(),
                        row_no,
                        socMiles.getStart_soc(),
                        socMiles.getEnd_soc(),
                        socMiles.getChanged_soc(),
                        socMiles.getStart_miles(),
                        socMiles.getEnd_miles(),
                        socMiles.getStart_time(),
                        socMiles.getEnd_time(),
                        socMiles.getPace_timemills());
                sql_list.add(insetSql);
            }
            dbHelper.insertRecords(sql_list);

        }
    }


    public static void generateDriveReportToMysql(List<SocMiles> socMilesList) throws Exception {
        DBHelper dbHelper = new DBHelper();
        if(socMilesList!=null&&socMilesList.size()>0){
            SocMiles firstSocMiles = socMilesList.get(0);
            String first_cs_vin = firstSocMiles.getCs_vin();
            //先删除该车统计数据
            String sql = " DELETE FROM drive_miles_basic_zt WHERE cs_vin='%s';  ";
            try {
                sql = String.format(sql, first_cs_vin);
                dbHelper.deleteRecords(sql);
            }
            catch (Exception ex){
                ex.printStackTrace();
                throw ex;
            }

            //生成插入语句
            List<String> sql_list = new ArrayList<>();
            int row_no=0;
            for(SocMiles socMiles:socMilesList){
                row_no++;
                String insetSql = "INSERT INTO  drive_miles_basic_zt" +
                        "(cs_vin,cs_number,row_no,start_soc,end_soc,changed_miles,start_miles,end_miles,start_time,end_time,pace_timemills) "+
                        "values('%s','%s',%d,%d,%d,%f,%f,%f,'%s','%s',%d)";
                insetSql=String.format(insetSql,
                        socMiles.getCs_vin(),
                        socMiles.getCs_number(),
                        row_no,
                        socMiles.getStart_soc(),
                        socMiles.getEnd_soc(),
                        socMiles.getChanged_miles(),
                        socMiles.getStart_miles(),
                        socMiles.getEnd_miles(),
                        socMiles.getStart_time(),
                        socMiles.getEnd_time(),
                        socMiles.getPace_timemills());
                sql_list.add(insetSql);
            }
            dbHelper.insertRecords(sql_list);

        }
    }

    private static void inserLog(String msg) throws SQLException{
        DBHelper dbHelper = new DBHelper();
        //生成插入语句
        List<String> sql_list = new ArrayList<>();
        String insert_sql = " insert into soc_log (msg) values (%s); ";
        insert_sql = String.format(insert_sql,msg);
        sql_list.add(insert_sql);
        dbHelper.insertRecords(sql_list);
    }

    public static void main(String[] args) {

    }
}
