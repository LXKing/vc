package com.ccclubs.mongo.orm.dao.impl;

import com.ccclubs.mongo.orm.dao.CsHistoryStateDao;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import java.util.List;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 状态历史dao
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class CsHistoryStateDaoImpl extends BaseDaoImpl<CsHistoryState> implements
    CsHistoryStateDao {

  private final String collection = "CsHistoryState";

  @Override
  public CsHistoryState save(CsHistoryState entity) {
    try {
      if (null != entity && !StringUtils.isEmpty(entity.getCshsNumber())) {
        getMongoTemplate()
            .insert(entity, getCollectionName(entity.getCshsNumber()));
      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
    return entity;
  }

  @Override
  public void batchInsert(List<CsHistoryState> batchList) {
    getMongoTemplate().insertAll(batchList);
  }

  /**
   * 根据车机号获取 mongodb collection 名
   */
  private String getCollectionName(String cshsNumber) {
    if (!StringUtils.isEmpty(cshsNumber)) {
      return new StringBuilder().append(collection).append("_")
          .append(Math.abs(cshsNumber.replace("%", "").toLowerCase().hashCode()) % 255).toString();
    }
    return collection;
  }
}
