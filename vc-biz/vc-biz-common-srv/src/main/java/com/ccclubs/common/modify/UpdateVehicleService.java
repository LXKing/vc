package com.ccclubs.common.modify;

import com.ccclubs.frm.cache.CacheConstants;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.jarvis.cache.annotation.Cache;
import com.jarvis.cache.annotation.ExCache;
import com.jarvis.cache.type.CacheOpType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 修改车辆信息
 *
 * @author jianghaiyang
 * @create 2017-07-24
 **/
@Component
public class UpdateVehicleService {

  @Autowired
  CsVehicleMapper dao;

  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvId:'+#args[0].csvId", opType = CacheOpType.WRITE, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvVin:'+#retVal.csvVin", condition = "!#empty(#retVal) && !#empty(#retVal.csvVin)"),
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvMachine:'+#retVal.csvMachine", condition = "!#empty(#retVal) && !#empty(#retVal.csvMachine) && #retVal.csvMachine > 0")})
  public CsVehicle update(CsVehicle vehicle) {

    if (vehicle.getCsvId() == null) {
      throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
    }

    int result = dao.updateByPrimaryKeySelective(vehicle);
    if (result > 0) {
      return dao.selectByPrimaryKey(vehicle.getCsvId());
    }

    return null;
  }
}
