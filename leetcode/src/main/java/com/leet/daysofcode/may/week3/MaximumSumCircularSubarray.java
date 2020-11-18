package com.leet.daysofcode.may.week3;

import java.util.Arrays;

public class MaximumSumCircularSubarray {


    public static void main(String[] args) {
        int[][] As = {{1, -2, 3, -2}, {5, -3, 5}, {3, -1, 2, -1}, {3, -2, 2, -3}, {-2, -3, -1}, {2, 3, -1, 2}, {1, 2, 3, 4}};

        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
        for (int[] A : As) {
            System.out.println(Arrays.toString(A) + " -> " + maximumSumCircularSubarray.maxSubarraySumCircular(A));
        }
    }


    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) {
            return Integer.MIN_VALUE;
        }
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currMin = 0;
        int totalSum = 0;
        for (int i : A) {
            currMax = Math.max(currMax + i, i);
            currMin = Math.min(currMin + i, i);
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
            totalSum += i;
        }
        if (minSum == totalSum) {
            return maxSum;
        }
        return Math.max(totalSum - minSum, maxSum);
    }
}
