package com.ib.arrays;

public class SpiralOrderMatrixI {

    public int[] spiralOrder(final int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return new int[]{};
        }
        int upperLimitX = A.length;
        int upperLimitY = A[0].length;
        int lowerXLimit = -1;
        int lowerYLimit = -1;
        int[] ans = new int[upperLimitX * upperLimitY];
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < ans.length) {
            while (index < ans.length && j < upperLimitY) {
                ans[index++] = A[i][j];
                j++;
            }
            lowerXLimit++;
            i++;
            j--;
            while (index < ans.length && i < upperLimitX) {
                ans[index++] = A[i][j];
                i++;
            }
            upperLimitY--;
            upperLimitX--;
            i--;
            j--;
            while (index < ans.length && j > lowerYLimit) {
                ans[index++] = A[i][j];
                j--;
            }
            j++;
            i--;
            while (index < ans.length && i > lowerXLimit) {
                ans[index++] = A[i][j];
                i--;
            }
            i++;
            j++;
            lowerYLimit++;
        }
        return ans;
    }

}
