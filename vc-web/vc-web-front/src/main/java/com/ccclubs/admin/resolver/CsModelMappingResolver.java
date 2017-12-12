package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsModelMapping;


public enum CsModelMappingResolver{
	
		主机厂用户(new Resolver<CsModelMapping>("userIdText", com.ccclubs.admin.metadata.MetaDef.getUserName) {
		private static final long serialVersionUID = 2038849391L;

		@Override
		public <T> T execute(CsModelMapping record) {
				if(record.getUserId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getUserId());
				return (T)result;
				}
		})
	,
		车型(new Resolver<CsModelMapping>("modelIdText", com.ccclubs.admin.metadata.MetaDef.getVehicleModelName) {
		private static final long serialVersionUID = 2038825982L;

		@Override
		public <T> T execute(CsModelMapping record) {
				if(record.getModelId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getModelId());
				return (T)result;
				}
		})
	;
	
	Resolver<CsModelMapping> resolver;
	CsModelMappingResolver(Resolver<CsModelMapping> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsModelMapping> getResolver(){
		return this.resolver;
	}
	
}
