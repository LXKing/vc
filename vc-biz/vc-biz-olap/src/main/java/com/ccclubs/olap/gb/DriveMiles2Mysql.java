package com.ccclubs.olap.gb;

import com.ccclubs.olap.bean.Cs_vehicle_machine_rel;
import com.ccclubs.olap.bean.SocMiles;
import com.ccclubs.olap.service.VehicleService;
import com.ccclubs.olap.util.BIReport;
import com.ccclubs.olap.util.CsVinPartitioner;
import com.ccclubs.olap.util.PropertiesHelper;
import com.ccclubs.olap.util.VehicleUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.sql.SQLException;
import java.util.*;

public class DriveMiles2Mysql {
    private static Logger logger = Logger.getLogger(DriveMiles2Mysql.class);
    public static void main(String[] args) throws SQLException {
        Logger.getLogger("org").setLevel(Level.ERROR);
        PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
        Integer batchStartNo = propertiesHelper.getBatchStartNo();
        Integer batchEndNo = propertiesHelper.getBatchEndNo();

        SparkSession sparkSession = SparkSession.builder()
                .appName("DriveMiles2Mysql")
                .enableHiveSupport()
                .getOrCreate();
        JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());

        VehicleService vehicleService = new VehicleService();
        List<List<Cs_vehicle_machine_rel>> waitList = vehicleService.waitVehicleListForZT(500);
        int calTotal=0;
        for(int i=0;i<waitList.size();i++) {
            //在计算区间号内
            if (i >= batchStartNo && i < batchEndNo) {
                List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list = waitList.get(i);
                calTotal += cs_vehicle_machine_rel_list.size();
                Map<String,Integer> chsMap = new HashMap<>();
                for(int k=0;k<cs_vehicle_machine_rel_list.size();k++){
                    Cs_vehicle_machine_rel cs_vehicle_machine_rel = cs_vehicle_machine_rel_list.get(k);
                    String cs_vin = cs_vehicle_machine_rel.getCs_vin();
                    chsMap.put(cs_vin,k);
                }
                String partition_sql = VehicleUtil.generateCsVinSqlSegement(cs_vehicle_machine_rel_list);
                logger.info("正在计算" + calTotal + "辆车辆的行驶里程数据!!");

                String sql_str = " select " +
                        "a.cs_vin," +
                        "a.cs_number," +
                        "a.start_soc," +
                        "a.end_soc," +
                        "a.changed_miles, " +
                        "a.start_miles, " +
                        "a.end_miles, " +
                        "a.start_time, " +
                        "a.end_time, " +
                        "a.pace_timemills " +
                        "from  dw_drive_miles_basic a  where " + partition_sql+" "+
                        "distribute by a.cs_vin sort by a.start_time asc ";

                Dataset<Row> result_df = sparkSession.sql(sql_str);

                result_df.toJavaRDD().mapPartitions(new FlatMapFunction<Iterator<Row>, Row>() {
                    @Override
                    public Iterator<Row> call(Iterator<Row> rowIterator) throws Exception {
                        logger.info("开始计算了!");
                        List<SocMiles> socMilesList = new ArrayList<>();
                        SocMiles socMiles = null;
                        while (rowIterator.hasNext()) {
                            logger.info("进入循环了!");
                            socMiles = new SocMiles();
                            Row row = rowIterator.next();

                            String cs_vin = row.getAs("cs_vin");
                            String cs_number = row.getAs("cs_number");
                            int start_soc = row.getAs("start_soc");
                            int end_soc = row.getAs("end_soc");
                            float changed_miles = row.getAs("changed_miles");
                            float start_miles = row.getAs("start_miles");
                            float end_miles = row.getAs("end_miles");
                            String start_time = row.getAs("start_time");
                            String end_time = row.getAs("end_time");
                            long pace_timemills = row.getAs("pace_timemills");

                            socMiles.setCs_vin(cs_vin);
                            socMiles.setCs_number(cs_number);
                            socMiles.setStart_soc(start_soc);
                            socMiles.setEnd_soc(end_soc);
                            socMiles.setChanged_miles(changed_miles);
                            socMiles.setStart_miles(start_miles);
                            socMiles.setEnd_miles(end_miles);
                            socMiles.setStart_time(start_time);
                            socMiles.setEnd_time(end_time);
                            socMiles.setPace_timemills(pace_timemills);

                            socMilesList.add(socMiles);
                        }

                        BIReport.generateDriveReportToMysql(socMilesList);
                        return rowIterator;
                    }
                }).take(1);
            }
        }
        sparkSession.stop();
    }
}
