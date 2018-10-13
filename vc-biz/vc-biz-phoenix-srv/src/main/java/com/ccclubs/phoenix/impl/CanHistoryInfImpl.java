package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.phoenix.inf.CanHistoryInf;
import com.ccclubs.phoenix.input.CanParam;
import com.ccclubs.phoenix.input.CanStateParam;
import com.ccclubs.phoenix.orm.dto.CanDto;
import com.ccclubs.phoenix.orm.dto.CanStateDto;
import com.ccclubs.phoenix.output.CanHistoryOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
public class CanHistoryInfImpl implements CanHistoryInf {

    static final Logger logger = LoggerFactory.getLogger(CanHistoryInfImpl.class);

    @Autowired
    private BaseQueryImpl baseQuery;

    @Override
    public List<CanDto> queryCanDtoList(CanParam param) {
        return baseQuery.queryDtoList(param,
                PhoenixConst.PHOENIX_CAR_CAN_HISTORY_NOR,
                PhoenixConst.PHOENIX_CAR_CAN_HISTORY_EXP, CanDto.class);
    }


    @Override
    public Long queryListCount(CanParam param) {
        return baseQuery.queryListCount(param,
                PhoenixConst.PHOENIX_CAR_CAN_HISTORY_NOR,
                PhoenixConst.PHOENIX_CAR_CAN_HISTORY_EXP);
    }


    @Override
    public CanHistoryOutput queryListByParam(CanParam param) {
        CanHistoryOutput canHistoryOutput = new CanHistoryOutput();
        canHistoryOutput.setList(queryCanDtoList(param));
        canHistoryOutput.setTotal(queryListCount(param));
        return canHistoryOutput;
    }

    @Override
    public CanStateDto queryCanStateDto(CanStateParam param) {
        return baseQuery.queryCanStateDto(param);
    }
}
