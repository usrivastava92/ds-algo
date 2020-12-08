package com.ib.dp;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WaysToDecode {

    public static void main(String[] args) {
        String[] inputs = {"8", "12", "1212", "121212", "1299", "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190", "10"};
        WaysToDecode waysToDecode = new WaysToDecode();
        int[] outputs = {1, 2, 5, 13, 2, 0, 1};
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            int output = waysToDecode.numDecodings(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    private static final int MOD = 1000000007;

    public int numDecodings(String A) {
        /*
        1212
        1
        12
        123
        1235

        1299
        1
        12
        12

        1 2 1
        1 21
        12 1

        1 21 2
        1 2  12
        1 2 1 2
        12 12
        12 1 2
        */

        if (A == null || A.length() <= 0) {
            return 0;
        }
        int len = A.length();
        long[] dp = new long[len];
        if (A.charAt(0) == '0') {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        dp[0] = A.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int currDigit = Character.getNumericValue(A.charAt(i));
            int includingPrev = Integer.parseInt(A.substring(i - 1, i + 1));
            if (currDigit > 0) {
                dp[i] = dp[i - 1] % MOD;
            }
            if (includingPrev >= 10 && includingPrev <= 26) {
                dp[i] = ((dp[i] % MOD) + (i - 2 >= 0 ? (dp[i - 2] % MOD) : 1)) % MOD;
            }
        }
        System.out.println(Arrays.toString(dp));
        long ans = dp[len - 1] % MOD;
        return (int) ans;
    }

}
