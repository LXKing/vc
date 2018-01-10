/**
 * 国标协议实时数据数据项
 * @type {{VEHICLE_DATA: number, DRIVE_MOTOR_DATA: number, FUEL_CEL_DATA: number, Engine_DATA: number, VEHICLE_LOCATION_DATA: number, EXTREME_DATA: number, ALARM_DATA: number, RECHARGEABLE_STORAGE_DEVICE_VOLTAGE_DATA: number, RECHARGEABLE_STORAGE_DEVICE_TEMPERATURE_DATA: number}}
 */
const GBMessageType = {
  VEHICLE_DATA: 1,//整车数据
  DRIVE_MOTOR_DATA: 2,//驱动电机数据
  FUEL_CEL_DATA: 3,//燃料电池数据
  Engine_DATA: 4,//发动机数据
  VEHICLE_LOCATION_DATA: 5,//车辆位置数据
  EXTREME_DATA: 6,//极值数据
  ALARM_DATA: 7,//报警数据
  RECHARGEABLE_STORAGE_DEVICE_VOLTAGE_DATA: 8,//可充电储能装置电压数据
  RECHARGEABLE_STORAGE_DEVICE_TEMPERATURE_DATA: 9//可充电储能装置温度数据
}

/**
 * 获取指定类型得扩展数据项
 * @param gbMessage 国标协议结构
 * @param type 获取指定得扩展数据项
 * @returns {null}
 */
function getGBMessageAdditional(gbMessage, type) {
  if (null === gbMessage || null === gbMessage.header || null
      === gbMessage.messageContents || null
      === gbMessage.messageContents.additionals || 0
      === gbMessage.messageContents.additionals.length) {
    return null;
  }

  for (var index = 0, length = gbMessage.messageContents.additionals.length;
      index < length; index++) {
    if (type === gbMessage.messageContents.additionals[index].additionalId) {
      return gbMessage.messageContents.additionals[index];
    }
  }

  return null;
}

/**
 * 获取报文时间
 * @param gbMessage
 * @returns {null}
 */
function getGBMessageTime(gbMessage) {
  if (null === gbMessage || null === gbMessage.header || null
      === gbMessage.messageContents || null
      === gbMessage.messageContents.time ) {
    return null;
  }

  return gbMessage.messageContents.time;
}

/**
 * 获取报文VIN
 * @param gbMessage
 * @returns {null}
 */
function getGBMessageVin(gbMessage) {
  if (null === gbMessage || null === gbMessage.header  ) {
    return null;
  }

  return gbMessage.header.vin;
}