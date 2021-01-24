package com.prep.practice;

import java.util.Stack;

public class CloneAStackWithoutExtraSpace {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] nums = {1, 2, 3, 4, 5};
        for (int num : nums) {
            stack.push(num);
        }
        System.out.println(stack);
        Stack<Integer> copy = new Stack<>();
        for (int i = 0; i < stack.size(); i++) {
            int topVal = stack.pop();
            for (int j = 0, len = stack.size() - i; j < len; j++) {
                copy.push(stack.pop());
            }
            stack.push(topVal);
            while (!copy.isEmpty()) {
                stack.push(copy.pop());
            }
        }
        System.out.println(stack);
        while (!stack.isEmpty()) {
            copy.push(stack.pop());
        }
        System.out.println(copy);
    }

}
