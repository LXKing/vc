package com.ccclubs.olap.gb;

import com.ccclubs.olap.bean.Cs_vehicle_machine_rel;
import com.ccclubs.olap.bean.Pace;
import com.ccclubs.olap.bean.Vehicle_entire;
import com.ccclubs.olap.service.VehicleService;
import com.ccclubs.olap.util.CsVinPartitioner;
import com.ccclubs.olap.util.PropertiesHelper;
import com.ccclubs.olap.util.SocPaceFactory;
import com.ccclubs.olap.util.VehicleUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CalDataToSocMiles {
    private static Logger logger = Logger.getLogger(CalDataToSocMiles.class);
    public static void main(String[] args) throws SQLException {
        Logger.getLogger("org").setLevel(Level.ERROR);
        PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
        Integer batchStartNo = propertiesHelper.getBatchStartNo();
        Integer batchEndNo = propertiesHelper.getBatchEndNo();

        SparkSession sparkSession = SparkSession.builder()
                .appName("CalDataToSocMiles")
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
                List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list = waitList.get(i);
                calTotal += cs_vehicle_machine_rel_list.size();
                Map<String,Integer> chsMap = new HashMap<>();
                for(int k=0;k<cs_vehicle_machine_rel_list.size();k++){
                    Cs_vehicle_machine_rel cs_vehicle_machine_rel = cs_vehicle_machine_rel_list.get(k);
                    String cs_vin = cs_vehicle_machine_rel.getCs_vin();
                    chsMap.put(cs_vin,k);
                }
                String partition_sql = VehicleUtil.generateCsVinSqlSegement(cs_vehicle_machine_rel_list);
                logger.info("正在计算" + calTotal + "辆车辆的电量里程数据!!");
                Dataset<Row> rows = sparkSession.sql(" select " +
                        "a.cs_vin," +
                        "a.cs_number," +
                        "a.cs_car_status," +
                        "a.can_batt_status," +
                        "a.batt_status," +
                        "a.saving_status," +
                        "a.speed," +
                        "a.total_miles," +
                        "a.soc," +
                        "a.gear," +
                        "a.total_volt," +
                        "a.total_elect," +
                        "a.add_time " +
                        "from ods_vehicle_entire a " +
                        "where " + partition_sql + " " +
                        "distribute by a.cs_vin sort by a.add_time asc ");

                JavaPairRDD<String,Row> pairRDD = rows.toJavaRDD().mapToPair(new PairFunction<Row, String, Row>() {
                    @Override
                    public Tuple2<String, Row> call(Row row) throws Exception {
                        String cs_vin =row.getAs("cs_vin");
                        return new Tuple2<String,Row>(cs_vin,row);
                    }
                });

                JavaRDD<Pace> paceRDD = pairRDD
                        .partitionBy(new CsVinPartitioner(chsMap))
                        .map(new Function<Tuple2<String, Row>, Row>() {
                            @Override
                            public Row call(Tuple2<String, Row> stringRowTuple2) throws Exception {
                                return stringRowTuple2._2();
                        }
                }).mapPartitions(new FlatMapFunction<Iterator<Row>, Pace>() {
                    @Override
                    public Iterator<Pace> call(Iterator<Row> rowIterator) throws Exception {
                        SocPaceFactory pf = new SocPaceFactory();
                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();
                            Vehicle_entire vehicle_entire = new Vehicle_entire();
                            String cs_vin = row.getAs("cs_vin");
                            String cs_number = row.getAs("cs_number");
                            Integer cs_car_status = row.getAs("cs_car_status");
                            Integer can_batt_status = row.getAs("can_batt_status");
                            Integer batt_status = row.getAs("batt_status");
                            Integer saving_status = row.getAs("saving_status");
                            float speed = row.getAs("speed");
                            float total_miles = row.getAs("total_miles");
                            Integer soc = row.getAs("soc");
                            String gear = row.getAs("gear");
                            float total_volt = row.getAs("total_volt");
                            float total_elect = row.getAs("total_elect");
                            String add_time = row.getAs("add_time");

                            vehicle_entire.setCs_vin(cs_vin);
                            vehicle_entire.setCs_number(cs_number);
                            vehicle_entire.setCs_car_status(cs_car_status);
                            vehicle_entire.setCan_batt_status(can_batt_status);
                            vehicle_entire.setBatt_status(batt_status);
                            vehicle_entire.setSaving_status(saving_status);
                            vehicle_entire.setSpeed(speed);
                            vehicle_entire.setTotal_miles(total_miles);
                            vehicle_entire.setSoc(soc);
                            vehicle_entire.setGear(gear);
                            vehicle_entire.setTotal_volt(total_volt);
                            vehicle_entire.setTotal_elect(total_elect);
                            vehicle_entire.setAddTime(add_time);

                            pf.addVehicleEntire(vehicle_entire);
                        }
                        Vehicle_entire final_vehicle_entire = new Vehicle_entire();
                        final_vehicle_entire.setTerminate_flg(1);
                        //插入一条终结标识记录
                        pf.addVehicleEntire(final_vehicle_entire);

                        List<Pace> paceList = pf.getPaceList();


                        return paceList.iterator();
                    }

                });

                Dataset pace_rows = sparkSession.createDataFrame(paceRDD, Pace.class);
                pace_rows.createOrReplaceTempView("dw_soc_miles_basic_ds");
                sparkSession.sql(" set hive.exec.dynamic.partition=true ");
                sparkSession.sql(" set hive.exec.dynamic.partition.mode=nonstrict ");
                sparkSession.sql(" set hive.exec.max.dynamic.partitions.pernode=1000000 ");
                sparkSession.sql(" insert overwrite table dw_soc_miles_basic " +
                        "partition(cs_vin) " +
                        "select cs_number,row_no,start_soc,end_soc,changed_soc,start_miles,end_miles,start_time,end_time,pace_timemills,cs_vin " +
                        "from dw_soc_miles_basic_ds  ");

            }
        }
        sparkSession.stop();

    }
}
