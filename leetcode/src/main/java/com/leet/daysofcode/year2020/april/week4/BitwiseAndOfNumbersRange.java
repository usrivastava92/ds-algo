package com.leet.daysofcode.year2020.april.week4;

public class BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        System.out.println(bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int ans = m;
        while (m++ < n) {
            ans = ans & m;
            if (ans == 0) {
                return 0;
            }
        }
        return ans;
    }

}
