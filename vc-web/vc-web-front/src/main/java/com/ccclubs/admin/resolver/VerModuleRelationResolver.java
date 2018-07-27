package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.VerModuleRelation;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum VerModuleRelationResolver{

		模块描述(new Resolver<VerModuleRelation>("moduleValText", com.ccclubs.admin.metadata.MetaDef.getModuleDesByRelationId) {
			private static final long serialVersionUID = 1;

			@Override
			public <T> T execute(VerModuleRelation record) {
				if(record.getid()==null){
					return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getid());
				return (T)result;
			}
		})
	,
	
		是否支持(new Resolver<VerModuleRelation>("isSupText") {
		private static final long serialVersionUID = 2038868803L;

		@Override
		public <T> T execute(VerModuleRelation record) {
				if(record.getIsSup()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getIsSup().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "不支持";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "支持";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<VerModuleRelation> resolver;
	VerModuleRelationResolver(Resolver<VerModuleRelation> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<VerModuleRelation> getResolver(){
		return this.resolver;
	}
	
}
