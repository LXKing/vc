package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.CarHistoryDeleteInf;
import com.ccclubs.phoenix.input.HistoryDeleteParam;
import com.ccclubs.phoenix.orm.consts.PhoenixConsts;
import com.ccclubs.phoenix.output.HistoryDeleteOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/3
 * @Time: 11:09
 * @Description: 历史数据删除实现！
 */

@org.springframework.stereotype.Service
@Service(version="1.0.0")
public class CarHistoryDeleteInfImpl implements CarHistoryDeleteInf {

    static  final Logger logger= LoggerFactory.getLogger(CarHistoryDeleteInfImpl.class);

    private static final String DELETE_CAN_SQL="DELETE FROM " +
            PhoenixConsts.PHOENIX_CAR_CAN_HISTORY+" " +
            "WHERE CS_NUMBER=? " +
            "AND CURRENT_TIME=? ";
    private static final String DELETE_GB_SQL="DELETE FROM " +
            PhoenixConsts.PHOENIX_CAR_GB_HISTORY+" " +
            "WHERE CS_VIN=? " +
            "AND ADD_TIME=? ";
    private static final String DELETE_STATE_SQL="DELETE FROM " +
            PhoenixConsts.PHOENIX_CAR_STATE_HISTORY+" " +
            "WHERE CS_NUMBER=? " +
            "AND CURRENT_TIME=? ";

    @Autowired
    private PhoenixTool phoenixTool;

    /**
     * 删除历史can数据
     *
     * @param param
     */
    @Override
    public HistoryDeleteOutput deleteCarCanHistory(HistoryDeleteParam param) {
        return baseDeleteHistory(param,DELETE_CAN_SQL);
    }

    /**
     * 删除历史状态数据
     *
     * @param param
     */
    @Override
    public HistoryDeleteOutput deleteCarStateHistory(HistoryDeleteParam param) {
        return baseDeleteHistory(param,DELETE_STATE_SQL);
    }

    /**
     * 删除历史国标数据
     *
     * @param param
     */
    @Override
    public HistoryDeleteOutput deleteCarGbHistory(HistoryDeleteParam param) {
        return baseDeleteHistory(param,DELETE_GB_SQL);
    }

    private HistoryDeleteOutput baseDeleteHistory(HistoryDeleteParam param,String sql){
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        HistoryDeleteOutput historyDeleteOutput=new HistoryDeleteOutput();
        ResultSet resultSet=null;
        try{
            long timePointLong= DateTimeUtil.date2UnixFormat(param.getTimePoint(),DateTimeUtil.UNIX_FORMAT);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , param.getDeleteKey());
            preparedStatement.setLong(2 , timePointLong);
            preparedStatement.execute();
            historyDeleteOutput.setSuccessCount(preparedStatement.getUpdateCount());
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,resultSet,sql);
        }
        return historyDeleteOutput;
    }
}
