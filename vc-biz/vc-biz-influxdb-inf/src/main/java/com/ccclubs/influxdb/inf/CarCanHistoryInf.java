package com.ccclubs.influxdb.inf;

import com.ccclubs.influxdb.input.CarCanHistoryParam;
import com.ccclubs.influxdb.model.CarCan;

import java.util.List;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
public interface CarCanHistoryInf {

    void insert( List<CarCan> recordList);

    List<CarCan>  selectCarCanListByCondition(CarCanHistoryParam carCanHistoryParam);
}
