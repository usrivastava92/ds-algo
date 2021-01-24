package com.leet.daysofcode.year2021.january.week3;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String[] s = {"babad", "cbbd", "a", "ac", "aacabdkacaa"};
        String[] outputs = {"bab", "bb", "a", "a", "aca"};
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        IntStream.range(0, s.length).forEachOrdered(i -> {
            System.out.println("Input : " + s[i]);
            String output = longestPalindromicSubstring.longestPalindrome(s[i]);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int end = 1;
        int max = 1;
        for (int j = 0; j + 1 < len; j++) {
            int x = j;
            int y = j + 1;
            if (s.charAt(x) == s.charAt(y)) {
                dp[x][y] = true;
                if (2 > max) {
                    start = x;
                    end = y + 1;
                    max = 2;
                }
            }
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                int x = j;
                int y = j + i;
                if (x == 0 && y == 3) {
                    System.out.println("");
                }
                if (s.charAt(x) == s.charAt(y) && y - 1 > -1 && x + 1 < len && dp[x + 1][y - 1]) {
                    dp[x][y] = true;
                    if (i + 1 > max) {
                        start = x;
                        end = y + 1;
                        max = i + 1;
                    }
                }
            }
        }
        ArrayUtils.printArr(dp);
        return s.substring(start, end);
    }

}
