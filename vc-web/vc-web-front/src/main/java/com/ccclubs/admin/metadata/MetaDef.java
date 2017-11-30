package com.ccclubs.admin.metadata;

import com.ccclubs.admin.config.SpringUtil;
import com.ccclubs.admin.entity.CsMachineCrieria;
import com.ccclubs.admin.entity.SrvDictCrieria;
import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.model.CsModel;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.SrvDict;
import com.ccclubs.admin.model.SrvHost;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.service.ICsModelService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.service.ISrvDictService;
import com.ccclubs.admin.service.ISrvHostService;
import com.ccclubs.admin.vo.IDictMetaData;
import com.ccclubs.admin.vo.IMetaData;
import java.util.List;
import org.apache.commons.lang3.StringUtils;


public class MetaDef {

  /**
   * 根据接入商Id，获取接入商名称
   */
  public final static IMetaData getAccessName = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ISrvHostService srvHostService = SpringUtil.getBean(ISrvHostService.class);
      if (null != srvHostService && null != data && !StringUtils.isEmpty(data.toString())) {
        SrvHost record = srvHostService.selectByPrimaryKey(data);
        if (null != record) {
          return (T) record.getShName();
        }
      }
      return null;
    }
  };

  /**
   * 根据字典表 type，及 value 获取 label
   */
  public final static IDictMetaData getDictLabel = new IDictMetaData() {

    @Override
    public <T> T get(String type, Object data) {
      ISrvDictService srvDictService = SpringUtil.getBean(ISrvDictService.class);
      if (srvDictService != null && data != null && !StringUtils.isEmpty(type)) {
        SrvDictCrieria query = new SrvDictCrieria();
        SrvDictCrieria.Criteria c = query.createCriteria();
        c.andtypeEqualTo(type);
        c.andvalueEqualTo(data.toString());
        List<SrvDict> recordList = srvDictService.selectByExample(query);
        if (recordList != null && recordList.size() > 0) {
          return (T) recordList.get(0).getlabel();
        }
      }
      return null;
    }
  };


  /**
   * 根据城市ID获取名称
   */
  public final static IMetaData getVehicleModelName = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ICsModelService csModelService = SpringUtil.getBean(ICsModelService.class);
      if (null != csModelService && null != data && !StringUtils.isEmpty(data.toString())) {
        CsModel record = csModelService.selectByPrimaryKey(data);
        if (null != record) {
          return (T) record.getCsmName();
        }
      }
      return null;
    }
  };

  /**
   * 根据 CsMachine id 获取序列号
   */
  public final static IMetaData getMachineTeNo = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ICsMachineService csMachineService = SpringUtil.getBean(ICsMachineService.class);
      if (null != csMachineService && null != data && !StringUtils.isEmpty(data.toString())) {
        CsMachine record = csMachineService.selectByPrimaryKey(data);
        if (null != record) {
          return (T) record.getCsmTeNo();
        }
      }
      return null;
    }
  };

  /**
   * 根据 CsMachine id 获取序列号
   */
  public final static IMetaData getMachineInfo = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ICsMachineService csMachineService = SpringUtil.getBean(ICsMachineService.class);
      if (null != csMachineService && null != data && !StringUtils.isEmpty(data.toString())) {
        CsMachineCrieria query = new CsMachineCrieria();
        CsMachineCrieria.Criteria c = query.createCriteria();
        c.andcsmNumberEqualTo(data.toString());
        List<CsMachine> recordList = csMachineService.selectByExample(query);
        if (recordList != null && recordList.size() > 0) {
          return (T) (recordList.get(0).getCsmTeNo()+"("+recordList.get(0).getCsmMobile()+")");
        }
      }
      return null;
    }
  };


  /**
   * 依据 carId 获取VIN码信息
   */
  public final static IMetaData getVehicleVin = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ICsVehicleService csVehicleService = SpringUtil.getBean(ICsVehicleService.class);
      if (null != csVehicleService && null != data && !StringUtils.isEmpty(data.toString())) {
        CsVehicle record = csVehicleService.selectByPrimaryKey(data);
        if (null != record) {
          return (T) record.getCsvVin();
        }
      }
      return null;
    }
  };

}
