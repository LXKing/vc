package com.ccclubs.admin.resolver;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.ccclubs.mongo.orm.model.remote.CsRemote;


public enum CsRemoteResolver{
	
		授权系统(new Resolver<CsRemote>("csrAccessText", com.ccclubs.admin.metadata.MetaDef.getAccessName) {
		private static final long serialVersionUID = 2038884176L;

		@Override
		public <T> T execute(CsRemote record) {
				if(record.getCsrAccess()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCsrAccess());
				return (T)result;
				}
		})
	,
		车机号(new Resolver<CsRemote>("csrNumberText") {
		private static final long serialVersionUID = 2038857512L;

		@Override
		public <T> T execute(CsRemote record) {
				if(record.getCsrNumber()==null){
				return null;
				}
				return (T)record.getCsrNumber();
				}
		})
	,
		关联车辆(new Resolver<CsRemote>("csrCarText", com.ccclubs.admin.metadata.MetaDef.getVehicleVin) {
		private static final long serialVersionUID = 2038884068L;

		@Override
		public <T> T execute(CsRemote record) {
				if(record.getCsrCar()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCsrCar());
				return (T)result;
				}
		})
	,
		发送方式(new Resolver<CsRemote>("csrWayText") {
		private static final long serialVersionUID = 2038837276L;

		@Override
		public <T> T execute(CsRemote record) {
				if(record.getCsrWay()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCsrWay().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "网关";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "短信";
				}
			}

				return (T)result;
				}
		})
	,
		指令类型(new Resolver<CsRemote>("csrTypeText", com.ccclubs.admin.metadata.MetaDef.getStructName) {
		private static final long serialVersionUID = 2038811846L;

		@Override
		public <T> T execute(CsRemote record) {
				if(record.getCsrType()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCsrType().longValue());
				return (T)result;
				}
		})
	,
		发送状态(new Resolver<CsRemote>("csrStateText") {
		private static final long serialVersionUID = 2038850160L;

		@Override
		public <T> T execute(CsRemote record) {
				if(record.getCsrState()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCsrState().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "未发送";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "已发送";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "组装中";
				}
			}

				return (T)result;
				}
		})
	,
		操作结果(new Resolver<CsRemote>("csrStatusText") {
		private static final long serialVersionUID = 2038875188L;

		@Override
		public <T> T execute(CsRemote record) {
				if(record.getCsrStatus()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCsrStatus().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "未知";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "操作成功";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "操作失败";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<CsRemote> resolver;
	CsRemoteResolver(Resolver<CsRemote> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsRemote> getResolver(){
		return this.resolver;
	}
	
}
