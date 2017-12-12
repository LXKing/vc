package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsStatistics;


public enum CsStatisticsResolver{
	;
	
	Resolver<CsStatistics> resolver;
	CsStatisticsResolver(Resolver<CsStatistics> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsStatistics> getResolver(){
		return this.resolver;
	}
	
}
