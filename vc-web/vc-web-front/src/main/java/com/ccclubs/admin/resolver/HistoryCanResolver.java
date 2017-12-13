package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.HistoryCan;


public enum HistoryCanResolver{
	;
	
	Resolver<HistoryCan> resolver;
	HistoryCanResolver(Resolver<HistoryCan> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<HistoryCan> getResolver(){
		return this.resolver;
	}
	
}
