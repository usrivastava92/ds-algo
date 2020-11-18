package com.leet.daysofcode.june.week1;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        char[][] inputs = {{'h', 'e', 'l', 'l', 'o'}, {'H', 'a', 'n', 'n', 'a', 'h'}};
        char[][] outputs = {{'o', 'l', 'l', 'e', 'h'}, {'h', 'a', 'n', 'n', 'a', 'H'}};
        ReverseString reverseString = new ReverseString();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            reverseString.reverseString(inputs[i]);
            System.out.println("Output : " + Arrays.toString(inputs[i]));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
            System.out.println("##############################################");
        }
    }

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }

}
