package com.ccclubs.vehicle.inf.push.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.ccclubs.common.query.QueryModelService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.logger.VehicleControlLogger;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.frm.spring.util.DESUtil;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.vehicle.dto.VehiclePushInput;
import com.ccclubs.vehicle.dto.VehiclePushOutput;
import com.ccclubs.vehicle.inf.push.PushVehicleInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 主机厂车辆推送
 *
 * @author qsxiaogang
 * @create 2017-12-09
 **/
@Service(version = VehicleServiceVersion.V1)
public class PushVehicleImpl implements PushVehicleInf {

  private static final Logger loggerBusiness = VehicleControlLogger.getLogger();

  @Value("${vehicle.push.zongtai}")
  private String PUSH_KEY;
  @Autowired
  CsVehicleMapper vdao;
  @Resource
  QueryModelService queryModelService;
  @Autowired
  QueryVehicleService queryVehicleService;
  @Autowired
  QueryTerminalService queryTerminalService;

  @Override
  public VehiclePushOutput vehiclePushSave(VehiclePushInput input) {
    if (null == input) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "推送内容不能为空！");
    }

    // 1、数据校验
    if (StringUtils.empty(input.getCsvModelCode())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "车型代码不能为空！");
    }
    if (StringUtils.empty(input.getCsvType())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "车辆类型不能为空！");
    }
    if (StringUtils.empty(input.getCsvModel())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "车型不能为空！");
    }
    if (StringUtils.empty(input.getCsvColorCode())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "车身颜色不能为空！");
    }
    if (StringUtils.empty(input.getCsvProdDate())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "生产日期不能为空！");
    }
    if (StringUtils.empty(input.getCsvVin())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "VIN不能为空！");
    }
    if (StringUtils.empty(input.getCsvEngineNo())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "发动机(电机)编号不能为空！");
    }
    if (StringUtils.empty(input.getCsvMachine())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "变速箱(车纷享)号不能为空！");
    }
    if (StringUtils.empty(input.getCsvBataccuCode())) {
      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "电池号不能为空！");
    }

//    if (StringUtils.isEmpty(input.getCsvProdDate())){
//      throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "生产日期不能为空！");
//    }

    //TODO:校验日期格式
    // 2、依据 input.getCsvVin() 查找车辆信息
//    CsModel model = queryModelService.queryModelByFlag(input.getCsvModel());
    CsVehicle vehicle = queryVehicleService.queryVehicleByVin(input.getCsvVin().trim());
    if (null == vehicle) {
      // 3、insert 车辆信息
      CsVehicle vehicleEngineNo = queryVehicleService
          .queryVehicleByEngineNo(input.getCsvEngineNo().trim());
      if (null != vehicleEngineNo) {
        throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), "发动机(电机)编号重复！");
      }
      // 检查终端信息
      CsMachine csMachine = queryTerminalService.queryCsMachineByTeNo(input.getCsvMachine());
      if (null == csMachine) {
        /**
         * log 终端序列号不存在的信息
         */
        String errorMsg = String.format("变速箱(车纷享)号 %s 不存在！", input.getCsvMachine());
        ApiMessage apiMessage = new ApiMessage(ApiEnum.REQUEST_PARAMS_VALID_FAILED);
        apiMessage.setData(input);
        apiMessage.setMessage(errorMsg);
        loggerBusiness.info(JSON.toJSONString(apiMessage));
        throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), errorMsg);
      }
      // 检查终端是否被占用
      CsVehicle existMachine = queryVehicleService.queryVehicleByMachine(csMachine.getCsmId());
      if (null != existMachine) {
        String errorMsg = String
            .format("变速箱(车纷享)号 %s 已被其他车辆 %s 绑定！", input.getCsvMachine(), existMachine.getCsvVin());
        ApiMessage apiMessage = new ApiMessage(ApiEnum.REQUEST_PARAMS_VALID_FAILED);
        apiMessage.setData(input);
        apiMessage.setMessage(errorMsg);
        loggerBusiness.info(JSON.toJSONString(apiMessage));
        throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED.code(), errorMsg);
      }

      // 开始insert车辆信息
      vehicle = new CsVehicle();
      //FIXME:暂时固定为E200
      vehicle.setCsvModel(5);
      vehicle.setCsvMachine(csMachine.getCsmId());
      vehicle.setCsvHost(0);
      //FIXME:暂时固定为 众车中心
      vehicle.setCsvAccess(1);
      vehicle.setCsvAddTime(new Date());
      vehicle.setCsvUpdateTime(new Date());
      vehicle.setCsvStatus(new Byte("1"));

      vehicle.setCsvVin(input.getCsvVin());
      vehicle.setCsvProdDate(StringUtils.date(input.getCsvProdDate(), "yyyy-MM-dd"));
      vehicle.setCsvBataccuCode(input.getCsvBataccuCode());
      vehicle.setCsvCertific(input.getCsvCertific());
      vehicle.setCsvColorCode(convertColorCode(input.getCsvColorCode()));
      vehicle.setCsvEngineNo(input.getCsvEngineNo());
      vehicle.setCsvInteriorColorCode(input.getCsvInteriorColorCode());
      vehicle.setCsvModelCodeFull(input.getCsvModelCode());
      vehicle.setCsvModelCodeSimple(input.getCsvModel());

      vdao.insertSelective(vehicle);
    } else {
      // 4、更新 车辆信息
      CsVehicle vehicleUpdate = new CsVehicle();
      vehicleUpdate.setCsvUpdateTime(new Date());
      vehicleUpdate.setCsvProdDate(StringUtils.date(input.getCsvProdDate(), "yyyy-MM-dd"));
      vehicleUpdate.setCsvBataccuCode(input.getCsvBataccuCode());
      vehicleUpdate.setCsvCertific(input.getCsvCertific());
      vehicleUpdate.setCsvColorCode(convertColorCode(input.getCsvColorCode()));
      vehicleUpdate.setCsvEngineNo(input.getCsvEngineNo());
      vehicleUpdate.setCsvInteriorColorCode(input.getCsvInteriorColorCode());
      vehicleUpdate.setCsvModelCodeFull(input.getCsvModelCode());
      vehicleUpdate.setCsvModelCodeSimple(input.getCsvModel());

      vehicleUpdate.setCsvId(vehicle.getCsvId());
      vdao.updateByPrimaryKeySelective(vehicle);
    }

    return null;
  }

  @Override
  public VehiclePushOutput vehiclePushSave(String input) {
    try {

      String result = DESUtil.decrypt(input, PUSH_KEY);

      VehiclePushInput pushInput = new ObjectMapper().readValue(result, VehiclePushInput.class);

      return this.vehiclePushSave(pushInput);

    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(ApiEnum.FAIL.code(), "推送内容解密时出错！");
    }
  }

  /**
   * 颜色中文名称转换为对应颜色值
   *
   * @param colorString colorString
   */
  private Byte convertColorCode(final String colorString) {
    Byte color = 7;
    switch (colorString) {
      case "白套红橙":
        color = 0;
        break;
      case "白套玫瑰金":
        color = 1;
        break;
      case "白套苹果绿":
        color = 2;
        break;
      case "红橙套黑":
        color = 3;
        break;
      case "红套黑":
        color = 4;
        break;
      case "黄/黑":
        color = 5;
        break;
      case "黄套黑":
        color = 6;
        break;
      case "蓝白套":
        color = 7;
        break;
      case "苹果绿/白":
        color = 8;
        break;
      case "深空黑/红橙":
        color = 9;
        break;
      case "紫白套":
        color = 10;
        break;

    }

    return color;
  }
}
