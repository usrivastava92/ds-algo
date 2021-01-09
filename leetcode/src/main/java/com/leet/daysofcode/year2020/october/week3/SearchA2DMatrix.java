package com.leet.daysofcode.year2020.october.week3;

import com.ds.utils.ArrayUtils;

import java.util.stream.IntStream;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, {}};
        int[] targets = {3, 12, 0};
        boolean[] outputs = {true, false, false};
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + ArrayUtils.toString(inputs[i])+" target : "+targets[i]);
            System.out.println("Output : " + searchA2DMatrix.searchMatrix(inputs[i], targets[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int totalElements = rows * columns;
        int low = 0;
        int high = totalElements - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] midIndex = locationOfIndex(rows, columns, mid);
            if (matrix[midIndex[0]][midIndex[1]] == target) {
                return true;
            } else if (matrix[midIndex[0]][midIndex[1]] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    private int[] locationOfIndex(int rows, int columns, int index) {
        int row = index / columns;
        int column = index - (row * columns);
        return new int[]{row, column};
    }


}
