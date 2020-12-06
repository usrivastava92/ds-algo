package com.ib.arrays;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NextPermutation {

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3}, {3, 2, 1}, {1, 1, 5}, {20, 50, 113}, {1, 3, 8, 2, 4, 5}, {1, 3, 2, 8, 5, 4}, {1, 3, 8, 2, 6, 4, 2, 1}};
        int[][] outputs = {{1, 3, 2}, {1, 2, 3}, {1, 5, 1}, {20, 113, 50}, {1, 3, 8, 2, 5, 4}, {1, 3, 4, 2, 5, 8}, {1, 3, 8, 4, 1, 2, 2, 6}};
        NextPermutation nextPermutation = new NextPermutation();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input -> " + Arrays.toString(inputs[i]));
            int[] output = nextPermutation.nextPermutation(inputs[i]);
            System.out.println("output : " + Arrays.toString(output));
            Assert.assertArrayEquals(outputs[i], output);
        });
    }

    public int[] nextPermutation(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int len = A.length;
        for (int i = len - 2; i > -1; i--) {
            if (A[i] < A[i + 1]) {
                int temp = i + 1;
                while (temp + 1 < len && A[temp + 1] > A[i]) {
                    temp++;
                }
                swap(A, i, temp);
                reverse(A, i + 1, A.length - 1);
                return A;
            }
        }
        reverse(A, 0, A.length - 1);
        return A;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}