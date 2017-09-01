package com.ccclubs.gateway.jt808.inf;


public interface IAlarmService {

	//public abstract void updateOnlineTime(String simNo);
	boolean isAlarmEnabled(String alarmType, String alarmSource);

//	public abstract void processRealData(GPSRealData rd);

	public abstract void stopService();
	
//	public AlarmRecord CreateRecord(String alarmSource, String alarmType,
//			String alarmState, GPSRealData rd);

}