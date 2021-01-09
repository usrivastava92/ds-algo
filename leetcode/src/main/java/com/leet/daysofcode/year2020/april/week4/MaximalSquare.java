package com.leet.daysofcode.year2020.april.week4;

import com.ds.utils.ArrayUtils;

public class MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
    }


    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    int prevTopIndex = i - 1;
                    int prevLeftIndex = j - 1;
                    int topMax = prevTopIndex > -1 ? dp[prevTopIndex][j] : 0;
                    int leftMax = prevLeftIndex > -1 ? dp[i][prevLeftIndex] : 0;
                    int diagMax = prevTopIndex > -1 && prevLeftIndex > -1 ? dp[prevTopIndex][prevLeftIndex] : 0;
                    int maxSquareLenPossible = Math.min(Math.min(topMax, leftMax), diagMax) + 1;
                    dp[i][j] = maxSquareLenPossible;
                    if (maxLen < maxSquareLenPossible) {
                        maxLen = maxSquareLenPossible;
                    }
                }
            }
        }
        ArrayUtils.printArr(dp);
        return (int) Math.pow(maxLen, 2);
    }

}
