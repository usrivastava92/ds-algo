package com.leet.ds.array;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class SearchA2DMatrixII {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}};
        int[] targets = {5, 20};
        boolean[] outputs = {true, false};
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            boolean output = searchA2DMatrixII.searchMatrix(inputs[i], targets[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j > -1) {
            int element = matrix[i][j];
            if (element > target) {
                j--;
            } else if (element < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }


}
