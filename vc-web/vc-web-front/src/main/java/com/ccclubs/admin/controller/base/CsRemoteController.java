package com.ccclubs.admin.controller.base;

import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.orm.query.CsRemoteQuery;
import com.ccclubs.mongo.service.impl.CsRemoteService;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CsRemote
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@SuppressWarnings("unused")
@RestController
@RequestMapping("monitor/historyRemote")
public class CsRemoteController {

    private static final long ONE_MOUTH = 2592000000L;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CsRemoteService csRemoteService;

    /**
     * 获取分页列表数据
     *
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

        TableResult<CsRemote> tableResult = new TableResult<>();
        //时间校验
        if(query.getStartTime() != null && query.getEndTime() != null) {
            long startTimeLong = query.getStartTime().getTime();
            long endTimeLong = query.getEndTime().getTime();
            long timeLong = endTimeLong - startTimeLong;
            if (timeLong > ONE_MOUTH) {
                return tableResult;
            }
        }
        if(query.getStartTime() != null && query.getEndTime() == null) {
            long endTimeLong = query.getStartTime().getTime() + ONE_MOUTH;
            query.setEndTime(new Date(endTimeLong));
        }
        if(query.getStartTime() == null && query.getEndTime() != null) {
            long startTimeLong = query.getEndTime().getTime() - ONE_MOUTH;
            query.setStartTime(new Date(startTimeLong));
        }

        PageInfo<CsRemote> pageResult = csRemoteService.getPage(query, new PageRequest(page,
                rows, new Sort(Sort.Direction.DESC, order)));
        List<CsRemote> list = pageResult.getList();
        for (CsRemote data : list) {
            registResolvers(data);
        }
        tableResult.setPage(new Page(page, rows, pageResult.getTotal()));
        tableResult.setData(pageResult.getList() == null ? new ArrayList<>() : pageResult.getList());
        return tableResult;
    }

    /**
     * 删除数据
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete/{ids}", method = RequestMethod.DELETE)
    public int list(@PathVariable("ids") String ids) {
        return csRemoteService.delete(ids);
    }


    /**
     * 注册属性内容解析器
     */
    void registResolvers(CsRemote data) {
        if (data != null) {
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.授权系统.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.车机号.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.关联车辆.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.发送方式.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.指令类型.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.发送状态.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.操作结果.getResolver());
        }
    }
}
