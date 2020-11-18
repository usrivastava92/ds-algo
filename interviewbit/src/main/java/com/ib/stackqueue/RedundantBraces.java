package com.ib.stackqueue;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String... args) {
        RedundantBraces redundantBraces = new RedundantBraces();
        System.out.println(redundantBraces.braces("(a)"));
    }


    public int braces(String A) {
        Stack<String> stack = new Stack<>();
        final String close = ")";
        final String open = "(";
        for (int i = 0, j = A.length(); i < j; i++) {
            String ch = A.substring(i, i + 1);
            if (ch.equals(close)) {
                try {
                    String out = stack.peek();
                    if (out.equals(open)) {
                        return 1;
                    } else {
                        boolean popsContainOperator = false;
                        while (!out.equals(open)) {
                            String s = stack.pop();
                            if ("+-*/".contains(s)) {
                                popsContainOperator = true;
                            }
                            out = stack.peek();
                        }
                        if (!popsContainOperator) {
                            return 1;
                        }
                        stack.pop();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return 1;
                }
            } else {
                stack.add(ch);
            }
        }
        return 0;
    }

}
