package com.ccclubs.mongo.orm.repository.history;

import com.ccclubs.mongo.orm.model.history.CsLogger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * CsLogger
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/

public interface CsLoggerRepository extends MongoRepository<CsLogger, String> {
}
