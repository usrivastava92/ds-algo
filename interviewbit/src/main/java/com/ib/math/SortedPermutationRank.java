package com.ib.math;

import java.util.*;

public class SortedPermutationRank {

    private Map<Integer, Integer> factorials = new HashMap<>();

    public static void main(String... args) {
        SortedPermutationRank sortedPermutationRank = new SortedPermutationRank();
        System.out.println(sortedPermutationRank.findRank("cab"));
    }

    int mod = 1000003;

    public int findRank(String A) {
        String s = A;
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            int c = 0;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) < s.charAt(i))
                    c++;
            }
            ans += ((c * fact(n - i - 1))) % mod;
        }
        return (ans + 1) % mod;
    }


    int fact(int n) {
        if (n == 0) return 1;
        else return (n * fact(n - 1)) % mod;
    }


    public int factorial(int x) {
        if (factorials.containsKey(x)) {
            return factorials.get(x);
        } else {
            if (x == 1 || x == 0) {
                return 1;
            } else {
                int fact = x * factorial(x - 1);
                factorials.put(x, fact);
                return fact;
            }
        }
    }


}
