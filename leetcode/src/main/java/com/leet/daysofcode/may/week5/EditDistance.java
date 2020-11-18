package com.leet.daysofcode.may.week5;

public class EditDistance {

    public static void main(String[] args) {
        String[] word1s = {"horse", "intention"};
        String[] word2s = {"ros", "execution"};
        int[] outputs = {3, 5};
        EditDistance editDistance = new EditDistance();
        for (int i = 0; i < outputs.length; i++) {
            System.out.println("Input : word1 -> " + word1s[i] + " , word2 -> " + word2s[i]);
            System.out.println("Output : " + editDistance.minDistance(word1s[i], word2s[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("################################################");
        }
    }


    public int minDistance(String word1, String word2) {
        int n = word2.length();
        int m = word1.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1];
                    int add = dp[i - 1][j];
                    int remove = dp[i][j - 1];
                    dp[i][j] = Math.min(Math.min(replace, add), remove) + 1;
                }
            }
        }
        return dp[n][m];
    }

}
