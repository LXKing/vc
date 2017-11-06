package com.ccclubs.frm.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qsxiaogang
 * @create 2017-11-06
 **/
public class VehicleControlLogger {

  private static Logger vehicleControlLogger = LoggerFactory.getLogger(VehicleControlLogger.class);

  public static Logger getLogger() {
    return vehicleControlLogger;
  }
}
