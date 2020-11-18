package com.leet.ds.string;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String[] inputs = {"", "babad", "cbbd", "bb", "abcba"};
        String[] outputs = {"", "bab", "bb", "bb", "abcba"};
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : \"" + inputs[i] + "\"");
            System.out.println("Output : \"" + longestPalindromicSubstring.longestPalindrome(inputs[i]) + "\"");
            System.out.println("Expected : \"" + outputs[i] + "\"");
            System.out.println("######################################");
        }
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLen = 0;
        int maxLow = 0;
        int maxHigh = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int low = i;
            int high = i;
            int low1 = i;
            int high1 = i + 1;
            boolean oddFailed = false;
            boolean evenFailed = false;
            while (true) {
                if (!oddFailed && low > -1 && high < len && s.charAt(low) == s.charAt(high)) {
                    int l = high - low + 1;
                    if (l > maxLen) {
                        maxLen = l;
                        maxLow = low;
                        maxHigh = high;
                    }
                    low--;
                    high++;
                } else {
                    oddFailed = true;
                }
                if (!evenFailed && low1 > -1 && high1 < len && s.charAt(low1) == s.charAt(high1)) {
                    int l = high1 - low1 + 1;
                    if (l > maxLen) {
                        maxLen = l;
                        maxLow = low1;
                        maxHigh = high1;
                    }
                    low1--;
                    high1++;
                } else {
                    evenFailed = true;
                }
                if (evenFailed && oddFailed) {
                    break;
                }
            }
        }
        return s.substring(maxLow, maxHigh + 1);
    }

}
