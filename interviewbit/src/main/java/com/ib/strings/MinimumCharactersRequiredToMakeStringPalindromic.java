package com.ib.strings;

public class MinimumCharactersRequiredToMakeStringPalindromic {

    public static void main(String... args) {
        MinimumCharactersRequiredToMakeStringPalindromic minimumCharactersRequiredToMakeStringPalindromic = new MinimumCharactersRequiredToMakeStringPalindromic();
        System.out.println(minimumCharactersRequiredToMakeStringPalindromic.solve("ABC"));
    }

    public int solve(String A) {
        int start = 0;
        int end = 0;
        int count = 0;
        String copy = new StringBuilder(A).reverse().toString();
        while (true) {
            System.out.println(copy.substring(start, end) + A);
            if (isPalin(copy.substring(start, end) + A))
                break;
            end++;
            count++;
        }
        return count;
    }

    public boolean isPalin(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

}
