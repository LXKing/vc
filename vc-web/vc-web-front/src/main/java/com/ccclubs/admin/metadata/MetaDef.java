package com.ccclubs.admin.metadata;

import com.ccclubs.admin.AppContext;
import com.ccclubs.admin.entity.CsMachineCrieria;
import com.ccclubs.admin.entity.SrvDictCrieria;
import com.ccclubs.admin.model.*;
import com.ccclubs.admin.service.*;
import java.util.List;

import com.ccclubs.frm.spring.resolver.IDictMetaData;
import com.ccclubs.frm.spring.resolver.IMetaData;
import org.apache.commons.lang3.StringUtils;


public class MetaDef {

  /**
   * 根据接入商Id，获取接入商名称
   */
  public final static IMetaData getUserName = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ISrvUserService srvUserService = AppContext.CTX.getBean(ISrvUserService.class);
      if (null != srvUserService && null != data && !StringUtils.isEmpty(data.toString())) {
        SrvUser record = srvUserService.selectByPrimaryKey(data);
        if (null != record) {
          return (T) record.getSuUsername();
        }
      }
      return null;
    }
  };

  /**
   * 根据接入商Id，获取接入商名称
   */
  public final static IMetaData getAccessName = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ISrvHostService srvHostService = AppContext.CTX.getBean(ISrvHostService.class);
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
      ISrvDictService srvDictService = AppContext.CTX.getBean(ISrvDictService.class);
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
      ICsModelService csModelService = AppContext.CTX.getBean(ICsModelService.class);
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
      ICsMachineService csMachineService = AppContext.CTX.getBean(ICsMachineService.class);
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
   * 根据 CsMachine id 获取终端序列号
   */
  public final static IMetaData getMachineInfo = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ICsMachineService csMachineService = AppContext.CTX.getBean(ICsMachineService.class);
      if (null != csMachineService && null != data && !StringUtils.isEmpty(data.toString())) {
        CsMachineCrieria query = new CsMachineCrieria();
        CsMachineCrieria.Criteria c = query.createCriteria();
        c.andcsmNumberEqualTo(data.toString());
        List<CsMachine> recordList = csMachineService.selectByExample(query);
        if (recordList != null && recordList.size() > 0) {
          return (T) (recordList.get(0).getCsmTeNo());
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
      ICsVehicleService csVehicleService = AppContext.CTX.getBean(ICsVehicleService.class);
      if (null != csVehicleService && null != data && !StringUtils.isEmpty(data.toString())) {
        CsVehicle record = csVehicleService.selectByPrimaryKey(data);
        if (null != record) {
          return (T) record.getCsvVin();
        }
      }
      return null;
    }
  };

  /**
   * 依据 Id 获取指令类型名称
   */
  public final static IMetaData getStructName = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      ICsStructService structService = AppContext.CTX.getBean(ICsStructService.class);
      if (null != structService && null != data && !StringUtils.isEmpty(data.toString())) {
        CsStruct record = structService.selectByPrimaryKey(data);
        if (null != record) {
          return (T) record.getCssName();
        }
      }
      return null;
    }
  };

    /**
     * 根据 Id 获取版本描述
     *    格式：
     *      版本号（版本描述）
     *     如：
     *      v1.0.0（测试版本）
     */
    public final static IMetaData getVersionNo = new IMetaData() {
        @Override
        public <T> T get(Object data) {
            IVerSoftHardwareService verSoftHardwareService = AppContext.CTX.getBean(IVerSoftHardwareService.class);
            if (null != verSoftHardwareService && null != data && !StringUtils.isEmpty(data.toString())) {
                VerSoftHardware record = verSoftHardwareService.selectByPrimaryKey(data);
                if (null != record) {
                    // 将版本号拼装成 版本号（版本描述）的格式展示
                    StringBuilder desSb = new StringBuilder();
                    desSb.append(record.getVerNo())
                            .append("\n（")
                            .append(record.getdes())
                            .append("）");
                    return (T) desSb.toString();
                }
            }
            return null;
        }
    };

    /**
     * 根据版本升级ID显示为
     *    ID + （描述）的描述格式
     */
    public final static IMetaData getUpgradeVersionNo = new IMetaData() {
        @Override
        public <T> T get(Object data) {
            IVerUpgradeService verUpgradeService = AppContext.CTX.getBean(IVerUpgradeService.class);
            if (null != verUpgradeService && null != data && !StringUtils.isEmpty(data.toString())) {
                VerUpgrade record = verUpgradeService.selectByPrimaryKey(data);
                if (null != record) {
                    // 将版本号拼装成 版本号（版本描述）的格式展示
                    StringBuilder desSb = new StringBuilder();
                    desSb.append(record.getUpVerNo())
                            .append("\n（")
                            .append(record.getdes())
                            .append("）");
                    return (T) desSb.toString();
                } else {
                    /**
                     * fixme 当前版本信息不存在时，展示原参数
                     * 这样做是为了在用插件版本ID查不到当前升级版本信息时，展示插件版本ID
                     */
                    return (T) String.valueOf(data);
                }
            }
            return null;
        }
    };

    /**
     * 根据模块关联ID获取模块关联ID值描述
     */
    public final static IMetaData getModuleDesByRelationId = new IMetaData() {
        @Override
        public <T> T get(Object data) {
            IVerModuleRelationService verModuleRelationService = AppContext.CTX.getBean(IVerModuleRelationService.class);
            IVerModuleService verModuleService = AppContext.CTX.getBean(IVerModuleService.class);
            if (null != verModuleService && null != verModuleRelationService && null != data && !StringUtils.isEmpty(data.toString())) {
                VerModuleRelation relation = verModuleRelationService.selectByPrimaryKey(data);
                VerModule module = verModuleService.selectByPrimaryKey(relation.getModuleId());
                if (relation.getModuleVal() != null && module.getDataValue() != null) {
                    String[] vals = module.getDataValue().split(";");
                    for (String item :
                            vals) {
                        String key = item.split("=")[0];
                        String value = item.split("=")[1];
                        if (relation.getModuleVal().equals(key)) {
                            return (T) value;
                        }
                    }
                }
            }
            return null;
        }
    };

    /**
     * 获取ftp文件服务器描述信息（名称）
     */
    public final static IMetaData getFtpServerName = new IMetaData() {
        @Override
        public <T> T get(Object data) {
            IVerFtpSerService verFtpSerService = AppContext.CTX.getBean(IVerFtpSerService.class);
            if (null != verFtpSerService && null != data && !StringUtils.isEmpty(data.toString())) {
                VerFtpSer record = verFtpSerService.selectByPrimaryKey(data);

                if (null != record) {
                    return (T) record.getname();
                }
            }
            return null;
        }
    };

}
