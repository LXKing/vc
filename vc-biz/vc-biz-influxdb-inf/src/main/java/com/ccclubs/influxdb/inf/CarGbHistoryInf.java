package com.ccclubs.influxdb.inf;

import com.ccclubs.influxdb.input.CarGbHistoryParam;
import com.ccclubs.influxdb.model.CarGb;

import java.util.List;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
public interface CarGbHistoryInf {

    void  insert( List<CarGb> recordList);

    List<CarGb> selectCarGbListByCondition(CarGbHistoryParam carGbHistoryParam);
}
