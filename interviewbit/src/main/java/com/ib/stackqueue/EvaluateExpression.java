package com.ib.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {

    public static void main(String... args) {
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        System.out.println(evaluateExpression.evalRPN(Arrays.asList("2", "1", "+", "3", "*")));
    }

    public int evalRPN(List<String> A) {
        Stack<String> stack = new Stack<>();
        int size = A.size();
        Integer a = null;
        Integer b = null;
        for (int i = size - 1; i > -1; i--) {
            String element = A.get(i);
            if ("+-*/".contains(element)) {
                stack.add(element);
            } else {
                if (a == null) {
                    a = Integer.parseInt(element);
                } else if (b == null) {
                    b = Integer.parseInt(element);
                }
                if (a != null && b != null) {
                    int output = 0;
                    String operation = stack.pop();
                    if ("+".equals(operation)) {
                        output = a + b;
                    } else if ("-".equals(operation)) {
                        output = b - a;
                    } else if ("*".equals(operation)) {
                        output = a * b;
                    } else if ("/".equals(operation)) {
                        output = b / a;
                    }
                    System.out.println("a -> " + a + " b -> " + b + " output -> " + output);
                    a = output;
                    b = null;
                }
            }
        }
        return a;
    }


}
