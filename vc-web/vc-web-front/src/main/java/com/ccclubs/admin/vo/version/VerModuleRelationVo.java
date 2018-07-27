package com.ccclubs.admin.vo.version;

import com.ccclubs.admin.model.VerModule;

/**
 * @Author: yeanzi
 * @Date: 2018/4/12
 * @Time: 18:40
 * Email:  yeanzhi@ccclubs.com
 * 模块映射关系页面VO
 */
public class VerModuleRelationVo extends VerModule {

    // 版本下的模块映射ID
    private Integer moduleRelationId;

    // 模块对应的值
    private String value;

    // 是否支持该模块
    private Integer isSup;

    public Integer getModuleRelationId() {
        return moduleRelationId;
    }

    public VerModuleRelationVo setModuleRelationId(Integer moduleRelationId) {
        this.moduleRelationId = moduleRelationId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public VerModuleRelationVo setValue(String value) {
        this.value = value;
        return this;
    }

    public Integer getIsSup() {
        return isSup;
    }

    public VerModuleRelationVo setIsSup(Integer isSup) {
        this.isSup = isSup;
        return this;
    }
}
