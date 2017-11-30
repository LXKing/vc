package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsModel;


public enum CsModelResolver{
	
		动力类型(new Resolver<CsModel>("csmTypeText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038864698L;

			@Override
			public <T> T execute(CsModel record) {
					if(record.getCsmType()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("csm_type",record.getCsmType());
					return (T)result;
					}
		})
	,
		变速箱类型(new Resolver<CsModel>("csmFileText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 20388230L;

			@Override
			public <T> T execute(CsModel record) {
					if(record.getCsmFile()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("csm_file",record.getCsmFile());
					return (T)result;
					}
		})
	,
		车辆种类(new Resolver<CsModel>("csmCatagoryText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038828917L;

			@Override
			public <T> T execute(CsModel record) {
					if(record.getCsmCatagory()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("csm_catagory",record.getCsmCatagory());
					return (T)result;
					}
		})
	,
		状态(new Resolver<CsModel>("csmStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038865178L;

			@Override
			public <T> T execute(CsModel record) {
					if(record.getCsmStatus()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("status",record.getCsmStatus());
					return (T)result;
					}
		})
	;
	
	Resolver<CsModel> resolver;
	CsModelResolver(Resolver<CsModel> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsModel> getResolver(){
		return this.resolver;
	}
	
}
