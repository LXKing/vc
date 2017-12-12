package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.HistoryState;


public enum HistoryStateResolver{
	;
	
	Resolver<HistoryState> resolver;
	HistoryStateResolver(Resolver<HistoryState> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<HistoryState> getResolver(){
		return this.resolver;
	}
	
}
