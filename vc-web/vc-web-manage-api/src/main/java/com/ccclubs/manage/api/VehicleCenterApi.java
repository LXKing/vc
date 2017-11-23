package com.ccclubs.manage.api;


import com.alibaba.fastjson.JSON;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.jwt.AuthenticationService;
import com.ccclubs.manage.dto.CsMachineInput;
import com.ccclubs.manage.dto.CsManageOutput;
import com.ccclubs.manage.dto.CsStateInput;
import com.ccclubs.manage.dto.CsVehicleInput;
import com.ccclubs.manage.inf.CsMachineInf;
import com.ccclubs.manage.inf.CsManageInf;
import com.ccclubs.manage.inf.CsStateInf;
import com.ccclubs.manage.inf.CsVehicleInf;
import com.ccclubs.manage.orm.model.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/9
 * Time: 19:31
 * Email:fengjun@ccclubs.com
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/vc")
public class VehicleCenterApi {

    @Autowired
    private CsMachineInf csMachineService;
    @Autowired
    private CsVehicleInf csVehicleService;
    @Autowired
    private CsStateInf csStateService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private CsManageInf csManageService;


    @RequestMapping(path = "/machines/v1", method={RequestMethod.GET})
    public ApiMessage<PageInfo<CsMachine>> getCsMechine(
            HttpServletRequest request,
            @RequestParam CsMachineInput csMachineInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csMachineInput.setCsAccess(jwtManage.getCsm_id());
        PageInfo<CsMachine> pi = csMachineService.getCsMachinePage(csMachineInput);
        return new ApiMessage<>(pi);
    }
    @RequestMapping(path = "/vehicles/v1", method={RequestMethod.GET})
    public ApiMessage<PageInfo<CsVehicle>> getCsVehicle(HttpServletRequest request,
                                                        @RequestParam CsVehicleInput csVehicleInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csVehicleInput.setCsAccess(jwtManage.getCsm_id());
        PageInfo<CsVehicle> pi =csVehicleService.getCsVehiclePage(csVehicleInput);
        return new ApiMessage<>(pi);
    }

    @RequestMapping(path = "/userInfo/v1", method={RequestMethod.GET})
    public ApiMessage<CsManageOutput> getUserInfoByToken(HttpServletRequest request){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        ApiMessage<CsManageOutput> result=new ApiMessage<CsManageOutput>(ApiEnum.SUCCESS);
        CsManageOutput csManageOutput=new CsManageOutput();
        CsManage csManage=csManageService.getCsManageByUserName(jwtManage.getUsername());
        csManage.setCsmPassword(null);
        csManageOutput.setUserInfo(csManage);
        result.setData(csManageOutput);
        return result;
    }

    @RequestMapping(path = "/vehiclesBiz/v1", method={RequestMethod.GET})
    public ApiMessage<PageInfo<CsVehicleBiz>> getCsVehicleBiz(HttpServletRequest request,
                                                              @RequestParam CsVehicleInput csVehicleInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csVehicleInput.setCsAccess(jwtManage.getCsm_id());
        PageInfo<CsVehicleBiz> pi =csVehicleService.getCsVehicleBizPage(csVehicleInput);
        System.out.println(JSON.toJSONString(pi));
        return new ApiMessage<>(pi);
    }

    @RequestMapping(path = "/states/v1", method={RequestMethod.GET})
    public ApiMessage<PageInfo<CsState>> getCsStates(HttpServletRequest request, @RequestParam CsStateInput csStateInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csStateInput.setCsAccess(jwtManage.getCsm_id());
        PageInfo<CsState> pi =csStateService.getCsStatePage(csStateInput);
        return new ApiMessage<>(pi);
    }

    @RequestMapping(path = "/state/v1", method={RequestMethod.GET})
    public ApiMessage<CsState> getCsState(HttpServletRequest request,@RequestParam CsStateInput csStateInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csStateInput.setCsAccess(jwtManage.getCsm_id());
        CsState csState =csStateService.getCsState(csStateInput);
        return new ApiMessage<>(csState);
    }






    @RequestMapping(path = "/machines/v1", method={RequestMethod.POST})
    public ApiMessage<String> updateCsMechine(HttpServletRequest request,@RequestBody CsMachineInput csMachineInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csMachineInput.setCsAccess(jwtManage.getCsm_id());
        if (csMachineService.insertOrUpdateCsMachine(csMachineInput)){
            return new ApiMessage<>(ApiEnum.SUCCESS);
        }
        return new ApiMessage<>(ApiEnum.FAIL);

    }
    @RequestMapping(path = "/machines/v1", method={RequestMethod.PUT})
    public ApiMessage<String> insertCsMechine(HttpServletRequest request,@RequestBody CsMachineInput csMachineInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csMachineInput.setCsAccess(jwtManage.getCsm_id());
        if (csMachineService.insertOrUpdateCsMachine(csMachineInput)){
            return new ApiMessage<>(ApiEnum.SUCCESS);
        }
        return new ApiMessage<>(ApiEnum.FAIL);

    }
    @RequestMapping(path = "/machines/v1", method={RequestMethod.DELETE})
    public ApiMessage<String> deleteCsMechine(HttpServletRequest request,@RequestBody CsMachineInput csMachineInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csMachineInput.setCsAccess(jwtManage.getCsm_id());
        if (csMachineService.deleteCsMachines(csMachineInput)){
            return new ApiMessage<>(ApiEnum.SUCCESS);
        }
        return new ApiMessage<>(ApiEnum.FAIL);

    }




    @RequestMapping(path = "/vehicles/v1", method={RequestMethod.POST})
    public ApiMessage<String> updateCsVehicle(HttpServletRequest request,@RequestBody CsVehicleInput csVehicleInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csVehicleInput.setCsAccess(jwtManage.getCsm_id());
        if (csVehicleService.insertOrUpdateCsVehicle(csVehicleInput)){
            return new ApiMessage<>(ApiEnum.SUCCESS);
        }
        return new ApiMessage<>(ApiEnum.FAIL);

    }
    @RequestMapping(path = "/vehicles/v1", method={RequestMethod.PUT})
    public ApiMessage<String> insertCsVehicle(HttpServletRequest request,@RequestBody CsVehicleInput csVehicleInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csVehicleInput.setCsAccess(jwtManage.getCsm_id());
        if (csVehicleService.insertOrUpdateCsVehicle(csVehicleInput)){
            return new ApiMessage<>(ApiEnum.SUCCESS);
        }
        return new ApiMessage<>(ApiEnum.FAIL);

    }
    @RequestMapping(path = "/vehicles/v1", method={RequestMethod.DELETE})
    public ApiMessage<String> deleteCsVehicle(HttpServletRequest request,@RequestBody CsVehicleInput csVehicleInput){
        JwtManage jwtManage=(JwtManage)authenticationService.getJwtUserFromToken(request);
        if(null==jwtManage){
            return new ApiMessage<>(ApiEnum.SIGN_CHECK_FAILED);
        }
        csVehicleInput.setCsAccess(jwtManage.getCsm_id());
        if (csVehicleService.deleteCsVehicles(csVehicleInput)){
            return new ApiMessage<>(ApiEnum.SUCCESS);
        }
        return new ApiMessage<>(ApiEnum.FAIL);

    }



}
