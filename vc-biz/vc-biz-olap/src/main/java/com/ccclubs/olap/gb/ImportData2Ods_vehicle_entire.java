package com.ccclubs.olap.gb;

import com.ccclubs.olap.bean.Cs_vehicle_machine_rel;
import com.ccclubs.olap.service.VehicleService;
import com.ccclubs.olap.util.PropertiesHelper;
import com.ccclubs.olap.util.VehicleUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.sql.SQLException;
import java.util.List;

public class ImportData2Ods_vehicle_entire {
    private static Logger logger = Logger.getLogger(ImportData2Ods_vehicle_entire.class);

    public static void main(String[] args) throws SQLException {
        Logger.getLogger("org").setLevel(Level.ERROR);
        PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
        Integer batchStartNo = propertiesHelper.getBatchStartNo();
        Integer batchEndNo = propertiesHelper.getBatchEndNo();
        SparkSession sparkSession = SparkSession.builder()
                .appName("ImportData2Ods_vehicle_entire")
                .enableHiveSupport()
                .getOrCreate();
        JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());

        sparkSession.sql(" set hive.exec.dynamic.partition=true ");
        sparkSession.sql(" set hive.exec.dynamic.partition.mode=nonstrict ");
        sparkSession.sql(" set hive.exec.max.dynamic.partitions.pernode=1000000 ");

        VehicleService vehicleService = new VehicleService();
        List<List<Cs_vehicle_machine_rel>> waitList = vehicleService.waitVehicleListForZT(500);
        int calTotal=0;
        for(int i=0;i<waitList.size();i++) {
            //在计算区间号内
            if (i >= batchStartNo && i < batchEndNo) {
//                Encoder<Cs_vehicle_machine_rel> cs_vehicle_machine_relEncoder = Encoders.bean(Cs_vehicle_machine_rel.class);
                List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list = waitList.get(i);
                calTotal += cs_vehicle_machine_rel_list.size();
//                Dataset<Cs_vehicle_machine_rel> cs_vehicle_machine_relDs = sparkSession.createDataset(cs_vehicle_machine_rel_list, cs_vehicle_machine_relEncoder);
//                cs_vehicle_machine_relDs.createOrReplaceTempView("Cs_vehicle_machine_rel");
                String partition_sql = VehicleUtil.generateCsVinSqlSegement(cs_vehicle_machine_rel_list);
                logger.info("正在导入" + calTotal + "台整车数据");

                sparkSession.sql("insert overwrite table ods_vehicle_entire\n" +
                        "partition(cs_vin)\n" +
                        "select a.cs_number,b.cs_car_status,b.can_batt_status,a.batt_status,a.saving_status,a.speed,a.total_miles,a.soc,b.gear,b.total_volt,b.total_elect,a.year,a.month,a.add_time,a.cs_vin\n" +
                        "from temp_vehicle_state_distinct a \n" +
                        "left join temp_vehicle_can_distinct b on a.cs_vin=b.cs_vin and a.add_time=b.add_time and"+partition_sql+" "+
                        "where b.cs_vin is not null "+
                        "distribute by a.cs_vin\n");
            }
        }
        sparkSession.stop();
    }
}
