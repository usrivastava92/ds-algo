package com.leet.ds.dp;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] cost = new int[]{1,0,0,0};
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for (int i = cost.length - 1; i > -1; i--) {
            if (i + 2 < cost.length) {
                dp[i] = Math.min(cost[i] + dp[i + 1], cost[i] + dp[i + 2]);
            } else {
                dp[i] = cost[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return Math.min(dp[0],dp[1]);
    }
}
