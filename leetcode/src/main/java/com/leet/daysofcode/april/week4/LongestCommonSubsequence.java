package com.leet.daysofcode.april.week4;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String[] text1 = {"abcde", "abc", "abc", "ezupkr", "bsbininm", "oxcpqrsvwf"};
        String[] text2 = {"ace", "abc", "def", "ubmrapg", "jmjkbkjkv", "shmtulqrypy"};

        int testCase = 5;

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1[testCase], text2[testCase]));
    }


    Map<String, Integer> dp = new HashMap<>();

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.trim().length() == 0 || text2.trim().length() == 0) {
            return 0;
        }
        dp.clear();
        return helper(0, 0, text1, text2);
    }

    private int helper(int i, int j, String text1, String text2) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        String key = i + "," + j;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int ans;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + helper(i + 1, j + 1, text1, text2);
        } else {
            ans = Math.max(helper(i + 1, j, text1, text2), helper(i, j + 1, text1, text2));
        }
        dp.put(key, ans);
        return ans;
    }

}
