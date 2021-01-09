package com.leet.daysofcode.year2020.december.week1;

public class ThekthFactorOfN {

    public static void main(String[] args) {

    }

    public int kthFactor(int n, int k) {
        if (n == 0) {
            return k;
        }
        int factorIndex = 1;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (factorIndex == k) {
                    return i;
                }
                factorIndex++;
            }
        }
        return -1;
    }
}
