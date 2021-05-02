package com.leet.ds.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {

    }

    private static final class TimeMap {

        private final Map<String, TreeMap<Integer, String>> map;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                Integer floorKey = map.get(key).floorKey(timestamp);
                if (floorKey != null) {
                    return map.get(key).get(floorKey);
                }
            }
            return "";
        }
    }

}
