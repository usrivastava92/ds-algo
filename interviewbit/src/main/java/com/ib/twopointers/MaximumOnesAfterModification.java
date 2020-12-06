package com.ib.twopointers;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumOnesAfterModification {

    public static void main(String[] args) {
        int[][] As = {{1, 0, 0, 1, 1, 0, 1}, {1, 0, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0}};
        int[] Bs = {1, 2, 1};
        int[] outputs = {4, 5, 2};
        MaximumOnesAfterModification maximumOnesAfterModification = new MaximumOnesAfterModification();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : " + Arrays.toString(As[i]) + ", B : " + Bs[i]);
            int output = maximumOnesAfterModification.solve(As[i], Bs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

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
        String s = "";
        System.out.println(Arrays.toString(dp));
        while (i < len && j < len) {
            int zeros = dp[j] - (i - 1 > -1 ? dp[i - 1] : 0);
            if (zeros > B) {
                i++;
            } else {
                max = Math.max(max, j - i + 1);
                s = i + "," + j;
                j++;
            }
        }
        System.out.println(s);
        return max;
    }

}
