package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsCan;


public enum CsCanResolver{
	
		接入商(new Resolver<CsCan>("cscAccessText", com.ccclubs.admin.metadata.MetaDef.getAccessName) {
		private static final long serialVersionUID = 2038837967L;

		@Override
		public <T> T execute(CsCan record) {
				if(record.getCscAccess()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCscAccess());
				return (T)result;
				}
		})
	,
		车机号(new Resolver<CsCan>("cscNumberText") {
		private static final long serialVersionUID = 2038860732L;

		@Override
		public <T> T execute(CsCan record) {
				if(record.getCscNumber()==null){
				return null;
				}
				String result = "";
				return (T)result;
				}
		})
	,
		车辆(new Resolver<CsCan>("cscCarText", com.ccclubs.admin.metadata.MetaDef.getVehicleVin) {
		private static final long serialVersionUID = 2038888684L;

		@Override
		public <T> T execute(CsCan record) {
				if(record.getCscCar()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCscCar());
				return (T)result;
				}
		})
	,
		CAN类型(new Resolver<CsCan>("cscTypeText") {
		private static final long serialVersionUID = 2038867203L;

		@Override
		public <T> T execute(CsCan record) {
				if(record.getCscType()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCscType().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "29bit";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "11bit";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<CsCan> resolver;
	CsCanResolver(Resolver<CsCan> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsCan> getResolver(){
		return this.resolver;
	}
	
}
