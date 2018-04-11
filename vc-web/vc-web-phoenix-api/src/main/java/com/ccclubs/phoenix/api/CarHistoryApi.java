/*
package com.ccclubs.phoenix.api;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.inf.CarCanHistoryInf;
import com.ccclubs.phoenix.inf.CarStateHistoryInf;
import com.ccclubs.phoenix.input.CarCanHistoryParam;
import com.ccclubs.phoenix.input.CarStateHistoryParam;
import com.ccclubs.phoenix.orm.model.CarCan;
import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.orm.model.Pace;
import com.ccclubs.phoenix.output.CarCanHistoryOutput;
import com.ccclubs.phoenix.output.CarStateHistoryOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

*/
/**

 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/27 0027
 *//*

@Deprecated
@RestController
@CrossOrigin
@RequestMapping("/carhistory")
public class CarHistoryApi {
    private static final Logger logger= LoggerFactory.getLogger(CarHistoryApi.class);

    @Reference(version = "1.0.0")
    private CarStateHistoryInf carStateHistoryInf;

    @Reference(version = "1.0.0")
    private CarCanHistoryInf carCanHistoryInf;

   */
/* @Autowired
    private IReplaceService replaceService;*//*


    //车辆状态查询
    @RequestMapping(value = "/states",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryCarStateList(CarStateHistoryParam param){
        logger.debug("we receive a state get request."+param.toString());
        if (!paramCheck(param.getCs_number(),
                param.getStart_time(),
                param.getEnd_time(),
                param.getPage_no(),
                param.getPage_size()))
        {
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        CarStateHistoryOutput carStateHistoryOutput= carStateHistoryInf.queryCarStateListByOutput(param);
        return new ApiMessage<>(carStateHistoryOutput);
    }

    //车辆状态数据存储
    @RequestMapping(value = "/states",method = RequestMethod.POST)
    public ApiMessage<CarStateHistoryOutput> saveCarStateList(@RequestBody List<CarState> carStateList){
        logger.debug("we receive a state date list.");
        //logger.warn(carStateList.toString());
        CarStateHistoryOutput carStateHistoryOutput = new CarStateHistoryOutput();
        if(carStateList!=null&&carStateList.size()>0) {
            carStateHistoryInf.saveOrUpdate(carStateList);
        }
        return new ApiMessage<>(carStateHistoryOutput);
    }

    //车辆CAN数据查询
    @RequestMapping(value = "/cans",method = RequestMethod.GET)
    public ApiMessage<CarCanHistoryOutput> queryCarCanList(CarCanHistoryParam param){
        logger.debug("we receive a can get request."+param.toString());
        if (!paramCheck(param.getCs_number(),
                param.getStart_time(),
                param.getEnd_time(),
                param.getPage_no(),
                param.getPage_size()))
        {
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        CarCanHistoryOutput carCanHistoryOutput= carCanHistoryInf.queryCarCanListByOutput(param);
        return new ApiMessage<>(carCanHistoryOutput);
    }

    //车辆CAN数据存储
    @RequestMapping(value = "/cans",method = RequestMethod.POST)
    public ApiMessage<CarCanHistoryOutput> saveCarCanList(@RequestBody List<CarCan> carCanList){

        logger.debug("we receive a can date list.");
        //logger.warn(carCanList.toString());
        CarCanHistoryOutput carCanHistoryOutput = new CarCanHistoryOutput();
        if(carCanList!=null&&carCanList.size()>0) {
            carCanHistoryInf.saveOrUpdate(carCanList);
        }
        return new ApiMessage<>(carCanHistoryOutput);
    }

    //驾驶阶段数据查询
    @RequestMapping(value = "/drivepaces",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryDrivePaces(CarStateHistoryParam param){
        if (!paramCheck(param.getCs_number(),
                param.getStart_time(),
                param.getEnd_time(),
                param.getPage_no(),
                param.getPage_size()))
        {
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        CarStateHistoryOutput carStateHistoryOutput=new CarStateHistoryOutput();
        param.setOrder("asc");
        param.setQuery_fields("PACE");
        param.setPage_no(-1);
        List<CarState> carStateList= carStateHistoryInf.queryCarStateListByOutput(param).getList();
        //Collections.reverse(carStateList);
        List<Pace> paceList = carStateHistoryInf.calDrivePaceList(carStateList);
        carStateHistoryOutput.setPaceList(paceList);
        //carStateHistoryOutput.setTotal(param.getPage_size()*100L);
        return new ApiMessage<>(carStateHistoryOutput);
    }

    //充电阶段数据查询
    @RequestMapping(value = "/chargingpaces",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryChargingPaces(CarStateHistoryParam param){
        if (!paramCheck(param.getCs_number(),
                param.getStart_time(),
                param.getEnd_time(),
                param.getPage_no(),
                param.getPage_size()))
        {
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        CarStateHistoryOutput carStateHistoryOutput=new CarStateHistoryOutput();
        param.setOrder("asc");
        param.setQuery_fields("PACE");
        param.setPage_no(-1);

        List<CarState> carStateList= carStateHistoryInf.queryCarStateListByOutput(param).getList();
        //Collections.reverse(carStateList);
        List<Pace> paceList = carStateHistoryInf.calChargingPaceList(carStateList);
        carStateHistoryOutput.setPaceList(paceList);
        //carStateHistoryOutput.setTotal(param.getPage_size()*100);
        return new ApiMessage<>(carStateHistoryOutput);
    }


*/
/*
    @RequestMapping(value = "/processed-states",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> getProcessedCarStateList(CarStateHistoryParam param){
        if (!paramCheck(param.getCs_number(),
                param.getStart_time(),
                param.getEnd_time(),
                param.getPage_no(),
                param.getPage_size()))
        {
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        ApiMessage<CarStateHistoryOutput> results= this.queryCarStateList(param);//调用普通查询结果。
        if (results.getData().getList()!=null&&results.getData().getList().size()>0){
            //carStateList=dictionaryService.dealListDateWithDictionary("saving_mode","saving_mode",carStateList);
            //carStateList=vehicleMachineRelService.dealListDateWithVehicleMachineRel(carStateList);
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("saving_mode","saving_mode");
            replaceService.replaceDataList(hashMap,results.getData().getList());
            //results.getData().setList(results.getData().getList());
        }
        return results;
    }

    @RequestMapping(value="/processed-cans",method=RequestMethod.GET)
    public ApiMessage<CarCanHistoryOutput> getCarCanList(CarCanHistoryParam param){
        if (!paramCheck(param.getCs_number(),
                param.getStart_time(),
                param.getEnd_time(),
                param.getPage_no(),
                param.getPage_size()))
        {
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        ApiMessage<CarCanHistoryOutput> results=this.queryCarCanList(param);
        if(results.getData().getList()!=null&&results.getData().getList().size()>0){
            //关联车辆信息与历史数据。
            //carCanList=vehicleMachineRelService.dealListDateWithVehicleMachineRel(carCanList);
            //carCanHistoryOutput.setList(carCanList);
        }
        return results;
    }*//*



    private boolean paramCheck(String csNumber,String startTime,String endTime,Integer pageNo,Integer pageSize){
        if (csNumber.isEmpty()||endTime.isEmpty()||startTime.isEmpty()){return false;}
        if (pageNo<-1||pageNo==0){return false;}
        if (pageSize<=0){return false;}
        if (pageSize>5000){return false;}
        try {
            DateTimeUtil.date2UnixFormat(startTime,DateTimeUtil.UNIX_FORMAT);
            DateTimeUtil.date2UnixFormat(endTime,DateTimeUtil.UNIX_FORMAT);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
*/
