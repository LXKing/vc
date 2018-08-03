package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.VerSoftHardware;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum VerSoftHardwareResolver{

    版本类型(new Resolver<VerSoftHardware>("typeText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
        private static final long serialVersionUID = 2038874699L;

        @Override
        public <T> T execute(VerSoftHardware record) {
            if(record.gettype()==null){
                return null;
            }
            String result = "";
            result = this.getDictMetaData().get("ver_upgrade_type",record.gettype());
            return (T)result;
        }
    })
    ;
	
	Resolver<VerSoftHardware> resolver;
	VerSoftHardwareResolver(Resolver<VerSoftHardware> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<VerSoftHardware> getResolver(){
		return this.resolver;
	}
	
}
