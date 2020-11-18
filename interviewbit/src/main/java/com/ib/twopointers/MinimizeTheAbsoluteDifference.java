package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeTheAbsoluteDifference {

    public static void main(String... args) {
        Integer[] A = new Integer[]{1, 4, 5, 8, 10};
        Integer[] B = new Integer[]{6, 9, 10};
        Integer[] C = new Integer[]{2, 3, 6, 10};
        MinimizeTheAbsoluteDifference minimizeTheAbsoluteDifference = new MinimizeTheAbsoluteDifference();

        System.out.println(minimizeTheAbsoluteDifference.solve(new ArrayList<>(Arrays.asList(A)), new ArrayList<>(Arrays.asList(B)), new ArrayList<>(Arrays.asList(C))));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int sizeA = A.size();
        int sizeB = B.size();
        int sizeC = C.size();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                for (int k = 0; k < sizeC; k++) {
                    int curr = absDiff(A.get(i), B.get(j), C.get(k));
                    if (curr < min) {
                        System.out.println(A.get(i) + " " + B.get(j) + " " + C.get(k));
                        min = curr;
                    }
                }
            }
        }
        return min;
    }

    public int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int absDiff(int a, int b, int c) {
        return Math.abs(max(a, b, c) - min(a, b, c));
    }
}
