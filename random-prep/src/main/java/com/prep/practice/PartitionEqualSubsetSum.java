package com.prep.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[][] inputs = {{1, 5, 11, 5}, {1, 2, 3, 5}, {1, 1, 1, 1}, {23, 13, 11, 7, 6, 5, 5}};
        boolean[] outputs = {true, false, true, true};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + partitionEqualSubsetSum.canPartition(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] dp = new int[101];
        int sum = 0;
        for (int num : nums) {
            dp[num]++;
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return false;
    }

}
