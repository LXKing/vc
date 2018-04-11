package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.GbState;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum GbStateResolver{
	;
	
	Resolver<GbState> resolver;
	GbStateResolver(Resolver<GbState> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<GbState> getResolver(){
		return this.resolver;
	}
	
}
