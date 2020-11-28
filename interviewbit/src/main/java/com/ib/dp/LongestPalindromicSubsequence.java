package com.ib.dp;

import com.ds.utils.ArrayUtils;

import java.util.stream.IntStream;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String[] As = {"bebeeed", "bebdeeedaddecebbbbbabebedc"};
        int[] outputs = {4, 13};
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : " + As[i]);
            System.out.println("Output : " + longestPalindromicSubsequence.solve(As[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int solve(String A) {
        if (A == null || A.trim().length() == 0) {
            return 0;
        }
        int[][] dp = new int[A.length()][A.length()];
        int max = 0;
        for (int subSize = 0; subSize < dp.length; subSize++) {
            for (int start = 0; start < dp.length - subSize; start++) {
                int end = start + subSize;
                if (start == end) {
                    dp[start][end] = 1;
                } else if (A.charAt(start) == A.charAt(end)) {
                    dp[start][end] = 2 + (start + 1 > end - 1 ? 0 : dp[start + 1][end - 1]);
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
                max = Math.max(max, dp[start][end]);
            }
        }
        return max;
    }

}
