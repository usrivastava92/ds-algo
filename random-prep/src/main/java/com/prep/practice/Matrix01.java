package com.prep.practice;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

public class Matrix01 {


    public static void main(String[] args) {
        int[][][] inputs = {{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}}, {{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}}};
        int[][][] outputs = {{{0, 0, 1, 0, 1, 2, 1, 0, 1, 2}, {1, 1, 2, 1, 0, 1, 1, 1, 2, 3}, {2, 1, 2, 1, 1, 0, 0, 0, 1, 2}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 2}, {0, 0, 1, 1, 1, 0, 1, 1, 2, 3}, {1, 0, 1, 2, 1, 1, 1, 2, 1, 2}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 2}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 2, 1, 0}}};
        Matrix01 matrix01 = new Matrix01();
        ArrayUtils.printArr(inputs[2]);
        System.out.println("#######################");
        ArrayUtils.printArr(outputs[0]);
        System.out.println("#######################");
        ArrayUtils.printArr(matrix01.updateMatrix(inputs[2]));
        System.out.println("#######################");
        Assert.assertArrayEquals(outputs[0], matrix01.updateMatrix(inputs[2]));
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[][]{{}};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    int min = Integer.MAX_VALUE - 1;
                    if (i - 1 > -1) {
                        min = Math.min(min, ans[i - 1][j]);
                    }
                    if (j - 1 > -1) {
                        min = Math.min(min, ans[i][j - 1]);
                    }
                    ans[i][j] = 1 + min;
                }
            }
        }
        for (int i = n - 1; i > -1; i--) {
            for (int j = m - 1; j > -1; j--) {
                if (matrix[i][j] == 1) {
                    int min = Integer.MAX_VALUE - 1;
                    if (i + 1 < n) {
                        min = Math.min(min, ans[i + 1][j]);
                    }
                    if (j + 1 < m) {
                        min = Math.min(min, ans[i][j + 1]);
                    }
                    ans[i][j] = Math.min(ans[i][j], 1 + min);
                }
            }
        }
        return ans;
    }

}
