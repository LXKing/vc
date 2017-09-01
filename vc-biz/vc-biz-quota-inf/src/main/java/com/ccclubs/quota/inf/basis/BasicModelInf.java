package com.ccclubs.quota.inf.basis;

import com.ccclubs.quota.orm.model.CsModel;
import com.ccclubs.quota.vo.basis.BasicModelAddInput;
import com.ccclubs.quota.vo.basis.BasicModelDelInput;
import com.ccclubs.quota.vo.basis.BasicModelQueryInput;
import com.github.pagehelper.PageInfo;

public interface BasicModelInf {
	void add(BasicModelAddInput input);
	void del(BasicModelDelInput input);
	void mod(BasicModelAddInput input);
	CsModel mod(Integer csmId);
	PageInfo<CsModel> que(BasicModelQueryInput input);
}
