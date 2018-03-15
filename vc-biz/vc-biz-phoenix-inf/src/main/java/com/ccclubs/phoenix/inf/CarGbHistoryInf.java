package com.ccclubs.phoenix.inf;



import com.ccclubs.phoenix.input.CarGbHistoryParam;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.phoenix.output.CarGbHistoryOutput;

import java.util.List;

public interface CarGbHistoryInf extends BaseHistoryInf<CarGb>{
    //查询车辆GB信息(非分页)
    public List<CarGb> queryCarGbListNoPage(CarGbHistoryParam carGbHistoryParam);

    //查询车辆GB信息(分页)
    public List<CarGb> queryCarGbListWithPage(CarGbHistoryParam carGbHistoryParam);

    //查询车辆GB信息记录总数
    public Long queryCarGbListCount(CarGbHistoryParam carGbHistoryParam);

    //查询车辆GB信息(封装)
    public CarGbHistoryOutput queryCarGbListByOutput(CarGbHistoryParam carGbHistoryParam);




}
