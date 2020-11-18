package com.leet.daysofcode.april.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> key = getCountMap(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<Map<Character,Integer>,List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    private Map<Character, Integer> getCountMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
