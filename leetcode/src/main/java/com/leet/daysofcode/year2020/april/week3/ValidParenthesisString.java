package com.leet.daysofcode.year2020.april.week3;

import java.util.ArrayDeque;

public class ValidParenthesisString {

    public static void main(String[] args) {
        String s = "(*))";
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString(s));
    }

    public boolean checkValidString(String s) {
        ArrayDeque<Integer> startStack = new ArrayDeque<>();
        ArrayDeque<Integer> bracketStack = new ArrayDeque<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                bracketStack.push(i);
            } else if (ch == ')') {
                if (bracketStack.isEmpty()) {
                    if (startStack.isEmpty()) {
                        return false;
                    } else {
                        startStack.pop();
                    }
                } else {
                    bracketStack.pop();
                }
            } else {
                startStack.push(i);
            }
        }

        while (!bracketStack.isEmpty()) {
            if(startStack.isEmpty()){
                return false;
            }
            if (startStack.peek() > bracketStack.peek()) {
                startStack.pop();
                bracketStack.pop();
            } else {
                return false;
            }
        }
        return true;
    }

}
