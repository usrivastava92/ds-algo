package com.leet.ds.dp;

public class MaximumSubarray {


    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSubarray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
