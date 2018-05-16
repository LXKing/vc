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
import com.ccclubs.phoenix.util.BaseTransformTool;
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
    @Autowired
    private BaseQueryImpl baseQuery;


    @Override
    public List<MqttStateDto> queryMqttStateDtoList(MqttStateParam param) {
        return baseQuery.queryDtoList(param,PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR,
                PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP,MqttStateDto.class);
        /*SqlAssembly sqlAssembly=new SqlAssembly(param,
                PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR,
                PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP);

        String pointKeyValue=sqlAssembly.getPointValue();

        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);

        String  QUERY_SQL = sqlAssembly.getQuerySql();

        List<MqttStateDto> mqttStateDtoList = new ArrayList<MqttStateDto>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {

            preparedStatement = connection.prepareStatement(QUERY_SQL);
            preparedStatement.setString(1, pointKeyValue);
            preparedStatement.setLong(2, startTime);
            preparedStatement.setLong(3, endTime);
            if (sqlAssembly.isPageQuery()){
                Integer limit = param.getPageSize();
                Integer offset = (param.getPageNum() - 1) * limit;
                preparedStatement.setInt(4, limit);
                preparedStatement.setInt(5, offset);
            }
            resultSet = preparedStatement.executeQuery();
            mqttStateDtoList= BaseTransformTool.resultSetToObjectList(resultSet,MqttStateDto.class);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,resultSet,"queryMqttStateDtoList");
        }
        return mqttStateDtoList;*/
    }

    @Override
    public Long queryListCount(MqttStateParam param) {

        return baseQuery.queryListCount(param,PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR,
                PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP);

        /*SqlAssembly sqlAssembly=new SqlAssembly(param,
                PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR,
                PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP);

        String pointKeyValue=sqlAssembly.getPointValue();
        String COUNT_SQL = sqlAssembly.getCountSql();
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
                    pst,resultSet,"queryMqttStateListCount");
        }
        return total;*/
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
