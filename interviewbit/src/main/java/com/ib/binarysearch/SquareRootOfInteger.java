package com.ib.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareRootOfInteger {

    public static void main(String... args) {

        SquareRootOfInteger squareRootOfInteger = new SquareRootOfInteger();
        System.out.println(squareRootOfInteger.sqrt(2147483647));
    }

    public int sqrt(int A) {
        if (A == 1) {
            return 1;
        }
        return findBinarySqrt(1, A, A);
    }


    private int findBinarySqrt(int low, int high, int num) {

        int mid = (low + ((high - low) / 2));
        if (mid == low || mid == high) {
            return mid;
        }
        int div = num / mid;
        System.out.println("low : " + low + " || high : " + high + " || num : " + num + " || div : " + div);
        if (div == mid) {
            return mid;
        } else if (div > mid) {
            return findBinarySqrt(mid, high, num);
        } else {
            return findBinarySqrt(low, mid, num);
        }
    }
}
