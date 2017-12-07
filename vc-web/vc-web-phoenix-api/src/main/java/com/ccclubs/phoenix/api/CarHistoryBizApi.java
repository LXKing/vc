package com.ccclubs.phoenix.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.inf.CarCanHistoryInf;
import com.ccclubs.phoenix.inf.CarStateHistoryInf;
import com.ccclubs.phoenix.inf.TransformForBizInf;
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

@RestController
@CrossOrigin
@RequestMapping("history")
public class CarHistoryBizApi {

    private static final Logger logger= LoggerFactory.getLogger(CarHistoryBizApi.class);


    @Reference(version = "1.0.0")
    private CarStateHistoryInf carStateHistoryInf;

    @Reference(version = "1.0.0")
    private CarCanHistoryInf carCanHistoryInf;


    @Reference(version = "1.0.0")
    private TransformForBizInf transformForBizService;

    @RequestMapping(value = "/states",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryCarStateList(CarStateHistoryParam param) {
        logger.info("we get a request form states:",param);

        param.setCs_number(transformForBizService.getCsNumberByCsVin(param.getCsVin()));
        if (null==param.getCs_number()||param.getCs_number().isEmpty()){
            logger.info("we find a PARAMS_VALID_FAILED at states.");
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
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

    //状态查询，内部
    @RequestMapping(value = "/states/nternal",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryCarStateListInternal(CarStateHistoryParam param) {
        logger.info("we get aiInternal request form states:",param);

        if (null==param.getCs_number()||param.getCs_number().isEmpty()){
            logger.info("we find a PARAMS_VALID_FAILED at states.");
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
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


    //驾驶阶段数据查询(内部使用)
    @RequestMapping(value = "/drivepaces/nternal",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryDrivePacesInternal(CarStateHistoryParam param) {
        logger.info("we get a Internal request form drivepaces:",param);
        if (null==param.getCs_number()||param.getCs_number().isEmpty()){
            logger.info("we find a PARAMS_VALID_FAILED at drivepaces.");
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
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

    //驾驶阶段数据查询
    @RequestMapping(value = "/drivepaces",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryDrivePaces(CarStateHistoryParam param) {
        logger.info("we get a request form drivepaces:",param);

        param.setCs_number(transformForBizService.getCsNumberByCsVin(param.getCsVin()));
        if (null==param.getCs_number()||param.getCs_number().isEmpty()){
            logger.info("we find a PARAMS_VALID_FAILED at drivepaces.");
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
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




    private boolean paramCheck(String csNumber,String startTime,String endTime,Integer pageNo,Integer pageSize){
        if (null==csNumber||null==endTime||null==startTime){return false;}
        if (csNumber.isEmpty()||endTime.isEmpty()||startTime.isEmpty()){return false;}
        if (pageNo<-1||pageNo==0){return false;}
        if (pageSize<=0){return false;}
        if (pageSize>5000){return false;}
        try {
            DateTimeUtil.date2UnixFormat(startTime,DateTimeUtil.format1);
            DateTimeUtil.date2UnixFormat(endTime,DateTimeUtil.format1);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
