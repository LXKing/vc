package com.ccclubs.common.query;

import com.ccclubs.frm.cache.CacheConstants;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.CsVehicleExample;
import com.jarvis.cache.annotation.Cache;
import com.jarvis.cache.annotation.ExCache;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 车辆查询
 *
 * @author jianghaiyang
 * @create 2017-07-11
 **/
@Component
public class QueryVehicleService {

  @Autowired
  CsVehicleMapper dao;

  /**
   * 查询车辆，由于存在批量注册车辆，查询车辆暂时不走缓存
   *
   * @param vin 车辆VIN码
   * @return 车辆CsVehicle
   */
//  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvVin:'+#args[0]", autoload = true, exCache = {
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvId:'+#retVal.csvId", condition = "!#empty(#retVal) && !#empty(#retVal.csvId)"),
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvMachine:'+#retVal.csvMachine", condition = "!#empty(#retVal) && !#empty(#retVal.csvMachine) && #retVal.csvMachine > 0")})
  public CsVehicle queryVehicleByVin(String vin) {
    CsVehicleExample example = new CsVehicleExample();
    CsVehicleExample.Criteria criteria = example.createCriteria();
    criteria.andCsvVinEqualTo(vin);
    List<CsVehicle> list = dao.selectByExample(example);
    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvMachine:'+#args[0]", autoload = true, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvId:'+#retVal.csvId", condition = "!#empty(#retVal) && !#empty(#retVal.csvId)"),
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvVin:'+#retVal.csvVin", condition = "!#empty(#retVal) && !#empty(#retVal.csvVin)")})
  public CsVehicle queryVehicleByMachine(Integer machine) {
    CsVehicleExample example = new CsVehicleExample();
    CsVehicleExample.Criteria criteria = example.createCriteria();
    criteria.andCsvMachineEqualTo(machine);
    List<CsVehicle> list = dao.selectByExample(example);
    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvId:'+#args[0]", autoload = true, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvVin:'+#retVal.csvVin", condition = "!#empty(#retVal) && !#empty(#retVal.csvVin)"),
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvMachine:'+#retVal.csvMachine", condition = "!#empty(#retVal) && !#empty(#retVal.csvMachine) && #retVal.csvMachine > 0")})
  public CsVehicle queryVehicleById(Integer id) {
    return dao.selectByPrimaryKey(id);
  }
}
