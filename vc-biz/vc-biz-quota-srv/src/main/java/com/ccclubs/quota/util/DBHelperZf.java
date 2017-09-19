package com.ccclubs.quota.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.olap.orm.model.CsCar;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31 0031.
 */


public class DBHelperZf {
//    public  String driver;
//    public  String url;
//    public  String  username;
//    public static String password;
    //
    public  Connection conn = null;
    public PreparedStatement pst = null;
    public Statement st = null;
    //
    public static String driver="com.mysql.jdbc.Driver";
    public static String url="jdbc:mysql://127.0.0.1:3306/ccclubs_cg_platform?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=PRC&useSSL=false";
    public static String  username="root";
    public static String password;


    /**
     * 获取所有车辆的信息
     */
    public List<CsCar>  getCsCarALL(){
        List<CsCar> csCarsList=new ArrayList<>();
        try{
            String sql="SELECT csc_number ,csc_car_no ,csc_model ,csc_code  from cs_car";
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();

            while(rs.next()){
                CsCar csCar=new CsCar();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String columnName = metaData.getColumnName(i);
                    if (columnName.equals("csc_number")){
                        csCar.setCscNumber(rs.getString(columnName));
                    }else if(columnName.equals("csc_car_no")){
                        csCar.setCscCarNo(rs.getString(columnName));
                    }else if(columnName.equals("csc_model")){
                        csCar.setCscModel(rs.getInt(columnName));
                    }else if(columnName.equals("csc_code")){
                        csCar.setCscCode(rs.getString(columnName));
                    }
                }
                csCarsList.add(csCar);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return csCarsList;
    }














    public JSONArray queryRecords(String sql,long limit,long offset) throws SQLException {

        JSONArray jsonArray = new JSONArray();
        String pagination_sql = String.format(sql+" limit %d,%d",limit,offset);
        pst = conn.prepareStatement(pagination_sql);
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        JSONObject obj = null;
        while(rs.next()){
            obj = new JSONObject();
            for(int i=1;i<=metaData.getColumnCount();i++){
                String columnName = metaData.getColumnName(i);
                Object columnValue = rs.getObject(columnName);
                obj.put(columnName,columnValue);
            }
            jsonArray.add(obj);
        }

        return jsonArray;
    }

    public  void getDBConnect(){
        try{
            Class.forName(driver);
            //得到数据库连接的相关信息
            conn = DriverManager.getConnection(getUrl(),getUsername(),getPassword());
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

    public JSONArray queryRecords(String sql) throws SQLException {

        JSONArray jsonArray = new JSONArray();
        pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        JSONObject obj = null;
        while(rs.next()){
            obj = new JSONObject();
            for(int i=1;i<=metaData.getColumnCount();i++){
                String columnName = metaData.getColumnName(i);
                Object columnValue = rs.getObject(columnName);
                obj.put(columnName,columnValue);
            }
            jsonArray.add(obj);
        }
        rs.close();
        pst.close();
        conn.close();
        return jsonArray;
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

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

}
