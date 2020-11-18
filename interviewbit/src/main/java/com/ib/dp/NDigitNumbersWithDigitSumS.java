package com.ib.dp;

import java.util.HashMap;
import java.util.Map;

public class NDigitNumbersWithDigitSumS {

    public static void main(String[] args) {
        int[] n = {2, 10, 5, 75};
        int[] s = {4, 15, 15, 22};
        int[] output = {4, 808753, 2654,478432066};
        NDigitNumbersWithDigitSumS nDigitNumbersWithDigitSumS = new NDigitNumbersWithDigitSumS();
        for (int i = 0; i < n.length; i++) {
            System.out.println("Input : N -> " + n[i] + " , S -> " + s[i]);
            System.out.println("Output : " + nDigitNumbersWithDigitSumS.solve(n[i], s[i]));
            System.out.println("Expected : " + output[i]);
            System.out.println("#########################################");
        }
    }


    public int solve(int n, int s) {
        Map<String, Integer> dp = new HashMap();
        dp.put("1 0", 1);
        dp.put("1 1", 1);
        dp.put("1 2", 1);
        dp.put("1 3", 1);
        dp.put("1 4", 1);
        dp.put("1 5", 1);
        dp.put("1 6", 1);
        dp.put("1 7", 1);
        dp.put("1 8", 1);
        dp.put("1 9", 1);
        return helper(n, s, false, dp);
    }

    private int helper(int n, int s, boolean include0, Map<String, Integer> dp) {
        int mod = 1000000007;
        if (n <= 0 || s < 0) {
            return 0;
        }
        String key = n + " " + s;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int ans = 0;
        int i = 0;
        if (!include0) {
            i++;
            include0 = true;
        }
        for (; i < 10; i++) {
            ans = (ans%mod) +  (helper(n - 1, s - i, include0, dp)%mod);
        }
        dp.put(key, ans%mod);
        return dp.get(key);
    }

    private void printer(int n, int s, boolean include0, String num) {
        if (n <= 0 || s < 0) {
            return;
        }
        if (n == 1 && s >= 0 && s <= 9) {
            System.out.println(num + s);
            return;
        }
        int i = 0;
        if (!include0) {
            i++;
            include0 = true;
        }
        for (; i < 10; i++) {
            printer(n - 1, s - i, include0, num + i);
        }
    }
}