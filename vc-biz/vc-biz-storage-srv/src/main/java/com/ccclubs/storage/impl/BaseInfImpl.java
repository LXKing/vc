package com.ccclubs.storage.impl;


import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.storage.inf.BaseHistoryInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/3/13
 * \* Time: 14:23
 * \* Description:phoenix 代码复用模块，集成了大量冗余代码的通用版本。
 * \
 */
@Service
public class BaseInfImpl {

    private static Logger logger = LoggerFactory.getLogger(BaseInfImpl.class);

    @Autowired
    private PhoenixTool phoenixTool;

    public <T> void saveOrUpdate(final List<T> records, BaseHistoryInf<T> baseHistoryInf, String insertSql, String tableName) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = phoenixTool.getConnection();
            preparedStatement = connection.prepareStatement(insertSql);
            Long count = 0L;
            for (T historyDate : records) {
                count++;
                baseHistoryInf.insertBulid(historyDate, preparedStatement);
                if (count % 500 == 0) {

                    preparedStatement.executeBatch();
                    connection.commit();

                }
            }
            if (!(count%500==0)){
                preparedStatement.executeBatch();
                connection.commit();
            }

        } catch (SQLException e) {
            logger.info("{} phoenix throw a error :{}",tableName,e.getMessage());
            logger.info("{} 异常数据：{} ",tableName,records.toString());
            e.printStackTrace();
        } finally {
            phoenixTool.closeResource(connection, preparedStatement, null, tableName + " saveOrUpdate ");
        }
    }
}
