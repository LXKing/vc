package com.ccclubs.quota.inf.monitor;

import com.ccclubs.quota.orm.model.CsStructWithBLOBs;
import com.ccclubs.quota.vo.BaseDeleteKeysInput;
import com.ccclubs.quota.vo.monitor.CsStructAddInput;
import com.ccclubs.quota.vo.monitor.CsStructQueryInput;
import com.github.pagehelper.PageInfo;

public interface CsStructInf {
	void add(CsStructAddInput input);
	void del(BaseDeleteKeysInput input);
	void mod(CsStructAddInput input);
	CsStructWithBLOBs mod(Long cssId);
	PageInfo<CsStructWithBLOBs> que(CsStructQueryInput input);
}
