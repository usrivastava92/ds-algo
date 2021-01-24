package com.prep.redis.encrypt;

public class CryptoUtils {
    private static String ALGTHM_TYPE_AES = "AES_";

    private CryptoUtils() {
    }

    public static String encryptAES(String value) throws SecurityException {
        return ALGTHM_TYPE_AES + value;
    }

    public static String decryptAES(String value) throws SecurityException {
        return value.replace(ALGTHM_TYPE_AES, "");
    }
}
