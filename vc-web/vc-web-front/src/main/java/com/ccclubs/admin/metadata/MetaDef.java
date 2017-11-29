package com.ccclubs.admin.metadata;

import com.ccclubs.admin.config.SpringUtil;
import com.ccclubs.admin.entity.SrvDictCrieria;
import com.ccclubs.admin.model.SrvDict;
import com.ccclubs.admin.service.ISrvDictService;
import com.ccclubs.admin.vo.IDictMetaData;
import com.ccclubs.admin.vo.IMetaData;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class MetaDef {

  /**
   * 根据用户名称
   */
  public final static IMetaData getAccessName = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      return null;
    }
  };

  /**
   * 根据城市ID获取名称
   */
  public final static IDictMetaData getDictLabel = new IDictMetaData() {

    @Override
    public <T> T get(String type, Object data) {
      ISrvDictService srvDictService = SpringUtil.getBean(ISrvDictService.class);
      if(srvDictService !=null && data!=null && !StringUtils.isEmpty(type)){
        SrvDictCrieria query = new SrvDictCrieria();
        SrvDictCrieria.Criteria c = query.createCriteria();
        c.andtypeEqualTo(type);
        c.andvalueEqualTo(data.toString());
        List<SrvDict> recordList = srvDictService.selectByExample(query);
        if(recordList!=null&&recordList.size()>0){
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
      return null;
    }
  };

  /**
   * 根据运营商ID获取名称
   */
  public final static IMetaData getMachineTeNo = new IMetaData() {

    @Override
    public <T> T get(Object data) {
      return null;
    }
  };

}
