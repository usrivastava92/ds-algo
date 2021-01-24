package com.prep.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[][] inputs = {{1, 3, 5, 4, 7}, {2, 2, 2, 2, 2}, {1, 1, 1, 2, 2, 2, 3, 3, 3}};
        int[] outputs = {2, 5, 27};
        NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + numberOfLongestIncreasingSubsequence.findNumberOfLIS(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp[][] = new int[nums.length][2];
        int[] globalMax = {1, 1};
        dp[0] = globalMax.clone();
        for (int i = 1; i < nums.length; i++) {
            int[] max = {1, 1};
            for (int j = i - 1; j > -1; j--) {
                if (nums[i] > nums[j]) {
                    if (max[0] == dp[j][0] + 1) {
                        max[1] += dp[j][1];
                    } else if (max[0] < dp[j][0] + 1) {
                        max = dp[j].clone();
                        max[0]++;
                    }
                }
            }
            dp[i] = max;
            if (max[0] > globalMax[0]) {
                globalMax = max.clone();
            } else if (max[0] == globalMax[0]) {
                globalMax[1] += max[1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return globalMax[1];
    }

}
