package com.ib.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 1, 5}, {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}, {10, 9, 2, 5, 3, 7, 101, 18}};
        int[] outputs = {3, 6, 4};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Inputs : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + longestIncreasingSubsequence.lis(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("#########################################");
        }
    }


    public int lis(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] dp = new int[A.length];
        int globalMax = 0;
        for (int i = 0; i < A.length; i++) {
            int maxLen = 0;
            for (int j = i - 1; j > -1; j--) {
                if (A[j] < A[i] && dp[j] > maxLen) {
                    maxLen = dp[j];
                }
            }
            dp[i] = maxLen + 1;
            if (dp[i] > globalMax) {
                globalMax = dp[i];
            }
        }
        return globalMax;
    }

}
