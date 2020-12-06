package com.ib.strings;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class ConvertToPalindrome {

    public static void main(String[] args) {
        String[] As = {"abcba", "abecbea", "phmjjmap", "ivjwvi"};
        int[] outputs = {1, 0, 0, 1};
        ConvertToPalindrome convertToPalindrome = new ConvertToPalindrome();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : " + As[i]);
            int output = convertToPalindrome.solveDp(As[i]);
            System.out.println("Output : " + outputs[i]);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int solve(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        int j = A.length() - 1;
        int i = 0;
        int misMatchCount = 0;
        while (i < j) {
            if (A.charAt(j) == A.charAt(i)) {
                i++;
                j--;
            } else {
                if (misMatchCount > 0) {
                    return 0;
                }
                int nextI = i + 1;
                int nextJ = j - 1;
                if (nextI == j) {
                    break;
                }
                if (nextI < j && A.charAt(nextI) == A.charAt(j)) {
                    i++;
                } else if (nextJ > i && A.charAt(nextJ) == A.charAt(i)) {
                    j--;
                }
                misMatchCount++;
            }
        }
        return 1;
    }


    public int solveDp(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        int len = A.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int max = 0;
        for (int dist = 1; dist < len; dist++) {
            for (int i = 0; i + dist < len; i++) {
                int j = i + dist;
                if (A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        ArrayUtils.printArr(dp);
        return len - max <= 1 ? 1 : 0;
    }


}
