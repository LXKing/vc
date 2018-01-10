package com.ccclubs.mongo.modify;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.dao.CsHistoryCanDao;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.pub.orm.mapper.CsCanMapper;
import com.ccclubs.pub.orm.model.CsCan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 更新can
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class UpdateCanService {

  @Autowired
  CsCanMapper dao;

  @Autowired
  CsHistoryCanDao hisDao;

  //  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsCan:cscId:'+#args[0].cscId", opType = CacheOpType.WRITE, exCache = {
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsCan:cscNumber:'+#retVal.cscNumber", condition = "!#empty(#retVal) && !#empty(#retVal.cscNumber)"),
//      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsCan:cscCar:'+#retVal.cscCar", condition = "!#empty(#retVal) && !#empty(#retVal.cscCar) && #retVal.cscCar > 0")})
  public CsCan update(CsCan can) {
    if (can.getCscId() == null) {
      throw new ApiException(ApiEnum.UPDATE_ID_NOT_SET);
    }

    int result = dao.updateByPrimaryKey(can);
    if (result > 0) {
      return dao.selectByPrimaryKey(can.getCscId());
    }

    return null;
  }

  /**
   * 批量更新
   *
   * @param batchList 等待批量更新的list
   */
  public void batchUpdate(List<CsCan> batchList) {
    dao.batchUpdate(batchList);
  }


  public CsCan insert(CsCan csCan) {
    dao.insertSelective(csCan);
    return csCan;
  }

  public CsHistoryCan insertHis(CsHistoryCan hisCan) {
    return hisDao.save(hisCan);
  }

  public void batchInsertHistory(List<CsHistoryCan> hisCanList) {
    hisDao.batchInsert(hisCanList);
  }
}
