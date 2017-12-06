package com.ccclubs.phoenix.util;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
public class QueryUtil {

    public static String fetchQueryFields(String queryFields){
        return fetchQueryFields(queryFields, ImmutableList.of("*"));
    }

    public static String fetchQueryFields(String queryFields,List<String> defaultFields){
        String retFields=StringUtils.join(defaultFields,",");
        queryFields = StringUtils.deleteWhitespace(queryFields);
        if(StringUtils.isNotEmpty(queryFields)){
            retFields = queryFields;
        }
        return retFields;
    }


}
