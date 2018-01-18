package com.ccclubs.frm.mongo.listener;

import com.ccclubs.frm.mongo.constants.MongoConstants;
import com.ccclubs.frm.mongo.document.LZPrimary;
import com.ccclubs.frm.spring.annotation.AutomaticSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 *
 *
 * @author jianghaiyang
 * @create 2018-01-09
 **/
@Component
public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {

    @Autowired
    @Qualifier("historyMongoTemplate")
    private MongoTemplate historyMongoTemplate;
    @Autowired
    @Qualifier("remoteMongoTemplate")
    private MongoTemplate remoteMongoTemplate;

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Object> event) {
        if (event != null && event.getSource() != null) {
            ReflectionUtils
                .doWithFields(event.getSource().getClass(), field -> {
                    ReflectionUtils.makeAccessible(field);
                    if (field.isAnnotationPresent(AutomaticSequence.class)) {
                        //设置自增ID
                        String collectionName = event.getSource().getClass().getSimpleName();
                        String packageName = event.getSource().getClass().getPackage().getName();
                        if (event.getSource().getClass().isAnnotationPresent(Document.class)) {
                            Document documentAnnotation = event.getSource().getClass()
                                    .getAnnotation(Document.class);
                            collectionName = documentAnnotation.collection();
                        }

                        field.set(event.getSource(), getNextId(packageName, collectionName));

                    }
                });
        }
    }

    @Override
    public void onBeforeSave(final BeforeSaveEvent<Object> event) {
        super.onBeforeSave(event);
    }

    /**
     * 获取下一个自增ID
     *
     * @param collName 集合名
     */
    private Long getNextId(String packageName, String collName) {
        // 集合名最好使用全类名，防止重复
        Query query = new Query(Criteria.where("name").is(collName));
        Update update = new Update();
        update.inc("id", 1L);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);
        options.returnNew(true);
        LZPrimary seqId;
        switch (packageName) {
            case MongoConstants.HISTORY_PACKAGE_SCAN:
                seqId = historyMongoTemplate
                        .findAndModify(query, update, options, LZPrimary.class);
                break;
            case MongoConstants.REMOTE_PACKAGE_SCAN:
                seqId = remoteMongoTemplate
                        .findAndModify(query, update, options, LZPrimary.class);
                break;
            default:
                seqId = historyMongoTemplate
                        .findAndModify(query, update, options, LZPrimary.class);
                break;
        }

        return seqId.getSequenceId() + 1;
    }
}
