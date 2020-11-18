package com.ib.dp;

import com.ds.utils.ArrayUtils;

public class MaxSumWithoutAdjacentElements {

    public static void main(String[] args) {
        int[][][] inputs = {{{1}, {2}}, {{1, 2, 3, 4}, {2, 3, 4, 5}}, {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}}, {{16, 5, 54, 55, 36, 82, 61, 77, 66, 61}, {31, 30, 36, 70, 9, 37, 1, 11, 68, 14}}};
        int[] outputs = {2, 8, 12, 321};
        MaxSumWithoutAdjacentElements maxSumWithoutAdjacentElements = new MaxSumWithoutAdjacentElements();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Inputs : ");
            ArrayUtils.printArr(inputs[i]);
            System.out.println("Output : " + maxSumWithoutAdjacentElements.adjacent(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("######################################");
        }
    }

    public int adjacent(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        int globalMaxSum = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int row1MaxSum = A[0][i];
            int row2MaxSum = A[1][i];
            for (int prev = i - 2; prev > -1; prev--) {
                int sum1Row1 = A[0][i] + dp[0][prev];
                int sum2Row1 = A[0][i] + dp[1][prev];
                row1MaxSum = Math.max(row1MaxSum, Math.max(sum1Row1, sum2Row1));

                int sum1Row2 = A[1][i] + dp[0][prev];
                int sum2Row2 = A[1][i] + dp[1][prev];
                row2MaxSum = Math.max(row2MaxSum, Math.max(sum1Row2, sum2Row2));
            }
            if (row1MaxSum > globalMaxSum) {
                globalMaxSum = row1MaxSum;
            }
            if (row2MaxSum > globalMaxSum) {
                globalMaxSum = row2MaxSum;
            }
            dp[0][i] = row1MaxSum;
            dp[1][i] = row2MaxSum;
        }
        ArrayUtils.printArr(dp);
        return globalMaxSum;
    }

}
