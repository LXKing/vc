package com.ccclubs.mongo.orm.dao;

import com.ccclubs.mongo.orm.model.CsHistoryState;
import java.util.List;

/**
 * 状态历史dao
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
public interface CsHistoryStateDao extends BaseDao<CsHistoryState>{

  /**
   * 批量写入
   */
  void batchInsert(List<CsHistoryState> batchList);
}
