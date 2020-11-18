package com.ib.math;

public class GreatestCommonDivisor {

    public static void main(String... args) {
        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
    }


    public int gcd(int A, int B) {
        if (A == B) {
            return A;
        } else {
            int min = A < B ? A : B;
            int max = A > B ? A : B;
            if (min == 0 || max == 0) {
                return max;
            }
            if (max % min == 0) {
                return min;
            }
            int minhalf = (min / 2) + 1;
            for (int i = minhalf; i >= 1; i--) {
                if (A % i == 0 && B % i == 0) {
                    return i;
                }
            }
        }
        return 1;
    }

}
