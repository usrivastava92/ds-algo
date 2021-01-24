package com.prep.redis.encrypt;

import java.lang.reflect.Field;
import java.util.*;

public class MetaDataUtil {
    public static final Map<Class<?>, List<Field>> cacheFields = new HashMap<Class<?>, List<Field>>();

    public static List<Field> cacheDeclaredFieldsIfNecessary(Class<?> classz) {
        List<Field> result = cacheFields.get(classz);
        if (result == null || result.isEmpty()) {
            result = extractFieldFromClassHierarchy(classz);
            cacheFields.put(classz, result);
        }
        return result;
    }

    public static List<Field> extractFieldFromClassHierarchy(Class<?> clazz) {
        List<Field> result = new ArrayList<>();
        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        if (fields.size() > 0) {
            for (Field field : fields) {
                if (field != null) {
                    if (field.getAnnotationsByType(RedisEncryptAttribute.class).length > 0) {
                        result.add(field);
                    }
                }
            }
        }
        return result;
    }
}
