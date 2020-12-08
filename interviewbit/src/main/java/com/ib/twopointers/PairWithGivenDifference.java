package com.ib.twopointers;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PairWithGivenDifference {

    public static void main(String[] args) {
        int[][] As = {{5, 10, 3, 2, 50, 80}, {-10, 20}, {5, 10, 3, 2, 50, 80}, {5, 10, 3, 2, 50, 80}, {5, 10, 3, 2, 50, 80}};
        int[] Bs = {78, 30, 80, 47, 1};
        int[] outputs = {1, 1, 0, 1, 1};
        PairWithGivenDifference pairWithGivenDifference = new PairWithGivenDifference();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : " + Arrays.toString(As[i]) + ", B : " + Bs[i]);
            int output = pairWithGivenDifference.solve(As[i], Bs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int solve(int[] A, int B) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int len = A.length;
        Arrays.sort(A);
        int i = 0;
        int j = 1;
        System.out.println(Arrays.toString(A));
        while (i < len && j < len) {
            if (i != j && A[j] - A[i] == B) {
                return 1;
            } else if (A[j] - A[i] < B) {
                j++;
            } else {
                i++;
            }
        }
        return 0;
    }


}
