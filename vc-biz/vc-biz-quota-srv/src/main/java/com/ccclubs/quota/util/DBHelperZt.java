package com.ccclubs.quota.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.quota.orm.model.CsIndexReport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
@Component
public class DBHelperZt {

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
    public  Connection conn = null;
    public PreparedStatement pst = null;
    public Statement st = null;
    //
//    public  String driver="com.mysql.jdbc.Driver";
////    public  String url="jdbc:mysql://rm-bp1ly42351i7096mj.mysql.rds.aliyuncs.com:3306/ccclubs_data_center?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=PRC&useSSL=false";
////    public  String  username="quota_user";
////    public  String password="jjN(HRXeh$HklmXkQW!IzAs";
//
//    public  String url="jdbc:mysql://121.199.49.206:3306/ccclubs_data_center?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=PRC&useSSL=false";
//    public  String  username="zkj_user";
//    public  String password="kANXZYqf2UzghVY7DnjP";


    public void  getZtCurrentOBD(List<CsIndexReport> exlist){

        JSONArray jsonArray = new JSONArray();
        try {
            String sqlll = "SELECT css_number, css_obd_mile  from cs_state WHERE   ";
            //

            StringBuffer sb=new StringBuffer();
            for (CsIndexReport csIndexReport:exlist){
                sb.append("css_number=").append("\""+csIndexReport.getCsNumber()+"\"").append("  or  ");
            }

            String str= sb.substring(0,sb.lastIndexOf("or"));
            String  sql = sqlll+str;
            //
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
           //
            while(rs.next()){
                JSONObject   obj = new JSONObject();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    obj.put(columnName,columnValue);
                }
                jsonArray.add(obj);
            }
            //
            for (CsIndexReport csIndexReport:exlist){
                String csNumber=csIndexReport.getCsNumber();
                for (Object object:jsonArray){
                    JSONObject jsonObject = (JSONObject)object;
                    String  csState_csNumber=((JSONObject) object).getString("css_number");
                    if(csNumber.equals(csState_csNumber)){
                        String css_obd_mile=((JSONObject) object).getString("css_obd_mile");
                        BigDecimal bd = new BigDecimal(css_obd_mile);
                        csIndexReport.setCumulativeMileage(bd);
                    }
                }
            }
            //
//            //当前里程与历史统计里程都统计出来
//            for (CsIndexReport csIndexReport:exlist){
//                String csNumber=csIndexReport.getCsNumber();
//
//                for (Object object:jsonArray){
//                    JSONObject jsonObject = (JSONObject)object;
//                    String  csState_csNumber=((JSONObject) object).getString("css_number");
//                    if(csNumber.equals(csState_csNumber)){
//                        String css_obd_mile=((JSONObject) object).getString("css_obd_mile");
//                        BigDecimal bd = new BigDecimal(css_obd_mile);
//                        csIndexReport.setCurrentCumulativeMileage(bd);
//                    }
//                }
//            }
            rs.close();
            pst.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

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
            if(st!=null){
                st.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取异常数据
     * @param vinList
     */
    public  List<CsIndexReport>  getZtExceptionData(List<String>vinList){

        try{
            //1——挑选剩余三千的条件
            String sqlll = "SELECT  cs_vin, cs_number, fac_time " +
                    "from ztConditionTemp WHERE  cs_vin IN ( ";
            //
            StringBuffer sb=new StringBuffer();
            for (String csVin:vinList){
                sb.append("'"+csVin+"'").append("  ,  ");
            }
            String str= sb.substring(0,sb.lastIndexOf(",")) +") and cs_number!=\"\"";
            String  sql = sqlll+str;
            System.out.println(sql);
            //
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // 统计出剩余的异常vin
           List<Map<String,Object>>sengYuList=new ArrayList<>();
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()){
                Map<String, Object>   map = new HashMap<>();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    map.put(columnName,columnValue);
                }
                sengYuList.add(map);
            }
            //2************************获取最新的obd里程********************************************
            String sqlobd = "SELECT css_number, css_obd_mile ,css_add_time from cs_state WHERE  css_number IN (";
            //
            StringBuffer sbobd=new StringBuffer();
            for (Map<String,Object> map:sengYuList){
                sbobd.append("\'"+map.get("cs_number").toString()+"'").append("  ,  ");
            }
            String strobd= sbobd.substring(0,sbobd.lastIndexOf(","))+")";
            String  sqlobdobd = sqlobd+strobd;
            //
            pst = conn.prepareStatement(sqlobdobd);
            rs = pst.executeQuery();
            // 统计出剩余的异常vin
            metaData = rs.getMetaData();
            List<Map<String,Object>>obdList=new ArrayList<>();
            while(rs.next()){
                Map<String, Object>   map = new HashMap<>();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    map.put(columnName,columnValue);
                }
                obdList.add(map);
            }
            return   getTongJi(sengYuList,obdList);
        }catch (Exception e){
                e.printStackTrace();
        }
        return null;
    }

    public   List<CsIndexReport> getTongJi(List<Map<String,Object>>sengYuList ,List<Map<String,Object>>obdList){

        List<CsIndexReport> list=new ArrayList<>();
        for(Map<String,Object> sengYuMap:sengYuList){
            String facTime=null;
            if(sengYuMap.get("fac_time")!=null){
                facTime=sengYuMap.get("fac_time").toString();
            }
            String csVinvin=sengYuMap.get("cs_vin").toString();
            String csNumber=sengYuMap.get("cs_number").toString();
            for (Map<String,Object> obdMap:obdList){
                  String   csNumberObd=obdMap.get("css_number").toString();
                if(csNumber.equals(csNumberObd)){
                    CsIndexReport csIndexReport=new CsIndexReport();
                    csIndexReport.setCsNumber(csNumber);
                    csIndexReport.setCsVin(csVinvin);
                    //1-计算月均行驶里程
                    int currentObd =Integer.parseInt(obdMap.get("css_obd_mile").toString());
                    if(currentObd!=0){

                        String currTime=obdMap.get("css_add_time").toString();
                       //
                        //月均行驶里程
                        BigDecimal monthlyAvgMile= getObdByMonth(facTime,currTime,currentObd);
                        //纯电行驶里程
                        BigDecimal electricRange=getElectricRange();
                        // 百公里耗电量
                        BigDecimal powerConsumePerHundred=getPowerConsumePerHundred(electricRange);
                        //累计充电量
                        BigDecimal cumulativeCharge=getCumulativeCharge(currentObd,powerConsumePerHundred);
                        //车辆一次充满电所用最少时间
                        BigDecimal   minChargeTime=getMinChargeTime();
                        //最大充电功率
                        BigDecimal  maxChargePower =getMaxChargePower();
                        //平均单日运行时间
                        BigDecimal avgDriveTimePerDay=getAvgDriveTimePerDay(currentObd);
                        //
                        //----//
                        csIndexReport.setMonthlyAvgMile(monthlyAvgMile);
                        csIndexReport.setElectricRange(electricRange);
                        csIndexReport.setPowerConsumePerHundred(powerConsumePerHundred);
                        csIndexReport.setCumulativeCharge(cumulativeCharge);
                        csIndexReport.setMinChargeTime(minChargeTime);
                        csIndexReport.setMaxChargePower(maxChargePower);
                        csIndexReport.setAvgDriveTimePerDay(avgDriveTimePerDay);
                        csIndexReport.setCumulativeMileage(new BigDecimal(currentObd));
                    }
                    list.add(csIndexReport);
                    break;
                }
            }
        }
        return  list;
    }

    //**************************各项指标计算公式***********************************
    public static  BigDecimal getObdByMonth(String facTime,String currTime,int currentObd){
        int month=1;
        if(facTime==null){
            facTime="2017-01-01 00:00:00";
        }
        month=DateTimeUtil.getMonthSpace(facTime,currTime);
       float ff=  currentObd/(float)month;
        BigDecimal   b   =   new   BigDecimal(ff);
        BigDecimal   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP);
        if(  f1.compareTo(new BigDecimal(0))==0){
                System.out.println("======");
        }
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
        float   ff= 3/random(start,end).floatValue();
        BigDecimal   b   =   new   BigDecimal(ff);
        BigDecimal   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP);
        return f1 ;
    }


    public   BigDecimal   getAvgDriveTimePerDay(int currentObd){
        BigDecimal ff=new BigDecimal(0);
//        if(currentObd<1000){
//            ff  =random(1,configZt.getAvgDriveTimePerDay()[0]  ,configZt.getAvgDriveTimePerDay()[1]);
//        }else if(currentObd>=1000&&currentObd<5000){
//            ff  =random(1,1.3f,2.5f).get(0);
//        }else if(currentObd>=5000&&currentObd<20000){
//            ff  =random(1,2.3f,3.5f).get(0);
//        }else if(currentObd>=20000&&currentObd<29000){
//            ff  =random(1,3.3f,6f).get(0);
//        }else if(currentObd>=29000){
//            ff  =random(1,5.3f,12f).get(0);
//        }

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



    //随机数据产生
    private static BigDecimal random( BigDecimal lower ,BigDecimal upper) {
        //ra.nextFloat*(upper-lower)+lower
        Random ra =new Random();
        BigDecimal result = (new BigDecimal(ra.nextFloat()).multiply(upper.subtract(lower))).add(lower);
         return result ;
    }



    //统计最新的众泰--国标指标数据************************以下修改********************************************
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
               String facTime="2017-01-01 00:00:00";
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
                           String currTime = temp.get("css_add_time").toString();
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
                           csIndexReport.setModifyDate(DateTimeUtil.dateToString(new Date(System.currentTimeMillis())));
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
                           csIndexReport.setModifyDate(DateTimeUtil.dateToString(new Date(System.currentTimeMillis())));
                       }
                       break;
                   }
               }
           }

       }catch (Exception e){
           e.printStackTrace();
       }
   }

   public void deleteData(){
       try {
           String delete_sql = " DELETE FROM cs_index_report";
           pst = conn.prepareStatement(delete_sql);
           pst.executeUpdate();
           conn.commit();
       }catch (Exception e){
           e.printStackTrace();
       }
   }


   public void insertCurrentData(List<CsIndexReport> exVinList){
        try{
           //生成插入语句
           List<String> sql_list = new ArrayList<>();
           for(CsIndexReport csIndexReport:exVinList){
               String insetSql = "INSERT INTO  cs_index_report" +
                       "(cs_vin,cs_number,monthly_avg_mile,avg_drive_time_per_day,power_consume_per_hundred,electric_range,max_charge_power,min_charge_time,cumulative_mileage,cumulative_charge,modifyDate,fac_time) "+
                       "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
               insetSql=String.format(insetSql,
                    csIndexReport.getCsVin(),
                    csIndexReport.getCsNumber(),
                    csIndexReport.getMonthlyAvgMile(),
                    csIndexReport.getAvgDriveTimePerDay(),
                    csIndexReport.getPowerConsumePerHundred(),
                    csIndexReport.getElectricRange(),
                    csIndexReport.getMaxChargePower(),
                    csIndexReport.getMinChargeTime(),
                    csIndexReport.getCumulativeMileage(),
                    csIndexReport.getCumulativeCharge(),
                    //
                    csIndexReport.getModifyDate(),
                    csIndexReport.getFacTime()
               );
               sql_list.add(insetSql);
           }
            //
           st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           for(String sql:sql_list){
               st.addBatch(sql);
           }
           st.executeBatch();
           conn.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
   }


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

    ///
    public static  void  main(String[] orgs){
//        Random ra =new Random();
//
//       for (int i=0;i<10;i++){
////           System.out.println(getAvgDriveTimePerDay(901)));
//           System.out.println(   ra.nextGaussian());
//
//       }
        BigDecimal bigDecimal=new BigDecimal(33);
        BigDecimal dfd= bigDecimal.divide(new BigDecimal(2),2, RoundingMode.UP);
        System.out.println("==="+dfd);

    }




}
