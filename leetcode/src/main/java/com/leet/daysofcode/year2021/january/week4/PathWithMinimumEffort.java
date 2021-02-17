package com.leet.daysofcode.year2021.january.week4;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class PathWithMinimumEffort {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}, {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}, {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}};
        int[] outputs = {2, 1, 0};
        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            int output = pathWithMinimumEffort.minimumEffortPath(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        return 0;
    }

}
