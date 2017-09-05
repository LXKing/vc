package com.ccclubs.common.modify;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsMachineMapper;
import com.ccclubs.pub.orm.mapper.CsTerminalMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsTerminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
@Component
public class UpdateTerminalService {

    @Autowired
    CsTerminalMapper dao;

    @Autowired
    CsMachineMapper csMachineDao;

    public CsTerminal update(CsTerminal terminal) {

        if (terminal.getCstId() == null) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        dao.updateByPrimaryKeySelective(terminal);
        return terminal;
    }

    public CsMachine update(CsMachine machine) {

        if (machine.getCsmId() == null) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        csMachineDao.updateByPrimaryKeySelective(machine);
        return machine;
    }

    public void insert(CsTerminal terminal) {
        dao.insertSelective(terminal);

    }

}
