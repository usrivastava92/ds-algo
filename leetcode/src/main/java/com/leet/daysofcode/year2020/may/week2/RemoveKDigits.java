package com.leet.daysofcode.year2020.may.week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

    public static void main(String[] args) {
        String[] nums = {"1432219", "10200", "10"};
        int[] ks = {3, 1, 2};

        RemoveKDigits removeKDigits = new RemoveKDigits();

        for (int i = 0; i < ks.length; i++) {
            System.out.println(removeKDigits.removeKdigits(nums[i], ks[i]));
        }
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            int number = Character.getNumericValue(ch);
            while (!stack.isEmpty() && stack.peek() > number && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(number);
        }
        while (!stack.isEmpty() && k > 0) {
            k--;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
