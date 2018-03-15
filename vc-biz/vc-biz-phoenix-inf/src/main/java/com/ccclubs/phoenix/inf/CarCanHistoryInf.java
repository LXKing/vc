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
public interface CarCanHistoryInf extends BaseHistoryInf<CarCan>{
    //查询车辆CAN信息(非分页)
     List<CarCan> queryCarCanListNoPage(CarCanHistoryParam carCanHistoryParam);

    //查询车辆CAN信息(分页)
     List<CarCan> queryCarCanListWithPage(CarCanHistoryParam carCanHistoryParam);

    //查询车辆CAN信息记录总数
     Long queryCarCanListCount(CarCanHistoryParam carCanHistoryParam);

    //查询车辆CAN信息(封装)
     CarCanHistoryOutput queryCarCanListByOutput(CarCanHistoryParam carCanHistoryParam);

}
