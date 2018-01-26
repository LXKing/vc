package com.ccclubs.admin.controller;

import com.ccclubs.admin.entity.CsMappingCrieria;
import com.ccclubs.admin.entity.CsTboxBindHisCrieria;
import com.ccclubs.admin.entity.CsVehicleCrieria;
import com.ccclubs.admin.model.*;
import com.ccclubs.admin.query.CsVehicleQuery;
import com.ccclubs.admin.service.*;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.util.UserAccessUtils;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 车辆信息管理Controller
 *
 * @author 修改者 Alban
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/admin/vehicle")
public class CsVehicleController {
  private static Logger logger= LoggerFactory.getLogger(CsVehicleController.class);

  @Autowired
  ICsVehicleService csVehicleService;
  @Autowired
  ReportThread reportThread;
  @Autowired
  ISrvGroupService srvGroupService;
  @Autowired
  ICsModelMappingService csModelMappingService;
  @Autowired
  ICsMachineService csMachineService;

  @Autowired
  ICsMappingService csMappingService;

  @Autowired
  UserAccessUtils userAccessUtils;

  @Autowired
  ICsTboxBindHisService tboxBindHisService;
  /**
   * 获取分页列表数据
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public TableResult<CsVehicle> list(
      @CookieValue("token") String token, CsVehicleQuery query,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer rows) {
    SrvUser user = userAccessUtils.getCurrentUser(token);
    this.addQueryConditionsByUser(user, query);
//想法是首先得到对应的用户组来进行处理，对query加上新的条件来限制查询到的结果。
//    if (null == user) {
//      return new ResultMsg<>(false,
//          ResultCode.INVALID_TOKEN, null);
//    }

    PageInfo<CsVehicle> pageInfo = csVehicleService.getPage(query.getCrieria(), page, rows);
    List<CsVehicle> list = pageInfo.getList();
    for (CsVehicle data : list) {
      registResolvers(data);
    }

    TableResult<CsVehicle> r = new TableResult<>(pageInfo);
    return r;
  }

  /**
   * 根据用户添加查询条件。
   */
  private void addQueryConditionsByUser(SrvUser user, CsVehicleQuery query) {
    //首先判断用户所在的组。
    SrvGroup srvGroup = srvGroupService.selectByPrimaryKey(user.getSuGroup().intValue());
    if (srvGroup.getSgFlag().equals("sys_user")) {
      //系统用户，此种用户可以随意查询（为所欲为）

    } else if (srvGroup.getSgFlag().equals("factory_user")) {
      //车厂 （按照车型进行查询）
      CsModelMapping csModelMapping = new CsModelMapping();
      csModelMapping.setUserId(user.getSuId());
      List<CsModelMapping> csModelMappingList = csModelMappingService.select(csModelMapping);
      if (null != csModelMappingList && csModelMappingList.size() > 0) {
        Integer[] csModelIds = new Integer[csModelMappingList.size()];
        for (int i = 0; i < csModelMappingList.size(); i++) {
          csModelIds[i] = csModelMappingList.get(i).getModelId();
        }
        query.setCsvModelIn(csModelIds);
      }
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
        }
        query.setCsvIdIn(carIds);
      }

    }


  }


  /**
   * 创建保存车辆信息管理
   */
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public VoResult<?> add(CsVehicle data) {

    if (null == data.getCsvAddTime()) {
      data.setCsvAddTime(new Date());
    }
    if (null == data.getCsvUpdateTime()) {
      data.setCsvUpdateTime(new Date());
    }

    CsVehicle conditionVinVehicle = new CsVehicle();
    conditionVinVehicle.setCsvVin(data.getCsvVin());
    if (csVehicleService.selectCount(conditionVinVehicle) > 0) {
      return VoResult.error("30001", String.format("车架号 %s 已存在", data.getCsvVin()));
    }

    if (!com.ccclubs.protocol.util.StringUtils.empty(data.getCsvCarNo())) {
      CsVehicle conditionNoVehicle = new CsVehicle();
      conditionNoVehicle.setCsvCarNo(data.getCsvCarNo());
      if (csVehicleService.selectCount(conditionNoVehicle) > 0) {
        return VoResult.error("30002", String.format("车牌号 %s 已存在", data.getCsvCarNo()));
      }
    }
    {
      data.setCsvCarNo(null);
    }

//    CsVehicle conditionEngine = new CsVehicle();
//    conditionEngine.setCsvEngineNo(data.getCsvEngineNo());
//    if (csVehicleService.selectCount(conditionEngine) > 0) {
//      return VoResult.error("30003", String.format("发动机(电机)编号 %s 已存在", data.getCsvEngineNo()));
//    }

    csVehicleService.insert(data);
    return VoResult.success();
  }

  /**
   * 更新车辆信息管理
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public VoResult<?> update(CsVehicle data) {
    if (null == data.getCsvUpdateTime()) {
      data.setCsvUpdateTime(new Date());
    }
    List<CsVehicle> existVehicleList;
    CsVehicle conditionVinVehicle = new CsVehicle();
    conditionVinVehicle.setCsvVin(data.getCsvVin());
    existVehicleList = csVehicleService.select(conditionVinVehicle);
    if (existVehicleList.size() > 0 && !existVehicleList.get(0).getCsvId()
        .equals(data.getCsvId())) {
      return VoResult.error("30001", String.format("车架号 %s 已存在", data.getCsvVin()));
    }

    if (!com.ccclubs.protocol.util.StringUtils.empty(data.getCsvCarNo())) {
      CsVehicle conditionNoVehicle = new CsVehicle();
      conditionNoVehicle.setCsvCarNo(data.getCsvCarNo());
      existVehicleList = csVehicleService.select(conditionNoVehicle);
      if (existVehicleList.size() > 0 && !existVehicleList.get(0).getCsvId()
          .equals(data.getCsvId())) {
        return VoResult.error("30002", String.format("车牌号 %s 已存在", data.getCsvCarNo()));
      }
    }

//    CsVehicle conditionEngine = new CsVehicle();
//    conditionEngine.setCsvEngineNo(data.getCsvEngineNo());
//    existVehicle = csVehicleService.selectOne(conditionEngine);
//    if (null != existVehicle && !existVehicle.getCsvId().equals(data.getCsvId())) {
//      return VoResult.error("30003", String.format("发动机(电机)编号 %s 已存在", data.getCsvEngineNo()));
//    }
    csVehicleService.updateByPrimaryKeySelective(data);
    return VoResult.success();
  }

  /**
   * 删除车辆信息管理
   */
  @RequestMapping(value = "delete", method = RequestMethod.DELETE)
  public VoResult<?> delete(@RequestParam(required = true) final Integer[] ids) {
    csVehicleService.batchDelete(ids);
    return VoResult.success();
  }

  /**
   * 注册属性内容解析器
   */
  void registResolvers(CsVehicle data) {
    if (data != null) {
      data.registResolver(com.ccclubs.admin.resolver.CsVehicleResolver.接入商.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsVehicleResolver.车型.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsVehicleResolver.车机设备.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsVehicleResolver.车身颜色.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsVehicleResolver.地标类型.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsVehicleResolver.车辆领域.getResolver());
      data.registResolver(com.ccclubs.admin.resolver.CsVehicleResolver.状态.getResolver());
    }
  }

  /**
   * 获取单条车辆信息管理信息
   */
  @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
  public VoResult<Map<String, CsVehicle>> detail(@PathVariable(required = true) Integer id) {
    CsVehicle data = csVehicleService.selectByPrimaryKey(id);
    Map<String, CsVehicle> map = new HashMap<String, CsVehicle>();
    registResolvers(data);
    map.put("tbody", data);
    return VoResult.success().setValue(map);
  }

  /**
   * 更换TBox
   */
  @RequestMapping(value = "/bind", method = RequestMethod.POST)
  public VoResult<?> bind(@CookieValue("token") String token, CsVehicle data) {
    CsVehicle oldVehicle = csVehicleService.selectByPrimaryKey(data.getCsvId());
    SrvUser user = userAccessUtils.getCurrentUser(token);
    if (null == data.getCsvMachine()) {
      if (null == oldVehicle.getCsvMachine()) {
        return VoResult.success();
      } else
      // 开始解除绑定TBOX
      {
        data.setCsvUpdateTime(new Date());
        csVehicleService.unbindTbox(data);
        //记录tbox解绑的日志-
        CsMachine csMachineTemp=new CsMachine();
        csMachineTemp.setCsmId(oldVehicle.getCsvMachine());
        CsMachine csMachine=csMachineService.selectOne(csMachineTemp);
        insertUnBindTobxLog(oldVehicle,csMachine,user.getSuId()+"");//解绑
        return VoResult.success();
      }
    } else {
      CsVehicle conditionVehicle = new CsVehicle();
      conditionVehicle.setCsvMachine(data.getCsvMachine());
      CsVehicle existVehicle = csVehicleService.selectOne(conditionVehicle);
      if (null == existVehicle) {
        conditionVehicle.setCsvId(data.getCsvId());
        conditionVehicle.setCsvUpdateTime(new Date());
        csVehicleService.updateByPrimaryKeySelective(data);
        //记录tbox更换日志-并增加一条新的记录
        CsMachine csMachineTemp=null;
        if(oldVehicle!=null&&oldVehicle.getCsvMachine()!=null){//更换时把之前的绑定记录下来
          csMachineTemp=new CsMachine();
          csMachineTemp.setCsmId(oldVehicle.getCsvMachine());
          CsMachine csMachine=csMachineService.selectOne(csMachineTemp);
          insertUnBindTobxLog(oldVehicle,csMachine,user.getSuId()+"");//解绑
        }
        csMachineTemp=new CsMachine();
        csMachineTemp.setCsmId(data.getCsvMachine());
        CsMachine csMachine=csMachineService.selectOne(csMachineTemp);
        insertBindTobxLog(oldVehicle,csMachine,user.getSuId());//绑定
        return VoResult.success();
      } else if (existVehicle.getCsvId().equals(data.getCsvId())) {
        return VoResult.success();
      } else {
        return VoResult.error("30003", "该终端已被其他车辆绑定!");
      }
    }
  }

  /**
   * 记录解绑时的日志
   */
  /**
   * 记录解绑时的日志
   */
  public void insertUnBindTobxLog(CsVehicle csVehicle ,CsMachine csMachine,String operateId){
    CsTboxBindHis record=new CsTboxBindHis();
    //
    CsTboxBindHisCrieria example=new CsTboxBindHisCrieria();
    CsTboxBindHisCrieria.Criteria criteria=example.createCriteria();
    criteria.andcstbVehicleIdEqualTo((long)csVehicle.getCsvId());
    criteria.andcstbMachineIdEqualTo((long)csMachine.getCsmId());
    criteria.andcstbEndTimeIsNull();
    List<CsTboxBindHis> list=tboxBindHisService.selectByExample(example);
    if(list==null||list.isEmpty()){
      record.setCstbVehicleId((long)csVehicle.getCsvId());
      record.setCstbMachineId((long)csMachine.getCsmId());
      record.setCstbVin(csVehicle.getCsvVin());
      record.setCstbNumber(csMachine.getCsmNumber());
      record.setCstbTeNo(csMachine.getCsmTeNo());
      record.setCstbStartTime(new Date());
      //状态 1:正常 0:无效
      record.setCstbStatus((short)1);
      record.setCstbAddTime(new Date());
      record.setCstbModTime(new Date());
      record.setCstbEndTime(new Date());
      if(operateId!=null){
        record.setCstbUnbindOperId(Long.parseLong(operateId));
      }
      //操作人类型 1:运营商 2:后台用户
      record.setCstbOperType((short)2);
      tboxBindHisService.insert(record);
    }else {
      record.setCstbEndTime(new Date());
      record.setCstbModTime(new Date());
      if(operateId!=null){
        record.setCstbUnbindOperId(Long.parseLong(operateId));
      }
      tboxBindHisService.updateByExampleSelective(record,example);
    }
  }

  /**
   * 记录Tbox绑定时的日志
   */
  public void insertBindTobxLog(CsVehicle csVehicle,CsMachine csMachine,long operateId ){
    CsTboxBindHis csTboxBindHis=new CsTboxBindHis();
    csTboxBindHis.setCstbVehicleId((long)csVehicle.getCsvId());
    csTboxBindHis.setCstbMachineId((long)csMachine.getCsmId());
    csTboxBindHis.setCstbVin(csVehicle.getCsvVin());
    csTboxBindHis.setCstbNumber(csMachine.getCsmNumber());
    csTboxBindHis.setCstbTeNo(csMachine.getCsmTeNo());
    csTboxBindHis.setCstbStartTime(new Date());
    //状态 1:正常 0:无效
    csTboxBindHis.setCstbStatus((short)1);
    csTboxBindHis.setCstbAddTime(new Date());
    csTboxBindHis.setCstbModTime(new Date());
    csTboxBindHis.setCstbBindOperId(operateId);
    //操作人类型 1:运营商 2:后台用户
    csTboxBindHis.setCstbOperType((short)2);
    tboxBindHisService.insert(csTboxBindHis);
  }



  /**
   * @param c 此方法仅在 createCriteria()后执行！
   */
  private void addCriteriaByUser(SrvUser user, CsVehicleCrieria.Criteria c) {
    SrvGroup srvGroup = srvGroupService.selectByPrimaryKey(user.getSuGroup().intValue());
    if (srvGroup.getSgFlag().equals("factory_user")) {//如果是车厂用户则只关心车型
      CsModelMapping csModelMapping = new CsModelMapping();
      csModelMapping.setUserId(user.getSuId());
      List<CsModelMapping> csModelMappingList = csModelMappingService.select(csModelMapping);
      if (null != csModelMappingList && csModelMappingList.size() > 0) {
        List<Integer> csModelIds = new ArrayList<>();
        for (CsModelMapping aCsModelMappingList : csModelMappingList) {
          csModelIds.add(aCsModelMappingList.getModelId());
        }
        c.andcsvModelIn(csModelIds);
      }
    } else if (srvGroup.getSgFlag().equals("platform_user")) {
      //小散户（通过mapping进行对应）
      CsMappingCrieria csMappingCrieria = new CsMappingCrieria();
      CsMappingCrieria.Criteria criteriaMapping = csMappingCrieria.createCriteria();
      criteriaMapping.andcsmManageEqualTo(user.getSuId());
      List<CsMapping> csMappingList = csMappingService.selectByExample(criteriaMapping);
      if (null != csMappingList && csMappingList.size() > 0) {
        List<Integer> carIds = new ArrayList<>();
        for (CsMapping aCsMappingList : csMappingList) {
          carIds.add(aCsMappingList.getCsmCar());
        }
        c.andcsvIdIn(carIds);
      }
    }
  }


  /**
   * 根据文本检索车辆信息管理信息
   */
  @RequestMapping(value = "/query", method = RequestMethod.GET)
  public VoResult<Map<String, List<Map<String, Object>>>> query(@CookieValue("token") String token,
      String text, String where,
      CsVehicle queryRecord) {

    SrvUser user = userAccessUtils.getCurrentUser(token);

    CsVehicleCrieria query = new CsVehicleCrieria();
    CsVehicleCrieria.Criteria c = query.createCriteria();
    CsVehicleCrieria.Criteria n = query.createCriteria();

    this.addCriteriaByUser(user, c);
    this.addCriteriaByUser(user, n);

    if (!StringUtils.isEmpty(text)) {
      String val = String.valueOf(text);
      c.andcsvVinLike(val);
      n.andcsvCarNoLike(val);
    }
    if (!StringUtils.isEmpty(where)) {
      Integer val = Integer.valueOf(where);
      c.andcsvIdEqualTo(val);
      n.andcsvIdEqualTo(val);
    }
    query.or(n);

    PageInfo<CsVehicle> pageInfo = csVehicleService.getPage(query, 0, 10);
    List<CsVehicle> list = pageInfo.getList();

    List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>(list.size());
    Map<String, Object> map;
    for (CsVehicle data : list) {
      map = new HashMap<String, Object>();
      map.put("value", data.getCsvId());
      map.put("text", data.getCsvVin() + "(" + data.getCsvCarNo() + ")");
      mapList.add(map);
    }
    return VoResult.success().setValue(mapList);
  }

  /**
   * 根据文本检索车辆信息管理信息
   */
  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public VoResult<Map<String, List<Map<String, Object>>>> find(@CookieValue("token") String token,
      String text, String where,
      CsVehicle queryRecord) {

    SrvUser user = userAccessUtils.getCurrentUser(token);
    CsVehicleCrieria query = new CsVehicleCrieria();
    CsVehicleCrieria.Criteria c = query.createCriteria();
    CsVehicleCrieria.Criteria n = query.createCriteria();

    this.addCriteriaByUser(user, c);
    this.addCriteriaByUser(user, n);

    if (!StringUtils.isEmpty(text)) {
      String val = String.valueOf(text);
      c.andcsvVinLike(val);
      n.andcsvCarNoLike(val);
    }
    if (!StringUtils.isEmpty(where)) {
      Integer val = Integer.valueOf(where);
      c.andcsvIdEqualTo(val);
      n.andcsvIdEqualTo(val);
    }
    query.or(n);

    PageInfo<CsVehicle> pageInfo = csVehicleService.getPage(query, 0, 10);
    List<CsVehicle> list = pageInfo.getList();

    List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>(list.size());
    Map<String, Object> map;
    for (CsVehicle data : list) {
      map = new HashMap<String, Object>();
      CsMachine csMachine = csMachineService.selectByPrimaryKey(data.getCsvMachine());
      if (csMachine != null) {
        map.put("value", csMachine.getCsmNumber());//得到的是车机号。
        map.put("text", data.getCsvVin() + "(" + data.getCsvCarNo() + ")");
        mapList.add(map);
      }

    }
    return VoResult.success().setValue(mapList);
  }

  /**
   * 根据文本检索车辆信息管理信息
   */
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public VoResult<Map<String, List<Map<String, Object>>>> search(@CookieValue("token") String token,
      String text, String where,
      CsVehicle queryRecord) {

    SrvUser user = userAccessUtils.getCurrentUser(token);

    CsVehicleCrieria query = new CsVehicleCrieria();
    CsVehicleCrieria.Criteria c = query.createCriteria();
    CsVehicleCrieria.Criteria n = query.createCriteria();

    this.addCriteriaByUser(user, c);
    this.addCriteriaByUser(user, n);

    if (!StringUtils.isEmpty(text)) {
      String val = String.valueOf(text);
      c.andcsvVinLike(val);
      n.andcsvCarNoLike(val);
    }
    if (!StringUtils.isEmpty(where)) {
      Integer val = Integer.valueOf(where);
      c.andcsvIdEqualTo(val);
      n.andcsvIdEqualTo(val);
    }

    query.or(n);

    PageInfo<CsVehicle> pageInfo = csVehicleService.getPage(query, 0, 10);
    List<CsVehicle> list = pageInfo.getList();

    List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>(list.size());
    Map<String, Object> map;
    for (CsVehicle data : list) {
      map = new HashMap<String, Object>();
      map.put("value", data.getCsvVin());
      map.put("text", data.getCsvVin() + "(" + data.getCsvCarNo() + ")");
      mapList.add(map);
    }
    return VoResult.success().setValue(mapList);
  }


  /**
   * 根据文本检索车辆信息并导出。
   */
  @RequestMapping(value = "/report", method = RequestMethod.POST)
  public VoResult<String> getReport(
          @CookieValue("token") String token, @RequestBody ReportParam<CsVehicleQuery> reportParam) {

    SrvUser user = userAccessUtils.getCurrentUser(token);
    this.addQueryConditionsByUser(user, reportParam.getQuery());

    List<CsVehicle> list;
    if (reportParam.getAllReport()==0){
      PageInfo<CsVehicle> pageInfo = csVehicleService.getPage(
              reportParam.getQuery().getCrieria(),
              reportParam.getPage(),
              reportParam.getRows());
      list= pageInfo.getList();
    }else {
      list=csVehicleService.getAllByParam(reportParam.getQuery().getCrieria());
    }

    for (CsVehicle data : list) {
      registResolvers(data);
    }
    String uuid = UUID.randomUUID().toString();
    reportThread.setBaseName("Vehicle");
    reportThread.setList(list);
    reportThread.setUserUuid(uuid);
    reportThread.setReportParam(reportParam);
    logger.info("start running report Vehicle thread.");
    EvManageContext.getThreadPool().execute(reportThread);

    VoResult<String> r = new VoResult<>();
    r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
    r.setValue(uuid);
    return r;
  }

  /**
   * 批量导入车辆信息
   * @return
   */
  @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
  @Transactional
  public VoResult<?> insertVchicleBatch(@CookieValue("token") String token,@RequestParam("fileUpload") MultipartFile fileUpload,CsVehicle csVehicleTemp) {
    try {
      SrvUser user = userAccessUtils.getCurrentUser(token);
      //根据vin码查找相同的数据
      List<CsVehicle> tempList=csVehicleService.selectAll();
      //
      Map<String,CsVehicle> tempMap=new HashMap<>();
      for (CsVehicle csVehicle:tempList){
        String csvVin=csVehicle.getCsvVin();
        String csvMachine=csVehicle.getCsvMachine()+"";
        String csvEngineNo=csVehicle.getCsvEngineNo();
        //
        if(csvVin!=null){
          tempMap.put(csvVin,csVehicle);
        }else if(csVehicle.getCsvMachine()!=null){
          tempMap.put(csvMachine,csVehicle);
        }else if (csvEngineNo!=null){
          tempMap.put(csvEngineNo,csVehicle);
        }
      }
      List<CsVehicle> existList =getConditionVinList(fileUpload,csVehicleTemp);
      //更新vin码相同的list数据
      List<CsVehicle> updateList=new ArrayList<>();
      //插入的vin码
      List<String>insertVinList=new ArrayList<>();
      //
      getItemListData(existList,updateList,insertVinList,tempMap,user);
      //vin码相同时更新表中数据---判断车机信息
      if (updateList!=null&&updateList.size()>0){
         csVehicleService.updateBatchByExampleSelective(updateList);
      }
      //插入数据
      if(existList!=null&&existList.size()>0){
        csVehicleService.insertBatchSelective(existList);
      }
       //根据用户所属组添加对应信息
      insertCsMappingByTokenAndVin(token,insertVinList);
      //记录批量插入的车辆与车机的对应关系的日志记录
      insertBatchTboxBindLog(insertVinList,user.getSuId());
      return VoResult.success();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   * 根据批量插入数据，车机与车辆的对应关系加入到tbox记录中
   */
  public void insertBatchTboxBindLog(List<String>insertVinList,long operateId){
    if(insertVinList!=null&&insertVinList.size()>0){
        CsVehicleCrieria condition=new CsVehicleCrieria();
        CsVehicleCrieria.Criteria criteria=condition.createCriteria();
        criteria.andcsvVinIn(insertVinList).andcsvMachineIsNotNull();
        List<CsVehicle> vehicleList=csVehicleService.selectByExample(condition);
        List<CsTboxBindHis> tboxList=new ArrayList<>();
        CsTboxBindHis csTboxBindHis=null;
        CsMachine csMachineTemp=null;
        for (CsVehicle csVehicle:vehicleList){
          csMachineTemp=new CsMachine();
          csMachineTemp.setCsmId(csVehicle.getCsvMachine());
          CsMachine csMachine=csMachineService.selectOne(csMachineTemp);
          //
          csTboxBindHis=new CsTboxBindHis();
          csTboxBindHis.setCstbVehicleId((long)csVehicle.getCsvId());
          csTboxBindHis.setCstbMachineId((long)csVehicle.getCsvMachine());
          //
          csTboxBindHis.setCstbVin(csVehicle.getCsvVin());
          csTboxBindHis.setCstbNumber(csMachine.getCsmNumber());
          csTboxBindHis.setCstbTeNo(csMachine.getCsmTeNo());

          csTboxBindHis.setCstbStartTime(new Date());
          //状态 1:正常 0:无效
          csTboxBindHis.setCstbStatus((short)1);
          csTboxBindHis.setCstbAddTime(new Date());
          csTboxBindHis.setCstbModTime(new Date());
          csTboxBindHis.setCstbBindOperId(operateId);
          //操作人类型 1:运营商 2:后台用户
          csTboxBindHis.setCstbOperType((short)2);
          tboxList.add(csTboxBindHis);
        }
        if(tboxList!=null&&tboxList.size()>0){
          tboxBindHisService.insertBatchSelective(tboxList);
        }

    }
  }

  /**
   * 根据用户所属组添加CsMapping对应信息
   */
  public void insertCsMappingByTokenAndVin(String token,List<String> vinList){
    SrvUser user = userAccessUtils.getCurrentUser(token);
    SrvGroup srvGroup = srvGroupService.selectByPrimaryKey(user.getSuGroup().intValue());
    if (srvGroup!=null&&"platform_user".equals(srvGroup.getSgFlag())){
      if(vinList!=null&&vinList.size()>0){
        CsVehicleCrieria condition=new CsVehicleCrieria();
        CsVehicleCrieria.Criteria criteria=condition.createCriteria();
        criteria.andcsvVinIn(vinList);
        List<CsVehicle> resultIdList= csVehicleService.selectByExample(condition);
        if(resultIdList!=null){
          List<CsMapping> csMappingList=new ArrayList<>();
          CsMapping csMapping=null;
          for (CsVehicle csVehicle:resultIdList){
            csMapping=new CsMapping();
            csMapping.setCsmManage(user.getSuId());
            csMapping.setCsmCar(csVehicle.getCsvId());
            csMappingList.add(csMapping);
          }
          csMappingService.insertBatchSelective(csMappingList);
        }
      }
    }
  }
  //整理各list中的数据
  public void getItemListData(List<CsVehicle> existList, List<CsVehicle> updateList,List<String>insertVinList, Map<String,CsVehicle> tempMap,SrvUser user){
      //删除list中的数据
      Iterator<CsVehicle> it = existList.iterator();
      while(it.hasNext()){
        CsVehicle csVehicle = it.next();
        //csvVin码
        if(tempMap.containsKey(csVehicle.getCsvMachine())){
            it.remove();
            continue;
        }else if(tempMap.containsKey(csVehicle.getCsvEngineNo())){
            it.remove();
            continue;
        }else if(tempMap.containsKey(csVehicle.getCsvVin())){//需要更新的数据
          if(csVehicle.getCsvMachine()!=null){//添加的车架号为空--直接添加
            CsVehicle oldVehicle=tempMap.get(csVehicle.getCsvVin());
            if(!csVehicle.getCsvMachine().equals(oldVehicle.getCsvMachine())){//车机号不等时更新
              CsMachine csMachineTemp=new CsMachine();
              csMachineTemp.setCsmId(csVehicle.getCsvMachine());
              CsMachine csMachine=csMachineService.selectOne(csMachineTemp);
              if(oldVehicle.getCsvMachine()!=null){
                insertUnBindTobxLog(oldVehicle,csMachine,user.getSuId()+"");//解绑
              }
              insertBindTobxLog(oldVehicle,csMachine,user.getSuId());//绑定
            }
          }
          updateList.add(csVehicle);
          it.remove();
          continue;
        }
        //最后插入的数据
        insertVinList.add(csVehicle.getCsvVin());
      }
  }

  //从excel中获取csVehicle中内容=
  public  List<CsVehicle> getConditionVinList(MultipartFile file,CsVehicle csVehicleTemp){
    List<CsVehicle> externalList=new ArrayList<>();
    try {
      Workbook workbook=null;
      InputStream is = file.getInputStream();
      String excelName= file.getOriginalFilename();
      if(excelName.indexOf(".xlsx")>-1){
        workbook = new XSSFWorkbook(is);
      }else{
        workbook = new HSSFWorkbook(is);
      }
      // 循环工作表Sheet--从第三行开始计算
      for (int numSheet =0; numSheet < 1; numSheet++) {
        Sheet sheet = workbook.getSheetAt(numSheet);
        if (sheet == null) {
          continue;
        }
        int rows=sheet.getPhysicalNumberOfRows();
        int columns=sheet.getRow(1).getPhysicalNumberOfCells();//从第二行开始算
        // 循环行Row
        CsVehicle csVehicle=null;
        for (int rowNum = 2; rowNum < rows; rowNum++) {
          String rowinfo = "";
          Row row = sheet.getRow(rowNum);
          if (row != null) {
            csVehicle = new CsVehicle();
            //遍历列
            //状态默认值
            for (int columnNum=1;columnNum<columns;columnNum++){
              Cell cell = row.getCell(columnNum);
              getExternalData(csVehicle,cell,columnNum);
            }
              //
            if(csVehicleTemp.getCsvAccess()!=null){
              csVehicle.setCsvAccess(csVehicleTemp.getCsvAccess());
            }else{
              csVehicle.setCsvAccess(0);
            }
             //
            if(csVehicleTemp.getCsvHost()!=null){
              csVehicle.setCsvHost(csVehicleTemp.getCsvHost());
            }else{
              csVehicle.setCsvHost(0);
            }
            if(csVehicleTemp.getCsvStatus()!=null){
              csVehicle.setCsvStatus(csVehicleTemp.getCsvStatus());
            }else{
              csVehicle.setCsvStatus((short)1);
            }
            if(csVehicleTemp.getCsvModel()!=null){
              csVehicle.setCsvModel(csVehicleTemp.getCsvModel());
            }else{
              csVehicle.setCsvModel(0);
            }
            csVehicle.setCsvAddTime(new Date());
            csVehicle.setCsvUpdateTime(new Date());
            externalList.add(csVehicle);
          }
        }
        break;
      }
      return externalList;
    }catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public  void getExternalData(CsVehicle csVehicle, Cell cell, int columnNum) {
    if (cell != null) {
      cell.setCellType(Cell.CELL_TYPE_STRING);
      String value = cell.getStringCellValue();
      if (null!=value&&!"".equals(value)){
        switch (columnNum) {
          //真实车牌号CsvCarNo
          case 1:
            csVehicle.setCsvCarNo(value);
            break;
          //车架号vin
          case 2:
            csVehicle.setCsvVin(value);
            break;
          //发动机号csv_engine_no
          case 3:
            csVehicle.setCsvEngineNo(value);
            break;
          //合格证号csv_certific
          case 4:
            csVehicle.setCsvCertific(value);
            break;
          //颜色csv_color
          case 5:
            csVehicle.setCsvColor(Integer.parseInt(value));
            break;
          case 6:
            //终端编号---判断==能否绑定
            CsMachine record = new CsMachine();
            record.setCsmTeNo(value);
            CsMachine csMachine = csMachineService.selectOne(record);
            if (csMachine != null) {
              CsVehicle vehicleRecord=new CsVehicle();
              vehicleRecord.setCsvMachine(csMachine.getCsmId());
              if(csVehicleService.selectCount(vehicleRecord)<1){//绑定
                csVehicle.setCsvMachine(csMachine.getCsmId());
              }
            }
            break;
          case 7:
            //车颜色代码csv_color_code
            csVehicle.setCsvColorCode(Short.parseShort(value));
            break;
          case 8:
            //可充电储能系统编码csv_bataccu_code
            csVehicle.setCsvBataccuCode(value);
            break;
          case 9:
            //出厂日期csv_prod_date
            try{
              SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              Date dateTime =dff.parse(value);
              csVehicle.setCsvProdDate(dateTime);
            }catch (Exception e){
              e.printStackTrace();
            }
            break;
          case 10:
            //地标类型csv_landmark
            csVehicle.setCsvLandmark(value);
            break;
          case 11:
            //车辆领域csv_domain
            csVehicle.setCsvDomain(Short.parseShort(value));
            break;
          case 12:
            //车型代码csv_model_code_full
            csVehicle.setCsvModelCodeFull(value);
            break;
          case 13:
            //车型备案型号csv_model_code_simple
            csVehicle.setCsvModelCodeSimple(value);
            break;
          case 14:
            //内饰颜色csv_interior_color_code
            csVehicle.setCsvInteriorColorCode(value);
            break;
        }
      }
    }
  }

  @RequestMapping(value = "/mappingRelationBatch", method = RequestMethod.POST)
  public VoResult<?>  mappingRelationBatch(@CookieValue("token") String token,@RequestParam("fileUpload") MultipartFile fileUpload) {
    SrvUser user = userAccessUtils.getCurrentUser(token);
    SrvGroup srvGroup = srvGroupService.selectByPrimaryKey(user.getSuGroup().intValue());
    if (srvGroup==null||!"platform_user".equals(srvGroup.getSgFlag())){
      return  VoResult.error(null,"不是企业用户");
    }
    List<String> vinList=getConditionVinList(fileUpload);
    if(vinList!=null&&vinList.size()>0){
      CsVehicleCrieria  example=new CsVehicleCrieria();
      CsVehicleCrieria.Criteria criteria=example.createCriteria();
      //
      criteria.andcsvVinIn(vinList);
      List<CsVehicle> csVehicleList=csVehicleService.selectByExample(example);
      //--
      List<Integer> mapCarList=new ArrayList<>();
      for (CsVehicle csVehicle:csVehicleList){
        mapCarList.add(csVehicle.getCsvId());
      }
      //
      CsMappingCrieria mapingExample=new CsMappingCrieria();
      CsMappingCrieria.Criteria mapingCriteria1=mapingExample.createCriteria();
      mapingCriteria1.andcsmCarIn(mapCarList);
      mapingCriteria1.andcsmManageEqualTo(user.getSuId());
      List<CsMapping>mappingList=csMappingService.selectByExample(mapingExample);
      Map<Integer,Object>mapingMap=new HashMap<>(mappingList.size());
      for(CsMapping csMapping:mappingList){
        mapingMap.put(csMapping.getCsmCar(),null);
      }
      //过滤掉重复的数据
      List<CsMapping> csMappingList=new ArrayList<>();
      CsMapping csMapping=null;
       for (CsVehicle csVehicle:csVehicleList){
            if (!mapingMap.containsKey(csVehicle.getCsvId())){
              csMapping=new CsMapping();
              csMapping.setCsmCar(csVehicle.getCsvId());
              csMapping.setCsmManage(user.getSuId());
              csMappingList.add(csMapping);
            }
       }
       if (csMappingList!=null&&csMappingList.size()>0){
         csMappingService.insertBatchSelective(csMappingList);
       }
    }
    return  VoResult.success();
  }

  //从excel中获取csVehicle中内容=
  public  List<String> getConditionVinList(MultipartFile file){
    List<String> externalList=new ArrayList<>();
    try {
      Workbook workbook=null;
      InputStream is = file.getInputStream();
      String excelName= file.getOriginalFilename();
      if(excelName.indexOf(".xlsx")>-1){
        workbook = new XSSFWorkbook(is);
      }else{
        workbook = new HSSFWorkbook(is);
      }
      // 循环工作表Sheet--从第三行开始计算
      for (int numSheet =0; numSheet < 1; numSheet++) {
        Sheet sheet = workbook.getSheetAt(numSheet);
        if (sheet == null) {
          continue;
        }
        int rows=sheet.getPhysicalNumberOfRows();
        int columns=sheet.getRow(1).getPhysicalNumberOfCells();//从第二行开始算
        // 循环行Row
        for (int rowNum = 1; rowNum < rows; rowNum++) {
          Row row = sheet.getRow(rowNum);
          if (row != null) {
            //遍历列
            //状态默认值
              Cell cell = row.getCell(0);
              externalList.add(cell.getStringCellValue());
          }
        }
        break;
      }
      return externalList;
    }catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }




}
