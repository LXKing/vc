package com.ccclubs.mongo.orm.dao.impl;

import com.ccclubs.frm.mongo.constants.MongoConstants;
import com.ccclubs.mongo.orm.dao.BaseDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * baseDao
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
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
    @Qualifier("historyMongoTemplate")
    private MongoTemplate historyMongoTemplate;

    @Autowired
    @Qualifier("remoteMongoTemplate")
    private MongoTemplate remoteMongoTemplate;

    @Override
    public List<T> list(Query query) {
        String packageName = this.getClazz().getPackage().getName();
        switch (packageName) {
            case MongoConstants.HISTORY_PACKAGE_SCAN:
                return this.historyMongoTemplate.find(query, this.getClazz());
            case MongoConstants.REMOTE_PACKAGE_SCAN:
                return this.remoteMongoTemplate.find(query, this.getClazz());
            default:
                return this.historyMongoTemplate.find(query, this.getClazz());
        }
    }

    @Override
    public T findOne(Query query) {
        String packageName = this.getClazz().getPackage().getName();
        switch (packageName) {
            case MongoConstants.HISTORY_PACKAGE_SCAN:
                return this.historyMongoTemplate.findOne(query, this.getClazz());
            case MongoConstants.REMOTE_PACKAGE_SCAN:
                return this.remoteMongoTemplate.findOne(query, this.getClazz());
            default:
                return this.historyMongoTemplate.findOne(query, this.getClazz());
        }
    }

    @Override
    public void update(Query query, Update update) {
        if (null != update) {
            update.set("lastModifiedDate", DateTime.now());
        }
        String packageName = this.getClazz().getPackage().getName();
        switch (packageName) {
            case MongoConstants.HISTORY_PACKAGE_SCAN:
                this.historyMongoTemplate.findAndModify(query, update, this.getClazz());
                break;
            case MongoConstants.REMOTE_PACKAGE_SCAN:
                this.remoteMongoTemplate.findAndModify(query, update, this.getClazz());
                break;
            default:
                this.historyMongoTemplate.findAndModify(query, update, this.getClazz());
                break;
        }
    }

    @Override
    public T save(T entity) {
        String packageName = this.getClazz().getPackage().getName();
        try {
            switch (packageName) {
                case MongoConstants.HISTORY_PACKAGE_SCAN:
                    this.historyMongoTemplate.insert(entity);
                    break;
                case MongoConstants.REMOTE_PACKAGE_SCAN:
                    this.remoteMongoTemplate.insert(entity);
                    break;
                default:
                    this.historyMongoTemplate.insert(entity);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return entity;
    }

    /**
     * 通过id来加载数据对象
     */
    @Override
    public T findById(Object id) {
        String packageName = this.getClazz().getPackage().getName();
        switch (packageName) {
            case MongoConstants.HISTORY_PACKAGE_SCAN:
                return this.historyMongoTemplate.findById(id, this.getClazz());
            case MongoConstants.REMOTE_PACKAGE_SCAN:
                return this.remoteMongoTemplate.findById(id, this.getClazz());
            default:
                return this.historyMongoTemplate.findById(id, this.getClazz());
        }
    }

    @Override
    public List<T> list() {
        String packageName = this.getClazz().getPackage().getName();
        switch (packageName) {
            case MongoConstants.HISTORY_PACKAGE_SCAN:
                return this.historyMongoTemplate.findAll(getClazz());
            case MongoConstants.REMOTE_PACKAGE_SCAN:
                return this.remoteMongoTemplate.findAll(getClazz());
            default:
                return this.historyMongoTemplate.findAll(getClazz());
        }

    }

    @Override
    public void deleteById(Object id) {
        String packageName = this.getClazz().getPackage().getName();
        switch (packageName) {
            case MongoConstants.HISTORY_PACKAGE_SCAN:
                this.historyMongoTemplate.remove(new Query(Criteria.where("_id").is(id)),
                        this.getClazz());
                break;
            case MongoConstants.REMOTE_PACKAGE_SCAN:
                this.remoteMongoTemplate.remove(new Query(Criteria.where("_id").is(id)),
                        this.getClazz());
                break;
            default:
                this.historyMongoTemplate.remove(new Query(Criteria.where("_id").is(id)),
                        this.getClazz());
                break;
        }
    }
}
