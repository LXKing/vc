package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.MqttStateHistoryInf;
import com.ccclubs.phoenix.input.MqttStateParam;
import com.ccclubs.phoenix.orm.dto.MqttStateDto;
import com.ccclubs.phoenix.output.MqttStateHistoryOutput;
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
 * @Date: 2018/5/14
 * @Time: 15:15
 * @Description: 分时租赁状态历史数据查询接口实现！
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class MqttStateHistoryInfImpl implements MqttStateHistoryInf {

    static  final Logger logger= LoggerFactory.getLogger(MqttStateHistoryInfImpl.class);

    @Autowired
    private PhoenixTool phoenixTool;


    @Override
    public List<MqttStateDto> queryMqttStateDtoList(MqttStateParam param) {
        String queryFields = param.getQueryFields();
        String tableName=null;
        String pointKeyName=null;
        String pointKeyValue=null;
        //区分查询何张表
        if (param.getVin()!=null&&param.getTeNumber()==null){
            tableName=PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR;
            pointKeyName="VIN";
            pointKeyValue= param.getVin();
        }else if (param.getVin()==null&&param.getTeNumber()!=null){
            tableName=PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP;
            pointKeyName="TE_NUMBER";
            pointKeyValue=param.getTeNumber();
        }

        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);
        String pageSql="";
        if (param.getPageNum()>0){
            pageSql="limit ? offset ? ";
        }

        String  QUERY_SQL = "select " +
                queryFields + " from " +tableName+" where " +pointKeyName+
                "=? and current_time>=? and current_time<=? order by current_time  "
                + param.getOrder() + " "+pageSql;

        List<MqttStateDto> mqttStateDtoList = new ArrayList<MqttStateDto>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {

            preparedStatement = connection.prepareStatement(QUERY_SQL);
            preparedStatement.setString(1, pointKeyValue);
            preparedStatement.setLong(2, startTime);
            preparedStatement.setLong(3, endTime);
            if (!pageSql.equals("")){
                Integer limit = param.getPageSize();
                Integer offset = (param.getPageNum() - 1) * limit;
                preparedStatement.setInt(4, limit);
                preparedStatement.setInt(5, offset);
            }
            resultSet = preparedStatement.executeQuery();
            //JSONArray jsonArray = BaseQueryInfImpl.resultSetToJSONArray(resultSet);
            mqttStateDtoList=BaseQueryInfImpl.resultSetToObjectList(resultSet,MqttStateDto.class);
            //BaseQueryInfImpl.parseJosnArrayToObjects(jsonArray,queryFields,mqttStateDtoList,MqttStateDto.class);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,resultSet,"queryMqttStateDtoList");
        }
        return mqttStateDtoList;
    }

    @Override
    public Long queryListCount(MqttStateParam param) {

        String tableName=null;
        String pointKeyName=null;
        String pointKeyValue=null;
        //区分查询何张表
        if (param.getVin()!=null&&param.getTeNumber()==null){
            tableName=PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR;
            pointKeyName="VIN";
            pointKeyValue= param.getVin();
        }else if (param.getVin()==null&&param.getTeNumber()!=null){
            tableName=PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP;
            pointKeyName="TE_NUMBER";
            pointKeyValue=param.getTeNumber();
        }
        String COUNT_SQL = "select count(current_time) as total from "
                +tableName+" where " +pointKeyName+
                "=? and current_time>=? and current_time<=? ";
        long total = 0L;
        PreparedStatement pst = null;
        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);
        Connection connection= phoenixTool.getConnection();
        ResultSet resultSet =null;
        try {
            pst = connection.prepareStatement(COUNT_SQL);
            pst.setString(1, pointKeyValue);
            pst.setLong(2, startTime);
            pst.setLong(3, endTime);
            resultSet = pst.executeQuery();
            JSONArray jsonArray = BaseQueryInfImpl.queryRecords(resultSet);
            if(jsonArray!=null&&jsonArray.size()>0){
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                total=jsonObject.getLong("TOTAL");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    pst,resultSet,"queryListCount");
        }
        return total;
    }

    @Override
    public MqttStateHistoryOutput queryListByParam(MqttStateParam param) {
        MqttStateHistoryOutput mqttStateHistoryOutput= new MqttStateHistoryOutput();
        List<MqttStateDto> mqttStateDtoList=queryMqttStateDtoList(param);
        Long count=queryListCount(param);
        mqttStateHistoryOutput.setList(mqttStateDtoList);
        mqttStateHistoryOutput.setTotal(count);

        return mqttStateHistoryOutput;
    }

}
