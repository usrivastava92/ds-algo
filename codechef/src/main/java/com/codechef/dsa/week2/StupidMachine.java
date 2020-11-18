package com.codechef.dsa.week2;

import java.util.Arrays;
import java.util.Scanner;

public class StupidMachine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            long[] si = new long[n];
            int minIndex = -1;
            long prevMinIndex = n;
            long min = Integer.MAX_VALUE;
            long maxItems = 0;
            for (int i = 0; i < n; i++) {
                si[i] = sc.nextLong();
                if (si[i] < min) {
                    min = si[i];
                    minIndex = i;
                }
            }
            while (minIndex != 0) {
                maxItems += (min * (prevMinIndex - minIndex));
                prevMinIndex = minIndex;
                min = Integer.MAX_VALUE;
                for (int i = 0; i < prevMinIndex; i++) {
                    if (si[i] < min) {
                        min = si[i];
                        minIndex = i;
                    }
                }
            }
            maxItems += (min * prevMinIndex);
            System.out.println(maxItems);
        }
        sc.close();
    }
}
