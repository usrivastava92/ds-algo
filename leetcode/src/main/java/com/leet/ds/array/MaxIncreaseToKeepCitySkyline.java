package com.leet.ds.array;

import java.util.Arrays;

public class MaxIncreaseToKeepCitySkyline {

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        MaxIncreaseToKeepCitySkyline maxIncreaseToKeepCitySkyline = new MaxIncreaseToKeepCitySkyline();
        System.out.println(maxIncreaseToKeepCitySkyline.maxIncreaseKeepingSkyline(grid));
    }


    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[] rightSkylineView = new int[m];
        int[] topSkylineView = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int element = grid[i][j];
                if (element > rightSkylineView[i]) {
                    rightSkylineView[i] = element;
                }
                if (element > topSkylineView[j]) {
                    topSkylineView[j] = element;
                }
            }
        }

        System.out.println(Arrays.toString(topSkylineView));
        System.out.println(Arrays.toString(rightSkylineView));

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += Math.min(rightSkylineView[i], topSkylineView[j]) - grid[i][j];
            }
        }
        return sum;
    }

}
