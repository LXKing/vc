package com.ccclubs.common.query;

import com.ccclubs.mongo.orm.dao.BaseDao;
import com.ccclubs.mongo.orm.model.VcVehicleKeyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-09-27
 **/
@Component
public class QueryVehicleKeyStatusService {

  @Autowired
  private BaseDao<VcVehicleKeyStatus> vehicleKeyStatusBaseDao;

  /**
   * 依据车机号，业务订单号查询已有记录
   */
  public VcVehicleKeyStatus queryVehicleKeyStatus(String terminalNo, Long transNo) {
    Query query = new Query(
        Criteria.where("terminalNumber").is(terminalNo).and("transOrderId").is(transNo));
    return vehicleKeyStatusBaseDao.findOne(query);
  }

  /**
   * 已经主键id 查询已有记录
   */
  public VcVehicleKeyStatus queryVehicleKeyStatusById(Long id) {
    Query query = new Query(Criteria.where("_id").is(id));
    return vehicleKeyStatusBaseDao.findOne(query);
  }

}
