package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.VerUpManage;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum VerUpManageResolver {
	
		升级状态(new Resolver<VerUpManage>("statusUpgradeText") {
		private static final long serialVersionUID = 2038853758L;

		@Override
		public <T> T execute(VerUpManage record) {
				if(record.getStatusUpgrade()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getStatusUpgrade().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "无升级";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "升级中";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "升级失败";
				}
				if(sArr[i].equals("3")){
					result+=(i==0?"":",")+ "升级成功";
				}
			}

				return (T)result;
				}
		})
	,
		当前版本(new Resolver<VerUpManage>("verCurIdText", com.ccclubs.admin.metadata.MetaDef.getUpgradeVersionNo) {
		private static final long serialVersionUID = 2038890610L;

		@Override
		public <T> T execute(VerUpManage record) {
				if(record.getVerCurId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getVerCurId());
				return (T)result;
				}
		})
	,
		车型(new Resolver<VerUpManage>("modelIdText", com.ccclubs.admin.metadata.MetaDef.getVehicleModelName) {
		private static final long serialVersionUID = 2038820272L;

		@Override
		public <T> T execute(VerUpManage record) {
				if(record.getModelId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getModelId());
				return (T)result;
				}
		})
	,
		车辆VIN码(new Resolver<VerUpManage>("vehicleIdText", com.ccclubs.admin.metadata.MetaDef.getVehicleVin) {
		private static final long serialVersionUID = 203887768L;

		@Override
		public <T> T execute(VerUpManage record) {
				if(record.getVehicleId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getVehicleId());
				return (T)result;
				}
		})
	;
	
	Resolver<VerUpManage> resolver;
	VerUpManageResolver(Resolver<VerUpManage> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<VerUpManage> getResolver(){
		return this.resolver;
	}
	
}
