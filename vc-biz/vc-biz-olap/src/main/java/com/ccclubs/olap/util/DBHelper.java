package com.ccclubs.olap.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;


/**
 * Created by Administrator on 2017/5/31 0031.
 */
public class DBHelper {
    public static String url="jdbc:mysql://%s:%s/ccclubs_data_center";
    public static String driver="com.mysql.jdbc.Driver";
    public static String  user;
    public static String password;
    private static Logger logger = Logger.getLogger(DBHelper.class);

    public Connection conn = null;
    public PreparedStatement pst = null;
    public Statement st = null;

    public DBHelper(){
        try{
            Class.forName(driver);
            //得到数据库连接的相关信息
            PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
            String mysqlHost = propertiesHelper.getMysqlHost();
            String mysqlPort = propertiesHelper.getMysqlPort();
            user = propertiesHelper.getMysqlUser();
            password = propertiesHelper.getMysqlPassword();

            url=String.format(url,mysqlHost,mysqlPort);

            conn = DriverManager.getConnection(url,user,password);
            //关闭自动提交
            conn.setAutoCommit(false);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
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

        return jsonArray;
    }

    public void deleteRecords(String sql) throws Exception {
        pst = conn.prepareStatement(sql);
        pst.executeUpdate();
        conn.commit();
    }

    public void insertRecords(List<String> sql_list)throws SQLException{
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        for(String sql:sql_list){
            st.addBatch(sql);
        }
        st.executeBatch();
        conn.commit();
    }



    public static void main(String[] args) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        JSONArray jsonArray = dbHelper.queryRecords(" select table_name,array_carno_str from table_carno_rel order by table_name ");
        System.out.println();
    }
}
