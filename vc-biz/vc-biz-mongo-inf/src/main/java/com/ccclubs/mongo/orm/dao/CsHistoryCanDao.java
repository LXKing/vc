package com.ccclubs.mongo.orm.dao;

import com.ccclubs.mongo.orm.model.CsHistoryCan;
import java.util.List;

/**
 * can历史dao
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
public interface CsHistoryCanDao extends BaseDao<CsHistoryCan> {

  /**
   * 批量写入
   */
  void batchInsert(List<CsHistoryCan> batchList);
}
