package com.leet.daysofcode.may.week4;

import java.util.Arrays;

public class UncrossedLines {

    public static void main(String[] args) {
        int[][] As = {{1, 4, 2}, {2, 5, 1, 2, 5}, {1, 3, 7, 1, 7, 5}, {1, 2, 3}};
        int[][] Bs = {{1, 2, 4}, {10, 5, 2, 1, 5, 2}, {1, 9, 2, 5, 1}, {2, 3, 1}};
        int[] outputs = {2, 3, 2, 2};
        UncrossedLines uncrossedLines = new UncrossedLines();
        for (int i = 0; i < As.length; i++) {
            System.out.println("Input -> ");
            System.out.println("A: " + Arrays.toString(As[i]));
            System.out.println("B: " + Arrays.toString(Bs[i]));
            System.out.println("Output -> " + uncrossedLines.maxUncrossedLines(As[i], Bs[i]));
            System.out.println("Expected -> " + outputs[i]);
            System.out.println("############################################");
        }
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length+1][B.length+1];
        int maxCount = 0;
        for (int i = A.length - 1; i > -1; i--) {
            for (int j = B.length - 1; j > -1; j--) {
                int count = 0;
                if (A[i] == B[j]) {
                    count = 1 + dp[i + 1][j + 1];
                } else {
                    count = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                dp[i][j] = count;
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }

}
