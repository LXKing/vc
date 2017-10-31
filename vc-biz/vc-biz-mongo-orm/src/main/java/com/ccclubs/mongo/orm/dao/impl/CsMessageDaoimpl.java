package com.ccclubs.mongo.orm.dao.impl;

import com.ccclubs.mongo.orm.dao.CsMessageDao;
import com.ccclubs.mongo.orm.model.CsMessage;
import java.util.List;
import javax.annotation.Resource;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * 报文
 *
 * @author jianghaiyang
 * @create 2017-08-09
 **/
@Component
public class CsMessageDaoimpl implements CsMessageDao {

  @Resource(name = "gbStandardMongoTemplate")
  private MongoTemplate mongoTemplate;

  @Override
  public void batchInsert(List<CsMessage> batchList) {
    mongoTemplate.insertAll(batchList);
  }

  @Override
  public List<CsMessage> list(Query query) {
    return this.mongoTemplate.find(query, CsMessage.class);
  }

  @Override
  public List<CsMessage> list() {
    return this.mongoTemplate.findAll(CsMessage.class);
  }

  @Override
  public CsMessage findById(Object id) {
    return mongoTemplate.findById(id, CsMessage.class);
  }

  @Override
  public CsMessage findOne(Query query) {
    return this.mongoTemplate.findOne(query, CsMessage.class);
  }

  @Override
  public void update(Query query, Update update) {
    if (null != update) {
      update.set("lastModifiedDate", DateTime.now());
    }
    mongoTemplate.findAndModify(query, update, CsMessage.class);
  }

  @Override
  public CsMessage save(CsMessage entity) {
    try {
      mongoTemplate.insert(entity);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
    return entity;
  }

  @Override
  public void deleteById(Object id) {
    mongoTemplate.remove(new Query(Criteria.where("_id").is(id)),
        CsMessage.class);
  }
}
