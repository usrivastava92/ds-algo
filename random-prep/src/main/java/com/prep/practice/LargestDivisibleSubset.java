package com.prep.practice;

import java.util.*;
import java.util.stream.IntStream;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3}, {8, 1, 4, 2}, {8, 1, 4, 2, 6, 12, 36}, {}, {2, 3, 4, 8}};
        int[][] outputs = {{1, 2}, {1, 2, 4, 8}, {1, 2, 6, 12, 24}, {}, {2, 4, 8}};
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + largestDivisibleSubset.largestDivisibleSubset(inputs[i]));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = i - 1; j > -1; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > max) {
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int maxLen = dp[maxIndex];
        while (true) {
            ans.add(nums[maxIndex]);
            maxLen--;
            if (maxLen == 0) {
                return ans;
            }
            do {
                maxIndex--;
            } while (dp[maxIndex] != maxLen || ans.get(ans.size() - 1) % nums[maxIndex] != 0);
        }
    }

}
