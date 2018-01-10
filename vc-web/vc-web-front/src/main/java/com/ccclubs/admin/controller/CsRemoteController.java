package com.ccclubs.admin.controller;

import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.orm.query.CsRemoteQuery;
import com.ccclubs.mongo.srv.CsRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CsRemote
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@SuppressWarnings("unused")
@RestController
@RequestMapping("command/csRemote")
public class CsRemoteController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CsRemoteService csRemoteService;

    /**
     * 获取分页列表数据
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<CsRemote> list(CsRemoteQuery query,
                                      @RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "10") Integer rows) {
        Page<CsRemote> pageResult = csRemoteService.getPage(query, new PageRequest(page, rows));
        TableResult<CsRemote> tableResult = new TableResult<>(pageResult);
        return tableResult;
    }

}
