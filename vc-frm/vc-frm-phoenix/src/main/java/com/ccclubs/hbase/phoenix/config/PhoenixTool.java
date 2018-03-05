package com.ccclubs.hbase.phoenix.config;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.sql.*;

/**
 * Module Desc:Phoenix工具类
 * User: taosm
 * DateTime: 2018/1/29 0029
 */
@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(PhoenixProperties.class)
@Service
public class PhoenixTool {
    private static Logger logger = LoggerFactory.getLogger(PhoenixTool.class);
    @Autowired
    private PhoenixProperties phoenixProperties;

    //获取Phoenix连接
    public Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            connection = DriverManager.getConnection("jdbc:phoenix:"+phoenixProperties.getZk_url());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //查询记录
    public JSONArray queryRecords(ResultSet rs){
        JSONArray jsonArray = new JSONArray();
        try{
            JSONObject obj = null;
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()){
                obj = new JSONObject();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    obj.put(columnName,columnValue);
                }
                jsonArray.add(obj);
            }
        }
        catch (SQLException exception){
            logger.error(exception.getMessage());
        }
        finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return jsonArray;
    }
}
