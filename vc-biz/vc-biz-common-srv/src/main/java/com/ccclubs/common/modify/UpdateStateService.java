package com.ccclubs.common.modify;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.dao.CsHistoryStateDao;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.pub.orm.mapper.CsStateMapper;
import com.ccclubs.pub.orm.model.CsState;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 车机状态数据更新服务
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class UpdateStateService {

  @Autowired
  CsStateMapper dao;
  @Autowired
  CsHistoryStateDao hisDao;


  //  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssId:'+#args[0].cssId", opType = CacheOpType.WRITE, condition = "!#empty(#args[0])", exCache = {
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssNumber:'+#retVal.cssNumber", condition = "!#empty(#retVal) && !#empty(#retVal.cssNumber)"),
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsState:cssCar:'+#retVal.cssCar", condition = "!#empty(#retVal) && !#empty(#retVal.cssCar) && #retVal.cssCar > 0")})
  public CsState update(CsState csState) {
    if (csState.getCssId() == null) {
      throw new ApiException(ApiEnum.UPDATE_ID_NOT_SET);
    }

    int result = dao.updateByPrimaryKeySelective(csState);
    if (result > 0) {
      return dao.selectByPrimaryKey(csState.getCssId());
    }

    return null;
  }

  public CsState insert(CsState csState) {
    dao.insertSelective(csState);
    return csState;
  }

  /**
   * 批量更新
   *
   * @param batchList 等待批量更新的list
   */
  public void batchUpdate(List<CsState> batchList) {
    dao.batchUpdate(batchList);
  }

  public CsHistoryState insertHis(CsHistoryState hisState) {
    return hisDao.save(hisState);
  }

  public void batchInsertHistory(List<CsHistoryState> hisStateList) {
    hisDao.batchInsert(hisStateList);
  }
}
