package com.ib.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MaxStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        MaxStack maxStack = new MaxStack();
        while (testCases-- > 0) {
            String[] str = sc.nextLine().trim().split(" ");
            int operationType = Integer.parseInt(str[0]);
            if (operationType == 1) {
                int insert = Integer.parseInt(str[1]);
                maxStack.push(insert);
            } else if (operationType == 2) {
                maxStack.pop();
            } else if (operationType == 3) {
                System.out.println(maxStack.getMax());
            }
        }
        sc.close();
    }

    private Stack<Integer> stack = new Stack<>();
    private Integer max = null;

    public void push(Integer i) {
        stack.push(i);
        if (max == null || max.compareTo(i) < 0) {
            max = i;
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            Integer element = stack.pop();
            if (element.compareTo(max) == 0) {
                if (stack.isEmpty()) {
                    max = null;
                } else {
                    max = stack.stream().max(Integer::compareTo).get();
                }
            }
        }
    }

    public Integer getMax() {
        return max;
    }
}