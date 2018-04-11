package com.ccclubs.admin.resolver;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.ccclubs.admin.model.CsCan;


public enum CsCanResolver{
	
		接入商(new Resolver<CsCan>("cscAccessText", com.ccclubs.admin.metadata.MetaDef.getAccessName) {
		private static final long serialVersionUID = 203882608L;

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
		private static final long serialVersionUID = 2038876737L;

		@Override
		public <T> T execute(CsCan record) {
				if(record.getCscNumber()==null){
				return null;
				}
				return (T)record.getCscNumber();
				}
		})
	,
		车辆(new Resolver<CsCan>("cscCarText", com.ccclubs.admin.metadata.MetaDef.getVehicleVin) {
		private static final long serialVersionUID = 2038869534L;

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
		private static final long serialVersionUID = 2038874589L;

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
	,
		状态(new Resolver<CsCan>("cscStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038842244L;

			@Override
			public <T> T execute(CsCan record) {
					if(record.getCscStatus()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("status",record.getCscStatus());
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
