package com.ib.dp;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Knapsack01 {

    public static void main(String[] args) {
        int[][] As = {{60, 100, 120}, {10, 20, 30, 40}};
        int[][] Bs = {{10, 20, 30}, {12, 13, 15, 19}};
        int[] Cs = {50, 10};
        int[] outputs = {220, 0};
        Knapsack01 knapsack01 = new Knapsack01();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input -> A : " + Arrays.toString(As[i]) + ", B : " + Arrays.toString(Bs[i]) + ", C : " + Cs[i]);
            int output = knapsack01.solve(As[i], Bs[i], Cs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int solve(int[] A, int[] B, int C) {
        if (A == null || A.length == 0 || C <= 0) {
            return 0;
        }
        int[][] dp = new int[B.length][C + 1];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j <= C; j++) {
                if (j >= B[i]) {
                    dp[i][j] = Math.max(A[i] + (i - 1 > -1 && j - B[i] > -1 ? dp[i - 1][j - B[i]] : 0), i - 1 > -1 ? dp[i - 1][j] : 0);
                } else {
                    dp[i][j] = (i - 1 > -1 ? dp[i - 1][j] : 0);
                }
            }
        }
        ArrayUtils.printArr(dp);
        return dp[B.length - 1][C];
    }

}
