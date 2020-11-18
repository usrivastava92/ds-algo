package com.ib.dp;

import com.ds.utils.ArrayUtils;

public class MaxRectangleInBinaryMatrix {

    public static void main(String... args) {
        int[][] A = {
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}
        };
        MaxRectangleInBinaryMatrix maxRectangleInBinaryMatrix = new MaxRectangleInBinaryMatrix();
        System.out.println(maxRectangleInBinaryMatrix.maximalRectangle(A));
    }


    public int maximalRectangle(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;

        int maxArea = 0;


        int[][] maxBreadthDp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    int topIndex = i - 1;
                    int leftIndex = j - 1;

                    int topMaxLen = topIndex > -1 ? A[topIndex][j] : 0;
                    int diagMaxLen = topIndex > -1 && leftIndex > -1 ? A[topIndex][leftIndex] : 0;

                    int leftMaxBreadth = leftIndex > -1 ? maxBreadthDp[i][leftIndex] : 0;
                    int diagMaxBreadth = topIndex > -1 && leftIndex > -1 ? maxBreadthDp[topIndex][leftIndex] : 0;


                    int maxLen = 1 + Math.min(topMaxLen, diagMaxLen);
                    int maxBreadth = 1 + Math.min(leftMaxBreadth, diagMaxBreadth);

                    int possibleArea = maxLen * maxBreadth;

                    if (possibleArea > maxArea) {
                        maxArea = possibleArea;
                    }

                    A[i][j] = maxLen;
                    maxBreadthDp[i][j] = maxBreadth;
                }
            }
        }

        ArrayUtils.printArr(A);
        System.out.println("##################################");
        ArrayUtils.printArr(maxBreadthDp);

        return maxArea;
    }

}
