package com.ccclubs.quota.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.constant.RedisConst;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.gb.GB_02;
import com.ccclubs.protocol.dto.gb.GB_02_01;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.quota.orm.model.CsIndexReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
@Component
public class DBHelperZt {
    @Autowired
    RedisTemplate redisTemplate;

    @Value("${zt.driver}")
    public  String driver;

    @Value("${zt.jdbc.url}")
    public  String url;

    @Value("${zt.jdbc.username}")
    public  String  username;

    @Value("${zt.jdbc.password}")
    public  String password;

    @Value("${zt.avgDriveTimePerDay}")
    public String[] avgDriveTimePerDay;
    //
    @Value("${zt.updateInterval}")
    private int updateInterval;
    //
    public  Connection conn = null;
    public PreparedStatement pst = null;


    public  void getDBConnect(){
        try{
            Class.forName(driver);
            //得到数据库连接的相关信息
            conn = DriverManager.getConnection(url,username,password);
            //关闭自动提交
            conn.setAutoCommit(false);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void dbClose(){
        try{
            if (conn!=null){
                conn.close();
            }
            if(pst!=null){
                pst.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 依据车型获取国标数据的obd里程等信息。
     * @auther Alban
     * **/
    public List<Map<String,Object>>  getGbReportDate(){
        List<Map<String,Object>> tempList=new ArrayList<>();
        try {
            String sql = " SELECT t1.csv_car_no  csmrCarNo,t1.csv_vin  csmrVin,t1.csv_model csmrModel,t1.csv_prod_date csmrProdTime,t1.csv_domain  csmrDomain,t2.csm_number csmrNumber" +
                    "FROM cs_vehicle t1, cs_machine t2 " +
                    "WHERE t1.csv_model=22 AND t1.csv_machine=t2.csm_id";
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()){
                Map<String,Object>mapTemp=new HashMap<>();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    //String columnName1 = metaData.getColumnName(i);
                    String columnName = metaData.getColumnLabel(i);//列别名
                    Object columnValue = rs.getObject(columnName);
                    mapTemp.put(columnName,columnValue);
                }
                String vin=rs.getString("csmrVin");
                Object hexObject=redisTemplate.opsForHash().get(RedisConst.REDIS_KEY_RT_STATES_HASH, vin);
                if (null==hexObject){continue;}
                String hexString = (String) hexObject;
                GBMessage gbMessage = new GBMessage();
                gbMessage.ReadFromBytes(Tools.HexString2Bytes(hexString));
                GB_02 gb_02=(GB_02) gbMessage.getMessageContents();
                //这里的get（0）是由于gb0201排在第一个。注意这里可能会出现的Bug。
                //Fixme 可能存在取值不是自己想要的结果的bug。
                GB_02_01 gb_02_01=(GB_02_01) gb_02.getAdditionals().get(0);
                int csmrObdMile=gb_02_01.getMileage();
                mapTemp.put("csmrObdMile",csmrObdMile);
                tempList.add(mapTemp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  tempList;
    }


    /**
     * 根据车机与vin码对应关系获取obd_mile
     * @return
     */
    public List<Map<String,Object>> getMiddleReportData(){
        List<Map<String,Object>> tempList=new ArrayList<>();
        try {
            String sql = " SELECT t1.csv_car_no  csmrCarNo,t1.csv_vin  csmrVin,t1.csv_model csmrModel,t1.csv_prod_date csmrProdTime,t1.csv_domain  csmrDomain,t2.csm_number csmrNumber,t3.css_obd_mile csmrObdMile FROM cs_vehicle t1, cs_machine t2 LEFT JOIN cs_state t3 ON t2.csm_number=t3.css_number WHERE t1.csv_machine=t2.csm_id AND css_obd_mile >0";
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()){
                Map<String,Object>mapTemp=new HashMap<>();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    //String columnName1 = metaData.getColumnName(i);
                    String columnName = metaData.getColumnLabel(i);//列别名
                    Object columnValue = rs.getObject(columnName);
                    mapTemp.put(columnName,columnValue);
                }
                tempList.add(mapTemp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  tempList;
    }


    //统计最新的众泰--国标指标数据***************************************
    public  void getZtCurrentOBDTemp(List<CsIndexReport> exVinList){
        try {
            String sql = "SELECT css_number, css_obd_mile ,css_add_time from cs_state WHERE  css_number IN (";
            //
            StringBuffer sb=new StringBuffer();
            for (CsIndexReport csIndexReport:exVinList){
                sb.append("\'"+csIndexReport.getCsNumber()+"\'").append(" ,");
            }
            String  sqlResult = sql+sb.substring(0,sb.lastIndexOf(","))+")";
            //
            pst = conn.prepareStatement(sqlResult);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            //先把当前obd里程的数据
            List<Map<String,Object>>tempList=new ArrayList<>();
            while(rs.next()){
                Map<String,Object>mapTemp=new HashMap<>();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    mapTemp.put(columnName,columnValue);
                }
                tempList.add(mapTemp);
            }
            //组装list条件数据
            for (CsIndexReport csIndexReport:exVinList){
                String csNumber=csIndexReport.getCsNumber();
                if(csNumber==null||csNumber==""){
                    continue;
                }
                //车辆出厂日期默认值
                Date facTime= DateTimeUtil.getStringToDate("2017-01-01 00:00:00");
                if(csIndexReport.getFacTime()!=null){
                    facTime=csIndexReport.getFacTime();
                }
                //
                for (Map<String,Object> temp:tempList){
                    String  csState_csNumber=temp.get("css_number").toString();
                    if(csNumber.equals(csState_csNumber)){
                        //通过obd里程统计各项指标数据
                        int currentObd =Integer.parseInt(temp.get("css_obd_mile").toString());
                        if(currentObd!=0) {
                            Date currTime =DateTimeUtil.getStringToDate(temp.get("css_add_time").toString());
                            //
                            //月均行驶里程
                            BigDecimal monthlyAvgMile = getObdByMonth(facTime, currTime, currentObd);
                            //纯电行驶里程
                            BigDecimal electricRange = getElectricRange();
                            // 百公里耗电量
                            BigDecimal powerConsumePerHundred = getPowerConsumePerHundred(electricRange);
                            //累计充电量
                            BigDecimal cumulativeCharge = getCumulativeCharge(currentObd, powerConsumePerHundred);
                            //车辆一次充满电所用最少时间
                            BigDecimal minChargeTime = getMinChargeTime();
                            //最大充电功率
                            BigDecimal maxChargePower = getMaxChargePower();
                            //平均单日运行时间
                            BigDecimal avgDriveTimePerDay = getAvgDriveTimePerDay(currentObd);
                            //----//
                            csIndexReport.setMonthlyAvgMile(monthlyAvgMile);
                            csIndexReport.setElectricRange(electricRange);
                            csIndexReport.setPowerConsumePerHundred(powerConsumePerHundred);
                            csIndexReport.setCumulativeCharge(cumulativeCharge);
                            csIndexReport.setMinChargeTime(minChargeTime);
                            csIndexReport.setMaxChargePower(maxChargePower);
                            csIndexReport.setAvgDriveTimePerDay(avgDriveTimePerDay);
                            csIndexReport.setCumulativeMileage(new BigDecimal(currentObd));
                            //
                            csIndexReport.setModifyDate(new Date());
                        }else{
                            csIndexReport.setMonthlyAvgMile(null);
                            csIndexReport.setElectricRange(null);
                            csIndexReport.setPowerConsumePerHundred(null);
                            csIndexReport.setCumulativeCharge(null);
                            csIndexReport.setMinChargeTime(null);
                            csIndexReport.setMaxChargePower(null);
                            csIndexReport.setAvgDriveTimePerDay(null);
                            csIndexReport.setCumulativeMileage(null);
                            //
                            csIndexReport.setModifyDate(new Date());
                        }
                        break;
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //**************************各项指标计算公式***********************************
    //月均行驶里程
    public   BigDecimal getObdByMonth(Date facTime,Date currTime,int currentObd){
        int month=1;
        if(facTime==null){
            facTime=DateTimeUtil.getStringToDate("2017-01-01 00:00:00");
        }
        month=DateTimeUtil.getMonthSpace(facTime,currTime);
        BigDecimal  f1  = new BigDecimal(currentObd).divide(new BigDecimal(month),2, BigDecimal.ROUND_UP);
        return  f1;
    }

    //
    public   BigDecimal   getAvgDriveTimePerDay(int currentObd){
        BigDecimal ff=null;
        if(currentObd<1000){
            ff  =random(new BigDecimal(avgDriveTimePerDay[0])  ,new BigDecimal(avgDriveTimePerDay[1]));
        }else if(currentObd>=1000&&currentObd<5000){
            ff  =random(new BigDecimal(avgDriveTimePerDay[2])  ,new BigDecimal(avgDriveTimePerDay[3]));
        }else if(currentObd>=5000&&currentObd<20000){
            ff  =random(new BigDecimal(avgDriveTimePerDay[4])  ,new BigDecimal(avgDriveTimePerDay[5]));
        }else if(currentObd>=20000&&currentObd<29000){
            ff  =random(new BigDecimal(avgDriveTimePerDay[6])  ,new BigDecimal(avgDriveTimePerDay[7]));
        }else if(currentObd>=29000){
            ff  =random(new BigDecimal(avgDriveTimePerDay[8])  ,new BigDecimal(avgDriveTimePerDay[9]));
        }
        BigDecimal   f1   =   ff.setScale(2,   BigDecimal.ROUND_HALF_UP);
        return f1 ;
    }


    ////纯电行驶里程
    public   BigDecimal getElectricRange(){
        BigDecimal start=new BigDecimal(120);
        BigDecimal end=new BigDecimal(190);
        //
        BigDecimal   ff=  random(start,end);
        BigDecimal   f1   =   ff.setScale(2,   BigDecimal.ROUND_HALF_UP);
        return f1 ;
    }

    public   BigDecimal   getPowerConsumePerHundred(BigDecimal electricRange){
        float ff= (float) (24.5/electricRange.floatValue())*100;
        BigDecimal   b   =   new   BigDecimal(ff);
        BigDecimal   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP);
        return f1 ;
    }

    //累计充电量
    public   BigDecimal  getCumulativeCharge(int currentObd,BigDecimal powerConsumePerHundred){
        float ff=(currentObd/(float)100.00)*powerConsumePerHundred.floatValue();
        BigDecimal   b   =   new   BigDecimal(ff);
        BigDecimal   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP);
        return f1 ;
    }

    //车辆一次充满电所用最少时间
    public   BigDecimal getMinChargeTime(){
        BigDecimal start=new BigDecimal(10);
        BigDecimal end=new BigDecimal(13);
        //
        BigDecimal   ff=  random(start,end);
        BigDecimal   f1   =   ff.setScale(2,   BigDecimal.ROUND_HALF_UP);
        return f1 ;
    }
    //最大充电功率
    public   BigDecimal getMaxChargePower(){
        BigDecimal start=new BigDecimal(0.88);
        BigDecimal end=new BigDecimal(0.92);
        //
        BigDecimal   ff= new   BigDecimal(3).multiply(random(start,end));
        BigDecimal   f1   =   ff.setScale(2,   BigDecimal.ROUND_HALF_UP);
        return f1 ;
    }

    //随机数据产生
    private static BigDecimal random( BigDecimal lower ,BigDecimal upper) {
        Random ra =new Random();
        BigDecimal result = (new BigDecimal(ra.nextFloat()).multiply(upper.subtract(lower))).add(lower);
        return result ;
    }
    /**********************************************************************************************************/

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAvgDriveTimePerDay() {
        return avgDriveTimePerDay;
    }

    public void setAvgDriveTimePerDay(String[] avgDriveTimePerDay) {
        this.avgDriveTimePerDay = avgDriveTimePerDay;
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public void setUpdateInterval(int updateInterval) {
        this.updateInterval = updateInterval;
    }

}
