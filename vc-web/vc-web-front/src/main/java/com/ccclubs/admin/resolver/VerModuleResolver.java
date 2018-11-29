package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.VerModule;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum VerModuleResolver{

    模块类型(new Resolver<VerModule>("typeText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
        private static final long serialVersionUID = 2038857578L;

        @Override
        public <T> T execute(VerModule record) {
            if(record.gettype()==null){
                return null;
            }
            String result = "";
            result = this.getDictMetaData().get("ver_upgrade_type",record.gettype());
            return (T)result;
        }
    })
    ,
		数据类别(new Resolver<VerModule>("dataTypeText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038862968L;

			@Override
			public <T> T execute(VerModule record) {
					if(record.getDataType()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("data_type",record.getDataType());
					return (T)result;
					}
		})
	,
		数据项类别(new Resolver<VerModule>("dataItemTypeText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038842619L;

			@Override
			public <T> T execute(VerModule record) {
					if(record.getDataItemType()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("data_item_type",record.getDataItemType());
					return (T)result;
					}
		})
	;
	
	Resolver<VerModule> resolver;
	VerModuleResolver(Resolver<VerModule> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<VerModule> getResolver(){
		return this.resolver;
	}
	
}
