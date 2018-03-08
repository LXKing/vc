package com.ccclubs.vtsearch.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.vehicle.dto.BindVehicleInput;
import com.ccclubs.vehicle.dto.BindVehicleOutput;
import com.ccclubs.vehicle.dto.ModelInputList;
import com.ccclubs.vehicle.dto.ModelRegisterInput;
import com.ccclubs.vehicle.dto.ModifyVehicleInput;
import com.ccclubs.vehicle.dto.ModifyVehicleOutput;
import com.ccclubs.vehicle.dto.RegisterOutput;
import com.ccclubs.vehicle.dto.UnBindVehicleInput;
import com.ccclubs.vehicle.dto.UnBindVehicleOutput;
import com.ccclubs.vehicle.dto.VehicleInputList;
import com.ccclubs.vehicle.dto.VehiclePushOutput;
import com.ccclubs.vehicle.dto.VehicleRegisterInput;
import com.ccclubs.vehicle.inf.binding.BindVehicleInf;
import com.ccclubs.vehicle.inf.binding.UnBindVehicleInf;
import com.ccclubs.vehicle.inf.modify.ModifyVehicleInf;
import com.ccclubs.vehicle.inf.push.PushVehicleInf;
import com.ccclubs.vehicle.inf.register.ModelRegisterInf;
import com.ccclubs.vehicle.inf.register.VehicleRegisterInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 机车操作API
 *
 * @author jianghaiyang
 * @create 2017-07-03
 **/
@RefreshScope
@RequestMapping("operate")
@RestController
public class VtOperateApi {

    private static final Logger logger = LoggerFactory.getLogger(VtOperateApi.class);

    @Reference(version = VehicleServiceVersion.V1)
    private VehicleRegisterInf vehicleRegisterInf;

    @Reference(version = VehicleServiceVersion.V1)
    private ModelRegisterInf modelRegisterInf;

    @Reference(version = VehicleServiceVersion.V1)
    private BindVehicleInf bindVehicleInf;

    @Reference(version = VehicleServiceVersion.V1)
    private UnBindVehicleInf unBindVehicleInf;

    @Reference(version = VehicleServiceVersion.V1)
    private ModifyVehicleInf modifyVehicleInf;

    @Reference(version = VehicleServiceVersion.V1)
    private PushVehicleInf pushVehicleInf;

    /**
     * 1.终端车辆绑定 <p>
     *
     * @param appId 应用授权ID
     * @param input 绑定关系修改参数
     * @return 新绑定关系
     */
    @ApiSecurity
    @ApiOperation(value = "终端车辆绑定", notes = "终端车辆绑定")
    @PostMapping("bindVehicle")
    public ApiMessage<BindVehicleOutput> bindVehicle(@RequestHeader("appId") String appId,
                                                     BindVehicleInput input) {
        logger.info("API事件:终端车辆绑定,APPID:{},车架号:{},终端编号:{}", input.getAppId(), input.getVin(), input.getTeNo());
        input.setAppId(appId);
        BindVehicleOutput output = bindVehicleInf.bindVehicle(input);
        return new ApiMessage<>(output);
    }

    /**
     * 2.终端车辆解除绑定 <p>
     *
     * @param appId 应用授权ID
     * @param input 绑定关系修改参数
     * @return 新绑定关系
     */
    @ApiSecurity
    @ApiOperation(value = "终端车辆解除绑定", notes = "终端车辆解除绑定")
    @PostMapping("unbindVehicle")
    public ApiMessage<UnBindVehicleOutput> unbindVehicle(@RequestHeader("appId") String appId,
                                                         UnBindVehicleInput input) {
        logger.info("API事件:终端车辆解除绑定,APPID:{},车架号:{},终端编号:{}", appId, input.getVin(), input.getTeNo());
        input.setAppId(appId);
        UnBindVehicleOutput output = unBindVehicleInf.unBindVehicle(input);
        return new ApiMessage<>(output);
    }

    /**
     * 3.车型注册（车型备案型号）
     *
     * @param list 多个车型
     * @return 注册结果
     */
    //@ApiSecurity
    //@ApiOperation(value = "车型注册", notes = "车型注册（车型备案型号）")
    //@PostMapping("modelRegister")
    public ApiMessage<RegisterOutput> vehicleModelRegister(ModelInputList list) {
        ModelRegisterInput[] array = list.getInputs()
                .toArray(new ModelRegisterInput[list.getInputs().size()]);
        RegisterOutput output = modelRegisterInf.vehicleModelRegister(array);
        return new ApiMessage<>(output);
    }

    /**
     * 4.车辆注册
     *
     * @param list 多辆车
     * @return 注册结果
     */
    @ApiSecurity
    @ApiOperation(value = "车辆注册", notes = "车辆注册")
    @PostMapping("vehicleRegister")
    public ApiMessage<RegisterOutput> vehicleRegister(@RequestHeader("appId") String appId,
                                                      VehicleInputList list) {
        logger.info("API事件:车辆注册,APPID:{},车辆数:{}辆", appId, list.getInputs().size());
        VehicleRegisterInput[] array = list.getInputs().toArray(new VehicleRegisterInput[list.getInputs().size()]);
        RegisterOutput output = vehicleRegisterInf.vehicleRegister(appId, array);
        return new ApiMessage<>(output);
    }


    /**
     * 5.车辆基本信息修改
     *
     * @param input 车
     * @return 注册结果
     */
    @ApiSecurity
    @ApiOperation(value = "车辆基本信息修改", notes = "车辆基本信息修改")
    @PostMapping("vehicleModify")
    public ApiMessage<ModifyVehicleOutput> vehicleModify(@RequestHeader("appId") String appId,
                                                         ModifyVehicleInput input) {
        logger.info("API事件:车辆基本信息修改,APPID:{},车架号:{}", appId, input.getVin());
        input.setAppId(appId);
        ModifyVehicleOutput output = modifyVehicleInf.vehicleModify(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.众泰追溯系统主动推送车辆注册 车辆信息完善后，或有变更时推送数据
     *
     * @return 推送数据结果
     */
    @ApiOperation(value = "推送车辆数据", notes = "推送车辆数据")
    @PostMapping("/factory/vehiclePush")
    public ApiMessage<VehiclePushOutput> vehiclePush(@RequestBody String input) {
        if (StringUtils.isEmpty(input)) {
            throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "推送内容不能为空！");
        }
        logger.info("API事件:推送车辆数据");
        VehiclePushOutput output = pushVehicleInf.vehiclePushSave(input);

        return new ApiMessage<>(output);
    }
}
