package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.CarHistoryDeleteInf;
import com.ccclubs.phoenix.input.HistoryDeleteParam;
import com.ccclubs.phoenix.orm.consts.PhoenixFieldsConsts;
import com.ccclubs.phoenix.output.HistoryNoQueryOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
            PhoenixConst.PHOENIX_CAR_CAN_HISTORY+" " +
            "WHERE CS_NUMBER=? " +
            "AND CURRENT_TIME=? ";
    private static final String DELETE_GB_SQL="DELETE FROM " +
            PhoenixConst.PHOENIX_CAR_GB_HISTORY+" " +
            "WHERE CS_VIN=? " +
            "AND ADD_TIME=? ";
    private static final String DELETE_STATE_SQL="DELETE FROM " +
            PhoenixConst.PHOENIX_CAR_STATE_HISTORY+" " +
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
    public HistoryNoQueryOutput deleteCarCanHistory(HistoryDeleteParam param) {
        return baseDeleteHistory(param,DELETE_CAN_SQL);
    }

    /**
     * 删除历史状态数据
     *
     * @param param
     */
    @Override
    public HistoryNoQueryOutput deleteCarStateHistory(HistoryDeleteParam param) {
        return baseDeleteHistory(param,DELETE_STATE_SQL);
    }

    /**
     * 批量删除历史状态数据
     *
     * @param paramList
     */
    @Override
    public HistoryNoQueryOutput deleteCarStateHistory(List<HistoryDeleteParam> paramList) {

        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        HistoryNoQueryOutput historyNoQueryOutput =new HistoryNoQueryOutput();

        try{
            Integer count=0;
            for (HistoryDeleteParam param:paramList
                 ) {
                count++;
                long timePointLong= DateTimeUtil.date2UnixFormat(param.getTimePoint(),DateTimeUtil.UNIX_FORMAT);
                preparedStatement = connection.prepareStatement(DELETE_STATE_SQL);
                preparedStatement.setString(1 , param.getDeleteKey());
                preparedStatement.setLong(2 , timePointLong);
                preparedStatement.addBatch();
                if (count%500==0){
                    preparedStatement.executeBatch();
                    connection.commit();
                }
            }
            preparedStatement.executeBatch();
            historyNoQueryOutput.setSuccessCount(preparedStatement.getUpdateCount());
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,null,DELETE_STATE_SQL);
        }
        return historyNoQueryOutput;
    }

    /**
     * 删除历史国标数据
     *
     * @param param
     */
    @Override
    public HistoryNoQueryOutput deleteCarGbHistory(HistoryDeleteParam param) {
        return baseDeleteHistory(param,DELETE_GB_SQL);
    }

    private HistoryNoQueryOutput baseDeleteHistory(HistoryDeleteParam param, String sql){
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        HistoryNoQueryOutput historyNoQueryOutput =new HistoryNoQueryOutput();

        try{
            long timePointLong= DateTimeUtil.date2UnixFormat(param.getTimePoint(),DateTimeUtil.UNIX_FORMAT);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , param.getDeleteKey());
            preparedStatement.setLong(2 , timePointLong);
            preparedStatement.execute();
            historyNoQueryOutput.setSuccessCount(preparedStatement.getUpdateCount());
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,null,sql);
        }
        return historyNoQueryOutput;
    }
}
