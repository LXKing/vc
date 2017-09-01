package com.ccclubs.mongodb.orm.dao;

import java.util.List;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public interface BaseDao<T> {

  List<T> list(Query query);

  List<T> list();

  T findById(Object id);

  T findOne(Query query);

  void update(Query query, Update update);

//  void update(T entry);

  T save(T entity);

  void deleteById(Object id);
}
