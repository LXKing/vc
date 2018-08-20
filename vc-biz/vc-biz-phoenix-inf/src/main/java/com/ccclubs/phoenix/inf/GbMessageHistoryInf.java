package com.ccclubs.phoenix.inf;

import com.ccclubs.phoenix.input.GbMessageParam;
import com.ccclubs.phoenix.orm.dto.GbMessageDto;
import com.ccclubs.phoenix.output.GbMessageHistoryOutput;

import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 16:02
 * @Description: 国标数据历史数据查询接口！
 */
public interface GbMessageHistoryInf {

    //查询车辆状态信息
    List<GbMessageDto> queryGbMessageDtoList(GbMessageParam param);

    //查询车辆状态信息记录总数
    Long queryListCount(GbMessageParam param);

    //查询车辆状态信息(封装)
    GbMessageHistoryOutput queryListByParam(GbMessageParam param);

}
