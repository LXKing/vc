package com.ccclubs.mongo.orm.dao;

import com.ccclubs.mongo.orm.model.CsMessage;
import java.util.List;

/**
 * 报文
 *
 * @author jianghaiyang
 * @create 2017-08-09
 **/
public interface CsMessageDao extends BaseDao<CsMessage> {

  /**
   * 批量写入
   */
  void batchInsert(List<CsMessage> batchList);
}

