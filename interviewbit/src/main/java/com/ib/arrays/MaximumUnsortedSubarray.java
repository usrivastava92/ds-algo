package com.ib.arrays;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {
        int[][] As = {{1, 3, 2, 4, 5}, {1, 2, 3, 4, 5}};
        int[][] outputs = {{1, 2}, {-1}};
        MaximumUnsortedSubarray maximumUnsortedSubarray = new MaximumUnsortedSubarray();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("input : " + Arrays.toString(As[i]) + ", output : " + Arrays.toString(outputs[i]));
            Assert.assertArrayEquals(outputs[i], maximumUnsortedSubarray.subUnsort(As[i]));
        });
    }


    public int[] subUnsort(int[] A) {
        int len = A.length;
        int[] min = new int[len];
        int[] max = new int[len];
        int currMax = A[0];
        for (int i = 0; i < len; i++) {
            currMax = Math.max(currMax, A[i]);
            max[i] = currMax;
        }
        int currMin = A[len - 1];
        for (int i = len - 1; i > -1; i--) {
            currMin = Math.min(currMin, A[i]);
            min[i] = currMin;
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            if (min[i] != max[i]) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        if (start == -1) {
            return new int[]{-1};
        }
        return new int[]{start, end};
    }

}
