package com.ccclubs.vehicle.inf.register.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.common.query.QueryModelService;
import com.ccclubs.pub.orm.mapper.CsModelMapper;
import com.ccclubs.pub.orm.model.CsModel;
import com.ccclubs.vehicle.dto.ModelRegisterInput;
import com.ccclubs.vehicle.dto.RegisterOutput;
import com.ccclubs.vehicle.inf.register.ModelRegisterInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 车型注册
 *
 * @author jianghaiyang
 * @create 2017-07-24
 **/
@Service(version = VehicleServiceVersion.V1)
public class ModelRegisterImpl implements ModelRegisterInf {

    @Autowired
    CsModelMapper modao;

    @Resource
    QueryModelService queryModelService;

    /**
     * 车型注册
     *
     * @param inputs 多条车型
     * @return 注册结果（包含成功和失败的），校验失败则抛出异常
     */
    @Override
    public RegisterOutput vehicleModelRegister(ModelRegisterInput... inputs) {
        RegisterOutput output = new RegisterOutput();
        List<CsModel> passList = new ArrayList<>();
        //车型注册校验
        boolean validate = validateModelRegister(output, passList, inputs);
        if (validate) {
            modao.batchInsert(passList);
        } else {
            //throw new ApiException(ApiEnum.VEHICLE_MODEL_EXISTS);
        }
        return output;
    }

    /**
     * 车型注册校验
     *
     * @param output   输出
     * @param passList 校验通过的车型
     * @param inputs   输入
     * @return 全部校验失败返回false，否则返回true
     */
    private boolean validateModelRegister(RegisterOutput output, List<CsModel> passList, ModelRegisterInput... inputs) {
        JSONObject outputItem;
        for (ModelRegisterInput input : inputs) {
            outputItem = new JSONObject();
            //根据车型备案型号条件获取车型xinxi
            CsModel model = queryModelService.queryModelByFlag(input.getCsmFlag());
            if (null == model) {
                model = new CsModel();
                BeanUtils.copyProperties(input, model);
                model.setCsmAddTime(new Date());
                model.setCsmUpdateTime(new Date());
                model.setCsmStatus(new Short("1"));
                passList.add(model);
                outputItem.put("model", model.getCsmFlag());
                output.getSuccess().add(outputItem);
            } else {
                outputItem.put("model", model.getCsmFlag());
                outputItem.put("errorMsg", "model aready exists");
                output.getFailure().add(outputItem);
            }
        }

        // 校验全部失败
        if (output.getSuccess().size() == 0) {
            return false;
        }
        return true;
    }
}
