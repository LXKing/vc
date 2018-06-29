package com.ccclubs.gateway.jt808.util;

import java.util.HashMap;

/**
 * @Author: yeanzi
 * @Date: 2018/6/28
 * @Time: 16:17
 * Email:  yeanzhi@ccclubs.com
 * 构建redis对象map
 */
public class RedisObjectBuilder {




    public static class RedisObj extends HashMap<String, Object> {
        private String idKey;

        public RedisObj(String idKey) {
            this.idKey = idKey;
        }

        @Override
        public RedisObj put(String objKey, Object value) {
            super.put(objKey, value);
            return this;
        }

        public String getIdKey() {
            return idKey;
        }

        public RedisObj setIdKey(String idKey) {
            this.idKey = idKey;
            return this;
        }
    }

}
