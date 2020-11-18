package com.leet.ds.dp;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n];
        for (int i = n - 1; i > -1; i--) {
            int next = i + 1;
            int nextToNext = i + 2;
            if (nextToNext < n) {
                dp[i] = dp[next] + dp[nextToNext];
            } else if (next < n) {
                dp[i] = 1 + dp[next];
            } else {
                dp[i] = 1;
            }
        }
        return dp[0];
    }
}
