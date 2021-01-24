package com.prep.redis.encrypt;

import java.util.HashMap;
import java.util.Map;

public class RedisUtils {

    private static Map<String, Object> map = new HashMap<>();

    public static void set(String key, Object val) {
        map.put(key, val);
    }

    public static Object get(String key) {
        return map.get(key);
    }

}
