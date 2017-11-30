package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.SrvHost;


public enum SrvHostResolver{
	
		状态(new Resolver<SrvHost>("shStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038893871L;

			@Override
			public <T> T execute(SrvHost record) {
					if(record.getShStatus()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("status",record.getShStatus());
					return (T)result;
					}
		})
	;
	
	Resolver<SrvHost> resolver;
	SrvHostResolver(Resolver<SrvHost> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<SrvHost> getResolver(){
		return this.resolver;
	}
	
}
