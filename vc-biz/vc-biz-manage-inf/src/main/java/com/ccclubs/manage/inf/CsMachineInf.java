package com.ccclubs.manage.inf;

import com.ccclubs.manage.dto.CsMachineInput;
import com.ccclubs.manage.orm.model.CsMachine;
import com.ccclubs.manage.dto.CsMachineOutput;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 10:35
 * Email:fengjun@ccclubs.com
 */
public interface CsMachineInf  {
     PageInfo<CsMachine> getCsMachinePage(CsMachineInput csMachineInput);
     CsMachineOutput getCsMachineAll(CsMachineInput csMachineInput);
     List<CsMachine> getCsMachineList(CsMachineInput csMachineInput);
     CsMachine getCsMachineByCsNumber(String csNumber);

     CsMachine getCsMachineById(Integer id);

     /**
      * 删除的时候，只删除一个也当做批量删除。因为一个是批量的特殊情况。
      * 删除的时候要判断是否有权限。
      * 成功返回true，失败返回false
      * */
     boolean deleteCsMachines(CsMachineInput csMachineInput);
     /**
      * 通过id是否为空来判断是插入还是更新。
      * 成功返回true，失败返回false
      * */
     boolean insertOrUpdateCsMachine(CsMachineInput csMachineInput);

}
