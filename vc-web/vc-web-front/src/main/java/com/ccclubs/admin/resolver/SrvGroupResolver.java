package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.SrvGroup;


public enum SrvGroupResolver{
	
		状态(new Resolver<SrvGroup>("sgStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038887754L;

			@Override
			public <T> T execute(SrvGroup record) {
					if(record.getSgStatus()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("status",record.getSgStatus());
					return (T)result;
					}
		})
	;
	
	Resolver<SrvGroup> resolver;
	SrvGroupResolver(Resolver<SrvGroup> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<SrvGroup> getResolver(){
		return this.resolver;
	}
	
}
