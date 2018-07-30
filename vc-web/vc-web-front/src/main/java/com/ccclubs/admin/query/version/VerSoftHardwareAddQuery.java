package com.ccclubs.admin.query.version;

import com.ccclubs.admin.model.VerSoftHardware;

import java.util.Map;

/**
 * @Author: yeanzi
 * @Date: 2018/4/12
 * @Time: 17:37
 * Email:  yeanzhi@ccclubs.com
 */
public class VerSoftHardwareAddQuery extends VerSoftHardware {

    private Map<Integer, String> relations;

    public Map<Integer, String> getRelations() {
        return relations;
    }

    public VerSoftHardwareAddQuery setRelations(Map<Integer, String> relations) {
        this.relations = relations;
        return this;
    }
}
