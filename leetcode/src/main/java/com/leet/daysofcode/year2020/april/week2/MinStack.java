package com.leet.daysofcode.year2020.april.week2;

import java.util.Arrays;
import java.util.Stack;

public class MinStack {


    public static void main(String[] args) {
        String[] operations = new String[]{"push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop", "push", "top", "getMin", "push", "top", "getMin", "pop", "getMin"};
        Integer[][] nums = new Integer[][]{new Integer[]{2147483646}, new Integer[]{2147483646}, new Integer[]{2147483647}, new Integer[]{}, new Integer[]{}, new Integer[]{}, new Integer[]{}, new Integer[]{}, new Integer[]{}, new Integer[]{2147483647}, new Integer[]{}, new Integer[]{}, new Integer[]{-2147483648}, new Integer[]{}, new Integer[]{}, new Integer[]{}, new Integer[]{}};
        MinStack minStack = new MinStack();
        for (int i = 0, len = operations.length; i < len; i++) {
            String operation = operations[i];
            Integer[] num = nums[i];
            System.out.println(operation + " : " + Arrays.toString(num));
            switch (operation) {
                case ("getMin"): {
                    System.out.println(minStack.getMin());
                    break;
                }
                case ("push"): {
                    minStack.push(num[0]);
                    break;
                }
                case ("top"): {
                    System.out.println(minStack.top());
                    break;
                }
                case ("pop"): {
                    minStack.pop();
                    break;
                }
                default:
            }
        }
    }


    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int pop = stack.pop();
        if(pop == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

