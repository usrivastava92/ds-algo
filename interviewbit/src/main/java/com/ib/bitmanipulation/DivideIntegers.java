package com.ib.bitmanipulation;

public class DivideIntegers {

    public static void main(String... args) {
        DivideIntegers divideIntegers = new DivideIntegers();
        System.out.println(divideIntegers.divide(10, 3));
    }

    public int divide(int A, int B) {
        long dividend = new Long(A);
        long divisor = new Long(B);
        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        long quotient = 0, temp = 0;
        for (int i = 31; i >= 0; --i) {
            if (temp + (divisor << i) <= dividend) {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }
        Long prod = sign * quotient;
        if (prod > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (prod < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return prod.intValue();
    }

}
