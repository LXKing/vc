package com.ccclubs.influxdb.inf;

import com.ccclubs.influxdb.input.CarStateHistoryParam;
import com.ccclubs.influxdb.model.CarState;

import java.util.List;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
public interface CarStateHistoryInf {

    void insert( List<CarState> recordList);

    List<CarState> selectCarStateListByCondition(CarStateHistoryParam carStateHistoryParam);
}
