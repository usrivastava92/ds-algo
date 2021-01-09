package com.leet.daysofcode.year2020.november.week1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindTheSmallestDivisorGivenAThreshold {

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 5, 9}, {2, 3, 5, 7, 11}, {19}};
        int[] thresholds = {6, 11, 5};
        int[] output = {5, 3, 4};
        FindTheSmallestDivisorGivenAThreshold findTheSmallestDivisorGivenAThreshold = new FindTheSmallestDivisorGivenAThreshold();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : nums -> " + Arrays.toString(inputs[i]) + " threshold -> " + thresholds[i]);
            System.out.println("Output : " + findTheSmallestDivisorGivenAThreshold.smallestDivisor(inputs[i], thresholds[i]));
            System.out.println("Expected : " + output[i]);
        });
    }

    public int smallestDivisor(int[] nums, int threshold) {
        if (threshold < nums.length) {
            return -1;
        }
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double sum = Arrays.stream(nums).mapToDouble(i -> Math.ceil((i * 1.0) / mid)).sum();
            if (sum == threshold) {
                high = mid - 1;
            } else if (sum > threshold) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}
