package com.ib.stackqueue;

import java.util.*;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        List<Integer> a = Arrays.asList(2, 1, 5, 6, 2, 3);
        System.out.println(largestRectangleInHistogram.largestRectangleArea(a));
    }

    public int largestRectangleArea(List<Integer> a) {
        Stack<Integer> stack = new Stack<Integer>();
        int top = 0;
        int maxArea = 0;
        int areaWithTop;
        int i = 0;
        while (i < a.size()) {
            System.out.println("When i = " + i);
            if (stack.isEmpty() || a.get(i) >= a.get(stack.peek())) {
                System.out.println("\t Pushing to stack " + i + " which has " + a.get(i));
                stack.push(i);
                i++;
            } else {
                top = stack.peek();
                stack.pop();
                areaWithTop = a.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                System.out.println("\t Area of the Top " + areaWithTop);
                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }
        System.out.print("Items in stack -> ");
        for (int j : stack) {
            System.out.print(j + " ");
        }
        System.out.println();
        while (!stack.isEmpty()) {
            top = stack.peek();
            stack.pop();
            areaWithTop = a.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }
        return maxArea;

    }
}