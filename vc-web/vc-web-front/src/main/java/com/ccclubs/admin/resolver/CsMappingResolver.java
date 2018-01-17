package com.ccclubs.admin.resolver;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.ccclubs.admin.model.CsMapping;


public enum CsMappingResolver{
	;
	
	Resolver<CsMapping> resolver;
	CsMappingResolver(Resolver<CsMapping> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsMapping> getResolver(){
		return this.resolver;
	}
	
}
