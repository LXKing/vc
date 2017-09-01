package com.ccclubs.olap.gb;

import com.ccclubs.olap.bean.Cs_vehicle_machine_rel;
import com.ccclubs.olap.service.VehicleService;
import com.ccclubs.olap.util.PropertiesHelper;
import com.ccclubs.olap.util.UDFUtil;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportData2Temp_vehicle_state_init {
    private static Logger logger = Logger.getLogger(ImportData2Temp_vehicle_state_init.class);

    public static void main(String[] args) throws SQLException {
        Logger.getLogger("org").setLevel(Level.ERROR);

        PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
        String mongodbHost = propertiesHelper.getMongodbHost();
        String mongodbPort = propertiesHelper.getMongodbPort();
        String mongodbUser = propertiesHelper.getMongodbUser();
        String mongoPassword = propertiesHelper.getMongodbPassword();
        String mongoDatabase = propertiesHelper.getMongodbDatabse();
        Integer batchStartNo = propertiesHelper.getBatchStartNo();
        Integer batchEndNo = propertiesHelper.getBatchEndNo();

        String inputUrl = "mongodb://%s:%s@%s:%s/%s.mycollection";
        inputUrl = String.format(inputUrl,mongodbUser,mongoPassword,mongodbHost,mongodbPort,mongoDatabase);

        SparkSession sparkSession = SparkSession.builder()
                .appName("ImportData2Temp_vehicle_state_init")
                .config("spark.mongodb.input.uri", inputUrl)
                .enableHiveSupport()
                .getOrCreate();

        JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());

        //注册日期函数
        UDFUtil.registerDateTimeFunc("convertDateTime", sparkSession);
        UDFUtil.registerDateYearFunc("convertYear", sparkSession);
        UDFUtil.registerDateMonthFunc("convertMonth", sparkSession);

        VehicleService vehicleService = new VehicleService();
        List<List<Cs_vehicle_machine_rel>> waitList = vehicleService.waitVehicleListForZT(20000);
        int calTotal=0;
        for(int i=0;i<waitList.size();i++) {
            //在计算区间号内
            if(i>=batchStartNo&&i<batchEndNo) {
                Encoder<Cs_vehicle_machine_rel> cs_vehicle_machine_relEncoder = Encoders.bean(Cs_vehicle_machine_rel.class);
                List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list = waitList.get(i);
                calTotal += cs_vehicle_machine_rel_list.size();
                Dataset<Cs_vehicle_machine_rel> cs_vehicle_machine_relDs = sparkSession.createDataset(cs_vehicle_machine_rel_list, cs_vehicle_machine_relEncoder);
                cs_vehicle_machine_relDs.createOrReplaceTempView("Cs_vehicle_machine_rel");
                logger.info("正在导入" + calTotal + "台STATE数据");

                for (int j = 0; j < 255; j++) {
                    logger.info("导入STATE INIT表进度为:" + (j + 1) + "/255");
                    Map<String, String> readOverrides = new HashMap<String, String>();
                    readOverrides.put("collection", "CsHistoryState_" + j);
                    readOverrides.put("readPreference.name", "secondaryPreferred");
                    ReadConfig readConfig = ReadConfig.create(jsc).withOptions(readOverrides);
                    Dataset<Row> history_can_df = MongoSpark.load(jsc, readConfig).toDF();
                    history_can_df.createOrReplaceTempView("CsHistoryState");

                    Dataset<Row> temp_vechicle_can_init_rows = sparkSession.sql(" select " +
                            "a.cs_vin," +
                            "b.cshsNumber as cs_number," +
                            "b.cshsCharging as batt_status," +
                            "b.cshsSaving as saving_status," +
                            "b.cshsSpeed as speed," +
                            "b.cshsObdMile as total_miles," +
                            "b.cshsEvBattery as soc," +
                            "convertYear(b.cshsAddTime) as year, " +
                            "convertMonth(b.cshsAddTime) as month, " +
                            "b.cshsAddTime as add_timemills " +
                            "from Cs_vehicle_machine_rel a  "+
                            "left join CsHistoryState b on a.cs_number=b.cshsNumber  "+
                            "where b.cshsNumber is not null and convertDateTime(b.cshsAddTime)>='2017-01-01 00:00:00'  "
                    );

                    temp_vechicle_can_init_rows.createOrReplaceTempView("temp_vechicle_state_init_ds");
                    sparkSession.sql(" set hive.exec.dynamic.partition=true ");
                    sparkSession.sql(" set hive.exec.dynamic.partition.mode=nonstrict ");
                    sparkSession.sql(" set hive.exec.max.dynamic.partitions.pernode=1000000 ");
                    sparkSession.sql(" insert overwrite table temp_vehicle_state_init\n" +
                            "partition(year,month,cs_vin)\n" +
                            "select cs_number,batt_status,saving_status,speed,total_miles,soc,add_timemills,year,month,cs_vin\n" +
                            "from temp_vechicle_state_init_ds distribute by cs_vin  ");
                }
            }
        }
        sparkSession.stop();
    }

}
