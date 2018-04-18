package com.ccclubs.hbase.phoenix.config;

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
    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            connection = DriverManager.getConnection("jdbc:phoenix:" + phoenixProperties.getZk_url());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }

        return connection;
    }

    /**
     * 关闭各类资源
     */
    public void closeResource(Connection connection,
                              PreparedStatement preparedStatement,
                              ResultSet resultSet,
                              String callerName) {
        boolean preparedStatementFlag = false;
        boolean resultSetFlag = false;
        boolean connectionFlag = false;
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatementFlag = true;
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }

        if (null != resultSet) {
            try {
                resultSet.close();
                resultSetFlag = true;
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else {
            resultSetFlag = true;
        }

        if (connection != null) {
            try {
                connection.close();
                connectionFlag = true;
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }


        if (connectionFlag && preparedStatementFlag && resultSetFlag) {
            logger.debug(callerName + "  resource closed.");
        } else {
            if (!connectionFlag) {
                logger.error(callerName + " connection release failed");
            }
            if (!preparedStatementFlag) {
                logger.error(callerName + " preparedStatement release failed");
            }
            if (!resultSetFlag) {
                logger.error(callerName + " resultSet release failed");
            }
        }

    }
}
