package com.ccclubs.quota.inf.data;

import com.ccclubs.quota.orm.model.CsCan;
import com.ccclubs.quota.orm.model.CsCanBiz;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.data.CsCanAddInput;
import com.ccclubs.quota.vo.data.CsCanQueryInput;
import com.github.pagehelper.PageInfo;

public interface CsCanInf {
	void add(CsCanAddInput input);
	void del(BaseDeleteInput input);
	void mod(CsCanAddInput input);
	CsCan mod(Integer cssId);
	PageInfo<CsCanBiz> que(CsCanQueryInput input);
}
