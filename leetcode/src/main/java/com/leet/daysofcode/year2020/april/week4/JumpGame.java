package com.leet.daysofcode.year2020.april.week4;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[][] nums = {{2, 3, 1, 1, 4}, {3, 2, 1, 0, 4}};
        System.out.println(jumpGame.canJump(nums[0]));
    }

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[ nums.length];
        for (int i = nums.length - 1; i > -1; i--) {
            int val = nums[i];
            if (i + val >= nums.length) {
                dp[i] = true;
            } else {
                boolean canJump = false;
                for (int j = 1; j <= val; j++) {
                    if (dp[i + j]) {
                        canJump = true;
                        break;
                    }
                }
                dp[i] = canJump;
            }
        }
        return dp[0];
    }

}
