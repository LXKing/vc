package com.ccclubs.phoenix.inf;


import com.ccclubs.phoenix.input.CarStateHistoryParam;
import com.ccclubs.phoenix.input.CarStateHistoryUpdateParam;
import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.orm.model.Pace;
import com.ccclubs.phoenix.output.CarStateHistoryOutput;
import com.ccclubs.phoenix.output.HistoryNoQueryOutput;

import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　 ┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
// extends BaseHistoryInf<CarState>
public interface CarStateHistoryInf{
    //查询车辆状态信息(非分页)
     List<CarState> queryCarStateListNoPage(CarStateHistoryParam carStateHistoryParam);

    //查询车辆状态信息(分页)
     List<CarState> queryCarStateListWithPage(CarStateHistoryParam carStateHistoryParam);

    //查询车辆状态信息记录总数
     Long queryCarStateListCount(CarStateHistoryParam carStateHistoryParam);

    //查询车辆状态信息(封装)
     CarStateHistoryOutput queryCarStateListByOutput(CarStateHistoryParam carStateHistoryParam);

     //更新车辆obd里程
     HistoryNoQueryOutput updateCarStateObdMiles(CarStateHistoryUpdateParam param);

    //批量更新车辆obd里程
    HistoryNoQueryOutput updateCarStateObdMiles(List<CarStateHistoryUpdateParam> paramList);


    //驾驶阶段数据计算
     List<Pace> calDrivePaceList(List<CarState> carStateList);

    //充电阶段数据计算
     List<Pace> calChargingPaceList(List<CarState> carStateList);

}
