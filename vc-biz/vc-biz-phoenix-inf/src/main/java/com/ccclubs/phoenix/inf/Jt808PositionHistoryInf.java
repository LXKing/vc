package com.ccclubs.phoenix.inf;

import com.ccclubs.phoenix.input.Jt808PositionParam;
import com.ccclubs.phoenix.orm.dto.Jt808Dto;
import com.ccclubs.phoenix.output.Jt808PositionHistoryOutput;

import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 16:03
 * @Description: Jt808位置数据历史数据查询接口！
 */
public interface Jt808PositionHistoryInf {

    //查询车辆状态信息
    List<Jt808Dto> queryJt808DtoList(Jt808PositionParam param);

    //查询车辆状态信息记录总数
    Long queryListCount(Jt808PositionParam param);

    //查询车辆状态信息(封装)
    Jt808PositionHistoryOutput queryListByParam(Jt808PositionParam param);
}
