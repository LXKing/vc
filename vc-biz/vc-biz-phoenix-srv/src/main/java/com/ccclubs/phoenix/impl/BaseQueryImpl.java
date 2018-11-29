package com.ccclubs.phoenix.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.input.BaseParamInf;
import com.ccclubs.phoenix.input.CanStateParam;
import com.ccclubs.phoenix.orm.dto.CanStateDto;
import com.ccclubs.phoenix.util.BaseTransformTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 17:51
 * @Description: 请填写描述！
 */

@Service
public class BaseQueryImpl {
    static final Logger logger = LoggerFactory.getLogger(BaseQueryImpl.class);

    @Autowired
    private PhoenixTool phoenixTool;

    public Long queryListCount(BaseParamInf param,
                               String norTableName,
                               String expTableName) {
        SqlAssembly sqlAssembly = new SqlAssembly(param,
                norTableName,
                expTableName);

        String pointKeyValue = sqlAssembly.getPointValue();
        String countSql = sqlAssembly.getCountSql();
        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);
        long total = 0L;
        PreparedStatement pst = null;
        Connection connection = phoenixTool.getConnection();
        ResultSet resultSet = null;
        try {
            pst = connection.prepareStatement(countSql);
            pst.setString(1, pointKeyValue);
            pst.setLong(2, startTime);
            pst.setLong(3, endTime);
            resultSet = pst.executeQuery();
            JSONArray jsonArray = BaseTransformTool.queryRecords(resultSet);
            if (jsonArray != null && jsonArray.size() > 0) {
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                total = jsonObject.getLong("TOTAL");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            phoenixTool.closeResource(connection,
                    pst, resultSet, "queryListCount" + countSql);
        }
        return total;
    }


    public <T> List<T> queryDtoList(BaseParamInf param,
                                    String norTableName,
                                    String expTableName, Class<T> clazz) {
        SqlAssembly sqlAssembly = new SqlAssembly(param,
                norTableName,
                expTableName);

        String pointKeyValue = sqlAssembly.getPointValue();

        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);

        String querySql = sqlAssembly.getQuerySql();

        List<T> dtoList = new ArrayList<>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, pointKeyValue);
            preparedStatement.setLong(2, startTime);
            preparedStatement.setLong(3, endTime);
            if (sqlAssembly.isPageQuery()) {
                Integer limit = param.getPageSize();
                Integer offset = (param.getPageNum() - 1) * limit;
                preparedStatement.setInt(4, limit);
                preparedStatement.setInt(5, offset);
            }
            resultSet = preparedStatement.executeQuery();
            dtoList = BaseTransformTool.resultSetToObjectList(resultSet, clazz);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            phoenixTool.closeResource(connection,
                    preparedStatement, resultSet, "queryList" + querySql);
        }
        return dtoList;
    }

    public CanStateDto queryCanStateDto(CanStateParam param) {
        String te_number = param.getTeNumber();
        long current_time = param.getCanTime();
        CanStateDto carState = null;

        final String queryFields = param.getQueryFields();
        String querySql = "select " +
                queryFields + " " +
                "from " + PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR + " " +
                "where te_number=? " +
                "and current_time=? ";

        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, te_number);
            preparedStatement.setLong(2, current_time);
            resultSet = preparedStatement.executeQuery();
            List<CanStateDto> dtoList = BaseTransformTool.resultSetToObjectList(resultSet, CanStateDto.class);
            carState = dtoList.get(0);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            phoenixTool.closeResource(connection,
                    preparedStatement, resultSet, "carState queryCarState NoData");
        }
        return carState;
    }


}

