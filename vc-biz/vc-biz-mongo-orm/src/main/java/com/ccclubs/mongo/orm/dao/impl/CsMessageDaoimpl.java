package com.ccclubs.mongo.orm.dao.impl;

import com.ccclubs.mongo.orm.dao.CsMessageDao;
import com.ccclubs.mongo.orm.model.CsMessage;
import java.util.List;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.stereotype.Component;

/**
 * 报文
 *
 * @author jianghaiyang
 * @create 2017-08-09
 **/
@Component
public class CsMessageDaoimpl extends BaseDaoImpl<CsMessage> implements CsMessageDao {

  @Override
  public void batchInsert(List<CsMessage> batchList) {
    getMongoTemplate().insertAll(batchList);
  }
}
