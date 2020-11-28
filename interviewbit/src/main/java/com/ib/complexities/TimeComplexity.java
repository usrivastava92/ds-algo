package com.ib.complexities;

import java.util.Date;

public class TimeComplexity {

    public static void main(String[] args) {
        int input = 50;
        System.out.println(new Date());
        System.out.println(iterativeFib(input));
        System.out.println(new Date());
        System.out.println(recursiveFib(input));
        System.out.println(new Date());
    }

    public static long recursiveFib(int n) {
        if (n == 1 || n == 2) {
            return n - 1;
        }
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    public static long iterativeFib(int n) {
        if (n == 1 || n == 2) {
            return n - 1;
        }
        long a = 0;
        long b = 1;
        long c = -1;
        n = n-2;
        while (n-- > 0) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}

//0,1,1,2,3,5,8..