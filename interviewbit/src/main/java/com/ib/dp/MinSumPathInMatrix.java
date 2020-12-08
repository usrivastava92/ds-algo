package com.ib.dp;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class MinSumPathInMatrix {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 3, 2}, {4, 3, 1}, {5, 6, 1}}};
        int[] outputs = {8};
        MinSumPathInMatrix minSumPathInMatrix = new MinSumPathInMatrix();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            System.out.println("####################################");
            int output = minSumPathInMatrix.minPathSum(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int minPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 > -1 && j - 1 > -1) {
                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i - 1 > -1) {
                    dp[i][j] = A[i][j] + dp[i - 1][j];
                } else if (j - 1 > -1) {
                    dp[i][j] = A[i][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = A[i][j];
                }
            }
        }
        ArrayUtils.printArr(dp);
        return dp[n - 1][m - 1];
    }

}
