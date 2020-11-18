package com.ib.hashing;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        WindowString windowString = new WindowString();
        System.out.println(windowString.minWindow(S, T));
    }

    public String minWindow(String A, String B) {
        if (A.contains(B)) {
            return B;
        }
        Map<Character, Integer> mapB = getMap(B);
        for (int windowSize = B.length(), aSize = A.length(); windowSize <= aSize; windowSize++) {
            for (int i = 0, size = A.length() - windowSize; i <= size; i++) {
                String subString = A.substring(i, i + windowSize);
                if (mapEquals(mapB, getMap(subString))) {
                    return subString;
                }
            }
        }
        return "";
    }

    private boolean mapEquals(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {
        for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            if (!mapB.containsKey(entry.getKey()) || mapB.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }

}
