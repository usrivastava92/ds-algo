package com.leet.daysofcode.year2021.january.week2;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        int[][] nums = {{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, {1, 1, 4, 2, 3}, {5, 6, 7, 8, 9}, {3, 2, 20, 1, 1, 3}, {5, 2, 3, 1, 1}, {1, 1}};
        int[] xs = {134365, 5, 4, 10, 5, 3};
        int[] outputs = {16, 2, -1, 5, 1, -1};
        MinimumOperationsToReduceXToZero minimumOperationsToReducexToZero = new MinimumOperationsToReduceXToZero();
        IntStream.range(0, nums.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(nums[i]) + " x : " + xs[i]);
            int output = minimumOperationsToReducexToZero.minOperations(nums[i], xs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int minOperations(int[] nums, int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        int start = 0;
        int end = 0;
        int total = Arrays.stream(nums).sum();
        int target = total - x;
        if (x > total) {
            return -1;
        }
        int currSum = 0;
        while (end < len && start < len) {
            if (currSum < target) {
                currSum += nums[end++];
            } else {
                if (currSum == target) {
                    ans = Math.min(ans, len - (end - start));
                }
                currSum -= nums[start++];
            }
        }
        if (currSum == target) {
            ans = Math.min(ans, len - (end - start));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
