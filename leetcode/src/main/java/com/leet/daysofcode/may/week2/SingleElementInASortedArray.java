package com.leet.daysofcode.may.week2;

import java.util.Arrays;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[][] nums = {{1, 1, 2, 3, 3, 4, 4, 8, 8}, {3, 3, 7, 7, 10, 11, 11}, {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9}, {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9}};
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]) + " -> " + singleElementInASortedArray.singleNonDuplicate(nums[i]));
        }
    }

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println((mid - 1 < low ? "out of index" : nums[mid - 1]) + " : " + nums[mid] + " : " + (mid + 1 > high ? "out of index" : nums[mid + 1]) + " low : " + low + " high : " + high);
            if (high - low == 2) {
                if (nums[mid] == nums[high]) {
                    return nums[low];
                } else {
                    return nums[high];
                }
            }
            if (mid == low) {
                return nums[low];
            }
            if ((mid + 1 > high || (nums[mid + 1] != nums[mid])) && (mid - 1 < low || (nums[mid - 1] != nums[mid]))) {
                return nums[mid];
            }
            if ((mid - low + 1) % 2 == 0) {
                if (nums[mid - 1] == nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else {
                if (nums[mid - 1] == nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
        }
        return -1;
    }

}
