package com.leet.ds.stack;

import java.util.Stack;

public class MinimumBracketFlipToBalanceBrackets {

    public static void main(String[] args) {
        String s = "}{{}}{{{";
        MinimumBracketFlipToBalanceBrackets minimumBracketFlipToBalanceBrackets = new MinimumBracketFlipToBalanceBrackets();
        System.out.println(minimumBracketFlipToBalanceBrackets.minimumBracketFlipToBalanceBrackets(s));
    }

    public int minimumBracketFlipToBalanceBrackets(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        System.out.println(stack);
        int count = 0;
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (stack.isEmpty()) {
                return -1;
            } else {
                if (stack.pop() == ch) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

}
