package com.ccclubs.admin.controller.base;

import com.ccclubs.admin.entity.CsMachineCrieria;
import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.query.CsMachineQuery;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

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
    ReportThread reportThread;

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
            map.put("text", data.getCsmNumber() + "(" + data.getCsmTeNo() + ")" + "(" + data.getCsmMobile() + ")");
            mapList.add(map);
        }
        return VoResult.success().setValue(mapList);
    }


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
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public VoResult<String> getReport(@RequestBody ReportParam<CsMachineQuery> reportParam
    ) {

        //logger.error(clms.toString());

        List<CsMachine> list;
        if (reportParam.getAllReport() == 0) {
            PageInfo<CsMachine> pageInfo = csMachineService.getPage(
                    reportParam.getQuery().getCrieria(),
                    reportParam.getPage(),
                    reportParam.getRows());
            list = pageInfo.getList();
        } else {
            list = csMachineService.getAllByParam(reportParam.getQuery().getCrieria());
        }


        for (CsMachine data : list) {
            registResolvers(data);
        }

        String uuid = UUID.randomUUID().toString();
        reportThread.setBaseName("Machine");
        reportThread.setList(list);
        reportThread.setUserUuid(uuid);
        reportThread.setReportParam(reportParam);
        logger.info("start running report Machine thread.");
        EvManageContext.getThreadPool().execute(reportThread);

        VoResult<String> r = new VoResult<>();
        r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
        r.setValue(uuid);
        return r;

    }

    /**
     * 批量导入车辆信息
     *
     * @param fileUpload
     * @return
     */
    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public VoResult<?> insertVchicleBatch(@RequestParam("fileUpload") MultipartFile fileUpload, CsMachine csMachineTemp) {
        try {
            List<CsMachine> existList = getConditionVinList(fileUpload, csMachineTemp);
            List<CsMachine> tempList = csMachineService.selectAll();
            Map<String, Object> tempMap = new HashMap<>();
            for (CsMachine csMachine : tempList) {
                String csmTeNo = csMachine.getCsmTeNo();
                String csmMobile = csMachine.getCsmMobile();
                String csmNumber = csMachine.getCsmNumber();
                //
                tempMap.put(csmTeNo, 1);
                tempMap.put(csmMobile, 1);
                tempMap.put(csmNumber, 1);
            }
            //更新vin码相同的list数据
            List<CsMachine> updateList = new ArrayList<>();
            //根据唯一索引==删除list中的数据
            Iterator<CsMachine> it = existList.iterator();
            while (it.hasNext()) {
                CsMachine csMcachine = it.next();
                //csvVin码
                if (csMcachine.getCsmTeNo() != null) {
                    if (tempMap.containsKey(csMcachine.getCsmTeNo())) {
                        updateList.add(csMcachine);
                        it.remove();
                        continue;
                    }
                } else if (csMcachine.getCsmMobile() != null) {
                    if (tempMap.containsKey(csMcachine.getCsmMobile())) {
                        it.remove();
                        continue;
                    }
                } else if (csMcachine.getCsmNumber() != null) {
                    if (tempMap.containsKey(csMcachine.getCsmNumber())) {
                        it.remove();
                        continue;
                    }
                }
            }
            //vin码相同时更新表中数据
//      if (updateList!=null&&updateList.size()>0){
//        csMachineService.updateBatchByExampleSelective( updateList);
//      }
            //插入数据
            if (existList != null && existList.size() > 0) {
                csMachineService.insertBatchSelective(existList);
            }

            return VoResult.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<CsMachine> getConditionVinList(MultipartFile file, CsMachine csMachineTemp) {

        List<CsMachine> externalList = new ArrayList<>();
        try {
            Workbook workbook = null;
            InputStream is = file.getInputStream();
            String excelName = file.getOriginalFilename();
            if (excelName.indexOf(".xlsx") > -1) {
                workbook = new XSSFWorkbook(is);
            } else {
                workbook = new HSSFWorkbook(is);
            }
            // 循环工作表Sheet--从第三行开始计算
            for (int numSheet = 0; numSheet < 1; numSheet++) {
                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet == null) {
                    continue;
                }
                int rows = sheet.getPhysicalNumberOfRows();
                int columns = sheet.getRow(2).getPhysicalNumberOfCells();//从第二行开始算
                // 循环行Row
                CsMachine csMachine = null;
                for (int rowNum = 2; rowNum < rows; rowNum++) {
                    String rowinfo = "";
                    Row row = sheet.getRow(rowNum);
                    if (row != null) {
                        csMachine = new CsMachine();
                        //遍历列
                        //状态默认值
                        for (int columnNum = 1; columnNum < columns; columnNum++) {
                            Cell cell = row.getCell(columnNum);
                            getExternalData(csMachine, cell, columnNum);
                        }
                        csMachine.setCsmAccess(csMachineTemp.getCsmAccess());
                        csMachine.setCsmHost(csMachineTemp.getCsmHost());
                        csMachine.setCsmTeType(csMachineTemp.getCsmTeType());
                        csMachine.setCsmProtocol(csMachineTemp.getCsmProtocol());
                        csMachine.setCsmStatus(csMachineTemp.getCsmStatus());
                        csMachine.setCsmAddTime(new Date());
                        csMachine.setCsmUpdateTime(new Date());
                        externalList.add(csMachine);
                    }
                }
                break;
            }
            return externalList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getExternalData(CsMachine csMachine, Cell cell, int columnNum) {
        if (cell != null) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String value = cell.getStringCellValue();
            if (null != value && !"".equals(value)) {
                switch (columnNum) {

                    case 1:
                        //车机号
                        csMachine.setCsmNumber(value);
                        break;

                    case 2:
                        //终端编号
                        csMachine.setCsmTeNo(value);
                        break;
                    case 3:
                        //终端型号
                        csMachine.setCsmTeModel(value);
                        break;

                    case 4:
                        //手机号码
                        csMachine.setCsmMobile(value);
                        break;

                    case 5:
                        //iccid
                        csMachine.setCsmIccid(value);
                        break;
                }
            }
        }
    }


}
