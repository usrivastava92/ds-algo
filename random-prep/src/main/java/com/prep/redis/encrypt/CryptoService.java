package com.prep.redis.encrypt;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;


public class CryptoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CryptoService.class);
    private static final String UNIQUECRYPTO = "pgp-theia:";

    public static void setEncryptionData(Object value) {
        if (isRedisEncryptPresent(value)) {
            try {
                setCryptographyObject(value, CryptoType.ENCRYPT);
            } catch (Exception e) {
                LOGGER.error(" Exception Occurred while encryption the data ", e);
            }
        }
    }

    public static Object getDecryptionData(Object value) {
        if (isRedisEncryptPresent(value)) {
            try {
                setCryptographyObject(value, CryptoType.DECRYPT);
            } catch (Exception e) {
                LOGGER.error(" Exception Occurred while decryption the data ", e);
                return null;
            }
        }
        return value;
    }

    private static boolean isRedisEncryptPresent(Object value) {
        if (value != null) {
            Class<?> className = value.getClass();
            if (className != null && className.getAnnotationsByType(RedisEncrypt.class).length > 0) {
                return true;
            }
        }
        return false;
    }

    private static void setCryptographyObject(Object value, final CryptoType cryptoType) throws Exception {

        if (value != null) {
            Class<?> aClass = value.getClass();
            if (aClass != null) {
                List<Field> fields = MetaDataUtil.cacheDeclaredFieldsIfNecessary(aClass);
                if (fields.size() > 0) {
                    for (Field field : fields) {
                        if (field != null) {
                            field.setAccessible(true);
                            Object encryptObj = field.get(value);
                            if (encryptObj != null) {
                                if (encryptObj instanceof List<?>) {
                                    for (Object object : (List<?>) encryptObj) {
                                        if (isRedisEncryptPresent(object)) {
                                            setCryptographyObject(object, cryptoType);
                                        }
                                    }
                                } else {
                                    if (field.getType().getAnnotationsByType(RedisEncrypt.class).length > 0) {
                                        setCryptographyObject(encryptObj, cryptoType);
                                    } else if (field.getType().equals(String.class)) {
                                        encryptionDecryptionAttribute(field, value, cryptoType);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    private static void encryptionDecryptionAttribute(Field field, Object value, CryptoType cryptoType) throws Exception {
        if (field != null && value != null && cryptoType != null) {
            if (CryptoType.ENCRYPT == cryptoType) {
                encryptField(field, value);
            } else if (CryptoType.DECRYPT == cryptoType) {
                decryptField(field, value);
            }
        }
    }

    private static void encryptField(Field field, Object obj) throws Exception {
        try {
            if (field != null && obj != null) {
                //LOGGER.info("Encrypted the Sensitive Data");
                String fieldValue = (String) field.get(obj);
                if (StringUtils.isNotBlank(fieldValue)) {
                    fieldValue = CryptoUtils.encryptAES(fieldValue);
                    if (!StringUtils.isEmpty(fieldValue))
                        field.set(obj, UNIQUECRYPTO + fieldValue);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception Occurred while Encryption During Storing in Redis", e);
            throw e;
        }
    }

    private static void decryptField(Field field, Object obj) throws Exception {
        try {
            if (obj != null && field != null) {
                //LOGGER.info("Decrypted the Sensitive Data");
                String fieldValue = (String) field.get(obj);
                if (StringUtils.isNotBlank(fieldValue)) {
                    if (fieldValue.startsWith(UNIQUECRYPTO)) {
                        fieldValue = fieldValue.replace(UNIQUECRYPTO, StringUtils.EMPTY);
                        fieldValue = CryptoUtils.decryptAES(fieldValue);
                        field.set(obj, fieldValue);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception Occurred while Decrytion During Storing in Redis", e);
            throw e;
        }
    }

}
