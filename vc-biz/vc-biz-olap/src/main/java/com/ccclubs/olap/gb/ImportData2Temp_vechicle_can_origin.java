package com.ccclubs.olap.gb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.olap.bean.Cs_vehicle_machine_rel;
import com.ccclubs.olap.bean.Vehicle_can;
import com.ccclubs.olap.service.VehicleService;
import com.ccclubs.olap.util.PropertiesHelper;
import com.ccclubs.olap.util.UDFUtil;
import com.ccclubs.olap.util.VehicleUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.*;

import java.sql.SQLException;
import java.util.List;

public class ImportData2Temp_vechicle_can_origin {
    private static Logger logger = Logger.getLogger(ImportData2Temp_vechicle_can_origin.class);

    public static void main(String[] args) throws SQLException {
        Logger.getLogger("org").setLevel(Level.ERROR);
        PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
        Integer batchStartNo = propertiesHelper.getBatchStartNo();
        Integer batchEndNo = propertiesHelper.getBatchEndNo();

        SparkSession sparkSession = SparkSession.builder()
                .appName("ImportData2Temp_vechicle_can_origin")
                .enableHiveSupport()
                .getOrCreate();

        sparkSession.sql(" set hive.auto.convert.join=true ");
        sparkSession.sql(" set hive.exec.dynamic.partition=true ");
        sparkSession.sql(" set hive.exec.dynamic.partition.mode=nonstrict ");
        sparkSession.sql(" set hive.exec.max.dynamic.partitions.pernode=1000000 ");

        JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());
        SparkConf conf = jsc.getConf();
        conf.set("spark.serializer","org.apache.spark.serializer.KryoSerializer");
        Class[] classes = {Vehicle_can.class};
        conf.registerKryoClasses(classes);

        //注册日期函数
        UDFUtil.registerDateTimeFunc("convertDateTime", sparkSession);
        UDFUtil.registerDateYearFunc("convertYear", sparkSession);
        UDFUtil.registerDateMonthFunc("convertMonth", sparkSession);
        //注册Can报文转换函数
        UDFUtil.registerCanToGb("convertCanToGb", sparkSession);
        //注册udf函数
        UDFUtil.registerTimeFix("timeFix",sparkSession);

        VehicleService vehicleService = new VehicleService();
        List<List<Cs_vehicle_machine_rel>> waitList = vehicleService.waitVehicleListForZT(500);
        int calTotal=0;
        for(int i=0;i<waitList.size();i++) {
            //在计算区间号内
            if(i>=batchStartNo&&i<batchEndNo) {
                Encoder<Cs_vehicle_machine_rel> cs_vehicle_machine_relEncoder = Encoders.bean(Cs_vehicle_machine_rel.class);
                List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list = waitList.get(i);
                calTotal += cs_vehicle_machine_rel_list.size();
                Dataset<Cs_vehicle_machine_rel> cs_vehicle_machine_relDs = sparkSession.createDataset(cs_vehicle_machine_rel_list, cs_vehicle_machine_relEncoder);
                //cs_vehicle_machine_relDs.createOrReplaceTempView("Cs_vehicle_machine_rel");
                String partition_sql = VehicleUtil.generateCsVinSqlSegement(cs_vehicle_machine_rel_list);
                logger.info("正在导入" + calTotal + "台CAN数据");
                Dataset<Row> temp_vechicle_can_origin_rows = sparkSession.sql("  select " +
                        "a.cs_vin, " +
                        "a.cs_number, " +
                        "convertCanToGb(a.cs_data) as cshcData, " +
                        "a.year as year, " +
                        "a.month as month, " +
                        "convertDateTime(a.add_timemills) as add_time " +
                        "from temp_vehicle_can_init a " +
                        "where convertCanToGb(a.cs_data) is not null and "+partition_sql);
                JavaRDD<Vehicle_can> temp_vechicle_can_rdd = temp_vechicle_can_origin_rows.toJavaRDD().map(new Function<Row, Vehicle_can>() {
                    @Override
                    public Vehicle_can call(Row row) throws Exception {
                        Vehicle_can vehicle_can = new Vehicle_can();
                        String json_data = row.getAs("cshcData");
                        JSONObject jsonObject = JSON.parseObject(json_data);
                        JSONObject vehicleRealData_obj = jsonObject.getJSONObject("vehicleRealData");
                        JSONObject vehicleData_obj = vehicleRealData_obj.getJSONObject("vehicleData");
                        //车辆状态
                        Integer cs_car_status = vehicleData_obj.getInteger("vehicleStatus");
                        //CAN电池状态
                        Integer can_batt_status = vehicleData_obj.getInteger("chargeStatus");
                        //总电压
                        float total_volt = vehicleData_obj.getFloat("totalVoltage");
                        //总电流
                        float total_elect = vehicleData_obj.getFloat("totalCurrent");
                        //档位
                        String gear = vehicleData_obj.getString("gear");
                        //车机号
                        String cs_number = row.getAs("cs_number");
                        //车辆vin码
                        String cs_vin = row.getAs("cs_vin");
                        //添加时间
                        String add_time = row.getAs("add_time");

                        Integer year = row.getAs("year");
                        Integer month = row.getAs("month");

                        vehicle_can.setCs_vin(cs_vin);
                        vehicle_can.setCs_number(cs_number);
                        vehicle_can.setCs_car_status(cs_car_status);
                        vehicle_can.setCan_batt_status(can_batt_status);
                        vehicle_can.setGear(gear);
                        vehicle_can.setTotal_volt(total_volt);
                        vehicle_can.setTotal_elect(total_elect);
                        vehicle_can.setAdd_time(add_time);
                        vehicle_can.setYear(year);
                        vehicle_can.setMonth(month);
                        return vehicle_can;
                    }
                });

                Dataset rows = sparkSession.createDataFrame(temp_vechicle_can_rdd, Vehicle_can.class);
                rows.createOrReplaceTempView("temp_vehicle_can_origin_ds");

                sparkSession.sql(" insert overwrite table temp_vehicle_can_origin\n" +
                        "partition(cs_vin)\n" +
                        "select cs_number,cs_car_status,can_batt_status,total_volt,total_elect,gear,year,month,timeFix(add_time) as add_time,cs_vin\n" +
                        "from temp_vehicle_can_origin_ds distribute by cs_vin  ");
            }
        }

        sparkSession.stop();
    }

}
