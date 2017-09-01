package com.ccclubs.vtsearch.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.vehicle.dto.*;
import com.ccclubs.vehicle.inf.binding.BindVehicleInf;
import com.ccclubs.vehicle.dto.ModifyVehicleInput;
import com.ccclubs.vehicle.dto.ModifyVehicleOutput;
import com.ccclubs.vehicle.inf.binding.UnBindVehicleInf;
import com.ccclubs.vehicle.inf.modify.ModifyVehicleInf;
import com.ccclubs.vehicle.inf.register.ModelRegisterInf;
import com.ccclubs.vehicle.inf.register.VehicleRegisterInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 1.终端车辆绑定
     * <p>
     *
     * @param appId 应用授权ID
     * @param input 绑定关系修改参数
     * @return 新绑定关系
     */
    @ApiSecurity
    @ApiOperation(value = "终端车辆绑定", notes = "终端车辆绑定")
    @PostMapping("bindVehicle")
    public ApiMessage<BindVehicleOutput> bindVehicle(@RequestHeader("appId") String appId, BindVehicleInput input) {
        input.setAppId(appId);
        BindVehicleOutput output = bindVehicleInf.bindVehicle(input);
        return new ApiMessage<>(output);
    }

    /**
     * 2.终端车辆解除绑定
     * <p>
     *
     * @param appId 应用授权ID
     * @param input 绑定关系修改参数
     * @return 新绑定关系
     */
    @ApiSecurity
    @ApiOperation(value = "终端车辆解除绑定", notes = "终端车辆解除绑定")
    @PostMapping("unbindVehicle")
    public ApiMessage<UnBindVehicleOutput> unbindVehicle(@RequestHeader("appId") String appId, UnBindVehicleInput input) {
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
        ModelRegisterInput[] array = list.getInputs().toArray(new ModelRegisterInput[list.getInputs().size()]);
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
    public ApiMessage<RegisterOutput> vehicleRegister(@RequestHeader("appId") String appId, VehicleInputList list) {
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
    public ApiMessage<ModifyVehicleOutput> vehicleModify(@RequestHeader("appId") String appId, ModifyVehicleInput input) {
        input.setAppId(appId);
        ModifyVehicleOutput output = modifyVehicleInf.vehicleModify(input);
        return new ApiMessage<>(output);
    }

}
