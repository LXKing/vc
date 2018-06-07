package com.ccclubs.admin.resolver;


import com.ccclubs.admin.model.CsVehicleExp;
import com.ccclubs.frm.spring.resolver.Resolver;

public enum CsVehicleExpResolver{

	终端类型(new Resolver<CsVehicleExp>("csveTeTypeText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038877203L;

			@Override
			public <T> T execute(CsVehicleExp record) {
				if (record.getCsveTeType() == null) {
					return null;
					}
					String result = "";
				result = this.getDictMetaData().get("csm_te_type", record.getCsveTeType());
					return (T)result;
					}
		})
	;
	
	Resolver<CsVehicleExp> resolver;
	CsVehicleExpResolver(Resolver<CsVehicleExp> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsVehicleExp> getResolver(){
		return this.resolver;
	}
	
}
