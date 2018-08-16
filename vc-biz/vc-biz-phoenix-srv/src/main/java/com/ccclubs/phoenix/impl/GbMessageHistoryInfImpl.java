package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.GbMessageHistoryInf;
import com.ccclubs.phoenix.input.GbMessageParam;
import com.ccclubs.phoenix.orm.dto.GbMessageDto;
import com.ccclubs.phoenix.output.GbMessageHistoryOutput;
import com.ccclubs.phoenix.util.BaseTransformTool;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
 * @Time: 16:59
 * @Description: 请填写描述！
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class GbMessageHistoryInfImpl implements GbMessageHistoryInf {

    static  final Logger logger= LoggerFactory.getLogger(GbMessageHistoryInfImpl.class);

    @Autowired
    private BaseQueryImpl baseQuery;

    @Autowired
    private PhoenixTool phoenixTool;

    @Override
    public List<GbMessageDto> queryGbMessageDtoList(GbMessageParam param) {
        /*return baseQuery.queryDtoList(param,
                PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY,
                null,
                GbMessageDto.class);*/
        String tableName = PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY;

        String pageSql = "";
        if (param.getPageNum() > 0) {
            pageSql = "limit ? offset ? ";
        }

        String querySql = "select " +
                param.getQueryFields() + " from " + tableName + " where VIN=? and add_time>=? and add_time<=? order by add_time  "
                + param.getOrder() + " " + pageSql;

        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);

        return dbOpration(param, startTime, endTime, pageSql, querySql);

    }

    @Override
    public Long queryListCount(GbMessageParam param) {
       /* return baseQuery.queryListCount(param,
                PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY,
                null);*/
        String countSql = "select count(add_time) as total from "
                + PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY +
                " where VIN=? and add_time>=? and add_time<=? ";
        long total = 0L;
        PreparedStatement pst = null;
        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);
        Connection connection= phoenixTool.getConnection();
        ResultSet resultSet =null;
        try {
            pst = connection.prepareStatement(countSql);
            pst.setString(1, param.getVin());
            pst.setLong(2, startTime);
            pst.setLong(3, endTime);
            resultSet = pst.executeQuery();
            JSONArray jsonArray = BaseTransformTool.queryRecords(resultSet);
            if(jsonArray!=null&&jsonArray.size()>0){
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                total=jsonObject.getLong("TOTAL");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    pst,resultSet,"queryGbMessageListCount");
        }
        return total;
    }

    @Override
    public GbMessageHistoryOutput queryListByParam(GbMessageParam param) {
        GbMessageHistoryOutput gbMessageHistoryOutput=new GbMessageHistoryOutput();
        gbMessageHistoryOutput.setList(queryGbMessageDtoList(param));
        gbMessageHistoryOutput.setTotal(queryListCount(param));
        return gbMessageHistoryOutput;
    }

    @Override
    public List<GbMessageDto> queryGbMessageDtoList(GbMessageParam param, Boolean isBanded) {

        /*return baseQuery.queryDtoList(param,
                PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY,
                null,
                GbMessageDto.class);*/
        String tableName = PhoenixConst.PHOENIX_CAR_TBOX_LOG_NOR;
        if(!isBanded) {
            tableName = PhoenixConst.PHOENIX_CAR_TBOX_LOG_EXP;
        }

        String pageSql = "";
        if (param.getPageNum() > 0) {
            pageSql = "limit ? offset ? ";
        }

        String querySql = "select " +
                param.getQueryFields() + " from " + tableName + " where VIN=? and add_time>=? and add_time<=? order by add_time  "
                + param.getOrder() + " " + pageSql;

        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);

        return dbOpration(param, startTime, endTime, pageSql, querySql);

    }

    private List<GbMessageDto> dbOpration(GbMessageParam param,
            Long startTime, Long endTime, String pageSql, String querySql) {

        List<GbMessageDto> gbMessageDtoList = new ArrayList<GbMessageDto>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {

            preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, param.getVin());
            preparedStatement.setLong(2, startTime);
            preparedStatement.setLong(3, endTime);
            if (!StringUtils.isEmpty(pageSql)){
                Integer limit = param.getPageSize();
                Integer offset = (param.getPageNum() - 1) * limit;
                preparedStatement.setInt(4, limit);
                preparedStatement.setInt(5, offset);
            }
            resultSet = preparedStatement.executeQuery();
            gbMessageDtoList= BaseTransformTool.resultSetToObjectList(
                    resultSet,GbMessageDto.class);

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,resultSet,"queryGbMessageDtoList");
        }

        return gbMessageDtoList;
    }
}
