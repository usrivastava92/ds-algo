package com.ib.dp;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stairs {

    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        int[] inputs = {1, 2, 4};
        int[] outputs = {1, 2, 5};
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            int output = stairs.climbStairs(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
        System.out.println();
    }

    public int climbStairs(int A) {
        if (A <= 0) {
            return 0;
        }
        /*
        4
        1
        12
        123
        1235
        12358
         */
        int[] dp = new int[A + 1];
        dp[0] = 1;
        for (int i = 1; i <= A; i++) {
            dp[i] = dp[i - 1] + (i - 2 > -1 ? dp[i - 2] : 0);
        }
        System.out.println(Arrays.toString(dp));
        return dp[A];
    }


}
