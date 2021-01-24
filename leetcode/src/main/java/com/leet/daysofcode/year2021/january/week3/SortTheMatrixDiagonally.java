package com.leet.daysofcode.year2021.january.week3;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class SortTheMatrixDiagonally {

    public static void main(String[] args) {
        int[][][] inputs = {{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}}};
        int[][][] outputs = {{{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}}};
        SortTheMatrixDiagonally matrixDiagonally = new SortTheMatrixDiagonally();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            int[][] output = matrixDiagonally.diagonalSort(inputs[i]);
            ArrayUtils.printArr(output);
            Assert.assertArrayEquals(output, outputs[i]);
        });
    }

    public int[][] diagonalSort(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m && i + j < n; j++) {
                priorityQueue.add(mat[i + j][j]);
            }
            for (int j = 0; j < m && i + j < n; j++) {
                mat[i + j][j] = priorityQueue.poll();
            }
            System.out.println();
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n && i + j < m; j++) {
                priorityQueue.add(mat[j][i + j]);
            }
            for (int j = 0; j < n && i + j < m; j++) {
                mat[j][i + j] = priorityQueue.poll();
            }
            System.out.println();
        }
        return mat;
    }

}
