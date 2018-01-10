package com.ccclubs.mongo.orm.dao.impl;

import com.ccclubs.mongo.orm.dao.CsHistoryCanDao;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import java.util.List;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * can历史
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class CsHistoryCanDaoImpl extends BaseDaoImpl<CsHistoryCan> implements CsHistoryCanDao {

  private final String collection = "CsHistoryCan";

  @Override
  public CsHistoryCan save(CsHistoryCan entity) {
    try {
      if (null != entity && !StringUtils.isEmpty(entity.getCshcNumber())) {
        getMongoTemplate()
            .insert(entity, getCollectionName(entity.getCshcNumber()));
      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
    return entity;
  }

  @Override
  public void batchInsert(List<CsHistoryCan> batchList) {
    getMongoTemplate().insertAll(batchList);
  }

  /**
   * 根据车机号获取 mongodb collection 名
   */
  private String getCollectionName(String cshcNumber) {
    if (!StringUtils.isEmpty(cshcNumber)) {
      return new StringBuilder().append(collection).append("_")
          .append(Math.abs(cshcNumber.replace("%", "").toLowerCase().hashCode()) % 255).toString();
    }
    return collection;
  }
}
