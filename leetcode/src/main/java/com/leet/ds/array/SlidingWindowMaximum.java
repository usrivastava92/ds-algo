package com.leet.ds.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[][] inputs = {{1, 3, -1, -3, 5, 3, 6, 7}, {1}, {1, -1}, {9, 11}, {4, -2}};
        int[] ks = {3, 1, 1, 2, 2};
        int[][] outputs = {{3, 3, 5, 5, 6, 7}, {1}, {1, -1}, {11}, {4}};
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]) + " k -> " + ks[i]);
            System.out.println("Output : " + Arrays.toString(slidingWindowMaximum.maxSlidingWindow(inputs[i], ks[i])));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int ansIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.getLast() < i - k + 1) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);
            if (i >= k - 1) {
                ans[ansIndex++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

}
