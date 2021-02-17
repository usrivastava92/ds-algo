package com.leet.daysofcode.year2021.february.week2;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][][] inputs = {{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}}, {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}, {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}}};
        int[] outputs = {3, -1, -1};
        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            int output = shortestPathInBinaryMatrix.shortestPathBinaryMatrix(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }


    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int level = 1;
        Queue<Pair> queue = new ArrayDeque<>();
        Set<Pair> visited = new HashSet<>();
        Pair pair = new Pair(0, 0);
        Pair destination = new Pair(n - 1, m - 1);
        if (grid[0][0] != 1) {
            queue.add(pair);
            visited.add(pair);
        }
        int[][] shifts = {{-1, 0}, {-1, 1}, {-1, -1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; i++) {
                Pair poll = queue.poll();
                if (destination.equals(poll)) {
                    return level;
                }
                for (int[] shift : shifts) {
                    pair = new Pair(poll.i + shift[0], poll.j + shift[1]);
                    if (ArrayUtils.isValidIndex(grid, pair.i, pair.j) && grid[pair.i][pair.j] != 1 && !visited.contains(pair)) {
                        queue.add(pair);
                        visited.add(pair);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private static final class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

}
