package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsVehicle;


public enum CsVehicleResolver{
	
		接入商(new Resolver<CsVehicle>("csvAccessText", com.ccclubs.admin.metadata.MetaDef.getAccessName) {
		private static final long serialVersionUID = 2038851498L;

		@Override
		public <T> T execute(CsVehicle record) {
				if(record.getCsvAccess()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCsvAccess());
				return (T)result;
				}
		})
	,
		车型(new Resolver<CsVehicle>("csvModelText", com.ccclubs.admin.metadata.MetaDef.getVehicleModelName) {
		private static final long serialVersionUID = 2038890723L;

		@Override
		public <T> T execute(CsVehicle record) {
				if(record.getCsvModel()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCsvModel());
				return (T)result;
				}
		})
	,
		车机设备(new Resolver<CsVehicle>("csvMachineText", com.ccclubs.admin.metadata.MetaDef.getMachineTeNo) {
		private static final long serialVersionUID = 2038881012L;

		@Override
		public <T> T execute(CsVehicle record) {
				if(record.getCsvMachine()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCsvMachine());
				return (T)result;
				}
		})
	,
		颜色(new Resolver<CsVehicle>("csvColorCodeText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038897457L;

			@Override
			public <T> T execute(CsVehicle record) {
					if(record.getCsvColorCode()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("color_code",record.getCsvColorCode());
					return (T)result;
					}
		})
	,
		地标类型(new Resolver<CsVehicle>("csvLandmarkText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038855108L;

			@Override
			public <T> T execute(CsVehicle record) {
					if(record.getCsvLandmark()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("landmark",record.getCsvLandmark());
					return (T)result;
					}
		})
	,
		状态(new Resolver<CsVehicle>("csvStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038834414L;

			@Override
			public <T> T execute(CsVehicle record) {
					if(record.getCsvStatus()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("status",record.getCsvStatus());
					return (T)result;
					}
		})
	;
	
	Resolver<CsVehicle> resolver;
	CsVehicleResolver(Resolver<CsVehicle> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsVehicle> getResolver(){
		return this.resolver;
	}
	
}
