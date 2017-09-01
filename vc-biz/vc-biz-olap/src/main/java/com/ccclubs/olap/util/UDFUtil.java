package com.ccclubs.olap.util;

import com.ccclubs.olap.etl.ITransform;
import com.ccclubs.olap.etl.impl.StateTimeInsertTransform;
import com.ccclubs.olap.etl.impl.StateTimeTransform;
import com.ccclubs.olap.protocol.util.FastJsonUtil;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.types.DataTypes;

public class UDFUtil {
    //注册日期时间函数(yyyy-MM-DD HH:mm:ss)
    public static void registerDateTimeFunc(String funName,SparkSession sparkSession){
        sparkSession.udf().register(funName, new UDF1<Long, String>() {
            @Override
            public String call(Long timeMills) throws Exception {
                return DateTimeUtil.getDateTimeByFormat1(timeMills);
            }
        }, DataTypes.StringType);
    }

    //注册日期函数(year)
    public static void registerDateYearFunc(String funName,SparkSession sparkSession){
        sparkSession.udf().register(funName, new UDF1<Long, Integer>() {
            @Override
            public Integer call(Long timeMills) throws Exception {
                return DateTimeUtil.getYear(timeMills);
            }
        }, DataTypes.IntegerType);
    }

    //注册日期函数(mohth)
    public static void registerDateMonthFunc(String funName,SparkSession sparkSession){
        sparkSession.udf().register(funName, new UDF1<Long, Integer>() {
            @Override
            public Integer call(Long timeMills) throws Exception {
                return DateTimeUtil.getMonth(timeMills);
            }
        }, DataTypes.IntegerType);
    }

    //注册国标转换函数
    public static void registerCanToGb(String funName,SparkSession sparkSession){
        sparkSession.udf().register(funName,new UDF1<String,String>(){
            @Override
            public String call(String cshcData) throws Exception {
                return FastJsonUtil.getCanToGb(cshcData);
            }
        },DataTypes.StringType);
    }

    //车辆数据时间修正函数
    public static void registerTimeFix(String funName,SparkSession sparkSession){
        sparkSession.udf().register(funName,new UDF1<String,String>(){
            @Override
            public String call(String originDateTime) throws Exception {
                ITransform<String,String> transform = new StateTimeTransform();
                return transform.doTransform(originDateTime);
            }
        },DataTypes.StringType);
    }

    //车辆State数据插值函数
    public static void registerStateDataInsert(String funName,SparkSession sparkSession){
        sparkSession.udf().register(funName,new UDF1<String,String>(){
            @Override
            public String call(String dataTime) throws Exception {
                ITransform<String,String> transform = new StateTimeInsertTransform();
                return transform.doTransform(dataTime);
            }
        },DataTypes.StringType);
    }

}
