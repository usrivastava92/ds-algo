package com.leet.ds.array;

import java.util.Arrays;

public class CreateTargetArrayInTheGivenOrder {

    public static void main(String[] args) {
        CreateTargetArrayInTheGivenOrder createTargetArrayInTheGivenOrder = new CreateTargetArrayInTheGivenOrder();
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(createTargetArrayInTheGivenOrder.createTargetArray(nums, index)));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
        for (int i = 0, len = nums.length; i < len; i++) {
            insert(ans, index[i], nums[i]);
        }
        return ans;
    }

    private void insert(int[] arr, int index, int value) {
        int i = arr.length - 1;
        while (i > index) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[index] = value;
    }

}
