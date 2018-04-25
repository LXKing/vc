package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.CsState;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum CsStateResolver{
	
		接入商(new Resolver<CsState>("cssAccessText", com.ccclubs.admin.metadata.MetaDef.getAccessName) {
		private static final long serialVersionUID = 2038874920L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssAccess()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCssAccess().intValue());
				return (T)result;
				}
		})
	,
		车机号(new Resolver<CsState>("cssNumberText") {
		private static final long serialVersionUID = 2038890774L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssNumber()==null){
				return null;
				}
				return (T)record.getCssNumber();
				}
		})
	,
		车辆(new Resolver<CsState>("cssCarText", com.ccclubs.admin.metadata.MetaDef.getVehicleVin) {
		private static final long serialVersionUID = 203881639L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssCar()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCssCar());
				return (T)result;
				}
		})
	,
		充电状态(new Resolver<CsState>("cssChargingText") {
		private static final long serialVersionUID = 2038875246L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssCharging()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssCharging().toString().split(",");
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
		GPS有效性(new Resolver<CsState>("cssGpsValidText") {
		private static final long serialVersionUID = 2038819218L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssGpsValid()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssGpsValid().toString().split(",");
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
		循环模式(new Resolver<CsState>("cssCircularText") {
		private static final long serialVersionUID = 2038847474L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssCircular()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssCircular().toString().split(",");
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
		PTC启停(new Resolver<CsState>("cssPtcText") {
		private static final long serialVersionUID = 2038854131L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssPtc()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssPtc().toString().split(",");
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
		压缩机(new Resolver<CsState>("cssCompresText") {
		private static final long serialVersionUID = 2038835310L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssCompres()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssCompres().toString().split(",");
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
		档风量(new Resolver<CsState>("cssFanText") {
		private static final long serialVersionUID = 2038847635L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssFan()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssFan().toString().split(",");
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
		功耗模式(new Resolver<CsState>("cssSavingText") {
		private static final long serialVersionUID = 2038865496L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssSaving()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssSaving().toString().split(",");
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
		发动机状态(new Resolver<CsState>("cssEngineText") {
		private static final long serialVersionUID = 2038818144L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssEngine()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssEngine().toString().split(",");
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
		档位(new Resolver<CsState>("cssGearText") {
		private static final long serialVersionUID = 2038854506L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssGear()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssGear().toString().split(",");
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
	,
		网络类型(new Resolver<CsState>("cssNetTypeText") {
		private static final long serialVersionUID = 2038822653L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssNetType()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssNetType().toString().split(",");
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
		手刹状态(new Resolver<CsState>("cssHandbrakeText") {
		private static final long serialVersionUID = 2038840112L;

		@Override
		public <T> T execute(CsState record) {
				if(record.getCssHandbrake()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssHandbrake().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "所有刹车释放";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "所有刹车应用";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "所有刹车不工作（应用或释放中）";
				}
				if(sArr[i].equals("3")){
					result+=(i==0?"":",")+ "未知";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<CsState> resolver;
	CsStateResolver(Resolver<CsState> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsState> getResolver(){
		return this.resolver;
	}
	
}
