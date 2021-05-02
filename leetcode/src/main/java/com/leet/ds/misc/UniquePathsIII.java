package com.leet.ds.misc;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class UniquePathsIII {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}, {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}, {{0, 1}, {2, 0}}};
        int[] outputs = {2, 4, 0};
        UniquePathsIII uniquePathsIII = new UniquePathsIII();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input -> ");
            ArrayUtils.printArr(inputs[i]);
            int output = uniquePathsIII.uniquePathsIII(inputs[i]);
            System.out.println("Output -> " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[] emptyCounter = new int[1];
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    emptyCounter[0]++;
                } else if (grid[i][j] == 1) {
                    emptyCounter[0]++;
                    startI = i;
                    startJ = j;
                }
            }
        }
        int[] counter = new int[1];
        traverse(grid, startI, startJ, counter, emptyCounter);
        return counter[0];
    }

    public void traverse(int[][] grid, int i, int j, int[] counter, int[] emptyCounter) {
        if (grid == null || i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == -1) {
            return;
        }
        if (grid[i][j] == 2) {
            if (emptyCounter[0] == 0) {
                counter[0]++;
            }
            return;
        }

        emptyCounter[0]--;
        grid[i][j] = -1;

        traverse(grid, i + 1, j, counter, emptyCounter);
        traverse(grid, i - 1, j, counter, emptyCounter);
        traverse(grid, i, j + 1, counter, emptyCounter);
        traverse(grid, i, j - 1, counter, emptyCounter);

        emptyCounter[0]++;
        grid[i][j] = 0;
    }
}
