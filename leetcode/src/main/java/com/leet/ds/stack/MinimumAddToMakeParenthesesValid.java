package com.leet.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {
        String[] inputs = {"())", "(((", "()", "()))((", ")())"};
        int[] outputs = {1, 3, 0, 4, 2};
        MinimumAddToMakeParenthesesValid minimumAddToMakeParenthesesValid = new MinimumAddToMakeParenthesesValid();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + minimumAddToMakeParenthesesValid.minAddToMakeValid(inputs[i]));
            System.out.println("Excepted : " + outputs[i]);
        });
    }

    public int minAddToMakeValid(String S) {
        if (S == null) {
            return -1;
        }
        S = S.trim();
        if (S.length() == 0) {
            return 0;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char opening = '(';
        int add = 0;
        for (Character bracket : S.toCharArray()) {
            if (opening == bracket) {
                stack.push(opening);
            } else {
                if (stack.isEmpty()) {
                    add++;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            add++;
            stack.pop();
        }
        return add;
    }

}
