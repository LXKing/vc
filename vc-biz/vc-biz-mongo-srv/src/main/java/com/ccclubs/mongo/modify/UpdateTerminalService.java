package com.ccclubs.mongo.modify;

import com.ccclubs.frm.cache.CacheConstants;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsMachineMapper;
import com.ccclubs.pub.orm.mapper.CsTerminalMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsTerminal;
import com.jarvis.cache.annotation.Cache;
import com.jarvis.cache.annotation.ExCache;
import com.jarvis.cache.type.CacheOpType;
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

  /**
   * 更新车机信息{@link CsMachine} 并返回更新后的结果
   */
  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsMachine:csmId:'+#args[0].csmId", condition = "!#empty(#args[0])", opType = CacheOpType.WRITE, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsMachine:csmNumber:'+#retVal.csmNumber", condition = "!#empty(#retVal) && !#empty(#retVal.csmNumber)"),
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsMachine:csmMobile:'+#retVal.csmMobile", condition = "!#empty(#retVal) && !#empty(#retVal.csmMobile)"),
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsMachine:csmTeNo:'+#retVal.csmTeNo", condition = "!#empty(#retVal) && !#empty(#retVal.csmTeNo)")})
  public CsMachine update(CsMachine machine) {

    if (null == machine.getCsmId()) {
      throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
    }
    int result = csMachineDao.updateByPrimaryKeySelective(machine);
    if (result > 0) {
      return csMachineDao.selectByPrimaryKey(machine.getCsmId());
    }
    return null;
  }

  /**
   * 新增终端信息{@link CsTerminal}
   */
  public int insert(CsTerminal terminal) {
    return dao.insertSelective(terminal);
  }


  /**
   * 更新终端信息{@link CsTerminal}
   */
  @Cache(expire = CacheConstants.NEVER_EXPIRE, key = "'CsTerminal:cstId:'+#args[0].cstId", opType = CacheOpType.WRITE, condition = "!#empty(#args[0])", exCache = {
      @ExCache(expire = CacheConstants.NEVER_EXPIRE, key = "'CsTerminal:cstIdd:'+#retVal.cstIdd", condition = "!#empty(#retVal)")})
  public CsTerminal update(CsTerminal terminal) {
    if (null == terminal.getCstId()) {
      throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
    }
    int result = dao.updateByPrimaryKeySelective(terminal);
    if (result > 0) {
      return dao.selectByPrimaryKey(terminal.getCstId());
    }
    return null;
  }
}
