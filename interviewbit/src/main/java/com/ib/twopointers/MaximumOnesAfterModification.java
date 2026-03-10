package com.ib.twopointers;

public class MaximumOnesAfterModification {

    public int solve(int[] A, int B) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int[] dp = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                sum++;
            }
            dp[i] = sum;
        }
        int i = 0;
        int j = 1;
        int max = 0;
        while (i < len && j < len) {
            int zeros = dp[j] - (i - 1 > -1 ? dp[i - 1] : 0);
            if (zeros > B) {
                i++;
            } else {
                max = Math.max(max, j - i + 1);
                j++;
            }
        }
        return max;
    }

}
