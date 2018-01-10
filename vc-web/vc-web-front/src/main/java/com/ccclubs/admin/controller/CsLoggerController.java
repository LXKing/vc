package com.ccclubs.admin.controller;

import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.mongo.orm.model.history.CsLogger;
import com.ccclubs.mongo.orm.query.CsLoggerQuery;
import com.ccclubs.mongo.srv.CsLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CsLogger
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@SuppressWarnings("unused")
@RestController
@RequestMapping("history/csLogger")
public class CsLoggerController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CsLoggerService csLoggerService;

    /**
     * 获取分页列表数据
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<CsLogger> list(CsLoggerQuery query,
                                      @RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "10") Integer rows) {
        Page<CsLogger> pageResult = csLoggerService.getPage(query, new PageRequest(page, rows));
        TableResult<CsLogger> tableResult = new TableResult<>(pageResult);
        return tableResult;
    }

}
