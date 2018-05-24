package com.ccclubs.admin.controller.can;

import com.ccclubs.admin.controller.base.BaseController;
import com.ccclubs.admin.entity.CsCanCrieria;
import com.ccclubs.admin.entity.CsMappingCrieria;
import com.ccclubs.admin.model.*;
import com.ccclubs.admin.query.CsCanQuery;
import com.ccclubs.admin.service.ICsCanService;
import com.ccclubs.admin.service.ICsMappingService;
import com.ccclubs.admin.service.ICsModelMappingService;
import com.ccclubs.admin.service.ISrvGroupService;
import com.ccclubs.admin.util.UserAccessUtils;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆实时CAN信息Controller
 *
 * @author
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/monitor/can")
public class CsCanController {

    @Autowired
    ICsCanService csCanService;

    @Autowired
    UserAccessUtils userAccessUtils;

    @Autowired
    ISrvGroupService srvGroupService;

    @Autowired
    ICsModelMappingService csModelMappingService;

    @Autowired
    ICsMappingService csMappingService;
    /**
     * 获取分页列表数据
     *
     * @param query
     * @param page
     * @param rows
     * @return
     */
    @ApiOperation(value = "获取can列表数据", notes = "根据参数查询can报文分页列表数据")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public TableResult<CsCan> list(@CookieValue("token") String token, CsCanQuery query, @RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "10") Integer rows) {

        List<Integer> conditonField = new ArrayList<>();
        String authority = addQueryConditionsByUser(token, conditonField);
        if ("factory_user".equals(authority)) {
            if (conditonField.size() > 0) {
                Short[] cscModelIn = new Short[conditonField.size()];
                for (int i = 0; i < conditonField.size(); i++) {
                    cscModelIn[i] = (short) conditonField.get(i).intValue();
                }
                query.setCscModelIn(cscModelIn);
            }

        }
        PageInfo<CsCan> pageInfo = csCanService.getPage(query.getCrieria(), page, rows);
        List<CsCan> list = pageInfo.getList();
        for (CsCan data : list) {
            registResolvers(data);
        }

        TableResult<CsCan> r = new TableResult<>(pageInfo);
        return r;
    }


    public String addQueryConditionsByUser(String token, List<Integer> conditonField) {

        SrvUser user = userAccessUtils.getCurrentUser(token);
        //首先判断用户所在的组。
        SrvGroup srvGroup = srvGroupService.selectByPrimaryKey(user.getSuGroup().intValue());

        if (srvGroup.getSgFlag().equals("sys_user")) {
            //系统用户，此种用户可以随意查询（为所欲为）
            return "sys_user";
        } else if (srvGroup.getSgFlag().equals("factory_user")) {
            //车厂 （按照车型进行查询）
            CsModelMapping csModelMapping = new CsModelMapping();
            csModelMapping.setUserId(user.getSuId());
            List<CsModelMapping> csModelMappingList = csModelMappingService.select(csModelMapping);
            if (null != csModelMappingList && csModelMappingList.size() > 0) {
                Integer[] csModelIds = new Integer[csModelMappingList.size()];
                for (int i = 0; i < csModelMappingList.size(); i++) {
                    csModelIds[i] = csModelMappingList.get(i).getModelId();
                    //
                    conditonField.add(csModelMappingList.get(i).getModelId());
                }
            }
            return "factory_user";
        } else if (srvGroup.getSgFlag().equals("platform_user")) {
            //小散户（通过mapping进行对应）
            CsMappingCrieria csMappingCrieria = new CsMappingCrieria();
            CsMappingCrieria.Criteria criteriaMapping = csMappingCrieria.createCriteria();
            criteriaMapping.andcsmManageEqualTo(user.getSuId());
            List<CsMapping> csMappingList = csMappingService.selectByExample(csMappingCrieria);
            if (null != csMappingList && csMappingList.size() > 0) {
                Integer[] carIds = new Integer[csMappingList.size()];
                for (int i = 0; i < csMappingList.size(); i++) {
                    carIds[i] = csMappingList.get(i).getCsmCar();
                    //
                    conditonField.add(csMappingList.get(i).getCsmCar());
                }
            }
            return "platform_user";
        }
        return "";
    }

    /**
     * 注册属性内容解析器
     */
    void registResolvers(CsCan data) {
        if (data != null) {
            data.registResolver(com.ccclubs.admin.resolver.CsCanResolver.接入商.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsCanResolver.车机号.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsCanResolver.车辆.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsCanResolver.CAN类型.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsCanResolver.状态.getResolver());
        }
    }

    /**
     * 获取单条车辆实时CAN信息信息
     */
    @ApiOperation(value = "获取can详细数据", notes = "根据id获取can详细信息")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public VoResult<Map<String, CsCan>> detail(@PathVariable(required = true) Long id) {
        CsCan data = csCanService.selectByPrimaryKey(id);
        Map<String, CsCan> map = new HashMap<String, CsCan>();
        registResolvers(data);
        map.put("tbody", data);
        return VoResult.success().setValue(map);
    }


    /**
     * 根据文本检索车辆实时CAN信息信息
     */
    @ApiOperation(value = "根据文本检索车辆实时CAN信息", notes = "根据文本检索车辆实时CAN信息")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public VoResult<Map<String, List<Map<String, Object>>>> query(String text, String where, CsCan queryRecord) {
        CsCanCrieria query = new CsCanCrieria();
        CsCanCrieria.Criteria c = query.createCriteria();
        if (!StringUtils.isEmpty(text)) {
            String val = String.valueOf(text);
            c.andcscNumberEqualTo(val);
        }
        if (!StringUtils.isEmpty(where)) {
            Long val = Long.valueOf(where);
            c.andcscIdEqualTo(val);
        }
        PageInfo<CsCan> pageInfo = csCanService.getPage(query, 0, 10);
        List<CsCan> list = pageInfo.getList();

        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>(list.size());
        Map<String, Object> map;
        for (CsCan data : list) {
            map = new HashMap<String, Object>();
            map.put("value", data.getCscId());
            map.put("text", data.getCscNumber());
            mapList.add(map);
        }
        return VoResult.success().setValue(mapList);
    }

}
