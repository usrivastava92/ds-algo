package com.leet.ds.string;

import java.util.HashMap;
import java.util.stream.IntStream;

public class StringToInteger {

    public static void main(String[] args) {
        String[] inputs = {"42", "   -42", "4193 with words", "words and 987", "-91283472332", "     91283472332"};
        int[] outputs = {42, -42, 4193, 0, -2147483648, 2147483647};
        StringToInteger stringToInteger = new StringToInteger();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : \"" + inputs[i] + "\"");
            System.out.println("Output : " + stringToInteger.myAtoi(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int myAtoi(String s) {
        int out = 0;
        if (s == null) {
            return out;
        }
        int i = 0;
        int len = s.length();
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        boolean isNegative = false;
        if (i < len && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                isNegative = true;
            }
            i++;
        }
        while (i < len && Character.isDigit(s.charAt(i))) {
            if ((out * 10d) > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            out *= 10;
            int digit = Character.getNumericValue(s.charAt(i));
            if (isNegative) {
                System.out.println("diff : " + Math.abs(Integer.MIN_VALUE - out) + " digit : " + digit);
                if (out != 0 && Math.abs(Integer.MIN_VALUE - out) < digit) {
                    return Integer.MIN_VALUE;
                }
                out -= digit;
            } else {
                if (Math.abs(Integer.MAX_VALUE - out) < digit) {
                    return Integer.MAX_VALUE;
                }
                out += digit;
            }
            i++;
        }
        return out;
    }

}
