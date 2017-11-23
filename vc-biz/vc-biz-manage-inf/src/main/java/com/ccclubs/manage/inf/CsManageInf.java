package com.ccclubs.manage.inf;

import com.ccclubs.manage.orm.model.CsManage;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 10:35
 * Email:fengjun@ccclubs.com
 */
public interface CsManageInf {
    CsManage getCsManageById(Integer id);

    CsManage getCsManageByUserName(String userName);
    /**
     * 检查用户名和密码，如果匹配则返回完整CsManage类型。交由业务逻辑代码处理。
     * */
    CsManage checkUserPassword(String username,String password);
}
