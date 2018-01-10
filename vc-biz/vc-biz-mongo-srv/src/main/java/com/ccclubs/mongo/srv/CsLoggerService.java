package com.ccclubs.mongo.srv;

import com.ccclubs.mongo.orm.model.history.CsLogger;
import com.ccclubs.mongo.orm.query.CsLoggerQuery;
import com.ccclubs.mongo.orm.repository.history.CsLoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@Service
public class CsLoggerService {
    @Autowired
    private CsLoggerRepository csLoggerRepository;

    public Page<CsLogger> getPage(CsLoggerQuery query, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("cslNumber",
                ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<CsLogger> example = Example.of(query, matcher);
        return csLoggerRepository.findAll(example, pageable);
    }
}
