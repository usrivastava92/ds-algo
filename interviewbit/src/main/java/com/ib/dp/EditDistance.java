package com.ib.dp;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class EditDistance {

    public static void main(String[] args) {
        String[] As = {"abad", "Anshuman", "aaa"};
        String[] Bs = {"abac", "Antihuman", "aa"};
        int[] outputs = {1, 2, 1};
        EditDistance editDistance = new EditDistance();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input -> A : " + As[i] + " B : " + Bs[i]);
            int output = editDistance.minDistance(As[i], Bs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int minDistance(String A, String B) {
        if (A == null && B == null) {
            return 0;
        }
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return A == null ? B.length() : A.length();
        }
        int n = B.length();
        int m = A.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(j - 1) == B.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        ArrayUtils.printArr(dp);
        return dp[n][m];
    }


}
