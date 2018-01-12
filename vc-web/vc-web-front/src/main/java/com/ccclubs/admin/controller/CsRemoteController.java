package com.ccclubs.admin.controller;

import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.orm.query.CsRemoteQuery;
import com.ccclubs.mongo.service.impl.CsRemoteService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * CsRemote
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@SuppressWarnings("unused")
@RestController
@RequestMapping("history/csRemote")
public class CsRemoteController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CsRemoteService csRemoteService;

    /**
     * 获取分页列表数据
     * @param query
     * @param page
     * @param rows
     * @param order
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<CsRemote> list(CsRemoteQuery query,
                                      @RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "10") Integer rows,
                                      @RequestParam(defaultValue = "csrAddTime") String order) {
        PageInfo<CsRemote> pageResult = csRemoteService.getPage(query, new PageRequest(page, rows, new Sort(Sort.Direction.DESC, order)));

        TableResult<CsRemote> tableResult = new TableResult<>(page, rows, pageResult);
        return tableResult;
    }

    /**
     * 删除数据
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete/{ids}", method = RequestMethod.DELETE)
    public int list(@PathVariable("ids") String ids) {
        return csRemoteService.delete(ids);
    }

}
