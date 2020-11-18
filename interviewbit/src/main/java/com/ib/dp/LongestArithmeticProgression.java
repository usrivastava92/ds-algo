package com.ib.dp;

import java.util.Arrays;
import java.util.HashMap;

public class LongestArithmeticProgression {

    public static void main(String[] args) {
        int[][] inputs = {{3, 6, 9, 12}, {9, 4, 7, 2, 10}, {2, 2}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        int[] outputs = {4, 3, 2, 10};
        LongestArithmeticProgression longestArithmeticProgression = new LongestArithmeticProgression();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input -> " + Arrays.toString(inputs[i]));
            System.out.println("Output -> " + longestArithmeticProgression.solve(inputs[i]));
            System.out.println("Correct output -> " + outputs[i]);
            System.out.println("##########################################");
        }
    }

    public int solve(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int max = 1;
        if (A.length <= 1) {
            return max;
        }
        HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();
        HashMap<Integer, Integer> blank = new HashMap<>();
        for (int i = A.length - 2; i > -1; i--) {
            HashMap<Integer, Integer> add = new HashMap<>();
            for (int j = i + 1; j < len; j++) {
                int d = A[j] - A[i];
                if (!add.containsKey(d)) {
                    HashMap<Integer, Integer> subDp = dp.getOrDefault(j, blank);
                    int apLen = subDp.getOrDefault(d, 1) + 1;
                    add.put(d, apLen);
                    if (apLen > max) {
                        max = apLen;
                    }
                }
            }
            dp.put(i, add);
        }
        System.out.println(dp);
        return max;
    }
}
