package com.ccclubs.olap.gb;

import com.ccclubs.olap.bean.Cs_vehicle_machine_rel;
import com.ccclubs.olap.service.VehicleService;
import com.ccclubs.olap.util.PropertiesHelper;
import com.ccclubs.olap.util.VehicleUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;

import java.sql.SQLException;
import java.util.List;

public class ImportData2Temp_vechicle_state_distinct {
    private static Logger logger = Logger.getLogger(ImportData2Temp_vechicle_state_distinct.class);
    public static void main(String[] args) throws SQLException {
        Logger.getLogger("org").setLevel(Level.ERROR);
        PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
        Integer batchStartNo = propertiesHelper.getBatchStartNo();
        Integer batchEndNo = propertiesHelper.getBatchEndNo();

        SparkSession sparkSession = SparkSession.builder()
                .appName("ImportData2Temp_vechicle_state_distinct")
                .enableHiveSupport()
                .getOrCreate();

        sparkSession.sql(" set hive.exec.dynamic.partition=true ");
        sparkSession.sql(" set hive.exec.dynamic.partition.mode=nonstrict ");
        sparkSession.sql(" set hive.exec.max.dynamic.partitions=1000000 ");
        sparkSession.sql(" set hive.exec.max.dynamic.partitions.pernode=1000000 ");
        JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());

        VehicleService vehicleService = new VehicleService();
        List<List<Cs_vehicle_machine_rel>> waitList = vehicleService.waitVehicleListForZT(500);
        int calTotal=0;
        for(int i=0;i<waitList.size();i++) {
            //在计算区间号内
            if (i >= batchStartNo && i < batchEndNo) {
                Encoder<Cs_vehicle_machine_rel> cs_vehicle_machine_relEncoder = Encoders.bean(Cs_vehicle_machine_rel.class);
                List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list = waitList.get(i);
                calTotal += cs_vehicle_machine_rel_list.size();
                //Dataset<Cs_vehicle_machine_rel> cs_vehicle_machine_relDs = sparkSession.createDataset(cs_vehicle_machine_rel_list, cs_vehicle_machine_relEncoder);
                //cs_vehicle_machine_relDs.createOrReplaceTempView("Cs_vehicle_machine_rel");
                String partition_sql = VehicleUtil.generateCsVinSqlSegement(cs_vehicle_machine_rel_list);
                logger.info("正在导入" + calTotal + "台STATE数据");
                Dataset<Row> temp_vechicle_state_distinct_rows = sparkSession.sql("select * from( " +
                        "select " +
                        "a.cs_number, " +
                        "a.batt_status, " +
                        "a.saving_status, " +
                        "a.speed, " +
                        "a.total_miles, " +
                        "a.soc, " +
                        "a.year, " +
                        "a.month, " +
                        "a.add_time, " +
                        "a.cs_vin, " +
                        "row_number() over(partition by a.cs_vin,a.add_time order by a.add_time asc) rank " +
                        "from temp_vehicle_state_origin a where " +partition_sql+" "+
                        ") " +
                        "where rank=1");

                temp_vechicle_state_distinct_rows.createOrReplaceTempView("temp_vehicle_state_distinct_ds");
                sparkSession.sql(" insert overwrite table temp_vehicle_state_distinct\n" +
                        "partition(cs_vin)\n" +
                        "select cs_number,batt_status,saving_status,speed,total_miles,soc,year,month,add_time,cs_vin\n" +
                        "from temp_vehicle_state_distinct_ds distribute by cs_vin ");

            }
        }
    }
}
