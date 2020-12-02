package com.ib.arrays;

import org.junit.Assert;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class MaximumSumTriplet {

    public static void main(String[] args) {
        int[][] inputs = {{2, 5, 3, 1, 4, 9}, {1, 2, 3}, {18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605}};
        int[] outputs = {16, 6, 88252};
        MaximumSumTriplet maximumSumTriplet = new MaximumSumTriplet();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            int output = maximumSumTriplet.solve(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int solve(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] rightMaxes = new int[A.length];
        int runningMax = A[A.length - 1];
        for (int i = A.length - 1; i > -1; i--) {
            runningMax = Math.max(runningMax, A[i]);
            rightMaxes[i] = runningMax;
        }
        int maxSum = Integer.MIN_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(A[0]);
        for (int i = 1; i < A.length - 1; i++) {
            int element = A[i];
            Integer lower = treeSet.lower(element);
            treeSet.add(A[i]);
            if (lower != null && element < rightMaxes[i + 1]) {
                maxSum = Math.max(lower + element + rightMaxes[i + 1], maxSum);
            }
        }
        return maxSum;
    }

}
