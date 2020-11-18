package com.leet.ds.string;

import java.util.TreeMap;

public class IncreasingDecreasingString {

    public static void main(String[] args) {
        IncreasingDecreasingString increasingDecreasingString = new IncreasingDecreasingString();
        String[] inputs = {"aaaabbbbcccc", "rat", "leetcode", "ggggggg", "spo"};
        int testCase = 0;
        System.out.println(increasingDecreasingString.sortString(inputs[testCase]));
    }

    public String sortString(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!map.isEmpty()) {
            for (Character key : map.keySet()) {
                int val = map.get(key) - 1;
                sb.append(key);
                if (val == 0) {
                    map.remove(key);
                } else {
                    map.put(key, val);
                }
            }
            for (Character key : map.descendingKeySet()) {
                int val = map.get(key) - 1;
                sb.append(key);
                if (val == 0) {
                    map.remove(key);
                } else {
                    map.put(key, val);
                }
            }
        }
        return sb.toString();
    }
}