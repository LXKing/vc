package com.ccclubs.admin.service.impl;


import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.CsTerminalMapper;
import com.ccclubs.admin.model.CsTerminal;
import com.ccclubs.admin.service.ICsTerminalService;

/**
 * TBox注册信息的Service实现
 * @author Joel
 */
@Service
public class CsTerminalServiceImpl extends CrudService<CsTerminalMapper, CsTerminal, Long> implements ICsTerminalService{
	
}