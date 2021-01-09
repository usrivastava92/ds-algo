package com.leet.daysofcode.year2020.november.week3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[][] nums = {{2, 5, 6, 0, 0, 1, 2}, {5, 6, 0, 0, 1, 2, 2}, {0, 0, 1, 2, 2, 5, 6}, {3, 1}, {3, 1, 1, 1}, {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        int[] target = {0, 3, 0, 1, 3, 2};
        boolean[] outputs = {true, false, true, true, true, false};
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();
        IntStream.range(0, nums.length).forEachOrdered(i -> {
            System.out.println("Input : nums -> " + Arrays.toString(nums[i]) + " target -> " + target[i]);
            System.out.println("Output : " + searchInRotatedSortedArrayII.search(nums[i], target[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            boolean rightSideSorted = nums[mid] < nums[end] || nums[mid] < nums[start];
            boolean leftSideSorted = nums[mid] > nums[start] || nums[mid] > nums[end];
            if (rightSideSorted) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (leftSideSorted) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end--;
            }
        }
        return false;
    }


}
