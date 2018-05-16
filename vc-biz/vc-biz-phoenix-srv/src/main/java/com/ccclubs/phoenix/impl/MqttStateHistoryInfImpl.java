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
    private BaseQueryImpl baseQuery;


    @Override
    public List<MqttStateDto> queryMqttStateDtoList(MqttStateParam param) {
        return baseQuery.queryDtoList(param,PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR,
                PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP,MqttStateDto.class);

    }

    @Override
    public Long queryListCount(MqttStateParam param) {

        return baseQuery.queryListCount(param,PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR,
                PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP);
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
