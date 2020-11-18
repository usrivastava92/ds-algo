package com.leet.daysofcode.october.week3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateArray {

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3, 4, 5, 6, 7}, {-1, -100, 3, 99}, {}, null, {1}};
        int[] ks = {3, 2, 2, 2, 10};
        int[][] outputs = {{5, 6, 7, 1, 2, 3, 4}, {3, 99, -1, -100}, {}, null, {1}};
        RotateArray rotateArray = new RotateArray();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i])+ ", k : "+ks[i]);
            rotateArray.rotate(inputs[i], ks[i]);
            System.out.println("Output : " + Arrays.toString(inputs[i]));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        if (start < 0 && start >= arr.length && end < 0 && end >= arr.length) {
            return;
        }
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
