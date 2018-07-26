package com.ccclubs.phoenix.inf;



import com.ccclubs.phoenix.input.CarGbHistoryParam;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.phoenix.output.CarGbHistoryOutput;

import java.util.List;

//extends BaseHistoryInf<CarGb>
public interface CarGbHistoryInf {
    @Deprecated
    //查询车辆GB信息(非分页)
    List<CarGb> queryCarGbListNoPage(CarGbHistoryParam carGbHistoryParam);

    @Deprecated
    //查询车辆GB信息(分页)
    List<CarGb> queryCarGbListWithPage(CarGbHistoryParam carGbHistoryParam);

    @Deprecated
    //查询车辆GB信息记录总数
    Long queryCarGbListCount(CarGbHistoryParam carGbHistoryParam);

    @Deprecated
    //查询车辆GB信息(封装)
    CarGbHistoryOutput queryCarGbListByOutput(CarGbHistoryParam carGbHistoryParam);




}
