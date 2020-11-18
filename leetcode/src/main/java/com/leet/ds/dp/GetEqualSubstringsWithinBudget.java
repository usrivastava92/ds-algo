package com.leet.ds.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetEqualSubstringsWithinBudget {


    public static void main(String[] args) {
        String[] s = {"abcd", "abcd", "abcd", "anryddgaqpjdw"};
        String[] t = {"bcdf", "cdef", "acde", "zjhotgdlmadcf"};
        int[] maxCost = {3, 3, 0, 5};

        int testCaseIndex = 0;

        GetEqualSubstringsWithinBudget getEqualSubstringsWithinBudget = new GetEqualSubstringsWithinBudget();
        System.out.println(getEqualSubstringsWithinBudget.equalSubstring(s[testCaseIndex], t[testCaseIndex], maxCost[testCaseIndex]));
    }


    public int equalSubstring(String s, String t, int maxCost) {
        Map<Integer, Integer> map = new HashMap<>();
        int cost = 0;
        int maxLen = 0;
        map.put(cost, -1);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            int sChar = s.charAt(i);
            int tChar = t.charAt(i);
            cost += Math.abs(sChar - tChar);
            int key = cost - maxCost;
            if (map.containsKey(key)) {
                int testLen = i - map.get(key);
                if (testLen > maxLen) {
                    maxLen = testLen;
                }
            } else {
                int index = i - maxLen;
                System.out.println(Arrays.toString(dp) + " | index : " + index + " | i : " + (i + 1) + " maxLen : " + maxLen + " key : " + key);
                while (index > -1 && dp[index] > key) {
                    index--;
                }
                index++;
                System.out.println("index : " + index);
                if (index > -1 && index < (len + 1) && dp[index] > key) {
                    int testLen = i + 1 - index;
                    if (testLen > maxLen) {
                        maxLen = testLen;
                    }
                }
            }
            map.put(cost, i);
            dp[i + 1] = cost;
        }
        return maxLen;
    }
}
