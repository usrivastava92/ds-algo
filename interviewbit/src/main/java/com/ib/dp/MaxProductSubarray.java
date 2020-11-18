package com.ib.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxProductSubarray {

    public static void main(String[] args) {
        int[][] inputs = {{2, 3, -2, 4}, {-10, 10, -10, 10}, {0, -3, 4, -10, -1, -6, 0, 8, -8, -6, -5, -5, 0, -3, -9, 1, 5, -8, 0, 6, 1, -6, -8, 3, 0, -8, -9, 6, 8, 5}};
        int[] outputs = {6, 10000, 17280};
        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + maxProductSubarray.maxProduct(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int maxProduct(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int maxProd = A[0];
        int minProd = A[0];
        int globalMax = maxProd;
        for (int i = 1; i < A.length; i++) {
            int choice1 = maxProd * A[i];
            int choice2 = minProd * A[i];
            System.out.printf("A[i] : %s , choice1 : %s , choice2 : %s \n", A[i], choice1, choice2);
            maxProd = max(choice1, choice2, A[i]);
            minProd = min(choice1, choice2, A[i]);
            globalMax = max(globalMax, maxProd);
            System.out.printf("i : %s , maxProd : %s , minProd : %s \n", i, maxProd, minProd);
        }
        return globalMax;
    }

    private int max(int... arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int max = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private int min(int... arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int max = Math.min(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            max = Math.min(max, arr[i]);
        }
        return max;
    }

}
