package com.leet.daysofcode.year2020.november.week2;

import com.ds.utils.ArrayUtils;

import java.util.stream.IntStream;

public class FlippingAnImage {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}, {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}};
        int[][][] outputs = {{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}}, {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}}};
        FlippingAnImage flippingAnImage = new FlippingAnImage();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            System.out.println("Output : ");
            flippingAnImage.flipAndInvertImage(inputs[i]);
            ArrayUtils.printArr(inputs[i]);
            System.out.println("Expected : ");
            ArrayUtils.printArr(outputs[i]);
        });
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int rowIndex = 0; rowIndex < A.length; rowIndex++) {
            int[] row = A[rowIndex];
            int i = 0;
            int j = row.length - 1;
            while (i <= j) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                invertBit(A, rowIndex, i);
                if (i != j) {
                    invertBit(A, rowIndex, j);
                }
                i++;
                j--;
            }
        }
        return A;
    }

    private void invertBit(int[][] A, int i, int j) {
        A[i][j] = A[i][j] == 1 ? 0 : 1;
    }

}
