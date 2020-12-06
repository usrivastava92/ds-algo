package com.ib.arrays;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SpiralOrderMatrixI {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {7, 8, 9, 1, 0}, {4, 5, 6, 7, 8}}};
        int[][] outputs = {{1, 2, 3, 6, 9, 8, 7, 4, 5},{1, 2, 3, 4, 5, 8, 0, 8, 7, 6, 5, 4, 7, 4, 5, 6, 7, 1, 9, 8}};
        SpiralOrderMatrixI spiralOrderMatrixI = new SpiralOrderMatrixI();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input -> ");
            ArrayUtils.printArr(inputs[i]);
            int[] output = spiralOrderMatrixI.spiralOrder(inputs[i]);
            System.out.println("output : " + Arrays.toString(output));
            Assert.assertArrayEquals(outputs[i], output);
        });
    }

    public int[] spiralOrder(final int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return new int[]{};
        }
        int upperLimitX = A.length;
        int upperLimitY = A[0].length;
        int lowerXLimit = -1;
        int lowerYLimit = -1;
        int[] ans = new int[upperLimitX * upperLimitY];
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < ans.length) {
            while (index < ans.length && j < upperLimitY) {
                ans[index++] = A[i][j];
                j++;
            }
            lowerXLimit++;
            i++;
            j--;
            while (index < ans.length && i < upperLimitX) {
                ans[index++] = A[i][j];
                i++;
            }
            upperLimitY--;
            upperLimitX--;
            i--;
            j--;
            while (index < ans.length && j > lowerYLimit) {
                ans[index++] = A[i][j];
                j--;
            }
            j++;
            i--;
            while (index < ans.length && i > lowerXLimit) {
                ans[index++] = A[i][j];
                i--;
            }
            i++;
            j++;
            lowerYLimit++;
        }
        return ans;
    }

}
