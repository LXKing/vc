package com.ccclubs.quota.inf;

import com.ccclubs.quota.orm.model.DriveMilesBasicZt;
import com.ccclubs.quota.orm.model.DriveMilesBizQuota;
import com.ccclubs.quota.orm.model.DriveMilesQuota;
import com.ccclubs.quota.vo.DriveMilesBasicZtInput;
import com.ccclubs.quota.vo.DriveMilesBizQuotaInput;
import com.ccclubs.quota.vo.DriveMilesQuotaInput;
import com.github.pagehelper.PageInfo;

public interface DriveMilesQuotaInf {
	PageInfo<DriveMilesBizQuota> bizQuota(DriveMilesBizQuotaInput input);
	PageInfo<DriveMilesBasicZt> bizQuotaDetail(DriveMilesBasicZtInput input);
	
	PageInfo<DriveMilesQuota> calcQuota(DriveMilesQuotaInput input);
	void quotaBuilder();
}
