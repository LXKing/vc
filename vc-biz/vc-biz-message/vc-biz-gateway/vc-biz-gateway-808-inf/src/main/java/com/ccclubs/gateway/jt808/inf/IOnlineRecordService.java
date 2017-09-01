package com.ccclubs.gateway.jt808.inf;


public interface IOnlineRecordService {

//	public void checkOnline(GPSRealData rd);

  // 创建上线下线状态变化的记录，记录变化的起止时间和间隔，及经纬度坐标
  //public void createOnlineChangeRecord(GPSRealData rd, String alarmType);

  void stopService();


  void updateConnectedState(String simNo, Boolean isConnected);

  Boolean isConnected(String simNo);

}