package com.ib.hashing;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {


    public static void main(String... args) {
        LongestSubstringWithoutRepeat longestSubstringWithoutRepeat = new LongestSubstringWithoutRepeat();
        System.out.println(longestSubstringWithoutRepeat.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String A) {
        if (A.length() == 0) {
            return 0;
        }
        int max = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = A.length(); i < j; i++) {
            Character ch = A.charAt(i);
            if (map.containsKey(ch)) {
                i = map.get(ch);
                if (len > max) {
                    max = len;
                }
                len = 0;
                map.clear();
            } else {
                map.put(ch, i);
                len++;
            }
        }
        if (len > max) {
            max = len;
        }
        return max;
    }

}
