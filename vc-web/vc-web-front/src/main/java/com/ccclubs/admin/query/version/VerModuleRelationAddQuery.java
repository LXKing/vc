package com.ccclubs.admin.query.version;

import com.ccclubs.admin.model.VerModuleRelation;

import java.util.List;

/**
 * @Author: yeanzi
 * @Date: 2018/4/13
 * @Time: 10:30
 * Email:  yeanzhi@ccclubs.com
 */
public class VerModuleRelationAddQuery {

    private List<VerModuleRelation> relationList;

    public List<VerModuleRelation> getRelationList() {
        return relationList;
    }

    public VerModuleRelationAddQuery setRelationList(List<VerModuleRelation> relationList) {
        this.relationList = relationList;
        return this;
    }
}
