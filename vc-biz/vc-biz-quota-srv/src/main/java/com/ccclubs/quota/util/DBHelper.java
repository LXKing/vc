package com.ccclubs.quota.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

/**
 * Created by Administrator on 2017/5/31 0031.
 */

@ConfigurationProperties(prefix = "databasetemp")
public class DBHelper {
    public  String driver;
    public  String url;
    public  String  username;
    public static String password;
    //
    public  Connection conn = null;
    public PreparedStatement pst = null;
    public Statement st = null;
    //
//    public  String driver="com.mysql.jdbc.Driver";
//    public  String url="jdbc:mysql://127.0.0.1:3306/ccclubs_cg_platform?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=PRC&useSSL=false";
//    public  String  user="root";
//    public  String password="123456";


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

//    public void deleteRecords(String sql) throws Exception {
//        pst = conn.prepareStatement(sql);
//        pst.executeUpdate();
//        conn.commit();
//    }
//
//    public void insertRecords(List<String> sql_list)throws SQLException{
//        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        for(String sql:sql_list){
//            st.addBatch(sql);
//        }
//        st.executeBatch();
//        conn.commit();
//    }


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
        System.out.println(username);
        return username;
    }

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBHelper.password = password;
    }

}
