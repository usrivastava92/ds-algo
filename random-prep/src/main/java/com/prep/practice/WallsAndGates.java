package com.prep.practice;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class WallsAndGates {

    private static final int INF = Integer.MAX_VALUE - 1;
    private static final int WALL = -1;
    private static final int DOOR = 0;

    public static void main(String[] args) {
        int[][][] grids = {{{INF, -1, 0, INF}, {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}}};
        int[][][] outputs = {{{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}}};
        WallsAndGates wallsAndGates = new WallsAndGates();
        IntStream.range(0, grids.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(grids[i]);
            int[][] output = wallsAndGates.minimiseDist(grids[i]);
            System.out.println("-------------------------");
            ArrayUtils.printArr(output);
            Assert.assertArrayEquals(outputs[i], output);
        });
    }

    private int[][] minimiseDist(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return grid;
        }
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = grid[i][j];
                if (curr != WALL && curr != DOOR) {
                    int left = j - 1 > -1 && grid[i][j - 1] != WALL && grid[i][j - 1] != INF ? grid[i][j - 1] + 1 : INF;
                    int top = i - 1 > -1 && grid[i - 1][j] != WALL && grid[i - 1][j] != INF ? grid[i - 1][j] + 1 : INF;
                    grid[i][j] = min(left, top, curr);
                }
            }
        }
        for (int i = n - 1; i > -1; i--) {
            for (int j = m - 1; j > -1; j--) {
                int curr = grid[i][j];
                if (curr != WALL && curr != DOOR) {
                    int right = j + 1 < m && grid[i][j + 1] != WALL && grid[i][j + 1] != INF ? grid[i][j + 1] + 1 : INF;
                    int bottom = i + 1 < n && grid[i + 1][j] != WALL && grid[i + 1][j] != INF ? grid[i + 1][j] + 1 : INF;
                    grid[i][j] = min(right, bottom, curr);
                }
            }
        }
        return grid;
    }

    private static int min(int... nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

}
