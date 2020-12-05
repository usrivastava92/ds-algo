package com.ib.graphs;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class RegionInBinaryMatrix {


    public static void main(String[] args) {
        int[][][] inputs = {{{0, 0, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 1}}, {{1, 1, 1}, {0, 0, 1}}};
        int[] outputs = {6, 4};
        RegionInBinaryMatrix regionInBinaryMatrix = new RegionInBinaryMatrix();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            int output = regionInBinaryMatrix.solve(inputs[i]);
            System.out.println("output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int solve(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    max = Math.max(max, dfs(A, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] A, int i, int j) {
        if (i >= A.length || i < 0 || j >= A[0].length || j < 0 || A[i][j] == 0) {
            return 0;
        }
        A[i][j] = 0;
        int up = dfs(A, i - 1, j);
        int down = dfs(A, i + 1, j);
        int left = dfs(A, i, j - 1);
        int right = dfs(A, i, j + 1);
        int upLeft = dfs(A, i - 1, j - 1);
        int upRight = dfs(A, i - 1, j + 1);
        int downLeft = dfs(A, i + 1, j - 1);
        int downRight = dfs(A, i + 1, j + 1);
        return 1 + up + down + left + right + upLeft + upRight + downLeft + downRight;
    }

}
