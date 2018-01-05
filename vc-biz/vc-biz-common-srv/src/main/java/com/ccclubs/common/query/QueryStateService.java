package com.ccclubs.common.query;

import com.ccclubs.frm.cache.CacheConstants;
import com.ccclubs.pub.orm.mapper.CsStateMapper;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsStateExample;
import com.jarvis.cache.annotation.Cache;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 状态数据查询
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class QueryStateService {

  @Resource
  CsStateMapper dao;

  /**
   * 通过 id 查询当前状态数据
   *
   * @param id {@link CsState} 主键
   */
//  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssId:'+#args[0]", autoload = true, exCache = {
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssNumber:'+#retVal.cssNumber", condition = "!#empty(#retVal) && !#empty(#retVal.cssNumber)"),
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssCar:'+#retVal.cssCar", condition = "!#empty(#retVal) && !#empty(#retVal.cssCar) && #retVal.cssCar > 0")})
  public CsState queryStateById(Integer id) {
    return dao.selectByPrimaryKey(id);
  }

  /**
   * 通过车机号查询当前状态数据
   *
   * @param csmNumber 车机号
   */
//  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssNumber:'+#args[0]", autoload = true, exCache = {
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssId:'+#retVal.cssId", condition = "!#empty(#retVal) && !#empty(#retVal.cssId)"),
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssCar:'+#retVal.cssCar", condition = "!#empty(#retVal) && !#empty(#retVal.cssCar) && #retVal.cssCar > 0")})
  public CsState queryStateByCsmNumber(String csmNumber) {
    if (StringUtils.isEmpty(csmNumber)) {
      return null;
    }

    CsStateExample stateExample = new CsStateExample();
    CsStateExample.Criteria stateExampleCriteria = stateExample.createCriteria();
    stateExampleCriteria.andCssNumberEqualTo(csmNumber);
    List<CsState> stateList = dao.selectByExample(stateExample);

    // 未查询到车辆实时状态
    if (stateList.size() > 0) {
      return stateList.get(0);
    }
    return null;
  }

  /**
   * 通过车辆id查询当前状态数据
   *
   * @param vehicleId 车辆id
   */
//  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssCar:'+#args[0]", autoload = true, condition = "#args[0] > 0", exCache = {
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssId:'+#retVal.cssId", condition = "!#empty(#retVal) && !#empty(#retVal.cssId)"),
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssNumber:'+#retVal.cssNumber", condition = "!#empty(#retVal) && !#empty(#retVal.cssNumber)")})
  public CsState queryStateByVehicleId(Integer vehicleId) {
    if (null == vehicleId) {
      return null;
    }

    CsStateExample stateExample = new CsStateExample();
    CsStateExample.Criteria stateExampleCriteria = stateExample.createCriteria();
    stateExampleCriteria.andCssCarEqualTo(vehicleId);
    List<CsState> stateList = dao.selectByExample(stateExample);

    // 未查询到车辆实时状态
    if (stateList.size() > 0) {
      return stateList.get(0);
    }
    return null;
  }

  /**
   * 让不含分时租赁插件的终端，查询时走缓存
   * @param id
   * @return
   */
//  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:jt808:cssId:'+#args[0]", autoload = true)
  public CsState queryStateByIdFor808(Integer id) {
    return dao.selectByPrimaryKey(id);
  }
}
