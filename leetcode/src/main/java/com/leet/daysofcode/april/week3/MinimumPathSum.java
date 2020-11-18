package com.leet.daysofcode.april.week3;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));
    }

    private Map<String, Integer> dp = new HashMap<>();

    public int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid == null) {
            return 0;
        }
        dp.clear();
        return traverseMin(grid, 0, 0);

    }

    public int traverseMin(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return -1;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (dp.containsKey(getKey(i, j))) {
            return dp.get(getKey(i, j));
        }

        int tempI = i;
        int tempJ = j + 1;
        int right = traverseMin(grid, tempI, tempJ);

        tempI = i + 1;
        tempJ = j;
        int down = traverseMin(grid, tempI, tempJ);

        int ans = -1;
        if (down == -1 || right == -1) {
            ans = right == -1 ? down : right;
        } else {
            ans = Math.min(right, down);
        }
        dp.put(getKey(i, j), grid[i][j] + ans);
        return dp.get(getKey(i, j));
    }

    private String getKey(int i, int j) {
        return i + "," + j;
    }

}
