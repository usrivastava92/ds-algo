package com.leet.ds.dp;

import com.ds.utils.ArrayUtils;

import java.util.Arrays;

public class CountSortedVowelString {

    public static void main(String[] args) {
        CountSortedVowelString countSortedVowelString = new CountSortedVowelString();
        countSortedVowelString.countVowelStrings(3);
    }

    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];
        for (int i = 1; i <= n; ++i) {
            for (int k = 1; k <= 5; ++k) {
                dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);
            }
        }
        ArrayUtils.printArr(dp);
        return dp[n][5];
    }
}
