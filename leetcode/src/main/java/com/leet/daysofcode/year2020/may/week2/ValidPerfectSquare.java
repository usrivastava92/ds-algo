package com.leet.daysofcode.year2020.may.week2;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        int[] num = {16, 14, 808201, 5};
        for (int testCase = 0; testCase < num.length; testCase++) {
            System.out.println(num[testCase] + " -> " + validPerfectSquare.isPerfectSquare(num[testCase]) + " : " + ((Math.sqrt(num[testCase]) % 1) == 0));
        }
    }

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        return helper(2, num, num);
    }

    private boolean helper(int low, int high, float target) {
        if (low > high) {
            return false;
        }
        int mid = low + ((high - low) / 2);
        float div = target / mid;
        if (mid == low || mid == high) {
            return ((target / low) == low) || ((target / high) == high);
        }
        if (div == mid) {
            return true;
        } else if (div < mid) {
            return helper(low, mid, target);
        }
        return helper(mid, high, target);
    }

}
