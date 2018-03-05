package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.VcJobTriggerInfo;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum VcJobTriggerInfoResolver{
	;
	
	Resolver<VcJobTriggerInfo> resolver;
	VcJobTriggerInfoResolver(Resolver<VcJobTriggerInfo> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<VcJobTriggerInfo> getResolver(){
		return this.resolver;
	}
	
}
