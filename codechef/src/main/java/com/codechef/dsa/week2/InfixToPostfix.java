package com.codechef.dsa.week2;

import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('/', 2);
        precedence.put('*', 2);
        precedence.put('^', 3);

        while (testCases-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String expression = sc.nextLine() + ")";
            ArrayDeque<Character> stack = new ArrayDeque<>();
            stack.push('(');
            String postfix = "";
            for (Character ch : expression.toCharArray()) {
                System.out.println(stack + " : " + postfix);
                if (precedence.keySet().contains(ch)) {
                    while (precedence.keySet().contains(stack.peek()) && precedence.get(ch) <= precedence.get(stack.peek())) {
                        postfix += stack.pop();
                    }
                    stack.push(ch);
                } else if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (stack.peek() != '(') {
                        postfix += stack.pop();
                    }
                    stack.pop();
                } else {
                    postfix += ch;
                }
            }
            System.out.println(postfix);
        }
        sc.close();
    }
}
