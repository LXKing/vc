package com.ccclubs.quota.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.quota.orm.model.CsIndexReport;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31 0031.
 */

public class DBHelperZt {
//    public  String driver;
//    public  String url;
//    public  String  username;
//    public static String password;
    //
    public  Connection conn = null;
    public PreparedStatement pst = null;
    public Statement st = null;
    //
    public  String driver="com.mysql.jdbc.Driver";
    public  String url="jdbc:mysql://rm-bp1ly42351i7096mj.mysql.rds.aliyuncs.com:3306/ccclubs_data_center?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=PRC&useSSL=false";
    public  String  username="quota_user";
    public  String password="jjN(HRXeh$HklmXkQW!IzAs";

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
            //当前里程与历史统计里程都统计出来
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
                pst.close();
                st.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
