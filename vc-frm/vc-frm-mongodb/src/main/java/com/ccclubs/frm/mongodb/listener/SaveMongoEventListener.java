package com.ccclubs.frm.mongodb.listener;

import com.ccclubs.frm.mongodb.document.LZPrimary;
import com.ccclubs.frm.mongodb.lang.AutomaticSequence;
import java.lang.reflect.Field;
import javax.annotation.Resource;
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

@Component
public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {

  @Resource
  private MongoTemplate mongoTemplate;

  @Override
  public void onBeforeConvert(final BeforeConvertEvent<Object> event) {
    if (event != null && event.getSource() != null) {

      ReflectionUtils
          .doWithFields(event.getSource().getClass(), new ReflectionUtils.FieldCallback() {
            public void doWith(Field field)
                throws IllegalArgumentException, IllegalAccessException {
              ReflectionUtils.makeAccessible(field);
              if (field.isAnnotationPresent(AutomaticSequence.class)) {
                //设置自增ID
                String collectionName = event.getSource().getClass().getSimpleName();
                if (event.getSource().getClass().isAnnotationPresent(Document.class)) {
                  Document documentAnnotation = event.getSource().getClass()
                      .getAnnotation(Document.class);
                  collectionName = documentAnnotation.collection();
                }

                field.set(event.getSource(), getNextId(collectionName));
              }
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
  private Long getNextId(String collName) {
    Query query = new Query(Criteria.where("name").is(collName));
    Update update = new Update();
    update.inc("id", 1L);
    FindAndModifyOptions options = new FindAndModifyOptions();
    options.upsert(true);
    options.returnNew(true);
    LZPrimary seqId = mongoTemplate
        .findAndModify(query, update, options, LZPrimary.class);
    return seqId.getSequenceId() + 1;
  }
}
