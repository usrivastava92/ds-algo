package com.ib.dp;

import java.util.stream.IntStream;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String[] As = {"abbcdgf"};
        String[] Bs = {"bbadcgf"};
        int[] outputs = {5};
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A -> " + As[i] + " B -> " + Bs[i]);
            System.out.println("Output : " + longestCommonSubsequence.solve(As[i], Bs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int solve(String A, String B) {
        if (A == null || A.trim().length() == 0 || B == null || B.trim().length() == 0) {
            return 0;
        }
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
