package com.synuwxy.demo.eventbus.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by wxy
 * 默认返回的数据模板
 */
public class ResultObject {

    public static Map<String, Object> newInstance(String code, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("Code",code);
        map.put("Data",data);
        return map;
    }
}
