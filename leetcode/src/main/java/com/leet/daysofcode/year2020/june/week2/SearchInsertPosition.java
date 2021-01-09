package com.leet.daysofcode.year2020.june.week2;

import java.util.Arrays;

public class SearchInsertPosition {


    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5, 6}, {1, 3, 5, 6}, {1, 3, 5, 6}, {1, 3, 5, 6}};
        int[] targets = {5, 2, 7, 0};
        int[] outputs = {2, 1, 4, 0};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Input : nums -> " + Arrays.toString(nums[i]) + " targets -> " + targets[i]);
            System.out.println("Output : " + searchInsertPosition.searchInsert(nums[i], targets[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("##################################################");
        }
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
