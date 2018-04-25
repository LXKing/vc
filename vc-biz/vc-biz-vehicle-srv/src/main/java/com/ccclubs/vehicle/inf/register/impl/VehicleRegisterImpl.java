package com.ccclubs.vehicle.inf.register.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryModelService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsModel;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import com.ccclubs.vehicle.dto.RegisterOutput;
import com.ccclubs.vehicle.dto.VehicleRegisterInput;
import com.ccclubs.vehicle.inf.register.VehicleRegisterInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 车辆注册
 *
 * @author jianghaiyang
 * @create 2017-07-24
 **/
@Service(version = VehicleServiceVersion.V1)
public class VehicleRegisterImpl implements VehicleRegisterInf {

    @Autowired
    CsVehicleMapper vdao;

    @Resource
    QueryModelService queryModelService;
    @Autowired
    QueryVehicleService queryVehicleService;
    @Autowired
    QueryAppInfoService queryAppInfoService;

    /**
     * 车辆注册
     *
     * @param inputs 多条车辆
     * @return 注册结果（包含成功和失败的），校验失败则抛出异常
     */
    @Override
    public RegisterOutput vehicleRegister(String appId, VehicleRegisterInput... inputs) {
        RegisterOutput output = new RegisterOutput();
        List<CsVehicle> passList = new ArrayList<>();
        boolean validate = validateVehicleRegister(appId, output, passList, inputs);
        if (validate) {
            vdao.batchInsert(passList);
        } else {
            //throw new ApiException(ApiEnum.ALL_VEHICLE_VALIDATE_FAILED);
        }
        return output;
    }

    /**
     * 车辆注册校验
     *
     * @param output   输出
     * @param passList 校验通过的车辆
     * @param inputs   输入
     * @return 全部校验失败返回false，否则返回true
     */
    private boolean validateVehicleRegister(String appId, RegisterOutput output,
                                            List<CsVehicle> passList, VehicleRegisterInput... inputs) {
        JSONObject outputItem;
        CsModel model;
        CsVehicle vehicle;
        CsVehicle vehicleCarNO;
        CsVehicle vehicleEngineNo;
        //CsMachine machine;
        SrvHost host;
        for (VehicleRegisterInput input : inputs) {
            model = queryModelService.queryModelByFlag(input.getCsvModel());
            vehicle = queryVehicleService.queryVehicleByVin(input.getCsvVin());
            if (StringUtils.isNotEmpty(input.getCsvCarNo())) {
                if (StringUtils.isNotEmpty(input.getCsvCarNo().trim())) {
                    vehicleCarNO = queryVehicleService.queryVehicleByCarNo(input.getCsvCarNo().trim());
                } else {
                    vehicleCarNO = null;
                }
            } else {
                vehicleCarNO = null;
            }

            vehicleEngineNo = queryVehicleService.queryVehicleByEngineNo(input.getCsvEngineNo().trim());
            //machine = terminalService.queryCsMachineByTeNo(input.getTeNo());
            host = queryAppInfoService.queryHostByAppid(appId);
            outputItem = new JSONObject();
            if (null != vehicleCarNO) {
                outputItem.put("vin", input.getCsvVin());
                outputItem.put("errorMsg", "csvCarNo aready exists");
                output.getFailure().add(outputItem);
                continue;
            } else {
                //重置csvCarNo为null FIXME
                input.setCsvCarNo(null);
            }

            if (null != vehicleEngineNo) {
                outputItem.put("vin", input.getCsvVin());
                outputItem.put("errorMsg", "csvEngineNo aready exists");
                output.getFailure().add(outputItem);
                continue;
            } else {
                //重置CsvEngineNo
                input.setCsvEngineNo(input.getCsvEngineNo().trim());
            }

            if (null == vehicle) {
                vehicle = new CsVehicle();
                // 异常数据: 车型不存在
                if (null == model) {
                    outputItem.put("vin", input.getCsvVin());
                    outputItem.put("errorMsg", "model not found");
                    output.getFailure().add(outputItem);
                    continue;
                }
                // 异常数据: appId不存在，非法用户操作
                if (null == host) {
                    outputItem.put("vin", input.getCsvVin());
                    outputItem.put("errorMsg", "APP Unauthorized");
                    output.getFailure().add(outputItem);
                    continue;
                }

                BeanUtils.copyProperties(input, vehicle);
                // 转日期类型
                try {
                    vehicle.setCsvProdDate(new SimpleDateFormat("yyyy-MM-dd").parse(input.getCsvProdDate()));
                } catch (ParseException e) {
                    throw new ApiException(ApiEnum.DATE_FORMAT_ERROR);
                }
                vehicle.setCsvModel(model.getCsmId());
                vehicle.setCsvMachine(null);
                vehicle.setCsvHost(0);
                vehicle.setCsvAccess(host.getShId());
                vehicle.setCsvAddTime(new Date());
                vehicle.setCsvUpdateTime(new Date());
                vehicle.setCsvStatus(new Byte("1"));
                passList.add(vehicle);
                outputItem.put("vin", vehicle.getCsvVin());
                output.getSuccess().add(outputItem);
                continue;

            } else {
                outputItem.put("vin", vehicle.getCsvVin());
                outputItem.put("errorMsg", "vehicle aready exists");
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
