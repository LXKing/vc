package com.ccclubs.quota.inf;

import com.ccclubs.quota.orm.model.SocMilesBasicZt;
import com.ccclubs.quota.orm.model.SocMilesBizQuota;
import com.ccclubs.quota.orm.model.SocMilesQuota;
import com.ccclubs.quota.vo.SocMilesBasicZtInput;
import com.ccclubs.quota.vo.SocMilesBizQuotaInput;
import com.ccclubs.quota.vo.SocMilesQuotaInput;
import com.github.pagehelper.PageInfo;

public interface SocMilesQuotaInf {
	PageInfo<SocMilesBizQuota> bizQuota(SocMilesBizQuotaInput input);
	PageInfo<SocMilesBasicZt> bizQuotaDetail(SocMilesBasicZtInput input);
	
	PageInfo<SocMilesQuota> calcQuota(SocMilesQuotaInput input);
	void quotaBuilder();
}
