package com.ccclubs.admin.controller;

import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.admin.query.HistoryStateQuery;
import com.ccclubs.admin.resolver.HistoryStateResolver;
import com.ccclubs.admin.service.IHistoryStateService;
import com.ccclubs.admin.service.IReportService;
import com.ccclubs.admin.vo.TableResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 车辆状态历史数据Controller
 *
 * @author
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/monitor/historyState")
public class HistoryStateController {

  @Autowired
  IHistoryStateService historyStateService;

  @Autowired
  IReportService reportService;

  /**
   * 获取分页列表数据
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public TableResult<HistoryState> list(HistoryStateQuery query,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer rows,
      @RequestParam(defaultValue = "desc") String order,
      @RequestParam(defaultValue = "true") Boolean isResolve) {

    if (null == query.getCsNumberEquals()) {
      return new TableResult<HistoryState>();
    }
    TableResult<HistoryState> pageInfo = historyStateService.getPage(query, page, rows, order);
    List<HistoryState> list = pageInfo.getData();
    if (null!=list&&list.size()>0){
      for (HistoryState data : list) {
        registResolvers(data, isResolve);
      }
    }

    return pageInfo;
  }


  /**
   * 注册属性内容解析器
   */
  void registResolvers(HistoryState data, Boolean isResolve) {
    if (data != null && isResolve) {
      data.registResolver(HistoryStateResolver.下位机时间.getResolver());
      data.registResolver(HistoryStateResolver.添加时间.getResolver());
      data.registResolver(HistoryStateResolver.充电状态.getResolver());
      data.registResolver(HistoryStateResolver.gps有效性.getResolver());
      data.registResolver(HistoryStateResolver.循环模式.getResolver());
      data.registResolver(HistoryStateResolver.PTC启停.getResolver());
      data.registResolver(HistoryStateResolver.压缩机状态.getResolver());
      data.registResolver(HistoryStateResolver.档风量.getResolver());
      data.registResolver(HistoryStateResolver.省电模式.getResolver());
      data.registResolver(HistoryStateResolver.发动机.getResolver());
      data.registResolver(HistoryStateResolver.网络类型.getResolver());
      data.registResolver(HistoryStateResolver.档位.getResolver());
    }
  }

  /**
   * 根据文本检索车辆历史状态信息并导出。
   */
  @RequestMapping(value = "/report", method = RequestMethod.GET)
  public void getReport(HttpServletResponse res, HistoryStateQuery query,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer rows,
      @RequestParam(defaultValue = "desc") String order,
      @RequestParam(defaultValue = "true") Boolean isResolve) {

    if (null == query.getCsNumberEquals()) {
      return;
    }
    TableResult<HistoryState> pageInfo = historyStateService.getPage(query, page, rows, order);
    List<HistoryState> list = pageInfo.getData();
    for (HistoryState data : list) {
      registResolvers(data, isResolve);
    }

    OutputStream os = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dateNowStr = sdf.format(System.currentTimeMillis());
    /**
     * 命名规则是 表意义+“——”+页号+“——”+页面大小+“——”+日期
     * */
    String fileName = "historyStates_" + page + "_" + rows + "_" + dateNowStr + ".xls";
    try {
      res.setHeader("content-type", "application/vnd.ms-excel");
      res.setContentType("application/vnd.ms-excel");
      res.setHeader("Content-Disposition",
          "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
      os = res.getOutputStream();
      //文件路径
      ByteArrayOutputStream bytes = null;
      bytes = reportService.reportHistoryStates(list);
      os.write(bytes.toByteArray());
      os.flush();
      os.close();
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
