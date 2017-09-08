package com.ccclubs.common.modify;

import com.ccclubs.mongo.orm.dao.CsLoggerDao;
import com.ccclubs.mongo.orm.model.CsLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 修改mongodb CsLogger
 *
 * @author qsxiaogang
 * @create 2017-08-07
 **/
@Component
public class UpdateLoggerService {

  @Autowired
  CsLoggerDao dao;

  public CsLogger save(String carNumber, String content, String hexString,
      Long order) {
    CsLogger csLogger = new CsLogger();
    csLogger.setCslNumber(carNumber);
    csLogger.setCslOrder(order);
    csLogger.setCslLog(content);
    csLogger.setCslData(hexString);
    csLogger.setCslAddTime(System.currentTimeMillis());
    csLogger.setCslStatus((short) 1);

    return save(csLogger);
  }

  public CsLogger save(CsLogger csLogger) {
    dao.save(csLogger);
    return csLogger;
  }
}
