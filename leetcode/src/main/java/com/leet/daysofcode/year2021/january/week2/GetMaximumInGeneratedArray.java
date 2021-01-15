package com.leet.daysofcode.year2021.january.week2;

import org.junit.Assert;

import java.util.stream.IntStream;

public class GetMaximumInGeneratedArray {

    public static void main(String[] args) {
        int[] ns = {7, 2, 3, 100};
        int[] outputs = {3, 1, 2, 21};
        GetMaximumInGeneratedArray getMaximumInGeneratedArray = new GetMaximumInGeneratedArray();
        IntStream.range(0, ns.length).forEachOrdered(i -> {
            System.out.println("Input : " + ns[i]);
            int output = getMaximumInGeneratedArray.getMaximumGenerated(ns[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    private static final int[] MAX = new int[101];

    static {
        int[] arr = new int[101];
        for (int i = 0; i < 101; i++) {
            arr[i] = getValue(i, arr);
            MAX[i] = Math.max(arr[i], i > 1 ? MAX[i - 1] : 0);
        }
    }

    private static int getValue(int n, int[] arr) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int temp = n / 2;
        if (n % 2 == 0) {
            return getValue(temp, arr);
        }
        return getValue(temp, arr) + getValue(temp + 1, arr);
    }

    public int getMaximumGenerated(int n) {
        return MAX[n];
    }

}