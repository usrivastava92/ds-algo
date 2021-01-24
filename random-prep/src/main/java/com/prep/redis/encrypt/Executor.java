package com.prep.redis.encrypt;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class Executor {

    public static void main(String[] args) {
        String key = "key";
        Object value = new TestEnc("value");
        encSet(key, value);
        System.out.println(RedisUtils.get(key));
        System.out.println(encGet(key));
    }

    private static void encSet(String key, Object value) {
        CryptoService.setEncryptionData(value);
        RedisUtils.set(key, value);
    }

    private static Object encGet(String key) {
        return CryptoService.getDecryptionData(RedisUtils.get(key));
    }

    @RedisEncrypt
    @ToString
    @AllArgsConstructor
    private static class TestEnc {

        @RedisEncryptAttribute
        private String name;

    }

}
