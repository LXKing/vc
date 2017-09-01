package com.ccclubs.mongodb.orm.dao.impl;

import com.ccclubs.mongodb.orm.dao.BaseDao;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class BaseDaoImpl<T> implements BaseDao<T> {

  private Class<T> clazz;

  private Class<T> getClazz() {
    if (this.clazz == null) {
      ParameterizedType type = (ParameterizedType) getClass()
          .getGenericSuperclass();
      this.clazz = ((Class) type.getActualTypeArguments()[0]);
    }
    return this.clazz;
  }

  @Autowired
  private MongoTemplate mongoTemplate;

  public List<T> list(Query query) {
    return this.mongoTemplate.find(query, this.getClazz());
  }

  public T findOne(Query query) {
    return this.mongoTemplate.findOne(query, this.getClazz());
  }

  public void update(Query query, Update update) {
    mongoTemplate.findAndModify(query, update, this.getClazz());
  }


  public T save(T entity) {
    try {
      mongoTemplate.insert(entity);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
    return entity;
  }

  /**
   * 通过id来加载数据对象
   */
  public T findById(Object id) {
    return mongoTemplate.findById(id, this.getClazz());
  }

  /**
   * 更新我们的实体类
   */
//  public void update(T entry) {
//    try {
//      Object id = BeanUtils.getProperty(entry, "id");
//
//      final Update update = new Update();
//      Field[] fields = this.getClazz().getDeclaredFields();
//      for (Field field : fields) {
//        String fieldName = field.getName();
//        if (!field.isAnnotationPresent(AutomaticSequence.class) && !field.isAnnotationPresent(
//            Id.class)&&!field.isAnnotationPresent(Version.class)&&!"serialVersionUID".equals(fieldName)) {
//          update.set(fieldName, BeanUtils.getProperty(entry, fieldName));
//        }
//      }
//
//      this.mongoTemplate.updateFirst(
//          new Query(Criteria.where("_id").is(id)), update,
//          this.getClazz());
//    } catch (Exception e) {
//      throw new RuntimeException(e.getMessage());
//    }
//  }
  public List<T> list() {
    return this.mongoTemplate.findAll(getClazz());
  }

  public void deleteById(Object id) {
    mongoTemplate.remove(new Query(Criteria.where("_id").is(id)),
        this.getClazz());
  }
}
