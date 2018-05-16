package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.GbMessageHistoryInf;
import com.ccclubs.phoenix.input.GbMessageParam;
import com.ccclubs.phoenix.orm.dto.GbMessageDto;
import com.ccclubs.phoenix.output.GbMessageHistoryOutput;
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
public class GbMessageHistoryInfImpl implements GbMessageHistoryInf {

    static  final Logger logger= LoggerFactory.getLogger(GbMessageHistoryInfImpl.class);

    @Autowired
    private BaseQueryImpl baseQuery;

    @Override
    public List<GbMessageDto> queryGbMessageDtoList(GbMessageParam param) {
        return baseQuery.queryDtoList(param,
                PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY,
                null,
                GbMessageDto.class);
    }

    @Override
    public Long queryListCount(GbMessageParam param) {
        return baseQuery.queryListCount(param,
                PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY,
                null);
    }

    @Override
    public GbMessageHistoryOutput queryListByParam(GbMessageParam param) {
        GbMessageHistoryOutput gbMessageHistoryOutput=new GbMessageHistoryOutput();
        gbMessageHistoryOutput.setList(queryGbMessageDtoList(param));
        gbMessageHistoryOutput.setTotal(queryListCount(param));
        return gbMessageHistoryOutput;
    }
}
