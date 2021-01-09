package com.leet.daysofcode.year2020.december.week5;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{1, 4, 4, 1, 7, 4, 0, 4, 2, 6, 2, 7, 6}));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int[] lefts = new int[len];
        int[] rights = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                lefts[i] = 0;
            } else {
                lefts[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i > -1; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rights[i] = len - 1;
            } else {
                rights[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(lefts));
        System.out.println(Arrays.toString(rights));
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (rights[i] - lefts[i] + 1));
        }
        return max;
    }

}
