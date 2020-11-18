package com.leet.daysofcode.june.week1;

import java.util.*;

public class CoinChange2 {


    public static void main(String[] args) {
        int[] amounts = {5, 3, 10, 0, 0};
        int[][] coins = {{1, 2, 5}, {2}, {10}, {}, {7}};
        int[] outputs = {4, 0, 1, 1, 1};
        CoinChange2 coinChange2 = new CoinChange2();
        for (int i = 0; i < amounts.length; i++) {
            System.out.println("Input : Amount -> " + amounts[i] + " , Coins -> " + Arrays.toString(coins[i]));
            System.out.println("Output : " + coinChange2.change(amounts[i], coins[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("#####################################");
        }
    }

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int n = coins.length + 1;
        int m = amount + 1;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int tmp = j - coins[i - 1];
                dp[i][j] = dp[i - 1][j] + (tmp >= 0 ? dp[i][tmp] : 0);
            }
        }
        return dp[n - 1][m - 1];
    }

}
