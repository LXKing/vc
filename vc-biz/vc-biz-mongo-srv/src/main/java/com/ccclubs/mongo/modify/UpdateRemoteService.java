package com.ccclubs.mongo.modify;

import com.ccclubs.mongo.orm.dao.CsRemoteDao;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

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
    Update update = new Update();
    if (null != remote.getCsrAccess()) {
      update.set("csrAccess", remote.getCsrAccess());
    }
    if (null != remote.getCsrHost()) {
      update.set("csrHost", remote.getCsrHost());
    }
    if (StringUtils.isNotEmpty(remote.getCsrNumber())) {
      update.set("csrNumber", remote.getCsrNumber());
    }
    if (null != remote.getCsrCar()) {
      update.set("csrCar", remote.getCsrCar());
    }
    if (null != remote.getCsrWay()) {
      update.set("csrWay", remote.getCsrWay());
    }
    if (null != remote.getCsrType()) {
      update.set("csrType", remote.getCsrType());
    }
    if (StringUtils.isNotEmpty(remote.getCsrCode())) {
      update.set("csrCode", remote.getCsrCode());
    }
    if (StringUtils.isNotEmpty(remote.getCsrResultCode())) {
      update.set("csrResultCode", remote.getCsrResultCode());
    }
    if (StringUtils.isNotEmpty(remote.getCsrResult())) {
      update.set("csrResult", remote.getCsrResult());
    }
    if (StringUtils.isNotEmpty(remote.getCsrEditor())) {
      update.set("csrEditor", remote.getCsrEditor());
    }
    if (StringUtils.isNotEmpty(remote.getCsrRemark())) {
      update.set("csrRemark", remote.getCsrRemark());
    }
    if (null != remote.getCsrState()) {
      update.set("csrState", remote.getCsrState());
    }
    if (null != remote.getCsrStatus()) {
      update.set("csrStatus", remote.getCsrStatus());
    }
    if (StringUtils.isNotEmpty(remote.getCsrResultCode())) {
      update.set("csrResultCode", remote.getCsrResultCode());
    }

    update.set("csrUpdateTime", System.currentTimeMillis());

    dao.update(query, update);
  }
}
