package com.ccclubs.common.modify;

import com.ccclubs.mongodb.orm.dao.CsRemoteDao;
import com.ccclubs.mongodb.orm.model.CsRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 更新指令记录
 *
 * @author jianghaiyang
 * @create 2017-08-28
 **/
@Component
public class UpdateRemoteService {
    @Autowired
    CsRemoteDao dao;

    public void update(CsRemote remote) {
        Query query = new Query(Criteria.where("csrId").is(remote.getCsrId()));
        Update update = new Update().set("csrAccess", remote.getCsrAccess())
                .set("csrHost", remote.getCsrHost())
                .set("csrNumber", remote.getCsrNumber())
                .set("csrCar", remote.getCsrCar())
                .set("csrWay", remote.getCsrWay())
                .set("csrType", remote.getCsrType())
                .set("csrCode", remote.getCsrCode())
                .set("csrResultCode", remote.getCsrResultCode())
                .set("csrResult", remote.getCsrResult())
                .set("csrEditor", remote.getCsrEditor())
                .set("csrRemark", remote.getCsrRemark())
                .set("csrUpdateTime", new Date().getTime())
                .set("csrState", remote.getCsrState())
                .set("csrStatus", remote.getCsrStatus());

        dao.update(query, update);
    }
}
