package com.prep.practice;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PalindromePermutation {

    public static void main(String[] args) {
        String[] inputs = {"code", "aab", "carerac"};
        boolean[] outputs = {false, true, true};
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            boolean output = palindromePermutation.canPermutePalindrome(inputs[i]);
            System.out.println("Output : " + outputs[i]);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size() <= 1;
    }

}
