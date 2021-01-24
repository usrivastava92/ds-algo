package com.prep.practice;

import com.ds.utils.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RussianDollEnvelopes {

    public static void main(String[] args) {
        int[][][] inputs = {{{5, 4}, {6, 4}, {6, 7}, {2, 3}}};
        int[] outputs = {3};
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + ArrayUtils.toString(inputs[i]));
            System.out.println("Output : " + russianDollEnvelopes.maxEnvelopes(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (i, j) -> {
            int comp = Integer.compare(i[0], i[0]);
            return comp == 0 ? Integer.compare(i[1], j[1]) : comp;
        });
        int[] dp = new int[envelopes.length];
        int globalMax = 1;
        for (int i = 0; i < envelopes.length; i++) {
            int max = 1;
            for (int j = i - 1; j > -1; j--) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            globalMax = Math.max(max, globalMax);
        }
        return globalMax;
    }

}
