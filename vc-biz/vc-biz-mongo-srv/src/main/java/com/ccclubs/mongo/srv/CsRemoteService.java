package com.ccclubs.mongo.srv;

import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.orm.query.CsRemoteQuery;
import com.ccclubs.mongo.orm.repository.remote.CsRemoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 指令结果
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@Service
public class CsRemoteService {
    @Autowired
    private CsRemoteRepository csRemoteRepository;

    public Page<CsRemote> getPage(CsRemoteQuery query, Pageable pageable){
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("csrNumber",
                ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<CsRemote> example = Example.of(query, matcher);
        return csRemoteRepository.findAll(example, pageable);
    }
}
