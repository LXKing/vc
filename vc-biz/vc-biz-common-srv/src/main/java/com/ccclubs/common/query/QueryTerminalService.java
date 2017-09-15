package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.CsMachineMapper;
import com.ccclubs.pub.orm.mapper.CsTerminalMapper;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 查询终端
 *
 * @author jianghaiyang
 * @create 2017-07-11
 **/
@Component
public class QueryTerminalService {
    @Autowired
    CsMachineMapper mdao;

    @Autowired
    CsTerminalMapper tdao;

    @Autowired
    CsVehicleMapper vdao;

    /**
     * 查询终端
     *
     * @param teNo 终端序列号
     * @return 终端cs
     */
    //@Cacheable(cacheNames = "terminals", key = "#teNo")
    public CsMachine queryTerminalByTeNo(String teNo) {
        CsMachineExample example = new CsMachineExample();
        CsMachineExample.Criteria criteria = example.createCriteria();
        criteria.andCsmTeNoEqualTo(teNo);
        List<CsMachine> list = mdao.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public CsTerminal queryCsTerminalByCstIdd(String cstIdd){

        CsTerminalExample terminalExample=new CsTerminalExample();
        CsTerminalExample.Criteria terminalCriteria=terminalExample.createCriteria();
        terminalCriteria.andCstIddEqualTo(cstIdd);
        List<CsTerminal>list= tdao.selectByExample(terminalExample);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

     public CsMachine queryCsMachineBySimNo(String simNo){
        CsMachineExample machineExample = new CsMachineExample();
        CsMachineExample.Criteria  machineCriteria= machineExample.createCriteria();
        machineCriteria.andCsmMobileEqualTo(simNo);
        List<CsMachine> list= mdao.selectByExample(machineExample);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
     }

    public CsMachine queryTerminalByCarNumber(String carNumber) {
        CsMachineExample machineExample = new CsMachineExample();
        CsMachineExample.Criteria  machineCriteria= machineExample.createCriteria();
        machineCriteria.andCsmNumberEqualTo(carNumber);
        List<CsMachine> list= mdao.selectByExample(machineExample);
        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    public CsMachine queryCsMachineById(Integer id){
        CsMachine machine= mdao.selectByPrimaryKey(id);
        return machine;
    }
}
