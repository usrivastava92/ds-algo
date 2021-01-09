package com.leet.daysofcode.year2020.november.week4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[][] nums = {{1, 3, -1, -3, 5, 3, 6, 7}, {1}, {1, -1}, {9, 11}, {4, -2}};
        int[] ks = {3, 1, 1, 2, 2};
        int[][] outputs = {{3, 3, 5, 5, 6, 7}, {1}, {1, -1}, {11}, {4}};
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        IntStream.range(0, nums.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(nums[i]) + " K -> " + ks[i]);
            System.out.println("Output : " + Arrays.toString(slidingWindowMaximum.maxSlidingWindow(nums[i], ks[i])));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (i >= k) {
                ans[index++] = nums[deque.peekFirst()];
            }
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        ans[index++] = nums[deque.peekFirst()];
        return ans;
    }

}
