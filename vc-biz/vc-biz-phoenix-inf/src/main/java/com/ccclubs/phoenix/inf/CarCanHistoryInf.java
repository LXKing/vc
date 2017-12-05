package com.ccclubs.phoenix.inf;


import com.ccclubs.phoenix.input.CarCanHistoryParam;
import com.ccclubs.phoenix.orm.model.CarCan;
import com.ccclubs.phoenix.output.CarCanHistoryOutput;

import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
public interface CarCanHistoryInf {
    //查询车辆CAN信息(非分页)
    public List<CarCan> queryCarCanListNoPage(CarCanHistoryParam carCanHistoryParam);

    //查询车辆CAN信息(分页)
    public List<CarCan> queryCarCanListWithPage(CarCanHistoryParam carCanHistoryParam);

    //查询车辆CAN信息记录总数
    public Long queryCarCanListCount(CarCanHistoryParam carCanHistoryParam);

    //查询车辆CAN信息(封装)
    public CarCanHistoryOutput queryCarCanListByOutput(CarCanHistoryParam carCanHistoryParam);

    //写入或更新车辆CAN信息
    public void saveOrUpdate(List<CarCan> records);
}
