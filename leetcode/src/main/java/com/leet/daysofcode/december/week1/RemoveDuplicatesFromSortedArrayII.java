package com.leet.daysofcode.december.week1;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveDuplicatesFromSortedArrayII {


    public static void main(String[] args) {
        int[][] nums = {{1, 1, 1, 2, 2, 3}, {0, 0, 1, 1, 1, 1, 2, 3, 3}, {1, 2, 3, 4}, {1, 1, 1}, {1, 1, 1, 2, 2, 2, 3, 3}};
        int[] outputs = {5, 7, 4, 2, 6};
        int[][] outputArrs = {{1, 1, 2, 2, 3}, {0, 0, 1, 1, 2, 3, 3}, {1, 2, 3, 4}, {1, 1}, {1, 1, 2, 2, 3, 3}};
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        IntStream.range(0, nums.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(nums[i]));
            int output = removeDuplicatesFromSortedArrayII.removeDuplicates(nums[i]);
            System.out.println("Output : " + output + " nums : " + Arrays.toString(nums[i]));
            Assert.assertEquals(outputs[i], output);
            for (int j = 0; j < output; j++) {
                Assert.assertEquals(outputArrs[i][j], nums[i][j]);
            }
        });
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        // Turns true if there's a duplicate element
        boolean present = false;
        int count = 1; // Since i starts from 1 below

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // First encouter of duplicate element
                if (!present) {
                    nums[count++] = nums[i];
                    present = true; // Indicates we have already visited dupe
                }
            } else { // No dupe, business as usual
                nums[count++] = nums[i];
                present = false;
            }
        }

        return count;
    }

    public void shift(int index, int end, int[] nums) {
        for (int i = index; i < end; i++) {
            swap(i, i + 1, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
