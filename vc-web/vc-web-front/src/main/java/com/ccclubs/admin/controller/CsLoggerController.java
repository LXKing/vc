package com.ccclubs.admin.controller;

import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.mongo.orm.model.history.CsLogger;
import com.ccclubs.mongo.orm.query.CsLoggerQuery;
import com.ccclubs.mongo.service.impl.CsLoggerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * CsLogger
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@SuppressWarnings("unused")
@RestController
@RequestMapping("monitor/historyLogger")
public class CsLoggerController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CsLoggerService csLoggerService;

    /**
     * 获取分页列表数据
     * @param query
     * @param page
     * @param rows
     * @return
     */
    @ApiOperation(value = "获取日志分页记录",notes = "获取日志分页记录")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<CsLogger> list(CsLoggerQuery query,
                                      @RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "10") Integer rows) {
        PageInfo<CsLogger> pageResult = csLoggerService.getPage(query, new PageRequest(page, rows));
        List<CsLogger> list = pageResult.getList();
        for(CsLogger data : list){
            registResolvers(data);
        }
        TableResult<CsLogger> tableResult = new TableResult<>(page, rows, pageResult);
        return tableResult;
    }

    /**
     * 删除数据
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete/{ids}", method = RequestMethod.DELETE)
    public int list(@PathVariable("ids") String ids) {
        return csLoggerService.delete(ids);
    }

    /**
     * 注册属性内容解析器
     */
    void registResolvers(CsLogger data){
        if(data!=null){
            data.registResolver(com.ccclubs.admin.resolver.CsLoggerResolver.状态.getResolver());
        }
    }

}
