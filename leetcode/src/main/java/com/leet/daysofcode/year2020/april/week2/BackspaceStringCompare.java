package com.leet.daysofcode.year2020.april.week2;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (Character ch : S.toCharArray()) {
            if ('#' == ch) {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(ch);
            }
        }
        for (Character ch : T.toCharArray()) {
            if ('#' == ch ) {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(ch);
            }
        }
        System.out.println(stack1 + " : " + stack2);
        return stack1.equals(stack2);
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        String S = "y#fo##f";
        String T = "y#f#o##f";

        backspaceStringCompare.backspaceCompare(S, T);
    }

}
