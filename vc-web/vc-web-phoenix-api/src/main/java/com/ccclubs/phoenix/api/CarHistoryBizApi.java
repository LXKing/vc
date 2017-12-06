package com.ccclubs.phoenix.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.manage.inf.CsMachineInf;
import com.ccclubs.manage.inf.CsVehicleInf;
import com.ccclubs.manage.orm.model.CsVehicle;
import com.ccclubs.phoenix.input.CarStateHistoryParam;
import com.ccclubs.phoenix.output.CarStateHistoryOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("history")
public class CarHistoryBizApi {

    private static final Logger logger= LoggerFactory.getLogger(CarHistoryBizApi.class);

    @Reference(version = "1.0.0")
    private CsMachineInf csMachineService;

    @Reference(version = "1.0.0")
    private CsVehicleInf csVehicleService;

    @Autowired
    private CarHistoryApi carHistoryApi;


    private String getCsNumberByCsVin(String csVin){
        if (null!=csVin&&!csVin.isEmpty()){
            CsVehicle csVehicle=csVehicleService.getCsVehicleByCsVin(csVin);
            if (null!=csVehicle&&null!=csVehicle.getCsvMachine()){
                Integer csMachineId=csVehicleService.getCsVehicleByCsVin(csVin).getCsvMachine();
                return csMachineService.getCsMachineById(csMachineId).getCsmNumber();
            }

        }
        logger.info("param csVin is null.");
        return null;
    }

    @RequestMapping(value = "/states",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryCarStateList(CarStateHistoryParam param) {
        logger.info("we get a request form states:",param);

        param.setCs_number(getCsNumberByCsVin(param.getCsVin()));
        if (null==param.getCs_number()||param.getCs_number().isEmpty()){
            logger.info("we find a PARAMS_VALID_FAILED at states.");
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        ApiMessage result=carHistoryApi.queryCarStateList(param);
        return result;
    }

    //驾驶阶段数据查询
    @RequestMapping(value = "/drivepaces",method = RequestMethod.GET)
    public ApiMessage<CarStateHistoryOutput> queryDrivePaces(CarStateHistoryParam param) {
        logger.info("we get a request form drivepaces:",param);

        param.setCs_number(getCsNumberByCsVin(param.getCsVin()));
        if (null==param.getCs_number()||param.getCs_number().isEmpty()){
            logger.info("we find a PARAMS_VALID_FAILED at drivepaces.");
            return new ApiMessage<>(100003, ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        ApiMessage result=carHistoryApi.queryDrivePaces(param);
        return result;
    }


}
