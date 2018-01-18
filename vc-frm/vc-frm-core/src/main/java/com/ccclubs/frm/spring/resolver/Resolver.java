package com.ccclubs.frm.spring.resolver;

import java.io.Serializable;

public abstract class Resolver<E> implements Serializable{
	
	private static final long serialVersionUID = 4665456056850105408L;
	
	private String name;
	private IMetaData metadata;
	private IDictMetaData dictMetaData;

	public Resolver(String name){
		this.name = name;
	}
	
	public Resolver(String name, IMetaData metadata){
		this.name = name;
		this.metadata = metadata;
	}

	public Resolver(String name, IDictMetaData dictMetaData){
		this.name = name;
		this.dictMetaData = dictMetaData;
	}

	public IMetaData getMetadata(){
		return this.metadata;
	}

	public IDictMetaData getDictMetaData(){
		return this.dictMetaData;
	}
	
	public String getName() {
		return name;
	}

	public abstract <T> T execute(E record);
	
}
