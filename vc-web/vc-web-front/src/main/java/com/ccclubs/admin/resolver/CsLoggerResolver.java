package com.ccclubs.admin.resolver;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.ccclubs.mongo.orm.model.history.CsLogger;

/**
 * 车机网络日志-解析器
 */
public enum CsLoggerResolver {

    状态(new Resolver<CsLogger>("cslStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
        private static final long serialVersionUID = 2038828781L;

        @Override
        public <T> T execute(CsLogger record) {
            if (record.getCslStatus() == null) {
                return null;
            }
            String result = "";
            result = this.getDictMetaData().get("status", record.getCslStatus());
            return (T) result;
        }
    });

    Resolver<CsLogger> resolver;

    CsLoggerResolver(Resolver<CsLogger> resolver) {
        this.resolver = resolver;
    }

    public String getName() {
        return this.resolver.getName();
    }

    public Resolver<CsLogger> getResolver() {
        return this.resolver;
    }

}
