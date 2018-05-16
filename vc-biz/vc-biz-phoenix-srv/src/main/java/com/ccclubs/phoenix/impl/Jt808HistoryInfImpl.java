package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.Jt808PositionHistoryInf;
import com.ccclubs.phoenix.input.Jt808PositionParam;
import com.ccclubs.phoenix.orm.dto.Jt808Dto;
import com.ccclubs.phoenix.output.Jt808PositionHistoryOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 16:58
 * @Description: 请填写描述！
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class Jt808HistoryInfImpl implements Jt808PositionHistoryInf {
    static  final Logger logger= LoggerFactory.getLogger(Jt808HistoryInfImpl.class);

    @Autowired
    private BaseQueryImpl baseQuery;

    @Override
    public List<Jt808Dto> queryJt808DtoList(Jt808PositionParam param) {

        return baseQuery.queryDtoList(param,
                PhoenixConst.PHOENIX_CAR_808_POSITION_HISTORY,
                PhoenixConst.PHOENIX_CAR_808_POSITION_HISTORY_EXP,
                Jt808Dto.class);
    }

    @Override
    public Long queryListCount(Jt808PositionParam param) {
        return baseQuery.queryListCount(param,
                PhoenixConst.PHOENIX_CAR_808_POSITION_HISTORY,
                PhoenixConst.PHOENIX_CAR_808_POSITION_HISTORY_EXP);
    }

    @Override
    public Jt808PositionHistoryOutput queryListByParam(Jt808PositionParam param) {
        Jt808PositionHistoryOutput jt808PositionHistoryOutput=new Jt808PositionHistoryOutput();
        jt808PositionHistoryOutput.setList(queryJt808DtoList(param));
        jt808PositionHistoryOutput.setTotal(queryListCount(param));
        return jt808PositionHistoryOutput;
    }
}
