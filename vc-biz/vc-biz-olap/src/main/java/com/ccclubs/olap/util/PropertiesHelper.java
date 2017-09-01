package com.ccclubs.olap.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private static PropertiesHelper propertiesUtil = new PropertiesHelper();
    private String mongodbHost;
    private String mongodbPort;
    private String mongodbUser;
    private String mongodbPassword;
    private String mongodbDatabse;
    private String mysqlHost;
    private String mysqlPort;
    private String mysqlUser;
    private String mysqlPassword;
    private Integer batchStartNo;
    private Integer batchEndNo;

    private PropertiesHelper(){
        Properties prop = new Properties();
        try {
            prop.load(PropertiesHelper.class.getClassLoader().getResourceAsStream("bigdata.properties"));
            mongodbHost = prop.getProperty("mongodb.host");
            mongodbPort = prop.getProperty("mongodb.port");
            mongodbUser = prop.getProperty("mongodb.user");
            mongodbPassword = prop.getProperty("mongodb.password");
            mongodbDatabse = prop.getProperty("mongodb.database");
            mysqlHost = prop.getProperty("mysql.host");
            mysqlPort = prop.getProperty("mysql.port");
            mysqlUser = prop.getProperty("mysql.user");
            mysqlPassword = prop.getProperty("mysql.password");
            batchStartNo = Integer.parseInt(prop.getProperty("batchStartNo"));
            batchEndNo = Integer.parseInt(prop.getProperty("batchEndNo"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getBatchStartNo() {
        return batchStartNo;
    }

    public Integer getBatchEndNo() {
        return batchEndNo;
    }

    public String getMongodbHost() {
        return mongodbHost;
    }

    public String getMongodbPort() {
        return mongodbPort;
    }

    public String getMongodbUser() {
        return mongodbUser;
    }

    public String getMongodbPassword() {
        return mongodbPassword;
    }

    public String getMysqlHost() {
        return mysqlHost;
    }

    public String getMysqlPort() {
        return mysqlPort;
    }

    public String getMysqlUser() {
        return mysqlUser;
    }

    public String getMysqlPassword() {
        return mysqlPassword;
    }

    public String getMongodbDatabse() {
        return mongodbDatabse;
    }

    public static PropertiesHelper getInstance(){
        return propertiesUtil;
    }


    public static void main(String[] args) {
        PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
        System.out.println();

    }
}
