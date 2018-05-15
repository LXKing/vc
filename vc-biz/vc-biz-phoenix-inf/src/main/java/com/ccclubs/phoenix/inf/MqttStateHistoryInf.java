package com.ccclubs.phoenix.inf;

import com.ccclubs.phoenix.input.CarStateHistoryParam;
import com.ccclubs.phoenix.input.MqttStateParam;
import com.ccclubs.phoenix.input.StateHistoryParam;
import com.ccclubs.phoenix.orm.dto.MqttStateDto;
import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.output.CarStateHistoryOutput;
import com.ccclubs.phoenix.output.MqttStateHistoryOutput;
import com.ccclubs.phoenix.output.StateHistoryOutput;

import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/14
 * @Time: 14:44
 * @Description: 分时租赁协议历史状态接口！
 */
public interface MqttStateHistoryInf {
    //查询车辆状态信息(非分页)
    List<MqttStateDto> queryMqttStateDtoList(MqttStateParam carStateHistoryParam);

    //查询车辆状态信息记录总数
    Long queryListCount(MqttStateParam carStateHistoryParam);

    //查询车辆状态信息(封装)
    MqttStateHistoryOutput queryListByParam(MqttStateParam carStateHistoryParam);

    //查询一个时间点前后的数据
    //StateHistoryOutput queryListWithLimit(StateHistoryParam stateHistoryParam) ;

}
