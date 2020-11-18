package com.leet.ds.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HouseRobberII {

    public static void main(String[] args) {
        int[][] inputs = {{2, 3, 2}, {1, 2, 3, 1}, {0}, {1}};
        int[] outputs = {3, 4, 0, 1};
        HouseRobberII houseRobberII = new HouseRobberII();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + houseRobberII.rob(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int low, int high) {
        if (low > high) {
            return 0;
        }
        System.out.println(String.format("low : %s high : %s", low, high));
        int robPrev = 0;
        int notRobPrev = 0;
        for (int i = low; i < high; i++) {
            int robCurrent = notRobPrev + nums[i];
            int notRobCurrent = Math.max(robPrev, notRobPrev);
            robPrev = robCurrent;
            notRobPrev = notRobCurrent;
        }
        return Math.max(robPrev, notRobPrev);
    }

}
