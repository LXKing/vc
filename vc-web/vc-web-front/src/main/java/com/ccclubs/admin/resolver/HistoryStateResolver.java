package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.frm.spring.entity.DateTimeUtil;


public enum HistoryStateResolver{
		下位机时间(new Resolver<HistoryState>("currentTimeText") {
			@Override
			public <T> T execute(HistoryState record) {
				if (null==record.getCurrentTime()){
					return null;
				}
				String result = "";
				result= DateTimeUtil.getDateTimeByFormat1(record.getCurrentTime());
				return (T) result;
			}
		})
		,添加时间(new Resolver<HistoryState>("addTimeText") {
		@Override
		public <T> T execute(HistoryState record) {
			if (null==record.getAddTime()){
				return null;
			}
			String result = "";
			result= DateTimeUtil.getDateTimeByFormat1(record.getAddTime());
			return (T) result;
		}
	})

		,充电状态(new Resolver<HistoryState>("chargingStatusText") {
		private static final long serialVersionUID = 2038853257L;

		@Override
		public <T> T execute(HistoryState record) {
				if(record.getChargingStatus()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getChargingStatus().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "未充电";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "慢充";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "快充";
				}
				if(sArr[i].equals("3")){
					result+=(i==0?"":",")+ "充电完成";
				}
			}

				return (T)result;
				}
		})
	,
		gps有效性(new Resolver<HistoryState>("gpsValidText") {
		private static final long serialVersionUID = 2038861751L;

		@Override
		public <T> T execute(HistoryState record) {
				if(record.getGpsValid()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getGpsValid().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "无效";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "有效";
				}
			}

				return (T)result;
				}
		})
	,
		循环模式(new Resolver<HistoryState>("circularModeText") {
		private static final long serialVersionUID = 2038849053L;
		@Override
		public <T> T execute(HistoryState record) {
				if(record.getCircularMode()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCircularMode().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "内循环";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "外循环";
				}
			}

				return (T)result;
				}
		})
	,
		PTC启停(new Resolver<HistoryState>("ptcStatusText") {
		private static final long serialVersionUID = 2038817042L;

		@Override
		public <T> T execute(HistoryState record) {
				if(record.getPtcStatus()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getPtcStatus().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "OFF";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "ON";
				}
			}

				return (T)result;
				}
		})
	,
		压缩机状态(new Resolver<HistoryState>("compreStatusText") {
		private static final long serialVersionUID = 2038812914L;

		@Override
		public <T> T execute(HistoryState record) {
				if(record.getCompreStatus()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCompreStatus().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "OFF";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "ON";
				}
			}

				return (T)result;
				}
		})
	,
		档风量(new Resolver<HistoryState>("fanModeText") {
		private static final long serialVersionUID = 2038822203L;

		@Override
		public <T> T execute(HistoryState record) {
				if(record.getFanMode()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getFanMode().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "OFF";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "1档";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "2档";
				}
				if(sArr[i].equals("3")){
					result+=(i==0?"":",")+ "3档";
				}
				if(sArr[i].equals("4")){
					result+=(i==0?"":",")+ "4档";
				}
			}

				return (T)result;
				}
		})
	,
		省电模式(new Resolver<HistoryState>("savingModeText") {
		private static final long serialVersionUID = 2038877668L;

		@Override
		public <T> T execute(HistoryState record) {
				if(record.getSavingMode()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getSavingMode().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "标准模式";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "最佳省电";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "极度省电";
				}
			}

				return (T)result;
				}
		})
	,
		发动机(new Resolver<HistoryState>("engineStatusText") {
		private static final long serialVersionUID = 203881898L;

		@Override
		public <T> T execute(HistoryState record) {
				if(record.getEngineStatus()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getEngineStatus().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "无效";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "未熄火";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "已熄火";
				}
			}

				return (T)result;
				}
		})
	,
		网络类型(new Resolver<HistoryState>("netTypeText") {
		private static final long serialVersionUID = 2038877944L;

		@Override
		public <T> T execute(HistoryState record) {
				if(record.getNetType()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getNetType().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "GSM";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "3G/4G";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "CDMA";
				}
			}

				return (T)result;
				}
		})
	,
	档位(new Resolver<HistoryState>("gearText") {
		private static final long serialVersionUID = 2038815431L;

		@Override
		public <T> T execute(HistoryState record) {
			if(record.getgear()==null){
				return null;
			}
			String result = "";
			String[] sArr = record.getgear().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("11")){
					result+=(i==0?"":",")+ "11挡";
				}
				if(sArr[i].equals("12")){
					result+=(i==0?"":",")+ "12挡";
				}
				if(sArr[i].equals("13")){
					result+=(i==0?"":",")+ "倒挡";
				}
				if(sArr[i].equals("14")){
					result+=(i==0?"":",")+ "自动D挡";
				}
				if(sArr[i].equals("15")){
					result+=(i==0?"":",")+ "停车P挡";
				}
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "空挡";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "1挡";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "2挡";
				}
				if(sArr[i].equals("3")){
					result+=(i==0?"":",")+ "3挡";
				}
				if(sArr[i].equals("4")){
					result+=(i==0?"":",")+ "4挡";
				}
				if(sArr[i].equals("5")){
					result+=(i==0?"":",")+ "5挡";
				}
				if(sArr[i].equals("6")){
					result+=(i==0?"":",")+ "6挡";
				}
				if(sArr[i].equals("7")){
					result+=(i==0?"":",")+ "7挡";
				}
				if(sArr[i].equals("8")){
					result+=(i==0?"":",")+ "8挡";
				}
				if(sArr[i].equals("9")){
					result+=(i==0?"":",")+ "9挡";
				}
				if(sArr[i].equals("10")){
					result+=(i==0?"":",")+ "10挡";
				}
			}

			return (T)result;
		}
	})
	;
	
	Resolver<HistoryState> resolver;
	HistoryStateResolver(Resolver<HistoryState> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<HistoryState> getResolver(){
		return this.resolver;
	}
	
}
