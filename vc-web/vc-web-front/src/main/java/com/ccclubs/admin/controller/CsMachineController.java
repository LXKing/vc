package com.ccclubs.admin.controller;

import com.ccclubs.admin.entity.CsMachineCrieria;
import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.query.CsMachineQuery;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.service.IReportService;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * T-box信息管理Controller
 *
 * @author
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/admin/machine")
public class CsMachineController {

  Logger logger = LoggerFactory.getLogger(CsMachineController.class);

  @Autowired
  ICsMachineService csMachineService;

  @Autowired
  IReportService reportService;

  /**
   * 获取分页列表数据
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public TableResult<CsMachine> list(CsMachineQuery query,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer rows) {
    PageInfo<CsMachine> pageInfo = csMachineService.getPage(query.getCrieria(), page, rows);
    List<CsMachine> list = pageInfo.getList();
    for (CsMachine data : list) {
      registResolvers(data);
    }

    TableResult<CsMachine> r = new TableResult<>(pageInfo);
    return r;
  }

  /**
   * 创建保存T-box信息管理
   */
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public VoResult<?> add(CsMachine data) {
    if (null == data.getCsmStatus()) {
      return VoResult.error("20010", String.format("存在不能为空的参数为空值。"));
    }
    if (null == data.getCsmAddTime()) {
      data.setCsmAddTime(new Date());
    }
    if (null == data.getCsmUpdateTime()) {
      data.setCsmUpdateTime(new Date());
    }
    if (null == data.getCsmHost()) {
      data.setCsmHost(0);
    }
    CsMachine existMachine;

    CsMachine conditionNumberMachine = new CsMachine();
    conditionNumberMachine.setCsmNumber(data.getCsmNumber());
    existMachine = csMachineService.selectOne(conditionNumberMachine);
    if (null != existMachine) {
      return VoResult.error("30001", String.format("车机号 %s 已存在", data.getCsmNumber()));
    }

    if (null != data.getCsmMobile()) {
      CsMachine conditionMobileMachine = new CsMachine();
      conditionMobileMachine.setCsmMobile(data.getCsmMobile());
      existMachine = csMachineService.selectOne(conditionMobileMachine);
      if (null != existMachine) {
        return VoResult.error("30002", String.format("手机号 %s 已存在", data.getCsmMobile()));
      }
    }

    CsMachine conditionTeNoMachine = new CsMachine();
    conditionTeNoMachine.setCsmTeNo(data.getCsmTeNo());
    existMachine = csMachineService.selectOne(conditionTeNoMachine);
    if (null != existMachine) {
      return VoResult.error("30003", String.format("终端序列号 %s 已存在", data.getCsmTeNo()));
    }

    data.setCsmBluetoothVersion(0);
    if (null == data.getCsmSuperSim()) {
      data.setCsmSuperSim("");
    }
    csMachineService.insert(data);
    return VoResult.success();
  }

  /**
   * 更新T-box信息管理
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public VoResult<?> update(CsMachine data) {
    if (null == data.getCsmUpdateTime()) {
      data.setCsmUpdateTime(new Date());
    }

    CsMachine existMachine;

    CsMachine conditionNumberMachine = new CsMachine();
    conditionNumberMachine.setCsmNumber(data.getCsmNumber());
    existMachine = csMachineService.selectOne(conditionNumberMachine);
    if (null != existMachine && !existMachine.getCsmId().equals(data.getCsmId())) {
      return VoResult.error("30001", String.format("车机号 %s 已存在", data.getCsmNumber()));
    }

    if (null != data.getCsmMobile()) {
      CsMachine conditionMobileMachine = new CsMachine();
      conditionMobileMachine.setCsmMobile(data.getCsmMobile());
      existMachine = csMachineService.selectOne(conditionMobileMachine);
      if (null != existMachine && !existMachine.getCsmId().equals(data.getCsmId())) {
        return VoResult.error("30002", String.format("手机号 %s 已存在", data.getCsmMobile()));
      }
    }

    CsMachine conditionTeNoMachine = new CsMachine();
    conditionTeNoMachine.setCsmTeNo(data.getCsmTeNo());
    existMachine = csMachineService.selectOne(conditionTeNoMachine);
    if (null != existMachine && !existMachine.getCsmId().equals(data.getCsmId())) {
      return VoResult.error("30003", String.format("终端序列号 %s 已存在", data.getCsmTeNo()));
    }
    /*if (null==data.getCsmBluetoothVersion()){
			data.setCsmBluetoothVersion(0);
		}*/

    csMachineService.updateByPrimaryKeySelective(data);
    return VoResult.success();
  }

  /**
   * 删除T-box信息管理
   */
  @RequestMapping(value = "delete", method = RequestMethod.DELETE)
  public VoResult<?> delete(@RequestParam(required = true) final Integer[] ids) {
    csMachineService.batchDelete(ids);
    return VoResult.success();
  }

  /**
   * 注册属性内容解析器
   */
  void registResolvers(CsMachine data) {
    if (data != null) {
      data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.接入商.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.终端类型.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.协议类型.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.适配车型.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.终端协议.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.状态.getResolver());
    }
  }

  /**
   * 获取单条T-box信息管理信息
   */
  @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
  public VoResult<Map<String, CsMachine>> detail(@PathVariable(required = true) Long id) {
    CsMachine data = csMachineService.selectByPrimaryKey(id.intValue());
    Map<String, CsMachine> map = new HashMap<String, CsMachine>();
    registResolvers(data);
    map.put("tbody", data);
    return VoResult.success().setValue(map);
  }


  /**
   * 根据文本检索T-box信息管理信息
   */
  @RequestMapping(value = "/query", method = RequestMethod.GET)
  public VoResult<Map<String, List<Map<String, Object>>>> query(String text, String where,
      CsMachine queryRecord) {
    CsMachineCrieria query = new CsMachineCrieria();
    CsMachineCrieria.Criteria c = query.createCriteria();
    CsMachineCrieria.Criteria n = query.createCriteria();
    CsMachineCrieria.Criteria m = query.createCriteria();
    if (!StringUtils.isEmpty(text)) {
      String val = String.valueOf(text);
      c.andcsmTeNoLike(val);
      n.andcsmNumberLike(val);
      m.andcsmMobileLike(val);
    }
    if (!StringUtils.isEmpty(where)) {
      Integer val = Integer.valueOf(where);
      c.andcsmIdEqualTo(val);
      n.andcsmIdEqualTo(val);
      m.andcsmIdEqualTo(val);
    }
    query.or(n);
    query.or(m);

    PageInfo<CsMachine> pageInfo = csMachineService.getPage(query, 0, 10);
    List<CsMachine> list = pageInfo.getList();

    List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>(list.size());
    Map<String, Object> map;
    for (CsMachine data : list) {
      map = new HashMap<String, Object>();
      map.put("value", data.getCsmId());
      map.put("text",data.getCsmNumber() + "(" + data.getCsmTeNo() + ")" + "(" + data.getCsmMobile() + ")");
      mapList.add(map);
    }
    return VoResult.success().setValue(mapList);
  }

  /**
   * 根据分页数据导出到excel。
   */
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public VoResult<Map<String, List<Map<String, Object>>>> search(String text,
      CsMachine queryRecord) {
    CsMachineCrieria query = new CsMachineCrieria();
    CsMachineCrieria.Criteria c = query.createCriteria();
    CsMachineCrieria.Criteria n = query.createCriteria();
    CsMachineCrieria.Criteria m = query.createCriteria();
    if (!StringUtils.isEmpty(text)) {
      String val = String.valueOf(text);
      c.andcsmTeNoLike(val);
      n.andcsmNumberLike(val);
      m.andcsmMobileLike(val);
    }
    query.or(n);
    query.or(m);
    PageInfo<CsMachine> pageInfo = csMachineService.getPage(query, 0, 10);
    List<CsMachine> list = pageInfo.getList();

    List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>(list.size());
    Map<String, Object> map;
    for (CsMachine data : list) {
      map = new HashMap<String, Object>();
      map.put("value", data.getCsmNumber());
      map.put("text", data.getCsmNumber() + "(" + data.getCsmTeNo() + ")" + "(" + data.getCsmMobile() + ")");
      mapList.add(map);
    }
    return VoResult.success().setValue(mapList);
  }

  /**
   * 根据文本检索T-box信息并导出。
   */
  @RequestMapping(value = "/report", method = RequestMethod.GET)
  public void getReport(HttpServletResponse res, CsMachineQuery query,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer rows) {

    PageInfo<CsMachine> pageInfo = csMachineService.getPage(query.getCrieria(), page, rows);
    List<CsMachine> list = pageInfo.getList();
    for (CsMachine data : list) {
      registResolvers(data);
    }

    OutputStream os = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dateNowStr = sdf.format(System.currentTimeMillis());
    /**
     * 命名规则是 表意义+“——”+页号+“——”+页面大小+“——”+日期
     * */
    String fileName = "Machine_" + page + "_" + rows + "_" + dateNowStr + ".xls";
    try {
      res.setHeader("content-type", "application/vnd.ms-excel");
      res.setContentType("application/vnd.ms-excel");
      res.setHeader("Content-Disposition",
          "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
      os = res.getOutputStream();
      //文件路径
      ByteArrayOutputStream bytes = null;
      bytes = reportService.reportMachines(list);
      os.write(bytes.toByteArray());
      os.flush();
      os.close();
      logger.info("report a file:" + fileName);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (os != null) {
          os.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}
