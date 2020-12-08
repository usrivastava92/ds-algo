package com.ib.dp;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ChainOfPairs {

    public static void main(String[] args) {
        int[][][] As = {{{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}}, {{10, 20}, {1, 2}}};
        int[] outputs = {3, 1};
        ChainOfPairs chainOfPairs = new ChainOfPairs();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input -> " + Arrays.deepToString(As[i]));
            int output = chainOfPairs.solve(As[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int solve(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int[] dp = new int[A.length];
        int globalMax = 0;
        for (int i = 0; i < A.length; i++) {
            int max = 0;
            for (int j = i - 1; j > -1; j--) {
                if (A[j][1] < A[i][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
            globalMax = Math.max(dp[i], globalMax);
        }
        System.out.println(Arrays.deepToString(A));
        return globalMax;
    }

}
