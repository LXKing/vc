package com.ccclubs.manage.inf;

import com.ccclubs.manage.dto.CsStateInput;
import com.ccclubs.manage.dto.CsStateOutput;
import com.ccclubs.manage.orm.model.CsState;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 10:36
 * Email:fengjun@ccclubs.com
 */
public interface CsStateInf {

    PageInfo<CsState> getCsStatePage(CsStateInput csStateInput);
    CsStateOutput getCsStateAll(CsStateInput csStateInput);
    CsState getCsState(CsStateInput csStateInput);
    List<CsState> getCsStateList(CsStateInput csStateInput);
}
