package com.leet.daysofcode.year2020.may.week1;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String[] inputs = {"leetcode", "loveleetcode"};
        int testCase = 1;
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
        System.out.println(firstUniqueCharacterInAString.firstUniqChar(inputs[testCase]));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0, len = s.length(); i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
