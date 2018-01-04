package com.ccclubs.common.query;

import com.ccclubs.frm.cache.CacheConstants;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.CsVehicleExample;
import com.jarvis.cache.annotation.Cache;
import com.jarvis.cache.annotation.ExCache;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 车辆查询
 *
 * @author jianghaiyang
 * @create 2017-07-11
 **/
@Component
public class QueryVehicleService {

  @Resource
  CsVehicleMapper dao;

  /**
   * 查询车辆，由于存在批量注册车辆，查询车辆暂时不走缓存
   *
   * @param vin 车辆VIN码
   * @return 车辆CsVehicle
   */
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

  /**
   * 查询车辆，由于存在批量注册车辆，查询车辆暂时不走缓存
   *
   * @param carNo 车辆车牌号码
   * @return 车辆 CsVehicle
   */
  public CsVehicle queryVehicleByCarNo(String carNo) {
    CsVehicleExample example = new CsVehicleExample();
    CsVehicleExample.Criteria criteria = example.createCriteria();
    criteria.andCsvCarNoEqualTo(carNo);
    List<CsVehicle> list = dao.selectByExample(example);
    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  /**
   * 查询车辆，由于存在批量注册车辆，查询车辆暂时不走缓存
   *
   * @param engineNo 车辆发动机号码
   * @return 车辆 CsVehicle
   */
  public CsVehicle queryVehicleByEngineNo(String engineNo) {
    CsVehicleExample example = new CsVehicleExample();
    CsVehicleExample.Criteria criteria = example.createCriteria();
    criteria.andCsvEngineNoEqualTo(engineNo);
    List<CsVehicle> list = dao.selectByExample(example);
    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvVin:'+#args[0]", autoload = true, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvId:'+#retVal.csvId", condition = "!#empty(#retVal) && !#empty(#retVal.csvId)"),
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvMachine:'+#retVal.csvMachine", condition = "!#empty(#retVal) && !#empty(#retVal.csvMachine) && #retVal.csvMachine > 0")})
  public CsVehicle queryVehicleByVinFromCache(String vin) {
    return queryVehicleByVin(vin);
  }

  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvMachine:'+#args[0]", autoload = true, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvId:'+#retVal.csvId", condition = "!#empty(#retVal) && !#empty(#retVal.csvId)"),
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvVin:'+#retVal.csvVin", condition = "!#empty(#retVal) && !#empty(#retVal.csvVin)")})
  public CsVehicle queryVehicleByMachineFromCache(Integer machine) {
    return queryVehicleByMachine(machine);
  }

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


  public CsVehicle queryVehicleById(Integer vehicle) {
    return dao.selectByPrimaryKey(vehicle);
  }

  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvId:'+#args[0]", autoload = true, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvVin:'+#retVal.csvVin", condition = "!#empty(#retVal) && !#empty(#retVal.csvVin)"),
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsVehicle:csvMachine:'+#retVal.csvMachine", condition = "!#empty(#retVal) && !#empty(#retVal.csvMachine) && #retVal.csvMachine > 0")})
  public CsVehicle queryVehicleByIdFromCache(Integer id) {
    return queryVehicleById(id);
  }
}
