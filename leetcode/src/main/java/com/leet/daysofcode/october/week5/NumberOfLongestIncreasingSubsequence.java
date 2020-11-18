package com.leet.daysofcode.october.week5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[][] inputs = {{1, 3, 5, 4, 7}, {2, 2, 2, 2, 2}};
        int[] outputs = {2, 5};
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
        int[] dpLen = new int[nums.length];
        int[] dpCount = new int[nums.length];
        dpLen[0] = 1;
        dpCount[0] = 1;
        int maxNumber = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            int count = 1;
            for (int j = i - 1; j > -1; j--) {
                if (nums[i] > nums[j]) {
                    int possLen = 1 + dpLen[j];
                    if (possLen > max) {
                        max = possLen;
                        count = dpCount[j];
                    } else if (possLen == max) {
                        count += dpCount[j];
                    }
                }
            }
            dpLen[i] = max;
            dpCount[i] = count;
            maxNumber = Math.max(maxNumber, dpLen[i]);
        }
        int count = 0;
        for (int i = 0; i < dpCount.length; i++) {
            if (dpLen[i] == maxNumber) {
                count += dpCount[i];
            }
        }
        return count;
    }

}
