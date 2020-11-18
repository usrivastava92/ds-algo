package com.leet.daysofcode.may.week3;

import java.util.*;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        String[] ss = {"abab", "cbaebabacd"};
        String[] ps = {"ab", "abc"};
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        for (int i = 0; i < ss.length; i++) {
            System.out.println(findAllAnagramsInAString.findAnagrams1(ss[i], ps[i]));
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int window = p.length();
        if (p == null || window == 0 || s == null || s.length() == 0) {
            return list;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (Character ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }
        for (int i = 0; i < window && i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        if (areEqual(sCount, pCount)) {
            list.add(0);
        }
        for (int i = 0, len = s.length() - window; i < len; i++) {
            sCount[s.charAt(i + window) - 'a']++;
            sCount[s.charAt(i) - 'a']--;
            if (areEqual(sCount, pCount)) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public boolean areEqual(int[] arr1, int arr2[]) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> findAnagrams1(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();

        int begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;
            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }
}