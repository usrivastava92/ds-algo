package com.prep.practice;

import java.util.stream.IntStream;

public class MinimumInsertionStepsToMakeAStringPalindrome {

    public static void main(String[] args) {
        String[] inputs = {"zzazz", "mbadm", "leetcode", "g", "no"};
        int[] outputs = {0, 2, 5, 0, 1};
        MinimumInsertionStepsToMakeAStringPalindrome m = new MinimumInsertionStepsToMakeAStringPalindrome();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + m.minInsertions(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int minInsertions(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        int maxPalindromicSubSeqLen = 0;
        for (int i = 0; i < len; i++) {
            for (int start = 0; start + i < len; start++) {
                int end = start + i;
                if (start == end) {
                    dp[start][end] = 1;
                } else {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = 2 + (end - start + 1 == 2 ? 0 : dp[start + 1][end - 1]);
                    } else {
                        dp[start][end] = Math.max(dp[start][end - 1], dp[start + 1][end]);
                    }
                }
                maxPalindromicSubSeqLen = Math.max(maxPalindromicSubSeqLen, dp[start][end]);
            }
//            ArrayUtils.printArr(dp);
  //          System.out.println("#####################");
        }
        return len - maxPalindromicSubSeqLen;
    }
}
