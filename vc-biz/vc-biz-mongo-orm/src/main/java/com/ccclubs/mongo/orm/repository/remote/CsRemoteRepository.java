package com.ccclubs.mongo.orm.repository.remote;

import com.ccclubs.mongo.orm.model.remote.CsRemote;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 指令记录
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
public interface CsRemoteRepository extends MongoRepository<CsRemote, Long> {
}
