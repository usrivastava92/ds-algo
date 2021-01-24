package com.prep.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[][] inputs = {{5, 7, 7, 8, 8, 8, 8, 10}, {5, 7, 7, 8, 8, 10}, {}, {2, 2}, {1, 2, 3, 3, 3, 3, 4, 5, 9}};
        int[] targets = {8, 6, 0, 3, 3};
        int[][] outputs = {{3, 6}, {-1, -1}, {-1, -1}, {-1, -1}, {2, 5}};
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]) + " target : " + targets[i]);
            System.out.println("Output : " + Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(inputs[i], targets[i])));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low >= nums.length || nums[low] != target) {
            return ans;
        }
        ans[0] = low;
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        ans[1] = low-1;
        return ans;
    }

}
