package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.SrvUser;


public enum SrvUserResolver{
	;
	
	Resolver<SrvUser> resolver;
	SrvUserResolver(Resolver<SrvUser> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<SrvUser> getResolver(){
		return this.resolver;
	}
	
}
