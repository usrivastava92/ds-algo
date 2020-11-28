package com.app;

import java.util.HashMap;
import java.util.Map;

public class RomanDecimalConverter {

    public static int romanToInt(String roman) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        String[] bars = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int len = bars.length;
        while (!roman.equals("")) {
            for (int i = 0; i < len; i++) {
                String bar = bars[i];
                if (roman.startsWith(bar)) {
                    ans += map.get(bar);
                    if (roman.equals(bar)) {
                        roman = "";
                    } else {
                        roman = roman.substring(bar.length());
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RomanDecimalConverter romanDecimalConverter = new RomanDecimalConverter();
        romanDecimalConverter.remAnagrams("basgadhbfgvhads", "sjdhgvbjdsbhvbvd");
    }

    public int remAnagrams(String s, String s1) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] ch1 = s.toCharArray();
        char[] ch2 = s1.toCharArray();
        for (Character ch : ch1) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : ch2) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map1);
        System.out.println(map2);
        int change = 0;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            change += Math.abs(entry.getValue() - map2.getOrDefault(entry.getKey(), 0));
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey())) {
                change += entry.getValue();
            }
        }
        return change;
    }


}
