package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.HistoryGb;


public enum HistoryGbResolver{
	
		协议类型(new Resolver<HistoryGb>("csProtocolText") {
		private static final long serialVersionUID = 2038886175L;

		@Override
		public <T> T execute(HistoryGb record) {
				if(record.getCsProtocol()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCsProtocol().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "国标";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "地标";
				}
			}

				return (T)result;
				}
		})
	,
		报文类型(new Resolver<HistoryGb>("gbTypeText") {
		private static final long serialVersionUID = 2038852666L;

		@Override
		public <T> T execute(HistoryGb record) {
				if(record.getGbType()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getGbType().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "未知";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "车辆登入";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "实时上报";
				}
				if(sArr[i].equals("3")){
					result+=(i==0?"":",")+ "补发上报";
				}
				if(sArr[i].equals("4")){
					result+=(i==0?"":",")+ "车辆登出";
				}
				if(sArr[i].equals("5")){
					result+=(i==0?"":",")+ "平台登入";
				}
				if(sArr[i].equals("6")){
					result+=(i==0?"":",")+ "平台登出";
				}
				if(sArr[i].equals("7")){
					result+=(i==0?"":",")+ "心跳";
				}
				if(sArr[i].equals("8")){
					result+=(i==0?"":",")+ "终端校时";
				}
			}

				return (T)result;
				}
		})
	,
		校验结果(new Resolver<HistoryGb>("csVerifyText") {
		private static final long serialVersionUID = 2038880736L;

		@Override
		public <T> T execute(HistoryGb record) {
				if(record.getCsVerify()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCsVerify().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "失败";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "成功";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<HistoryGb> resolver;
	HistoryGbResolver(Resolver<HistoryGb> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<HistoryGb> getResolver(){
		return this.resolver;
	}
	
}
