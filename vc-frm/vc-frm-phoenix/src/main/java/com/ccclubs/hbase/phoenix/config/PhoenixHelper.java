package com.ccclubs.hbase.phoenix.config;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2018/1/4 0004
 */
public class PhoenixHelper {
    private DruidDataSource phoenixDataSource;

    public PhoenixHelper(DruidDataSource phoenixDataSource){
        this.phoenixDataSource=phoenixDataSource;
    }


    public synchronized Connection getConnection(){
        Connection connection = null;
        try {
            connection = phoenixDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int getConnectionCount(){
        int count=0;
        if(phoenixDataSource!=null){
            count=phoenixDataSource.getPoolingCount();
        }
        return count;
    }

    public void start(){
        try {
            phoenixDataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        phoenixDataSource.close();
    }
}
